package io.github.houseofai.pinescript.documentation;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import io.github.houseofai.pinescript.parameterinfo.PineScriptFunctionRepository;
import io.github.houseofai.pinescript.parameterinfo.PineScriptFunctionSignature;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides documentation for Pine Script functions when hovering over them.
 */
public class PineScriptDocumentationProvider extends AbstractDocumentationProvider {

    @Override
    public @Nullable String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        // Try originalElement first, then element
        PsiElement targetElement = originalElement != null ? originalElement : element;

        if (targetElement == null) {
            return null;
        }

        IElementType elementType = targetElement.getNode() != null ? targetElement.getNode().getElementType() : null;

        // Check if this is a function identifier or builtin function
        if (elementType == PineScriptTokenTypes.BUILTIN_FUNCTION ||
            elementType == PineScriptTokenTypes.IDENTIFIER) {

            String functionName = getFunctionName(targetElement);
            if (functionName != null) {
                PineScriptFunctionSignature signature = PineScriptFunctionRepository.getSignature(functionName);
                if (signature != null) {
                    return formatDocumentation(signature);
                }

                // If no signature found, still show basic info for known functions
                String description = getDescription(functionName);
                if (description != null) {
                    return formatBasicDocumentation(functionName, description);
                }
            }
        }

        return null;
    }

    /**
     * Format basic documentation without signature
     */
    private String formatBasicDocumentation(String functionName, String description) {
        StringBuilder html = new StringBuilder();
        html.append("<html><body>");
        html.append("<b>").append(functionName).append("</b>");
        html.append("<br/><br/>");
        html.append("<div style='margin-top: 8px;'>");
        html.append(description);
        html.append("</div>");
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
        // Show quick info in a smaller popup
        return generateDoc(element, originalElement);
    }

    /**
     * Get the full function name including namespace (e.g., "ta.sma") using text analysis
     */
    private String getFunctionName(PsiElement element) {
        if (element == null) {
            return null;
        }

        // Get the text and offset
        String fileText = element.getContainingFile().getText();
        int endOffset = element.getTextRange().getEndOffset();
        int startOffset = element.getTextRange().getStartOffset();

        // Build function name by reading backwards to include namespace
        StringBuilder fullName = new StringBuilder(element.getText());

        // Check if there's a dot before this element (namespace separator)
        int i = startOffset - 1;
        while (i >= 0 && Character.isWhitespace(fileText.charAt(i))) {
            i--;
        }

        if (i >= 0 && fileText.charAt(i) == '.') {
            // Found a dot, read the namespace
            fullName.insert(0, '.');
            i--;

            // Skip whitespace before namespace
            while (i >= 0 && Character.isWhitespace(fileText.charAt(i))) {
                i--;
            }

            // Read namespace identifier
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
     * Format the function signature into HTML documentation
     */
    private String formatDocumentation(PineScriptFunctionSignature signature) {
        StringBuilder html = new StringBuilder();

        html.append("<html><body>");
        html.append("<b>").append(signature.getFunctionName()).append("</b>");
        html.append("(");

        // Add parameters
        for (int i = 0; i < signature.getParameterCount(); i++) {
            if (i > 0) {
                html.append(", ");
            }
            PineScriptFunctionSignature.Parameter param = signature.getParameters().get(i);

            if (param.isOptional()) {
                html.append("<i>");
            }

            html.append(param.getName());
            if (param.getType() != null && !param.getType().isEmpty()) {
                html.append(": <code>").append(param.getType()).append("</code>");
            }

            if (param.getDefaultValue() != null) {
                html.append(" = <code>").append(param.getDefaultValue()).append("</code>");
            }

            if (param.isOptional()) {
                html.append("</i>");
            }
        }

        html.append(")");

        // Add description based on function name
        String description = getDescription(signature.getFunctionName());
        if (description != null) {
            html.append("<br/><br/>");
            html.append("<div style='margin-top: 8px;'>");
            html.append(description);
            html.append("</div>");
        }

        html.append("</body></html>");

        return html.toString();
    }

    /**
     * Get description for common functions
     */
    private String getDescription(String functionName) {
        return switch (functionName) {
            case "plot" -> "Plots a series of data on the chart.";
            case "plotshape" -> "Plots visual shapes on the chart.";
            case "plotchar" -> "Plots a character on the chart.";
            case "hline" -> "Renders a horizontal line at a given fixed price level.";
            case "fill" -> "Fills the background between two plots or hlines.";
            case "bgcolor" -> "Colors the background of the bars.";
            case "indicator" -> "Declares the study and sets its properties.";
            case "strategy" -> "Declares the strategy and sets its properties.";
            case "ta.sma" -> "Simple Moving Average - calculates the arithmetic mean of values over a specified period.";
            case "ta.ema" -> "Exponential Moving Average - gives more weight to recent values.";
            case "ta.rsi" -> "Relative Strength Index - momentum oscillator measuring speed and magnitude of price changes.";
            case "ta.macd" -> "Moving Average Convergence Divergence - trend-following momentum indicator.";
            case "ta.atr" -> "Average True Range - measures market volatility.";
            case "ta.bb" -> "Bollinger Bands - volatility bands placed above and below a moving average.";
            case "ta.stoch" -> "Stochastic Oscillator - momentum indicator comparing closing price to price range.";
            case "ta.crossover" -> "Returns true when series1 crosses over series2.";
            case "ta.crossunder" -> "Returns true when series1 crosses under series2.";
            case "ta.change" -> "Returns the difference between the current value and its value n bars ago.";
            case "ta.highest" -> "Returns the highest value for a given number of bars back.";
            case "ta.lowest" -> "Returns the lowest value for a given number of bars back.";
            case "input.int" -> "Adds an integer input to the script settings.";
            case "input.float" -> "Adds a float input to the script settings.";
            case "input.bool" -> "Adds a boolean input to the script settings.";
            case "input.string" -> "Adds a string input to the script settings.";
            case "input.source" -> "Adds a source input to the script settings.";
            case "input.color" -> "Adds a color input to the script settings.";
            case "math.max" -> "Returns the greatest of two values.";
            case "math.min" -> "Returns the smallest of two values.";
            case "math.abs" -> "Returns the absolute value of a number.";
            case "math.round" -> "Rounds a number to the nearest integer or to a specified precision.";
            case "math.floor" -> "Rounds a number down to the nearest integer.";
            case "math.ceil" -> "Rounds a number up to the nearest integer.";
            case "array.new_float" -> "Creates a new float array.";
            case "array.get" -> "Returns the value at a specified index in an array.";
            case "array.set" -> "Sets the value at a specified index in an array.";
            case "array.push" -> "Appends a value to the end of an array.";
            case "array.size" -> "Returns the number of elements in an array.";
            case "request.security" -> "Requests data from another symbol or timeframe.";
            case "alert" -> "Creates an alert event.";
            case "alertcondition" -> "Creates an alert condition.";
            case "strategy.entry" -> "Generates a strategy entry order.";
            case "strategy.exit" -> "Generates a strategy exit order.";
            case "strategy.close" -> "Closes market position.";
            default -> null;
        };
    }

    private boolean isWhitespace(PsiElement element) {
        if (element == null) {
            return false;
        }
        IElementType type = element.getNode() != null ? element.getNode().getElementType() : null;
        return type == PineScriptTokenTypes.WHITE_SPACE;
    }
}
