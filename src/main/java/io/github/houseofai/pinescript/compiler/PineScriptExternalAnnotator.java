package io.github.houseofai.pinescript.compiler;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.ExternalAnnotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.ui.JBColor;
import java.awt.Color;
import java.awt.Font;
import io.github.houseofai.pinescript.PineScriptFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * External annotator that compiles PineScript using TradingView's API
 * and displays errors/warnings inline in the editor.
 *
 * External annotators run in 3 phases:
 * 1. collectInformation - gather data (runs on EDT)
 * 2. doAnnotate - process data (runs in background - can make HTTP calls)
 * 3. apply - apply annotations (runs on EDT)
 */
public class PineScriptExternalAnnotator extends ExternalAnnotator<PineScriptExternalAnnotator.CollectedInfo, PineScriptCompilerService.CompilationResult> {

    /**
     * Information collected from the PSI file.
     */
    public static class CollectedInfo {
        final String sourceCode;
        final int[] lineOffsets;

        CollectedInfo(String sourceCode, int[] lineOffsets) {
            this.sourceCode = sourceCode;
            this.lineOffsets = lineOffsets;
        }
    }

    @Override
    public @Nullable CollectedInfo collectInformation(@NotNull PsiFile file) {
        // Only process PineScript files
        if (!(file.getFileType() instanceof PineScriptFileType)) {
            return null;
        }

        String text = file.getText();
        if (text.isEmpty()) {
            return null;
        }

        // Pre-calculate line offsets for quick lookup later
        int[] lineOffsets = calculateLineOffsets(text);

        return new CollectedInfo(text, lineOffsets);
    }

    @Override
    public @Nullable CollectedInfo collectInformation(@NotNull PsiFile file, @NotNull Editor editor, boolean hasErrors) {
        return collectInformation(file);
    }

    @Override
    public @Nullable PineScriptCompilerService.CompilationResult doAnnotate(CollectedInfo collectedInfo) {
        if (collectedInfo == null || collectedInfo.sourceCode.isEmpty()) {
            return null;
        }

        // This runs in a background thread - safe to make HTTP calls
        return PineScriptCompilerService.compile(collectedInfo.sourceCode);
    }

    @Override
    public void apply(@NotNull PsiFile file, PineScriptCompilerService.CompilationResult result, @NotNull AnnotationHolder holder) {
        if (result == null) {
            return;
        }

        if (!result.isSuccess()) {
            // Show a general error at the top of the file if compilation completely failed
            holder.newAnnotation(HighlightSeverity.ERROR, "Compilation failed: " + result.getError())
                    .range(new TextRange(0, Math.min(1, file.getTextLength())))
                    .create();
            return;
        }

        Document document = PsiDocumentManager.getInstance(file.getProject()).getDocument(file);
        if (document == null) {
            return;
        }

        // Apply each issue as an annotation
        for (PineScriptCompilerService.CompilationIssue issue : result.getIssues()) {
            boolean isError = issue.getSeverity() == PineScriptCompilerService.CompilationIssue.Severity.ERROR;

            TextRange range = calculateTextRange(document, issue);
            if (range != null && range.getStartOffset() < document.getTextLength()) {
                // Create text attributes with wavy underline effect only
                Color effectColor = isError
                        ? JBColor.RED
                        : new JBColor(new Color(0xE5, 0xA5, 0x0A), new Color(0xE5, 0xA5, 0x0A));

                TextAttributes attributes = new TextAttributes(
                        null,  // foreground
                        null,  // background
                        effectColor,  // effect color
                        EffectType.WAVE_UNDERSCORE,  // effect type
                        Font.PLAIN  // font type
                );

                // Use GENERIC_SERVER_ERROR_OR_WARNING which has minimal default styling
                holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING, issue.getMessage())
                        .range(range)
                        .enforcedTextAttributes(attributes)
                        .create();
            }
        }
    }

    /**
     * Calculate line start offsets for the document.
     */
    private int[] calculateLineOffsets(String text) {
        java.util.List<Integer> offsets = new java.util.ArrayList<>();
        offsets.add(0); // First line starts at 0

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                offsets.add(i + 1);
            }
        }

        return offsets.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Calculate the text range for an issue based on line/column information.
     * TradingView API may provide start/end positions, or just a single position.
     */
    @Nullable
    private TextRange calculateTextRange(Document document, PineScriptCompilerService.CompilationIssue issue) {
        try {
            int lineCount = document.getLineCount();

            // TradingView uses 1-based line numbers
            int startLine = issue.getLine() - 1;

            if (startLine < 0 || startLine >= lineCount) {
                return null;
            }

            int lineStartOffset = document.getLineStartOffset(startLine);
            int lineEndOffset = document.getLineEndOffset(startLine);

            // Column values (convert from 1-based to 0-based)
            int col = Math.max(0, issue.getColumn() - 1);
            int endCol = Math.max(0, issue.getEndColumn() - 1);

            // Check if end column is meaningful (not just the default +1 from parsing)
            // If endCol > col + 1, the API provided an explicit end position
            boolean hasExplicitEnd = (endCol > col + 1) || (issue.getEndLine() > issue.getLine());

            String text = document.getText();
            int startOffset, endOffset;

            if (hasExplicitEnd) {
                // Use the explicit range from the API
                startOffset = lineStartOffset + col;
                if (issue.getEndLine() == issue.getLine()) {
                    endOffset = lineStartOffset + endCol;
                } else {
                    // Multi-line error - highlight to end of start line
                    endOffset = lineEndOffset;
                }
            } else {
                // No explicit end position - find word boundaries
                // The reported column might be at the start OR end of the error token
                int reportedPos = lineStartOffset + col;

                // Try to find the word at this position
                int wordStart = findWordStart(text, reportedPos);
                int wordEnd = findWordEnd(text, reportedPos);

                // If word boundaries are valid, use them
                if (wordEnd > wordStart && wordStart >= lineStartOffset) {
                    startOffset = wordStart;
                    endOffset = wordEnd;
                } else {
                    // Fallback: try from the position looking backward
                    // (in case position is at end of token)
                    wordStart = findWordStart(text, reportedPos);
                    wordEnd = reportedPos;
                    if (wordEnd > wordStart) {
                        // Also extend forward if there are more word chars
                        int extended = findWordEnd(text, reportedPos);
                        if (extended > wordEnd) {
                            wordEnd = extended;
                        }
                        startOffset = wordStart;
                        endOffset = wordEnd;
                    } else {
                        // Last fallback: highlight around the position
                        startOffset = Math.max(lineStartOffset, reportedPos - 10);
                        endOffset = Math.min(lineEndOffset, reportedPos + 5);
                    }
                }
            }

            // Clamp to line boundaries
            startOffset = Math.max(startOffset, lineStartOffset);
            endOffset = Math.min(endOffset, lineEndOffset);

            // Ensure valid range (at least 1 character)
            if (endOffset <= startOffset) {
                endOffset = Math.min(startOffset + 1, lineEndOffset);
            }

            return new TextRange(startOffset, Math.min(endOffset, document.getTextLength()));

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Find the start of the word at or before the given position.
     */
    private int findWordStart(String text, int pos) {
        if (pos <= 0) return 0;
        if (pos > text.length()) pos = text.length();

        int start = pos;

        // If we're at or past the end, or at a non-word char, step back to find a word
        while (start > 0 && (start >= text.length() || !isWordChar(text.charAt(start)))) {
            start--;
        }

        // Now find the start of the word by going backwards
        while (start > 0 && isWordChar(text.charAt(start - 1))) {
            start--;
        }

        return start;
    }

    /**
     * Find the end of the word at the given position.
     */
    private int findWordEnd(String text, int pos) {
        if (pos < 0) return 0;
        if (pos >= text.length()) return text.length();

        int end = pos;

        // If we're at a non-word char, we're already past the word
        if (!isWordChar(text.charAt(end))) {
            return end;
        }

        // Move forward to find the end of the word
        while (end < text.length() && isWordChar(text.charAt(end))) {
            end++;
        }
        return end;
    }

    /**
     * Check if a character is part of a word (identifier).
     */
    private boolean isWordChar(char c) {
        return Character.isLetterOrDigit(c) || c == '_' || c == '.';
    }
}
