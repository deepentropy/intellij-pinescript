package io.github.houseofai.pinescript.documentation;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides documentation for Pine Script functions when hovering over them.
 * Shows documentation similar to TradingView's popup style.
 */
public class PineScriptDocumentationProvider extends AbstractDocumentationProvider {

    // Dark theme colors similar to TradingView
    private static final String COLOR_FUNCTION = "#4EC9B0";      // Teal for function names
    private static final String COLOR_TYPE = "#4EC9B0";          // Teal for types
    private static final String COLOR_KEYWORD = "#569CD6";       // Blue for keywords
    private static final String COLOR_PARAM = "#9CDCFE";         // Light blue for parameters
    private static final String COLOR_STRING = "#CE9178";        // Orange for strings
    private static final String COLOR_COMMENT = "#6A9955";       // Green for comments
    private static final String COLOR_SECTION = "#DCDCAA";       // Yellow for section headers

    @Override
    public @Nullable String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        PsiElement targetElement = originalElement != null ? originalElement : element;

        if (targetElement == null) {
            return null;
        }

        IElementType elementType = targetElement.getNode() != null ? targetElement.getNode().getElementType() : null;
        String elementText = targetElement.getText();

        // Check if this is a function identifier or builtin function
        if (elementType == PineScriptTokenTypes.BUILTIN_FUNCTION ||
            elementType == PineScriptTokenTypes.IDENTIFIER) {

            String functionName = getFunctionName(targetElement);
            if (functionName != null) {
                // Try to get documentation from repository
                PineScriptDocumentationRepository.FunctionDoc doc =
                    PineScriptDocumentationRepository.getDocumentation(functionName);

                if (doc != null) {
                    return formatDocumentation(doc);
                }

                // Fallback: show basic info even without full docs
                return formatBasicDoc(functionName, elementType.toString());
            }
        }

        // Debug fallback - show what element we're seeing
        if (elementType != null && elementType != PineScriptTokenTypes.WHITE_SPACE) {
            return "<html><body><b>Element:</b> " + escapeHtml(elementText) +
                   "<br/><b>Type:</b> " + elementType.toString() + "</body></html>";
        }

        return null;
    }

    /**
     * Format basic documentation when full docs aren't available.
     */
    private String formatBasicDoc(String functionName, String elementType) {
        StringBuilder html = new StringBuilder();
        html.append("<html><body>");
        html.append("<div style='color:#4EC9B0; font-weight:bold; font-size:14px;'>").append(escapeHtml(functionName)).append("</div>");
        html.append("<div style='color:#888;'>(built-in function)</div>");
        html.append("<br/><div style='color:#aaa;'>Documentation not available for this function.</div>");
        html.append("</body></html>");
        return html.toString();
    }

    @Override
    public @Nullable PsiElement getDocumentationElementForLookupItem(com.intellij.psi.PsiManager psiManager, Object object, PsiElement element) {
        return element;
    }

    @Override
    public @Nullable PsiElement getDocumentationElementForLink(com.intellij.psi.PsiManager psiManager, String link, PsiElement context) {
        return context;
    }

    @Override
    public @Nullable String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
        return generateDoc(element, originalElement);
    }

    @Override
    public @Nullable PsiElement getCustomDocumentationElement(@NotNull Editor editor, @NotNull PsiFile file, @Nullable PsiElement contextElement, int targetOffset) {
        // Return the element at cursor position for documentation lookup
        if (contextElement != null) {
            return contextElement;
        }
        return file.findElementAt(targetOffset);
    }

    /**
     * Get the full function name including namespace (e.g., "ta.sma")
     */
    private String getFunctionName(PsiElement element) {
        if (element == null) {
            return null;
        }

        String fileText = element.getContainingFile().getText();
        int startOffset = element.getTextRange().getStartOffset();

        StringBuilder fullName = new StringBuilder(element.getText());

        // Check if there's a dot before this element (namespace separator)
        int i = startOffset - 1;
        while (i >= 0 && Character.isWhitespace(fileText.charAt(i))) {
            i--;
        }

        if (i >= 0 && fileText.charAt(i) == '.') {
            fullName.insert(0, '.');
            i--;

            while (i >= 0 && Character.isWhitespace(fileText.charAt(i))) {
                i--;
            }

            StringBuilder namespace = new StringBuilder();
            while (i >= 0 && (Character.isLetterOrDigit(fileText.charAt(i)) || fileText.charAt(i) == '_')) {
                namespace.insert(0, fileText.charAt(i));
                i--;
            }

            fullName.insert(0, namespace);
        }

        return fullName.toString();
    }

    /**
     * Format the documentation into HTML similar to TradingView style.
     */
    private String formatDocumentation(PineScriptDocumentationRepository.FunctionDoc doc) {
        StringBuilder html = new StringBuilder();

        html.append("<html><head>");
        html.append("<style>");
        html.append("body { font-family: 'JetBrains Mono', Consolas, monospace; font-size: 12px; }");
        html.append(".function-name { color: ").append(COLOR_FUNCTION).append("; font-weight: bold; font-size: 14px; }");
        html.append(".type { color: ").append(COLOR_TYPE).append("; }");
        html.append(".section { color: ").append(COLOR_SECTION).append("; font-weight: bold; margin-top: 12px; margin-bottom: 4px; }");
        html.append(".param-name { color: ").append(COLOR_PARAM).append("; }");
        html.append(".code { font-family: 'JetBrains Mono', Consolas, monospace; }");
        html.append("pre { background-color: #2d2d2d; padding: 8px; border-radius: 4px; overflow-x: auto; }");
        html.append("</style>");
        html.append("</head><body>");

        // Function name with type indicator
        html.append("<div class='function-name'>").append(escapeHtml(doc.getName())).append("</div>");
        html.append("<div style='color: #888; margin-bottom: 8px;'>(built-in function)</div>");

        // Description
        if (doc.getDescription() != null && !doc.getDescription().isEmpty()) {
            html.append("<div style='margin-bottom: 12px;'>");
            html.append(formatDescription(doc.getDescription()));
            html.append("</div>");
        }

        // Syntax section
        if (doc.getSyntax() != null && !doc.getSyntax().isEmpty()) {
            html.append("<div class='section'>Syntax</div>");
            html.append("<div class='code'>");
            html.append(formatSyntax(doc.getSyntax()));
            html.append("</div>");
        }

        // Arguments section
        if (doc.getArguments() != null && !doc.getArguments().isEmpty()) {
            html.append("<div class='section'>Arguments</div>");
            html.append("<div style='margin-left: 8px;'>");
            html.append(formatArguments(doc.getArguments()));
            html.append("</div>");
        }

        // Returns section
        if (doc.getReturns() != null && !doc.getReturns().isEmpty()) {
            html.append("<div class='section'>Returns</div>");
            html.append("<div style='margin-left: 8px;'>");
            html.append(escapeHtml(doc.getReturns()));
            html.append("</div>");
        }

        // Remarks section
        if (doc.getRemarks() != null && !doc.getRemarks().isEmpty()) {
            html.append("<div class='section'>Remarks</div>");
            html.append("<div style='margin-left: 8px; color: #aaa;'>");
            html.append(formatDescription(doc.getRemarks()));
            html.append("</div>");
        }

        // See also section
        if (doc.getSeeAlso() != null && !doc.getSeeAlso().isEmpty()) {
            html.append("<div class='section'>See also</div>");
            html.append("<div style='margin-left: 8px;'>");
            html.append(formatSeeAlso(doc.getSeeAlso()));
            html.append("</div>");
        }

        html.append("</body></html>");

        return html.toString();
    }

    /**
     * Format the syntax with syntax highlighting.
     */
    private String formatSyntax(String syntax) {
        String escaped = escapeHtml(syntax);

        // Highlight the function name (before the parenthesis)
        escaped = escaped.replaceAll("^([a-zA-Z_][a-zA-Z0-9_.]*)(\\()",
                "<span style='color:" + COLOR_FUNCTION + "'>$1</span>$2");

        // Highlight return type (after ->)
        escaped = escaped.replaceAll("→\\s*([a-zA-Z_<>\\[\\]/]+)",
                "→ <span style='color:" + COLOR_TYPE + "'>$1</span>");

        // Highlight types in angle brackets
        escaped = escaped.replaceAll("&lt;([^&]+)&gt;",
                "&lt;<span style='color:" + COLOR_TYPE + "'>$1</span>&gt;");

        return escaped;
    }

    /**
     * Format arguments with parameter highlighting.
     */
    private String formatArguments(String arguments) {
        StringBuilder html = new StringBuilder();
        String[] lines = arguments.split("\n\n");

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // Match: paramName (type) Description
            if (line.matches("^[a-zA-Z_][a-zA-Z0-9_]*\\s*\\(.*")) {
                int parenStart = line.indexOf('(');
                int parenEnd = line.indexOf(')');

                if (parenStart > 0 && parenEnd > parenStart) {
                    String paramName = line.substring(0, parenStart).trim();
                    String type = line.substring(parenStart + 1, parenEnd).trim();
                    String desc = parenEnd + 1 < line.length() ? line.substring(parenEnd + 1).trim() : "";

                    html.append("<div style='margin-bottom: 6px;'>");
                    html.append("<span class='param-name'>").append(escapeHtml(paramName)).append("</span>");
                    html.append(" <span style='color:#888'>(</span>");
                    html.append("<span class='type'>").append(escapeHtml(type)).append("</span>");
                    html.append("<span style='color:#888'>)</span>");
                    if (!desc.isEmpty()) {
                        html.append(" ").append(escapeHtml(desc));
                    }
                    html.append("</div>");
                } else {
                    html.append("<div style='margin-bottom: 6px;'>").append(escapeHtml(line)).append("</div>");
                }
            } else {
                html.append("<div style='margin-bottom: 6px;'>").append(escapeHtml(line)).append("</div>");
            }
        }

        return html.toString();
    }

    /**
     * Format description, handling markdown-like syntax.
     */
    private String formatDescription(String description) {
        String text = escapeHtml(description);

        // Handle inline code
        text = text.replaceAll("`([^`]+)`",
                "<code style='background:#2d2d2d; padding:1px 4px; border-radius:2px;'>$1</code>");

        // Handle bold
        text = text.replaceAll("\\*\\*([^*]+)\\*\\*", "<b>$1</b>");

        // Convert newlines to <br>
        text = text.replace("\n", "<br>");

        return text;
    }

    /**
     * Format see also links.
     */
    private String formatSeeAlso(String seeAlso) {
        String[] funcs = seeAlso.split(",\\s*");
        StringBuilder html = new StringBuilder();

        for (int i = 0; i < funcs.length; i++) {
            if (i > 0) {
                html.append(", ");
            }
            String func = funcs[i].trim();
            html.append("<span style='color:").append(COLOR_FUNCTION).append("'>").append(escapeHtml(func)).append("</span>");
        }

        return html.toString();
    }

    /**
     * Escape HTML special characters.
     */
    private String escapeHtml(String text) {
        if (text == null) return "";
        return text
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
