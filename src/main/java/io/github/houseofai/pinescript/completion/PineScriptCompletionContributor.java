package io.github.houseofai.pinescript.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import io.github.houseofai.pinescript.PineScriptLanguage;
import org.jetbrains.annotations.NotNull;

public class PineScriptCompletionContributor extends CompletionContributor {

    public PineScriptCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(PineScriptLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters,
                                                 @NotNull ProcessingContext context,
                                                 @NotNull CompletionResultSet result) {
                        addPineScriptCompletions(result);
                    }
                });
    }

    private void addPineScriptCompletions(CompletionResultSet result) {
        // Keywords
        String[] keywords = {
            "if", "else", "for", "while", "break", "continue", "return",
            "function", "var", "varip", "import", "export",
            "indicator", "strategy", "library", "true", "false", "na"
        };

        for (String keyword : keywords) {
            result.addElement(LookupElementBuilder.create(keyword)
                    .withTypeText("keyword")
                    .bold());
        }

        // Built-in variables
        String[] builtins = {
            "open", "high", "low", "close", "volume", "time",
            "bar_index", "hl2", "hlc3", "ohlc4",
            "syminfo.baseCurrency", "syminfo.currency", "syminfo.timezone"
        };

        for (String builtin : builtins) {
            result.addElement(LookupElementBuilder.create(builtin)
                    .withTypeText("built-in variable")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Variable));
        }

        // Technical analysis functions
        String[][] taFunctions = {
            {"sma", "Simple Moving Average"},
            {"ema", "Exponential Moving Average"},
            {"rsi", "Relative Strength Index"},
            {"macd", "MACD"},
            {"stoch", "Stochastic Oscillator"},
            {"bb", "Bollinger Bands"},
            {"atr", "Average True Range"},
            {"kama", "Kaufman Adaptive Moving Average"},
            {"dmi", "Directional Movement Index"},
            {"aroon", "Aroon Oscillator"}
        };

        for (String[] func : taFunctions) {
            result.addElement(LookupElementBuilder.create("ta." + func[0])
                    .withTypeText(func[1])
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Request functions
        String[][] requestFunctions = {
            {"security", "request.security(symbol, timeframe, expression)"},
            {"earnings", "request.earnings(symbol, field, period)"},
            {"dividends", "request.dividends(symbol, type, period)"}
        };

        for (String[] func : requestFunctions) {
            result.addElement(LookupElementBuilder.create("request." + func[0])
                    .withTypeText(func[1])
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Strategy functions
        String[][] strategyFunctions = {
            {"entry", "strategy.entry(id, direction, qty, limit, stop, ...)"},
            {"exit", "strategy.exit(id, from_entry, qty, limit, stop, ...)"},
            {"order", "strategy.order(id, direction, qty, limit, stop, ...)"},
            {"position_avg_price", "strategy.position_avg_price"},
            {"position_size", "strategy.position_size"}
        };

        for (String[] func : strategyFunctions) {
            result.addElement(LookupElementBuilder.create("strategy." + func[0])
                    .withTypeText(func[1])
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Math functions
        String[] mathFunctions = {
            "abs", "acos", "asin", "atan", "avg", "ceil", "cos",
            "exp", "floor", "log", "log10", "max", "min", "pow",
            "round", "sign", "sin", "sqrt", "sum", "tan"
        };

        for (String func : mathFunctions) {
            result.addElement(LookupElementBuilder.create("math." + func)
                    .withTypeText("math function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // String functions
        String[] stringFunctions = {
            "tostring", "tonumber", "format", "substring"
        };

        for (String func : stringFunctions) {
            result.addElement(LookupElementBuilder.create("str." + func)
                    .withTypeText("string function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Chart types
        String[] chartTypes = {
            "type_bar", "type_candle", "type_hollow_candle",
            "type_line", "type_area", "type_renko",
            "type_linebreak", "type_kagi", "type_point_and_figure"
        };

        for (String chartType : chartTypes) {
            result.addElement(LookupElementBuilder.create("chart." + chartType)
                    .withTypeText("chart type")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }
    }
}
