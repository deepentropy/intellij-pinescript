package io.github.houseofai.pinescript.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.JBColor;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.Color;
import java.awt.Font;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Annotator for PineScript that provides compile-time validation and warnings.
 * Based on TradingView's PineScript execution model and common error patterns.
 */
public class PineScriptAnnotator implements Annotator {

    // Warning text attributes with wavy underline (yellow/orange)
    private static final TextAttributes WARNING_ATTRIBUTES = new TextAttributes(
            null, null,
            new JBColor(new Color(0xE5, 0xA5, 0x0A), new Color(0xE5, 0xA5, 0x0A)),
            EffectType.WAVE_UNDERSCORE,
            Font.PLAIN
    );

    // Error text attributes with wavy underline (red)
    private static final TextAttributes ERROR_ATTRIBUTES = new TextAttributes(
            null, null,
            JBColor.RED,
            EffectType.WAVE_UNDERSCORE,
            Font.PLAIN
    );

    // Pattern to detect version annotation
    private static final Pattern VERSION_PATTERN = Pattern.compile("//@version\\s*=\\s*(\\d+)");

    // Pattern to detect historical reference operator [n]
    private static final Pattern HISTORY_REF_PATTERN = Pattern.compile("\\[(\\d+)\\]");

    // Functions that require consistent execution every bar
    private static final Set<String> HISTORY_DEPENDENT_FUNCTIONS = new HashSet<>();
    static {
        // Technical analysis functions
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.sma");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.ema");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.wma");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.vwma");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.rma");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.rsi");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.macd");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.stoch");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.cci");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.mfi");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.bb");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.bbw");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.kc");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.atr");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.tr");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.sar");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.supertrend");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.dmi");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.adx");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.mom");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.roc");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.tsi");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.obv");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.change");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.cum");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.stdev");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.variance");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.correlation");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.cross");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.crossover");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.crossunder");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.valuewhen");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.barssince");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.highest");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.lowest");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.highestbars");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.lowestbars");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.pivothigh");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.pivotlow");
        HISTORY_DEPENDENT_FUNCTIONS.add("ta.linreg");
        // Request functions
        HISTORY_DEPENDENT_FUNCTIONS.add("request.security");
        HISTORY_DEPENDENT_FUNCTIONS.add("request.security_lower_tf");
    }

    // Track state per file
    private boolean hasVersionAnnotation = false;
    private boolean hasScriptDeclaration = false;
    private int securityCallCount = 0;
    private int currentConditionalDepth = 0;

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        PsiFile file = element.getContainingFile();
        if (file == null) return;

        // Only perform file-level checks once (on the first element)
        if (element.equals(file.getFirstChild())) {
            performFileValidation(file, element, holder);
        }

        // Element-level checks
        if (element.getNode() == null) return;

        String elementText = element.getText();

        // Check for conditional blocks (if, for, while, switch)
        if (element.getNode().getElementType() == PineScriptTokenTypes.KEYWORD) {
            if (isConditionalKeyword(elementText)) {
                // We're entering a conditional block
                // Note: This is a simplified check - a full implementation would track scope
            }
        }

        // Check for history-dependent functions in conditional contexts
        if (element.getNode().getElementType() == PineScriptTokenTypes.BUILTIN_FUNCTION) {
            checkHistoryDependentFunction(element, elementText, holder);
        }

        // Check for large historical offsets
        if (element.getNode().getElementType() == PineScriptTokenTypes.NUMBER) {
            checkHistoricalOffset(element, holder);
        }

        // Check for request.security calls (count them)
        if (elementText.equals("request.security") || elementText.equals("request.security_lower_tf")) {
            securityCallCount++;
            if (securityCallCount > 40) {
                holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING,
                    "Too many request.security() calls. Maximum is 40.")
                    .range(element.getTextRange())
                    .enforcedTextAttributes(ERROR_ATTRIBUTES)
                    .create();
            } else if (securityCallCount > 35) {
                holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING,
                    "Approaching request.security() limit (40). Current count: " + securityCallCount)
                    .range(element.getTextRange())
                    .enforcedTextAttributes(WARNING_ATTRIBUTES)
                    .create();
            }
        }
    }

    /**
     * Perform file-level validation checks
     */
    private void performFileValidation(PsiFile file, PsiElement firstChild, AnnotationHolder holder) {
        String fileText = file.getText();
        TextRange elementRange = firstChild.getTextRange();

        // Reset counters
        hasVersionAnnotation = false;
        hasScriptDeclaration = false;
        securityCallCount = 0;

        // Check for version annotation
        Matcher versionMatcher = VERSION_PATTERN.matcher(fileText);
        if (versionMatcher.find()) {
            hasVersionAnnotation = true;
            int version = Integer.parseInt(versionMatcher.group(1));
            if (version < 4) {
                int start = versionMatcher.start();
                int end = versionMatcher.end();
                // Only annotate if range fits within the element
                if (start >= elementRange.getStartOffset() && end <= elementRange.getEndOffset()) {
                    holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING,
                        "Consider upgrading to PineScript v5 or v6 for latest features and better performance.")
                        .range(new TextRange(start, end))
                        .enforcedTextAttributes(WARNING_ATTRIBUTES)
                        .create();
                }
            }
        } else {
            // No version annotation found - add warning on the first element
            if (fileText.length() > 0) {
                holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING,
                    "Missing version annotation. Add '//@version=6' at the top of your script.")
                    .range(elementRange)
                    .enforcedTextAttributes(WARNING_ATTRIBUTES)
                    .create();
            }
        }

        // Check for script declaration (indicator, strategy, or library)
        if (fileText.contains("indicator(") || fileText.contains("indicator (")) {
            hasScriptDeclaration = true;
        } else if (fileText.contains("strategy(") || fileText.contains("strategy (")) {
            hasScriptDeclaration = true;
        } else if (fileText.contains("library(") || fileText.contains("library (")) {
            hasScriptDeclaration = true;
        }

        if (!hasScriptDeclaration && hasVersionAnnotation) {
            // Annotate on the first element since the target range may be outside it
            holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING,
                "Script must declare indicator(), strategy(), or library().")
                .range(elementRange)
                .enforcedTextAttributes(ERROR_ATTRIBUTES)
                .create();
        }
    }

    /**
     * Check if a history-dependent function is called in a conditional context
     */
    private void checkHistoryDependentFunction(PsiElement element, String functionName, AnnotationHolder holder) {
        if (!HISTORY_DEPENDENT_FUNCTIONS.contains(functionName)) {
            return;
        }

        // Check if this element is inside a conditional block
        if (isInsideConditionalBlock(element)) {
            holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING,
                "'" + functionName + "' should be called on every bar for consistent results. " +
                "Calling it inside a conditional block may cause unexpected behavior.")
                .range(element.getTextRange())
                .enforcedTextAttributes(WARNING_ATTRIBUTES)
                .create();
        }
    }

    /**
     * Check if an element is inside a conditional block (if, for, while, switch)
     */
    private boolean isInsideConditionalBlock(PsiElement element) {
        // Walk up the tree to find if we're inside a conditional
        PsiElement current = element.getParent();
        int depth = 0;

        while (current != null && depth < 50) { // Limit depth to prevent infinite loops
            // Check siblings for conditional keywords
            PsiElement sibling = current.getPrevSibling();
            while (sibling != null) {
                if (sibling.getNode() != null &&
                    sibling.getNode().getElementType() == PineScriptTokenTypes.KEYWORD) {
                    String text = sibling.getText();
                    if (isConditionalKeyword(text)) {
                        return true;
                    }
                }
                sibling = sibling.getPrevSibling();
            }
            current = current.getParent();
            depth++;
        }
        return false;
    }

    /**
     * Check if a keyword is a conditional keyword
     */
    private boolean isConditionalKeyword(String keyword) {
        return "if".equals(keyword) || "for".equals(keyword) ||
               "while".equals(keyword) || "switch".equals(keyword);
    }

    /**
     * Check for large historical offsets that may need max_bars_back()
     */
    private void checkHistoricalOffset(PsiElement element, AnnotationHolder holder) {
        // Check if this number is used as a historical reference
        PsiElement prev = element.getPrevSibling();
        if (prev != null && prev.getNode() != null &&
            prev.getNode().getElementType() == PineScriptTokenTypes.LBRACKET) {

            try {
                int offset = Integer.parseInt(element.getText());
                if (offset > 500) {
                    holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING,
                        "Large historical offset (" + offset + "). Consider using max_bars_back() " +
                        "to ensure sufficient historical buffer.")
                        .range(element.getTextRange())
                        .enforcedTextAttributes(WARNING_ATTRIBUTES)
                        .create();
                } else if (offset > 200) {
                    holder.newAnnotation(HighlightSeverity.GENERIC_SERVER_ERROR_OR_WARNING,
                        "Historical offset of " + offset + " bars. If you encounter buffer errors, " +
                        "use max_bars_back() to increase the historical buffer.")
                        .range(element.getTextRange())
                        .enforcedTextAttributes(WARNING_ATTRIBUTES)
                        .create();
                }
            } catch (NumberFormatException e) {
                // Not a valid number, ignore
            }
        }
    }
}
