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
        // Keywords (PineScript v6)
        String[] keywords = {
            "if", "else", "for", "while", "switch", "break", "continue", "return",
            "function", "method", "var", "varip", "type", "enum",
            "import", "export", "indicator", "strategy", "library",
            "true", "false", "na", "and", "or", "not"
        };

        for (String keyword : keywords) {
            result.addElement(LookupElementBuilder.create(keyword)
                    .withTypeText("keyword")
                    .bold());
        }

        // Built-in variables
        String[] builtins = {
            "open", "high", "low", "close", "volume", "time",
            "bar_index", "last_bar_index", "hl2", "hlc3", "ohlc4", "hlcc4",
            "barstate.isconfirmed", "barstate.isfirst", "barstate.ishistory",
            "barstate.islast", "barstate.islastconfirmedhistory", "barstate.isnew", "barstate.isrealtime",
            "syminfo.basecurrency", "syminfo.currency", "syminfo.description",
            "syminfo.mintick", "syminfo.pointvalue", "syminfo.prefix",
            "syminfo.root", "syminfo.session", "syminfo.ticker", "syminfo.tickerid", "syminfo.timezone", "syminfo.type",
            "timeframe.period", "timeframe.multiplier", "timeframe.isdaily", "timeframe.isdwm",
            "timeframe.isintraday", "timeframe.isminutes", "timeframe.ismonthly", "timeframe.isseconds", "timeframe.isweekly"
        };

        for (String builtin : builtins) {
            result.addElement(LookupElementBuilder.create(builtin)
                    .withTypeText("built-in variable")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Variable));
        }

        // Technical analysis functions (ta.*)
        String[][] taFunctions = {
            {"sma", "Simple Moving Average"},
            {"ema", "Exponential Moving Average"},
            {"wma", "Weighted Moving Average"},
            {"vwma", "Volume Weighted Moving Average"},
            {"rma", "Rolling Moving Average"},
            {"rsi", "Relative Strength Index"},
            {"macd", "MACD"},
            {"stoch", "Stochastic Oscillator"},
            {"cci", "Commodity Channel Index"},
            {"mfi", "Money Flow Index"},
            {"bb", "Bollinger Bands"},
            {"bbw", "Bollinger Bands Width"},
            {"kc", "Keltner Channels"},
            {"atr", "Average True Range"},
            {"tr", "True Range"},
            {"sar", "Parabolic SAR"},
            {"supertrend", "SuperTrend"},
            {"kama", "Kaufman Adaptive Moving Average"},
            {"alma", "Arnaud Legoux Moving Average"},
            {"dmi", "Directional Movement Index"},
            {"adx", "Average Directional Index"},
            {"aroon", "Aroon Oscillator"},
            {"mom", "Momentum"},
            {"roc", "Rate of Change"},
            {"tsi", "True Strength Index"},
            {"obv", "On Balance Volume"},
            {"cum", "Cumulative (total sum)"},
            {"sma", "Simple Moving Average"},
            {"change", "Difference between current and previous value"},
            {"correlation", "Correlation coefficient"},
            {"stdev", "Standard Deviation"},
            {"variance", "Variance"},
            {"median", "Median"},
            {"mode", "Mode"},
            {"range", "Range (highest - lowest)"},
            {"percentile_linear_interpolation", "Percentile with linear interpolation"},
            {"percentile_nearest_rank", "Percentile with nearest rank"},
            {"percentrank", "Percent rank"},
            {"cross", "Cross (two series cross each other)"},
            {"crossover", "Crossover (series crosses over another)"},
            {"crossunder", "Crossunder (series crosses under another)"},
            {"valuewhen", "Value when condition is true"},
            {"barssince", "Bars since condition was true"},
            {"highest", "Highest value for a given number of bars"},
            {"lowest", "Lowest value for a given number of bars"},
            {"highestbars", "Offset to the highest bar"},
            {"lowestbars", "Offset to the lowest bar"},
            {"pivothigh", "Pivot high"},
            {"pivotlow", "Pivot low"}
        };

        for (String[] func : taFunctions) {
            result.addElement(LookupElementBuilder.create("ta." + func[0])
                    .withTypeText(func[1])
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Request functions
        String[][] requestFunctions = {
            {"security", "Request data from another symbol/timeframe"},
            {"security_lower_tf", "Request data from lower timeframe"},
            {"earnings", "Request earnings data"},
            {"dividends", "Request dividends data"},
            {"splits", "Request stock splits data"},
            {"financial", "Request financial data"},
            {"economic", "Request economic data"},
            {"quandl", "Request Quandl data"},
            {"currency_rate", "Get currency exchange rate"},
            {"seed", "Seed data from another symbol"}
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
            {"close", "strategy.close(id, when, comment, ...)"},
            {"close_all", "strategy.close_all(when, comment, ...)"},
            {"cancel", "strategy.cancel(id)"},
            {"cancel_all", "strategy.cancel_all()"},
            {"position_avg_price", "Average entry price"},
            {"position_size", "Current position size"},
            {"opentrades", "Number of open trades"},
            {"closedtrades", "Number of closed trades"},
            {"wintrades", "Number of winning trades"},
            {"losstrades", "Number of losing trades"},
            {"eventrades", "Number of break-even trades"},
            {"grossprofit", "Total gross profit"},
            {"grossloss", "Total gross loss"},
            {"netprofit", "Total net profit"},
            {"max_drawdown", "Maximum drawdown"}
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
            "round", "round_to_mintick", "sign", "sin", "sqrt", "sum", "tan",
            "todegrees", "toradians", "random"
        };

        for (String func : mathFunctions) {
            result.addElement(LookupElementBuilder.create("math." + func)
                    .withTypeText("math function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // String functions
        String[][] stringFunctions = {
            {"tostring", "Convert value to string"},
            {"tonumber", "Convert string to number"},
            {"format", "Format string with arguments"},
            {"format_time", "Format time to string"},
            {"substring", "Extract substring"},
            {"length", "Get string length"},
            {"contains", "Check if contains substring"},
            {"pos", "Find position of substring"},
            {"split", "Split string into array"},
            {"replace", "Replace substring"},
            {"replace_all", "Replace all occurrences"},
            {"match", "Match regex pattern"},
            {"startswith", "Check if starts with"},
            {"endswith", "Check if ends with"},
            {"lower", "Convert to lowercase"},
            {"upper", "Convert to uppercase"},
            {"trim", "Trim whitespace"},
            {"repeat", "Repeat string"}
        };

        for (String[] func : stringFunctions) {
            result.addElement(LookupElementBuilder.create("str." + func[0])
                    .withTypeText(func[1])
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Chart types
        String[] chartTypes = {
            "type_bar", "type_candle", "type_hollow_candle",
            "type_line", "type_area", "type_renko",
            "type_linebreak", "type_kagi", "type_point_and_figure",
            "is_standard", "is_heikinashi", "is_kagi", "is_linebreak",
            "is_pnf", "is_range", "is_renko", "bg_color", "fg_color",
            "left_visible_bar_time", "right_visible_bar_time"
        };

        for (String chartType : chartTypes) {
            result.addElement(LookupElementBuilder.create("chart." + chartType)
                    .withTypeText("chart constant/variable")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Array functions (array.*) - PineScript v6
        String[] arrayFunctions = {
            "new_float", "new_int", "new_bool", "new_string", "new_color",
            "new_line", "new_label", "new_box", "new_table",
            "from", "get", "set", "push", "pop", "shift", "unshift",
            "insert", "remove", "clear", "concat", "copy", "slice",
            "reverse", "sort", "sort_indices", "includes", "indexof", "lastindexof",
            "min", "max", "sum", "avg", "median", "mode", "variance", "stdev",
            "range", "percentile_linear_interpolation", "percentile_nearest_rank",
            "percentrank", "covariance", "standardize", "size", "first", "last",
            "binary_search", "binary_search_leftmost", "binary_search_rightmost",
            "every", "some", "join", "fill"
        };

        for (String func : arrayFunctions) {
            result.addElement(LookupElementBuilder.create("array." + func)
                    .withTypeText("array function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Map functions (map.*) - PineScript v6
        String[] mapFunctions = {
            "new", "get", "put", "put_all", "remove", "clear",
            "contains", "keys", "values", "size", "copy"
        };

        for (String func : mapFunctions) {
            result.addElement(LookupElementBuilder.create("map." + func)
                    .withTypeText("map function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Matrix functions (matrix.*) - PineScript v6
        String[] matrixFunctions = {
            "new", "get", "set", "fill", "copy", "submatrix",
            "add_row", "add_col", "remove_row", "remove_col",
            "swap_rows", "swap_columns", "reverse",
            "transpose", "reshape", "concat",
            "sum", "avg", "median", "mode", "max", "min", "range",
            "stdev", "variance", "rank", "trace", "det", "inv",
            "pinv", "eigenvalues", "eigenvectors",
            "mult", "pow", "diff", "elements_count",
            "row", "col", "rows", "columns", "is_square",
            "is_identity", "is_binary", "is_zero", "is_stochastic",
            "is_symmetric", "is_antisymmetric"
        };

        for (String func : matrixFunctions) {
            result.addElement(LookupElementBuilder.create("matrix." + func)
                    .withTypeText("matrix function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Line functions (line.*)
        String[] lineFunctions = {
            "new", "delete", "get_price", "get_x1", "get_x2", "get_y1", "get_y2",
            "set_color", "set_extend", "set_style", "set_width", "set_xy1", "set_xy2",
            "set_x1", "set_x2", "set_y1", "set_y2", "copy", "all"
        };

        for (String func : lineFunctions) {
            result.addElement(LookupElementBuilder.create("line." + func)
                    .withTypeText("line function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Label functions (label.*)
        String[] labelFunctions = {
            "new", "delete", "get_text", "get_x", "get_y",
            "set_color", "set_size", "set_style", "set_text", "set_textcolor",
            "set_tooltip", "set_x", "set_xy", "set_y", "set_yloc", "copy", "all"
        };

        for (String func : labelFunctions) {
            result.addElement(LookupElementBuilder.create("label." + func)
                    .withTypeText("label function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Box functions (box.*)
        String[] boxFunctions = {
            "new", "delete", "get_bottom", "get_left", "get_right", "get_top",
            "set_bgcolor", "set_border_color", "set_border_style", "set_border_width",
            "set_bottom", "set_extend", "set_left", "set_lefttop", "set_right",
            "set_rightbottom", "set_top", "copy", "all"
        };

        for (String func : boxFunctions) {
            result.addElement(LookupElementBuilder.create("box." + func)
                    .withTypeText("box function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Polyline functions (polyline.*) - PineScript v6
        String[] polylineFunctions = {
            "new", "delete", "copy", "all"
        };

        for (String func : polylineFunctions) {
            result.addElement(LookupElementBuilder.create("polyline." + func)
                    .withTypeText("polyline function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Linefill functions (linefill.*) - PineScript v6
        String[] linefillFunctions = {
            "new", "delete", "get_line1", "get_line2", "set_color", "copy"
        };

        for (String func : linefillFunctions) {
            result.addElement(LookupElementBuilder.create("linefill." + func)
                    .withTypeText("linefill function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Color functions (color.*)
        String[] colorFunctions = {
            "rgb", "new", "from_gradient"
        };

        for (String func : colorFunctions) {
            result.addElement(LookupElementBuilder.create("color." + func)
                    .withTypeText("color function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Color constants
        String[] colorConstants = {
            "aqua", "black", "blue", "fuchsia", "gray", "green", "lime",
            "maroon", "navy", "olive", "orange", "purple", "red", "silver",
            "teal", "white", "yellow"
        };

        for (String color : colorConstants) {
            result.addElement(LookupElementBuilder.create("color." + color)
                    .withTypeText("color constant")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Input functions (input.*)
        String[] inputFunctions = {
            "bool", "color", "float", "int", "string", "text_area",
            "session", "source", "timeframe", "symbol", "price",
            "time", "enum"
        };

        for (String func : inputFunctions) {
            result.addElement(LookupElementBuilder.create("input." + func)
                    .withTypeText("input function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Plot functions
        String[] plotFunctions = {
            "plot", "plotshape", "plotchar", "plotarrow", "plotbar", "plotcandle",
            "hline", "fill", "bgcolor", "barcolor"
        };

        for (String func : plotFunctions) {
            result.addElement(LookupElementBuilder.create(func)
                    .withTypeText("plot function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Timeframe functions (timeframe.*)
        String[] timeframeFunctions = {
            "in_seconds", "from_seconds"
        };

        for (String func : timeframeFunctions) {
            result.addElement(LookupElementBuilder.create("timeframe." + func)
                    .withTypeText("timeframe function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Table functions (table.*)
        String[] tableFunctions = {
            "new", "cell", "cell_set_bgcolor", "cell_set_text_color",
            "cell_set_text", "cell_set_text_size", "cell_set_text_halign",
            "cell_set_text_valign", "cell_set_width", "cell_set_height",
            "clear", "delete", "merge_cells"
        };

        for (String func : tableFunctions) {
            result.addElement(LookupElementBuilder.create("table." + func)
                    .withTypeText("table function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Ticker functions (ticker.*)
        String[] tickerFunctions = {
            "new", "heikinashi", "renko", "linebreak", "kagi", "pointfigure",
            "modify", "standard", "inherit"
        };

        for (String func : tickerFunctions) {
            result.addElement(LookupElementBuilder.create("ticker." + func)
                    .withTypeText("ticker function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Alert functions
        String[] alertFunctions = {
            "alert", "alertcondition"
        };

        for (String func : alertFunctions) {
            result.addElement(LookupElementBuilder.create(func)
                    .withTypeText("alert function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }


        // Additional TA functions
        String[][] additionalTaFunctions = {
            {"wpr", "Williams %R"},
            {"cmo", "Chande Momentum Oscillator"},
            {"cog", "Center of Gravity"},
            {"linreg", "Linear Regression"},
            {"dev", "Deviation"},
            {"falling", "Checks if value is falling"},
            {"rising", "Checks if value is rising"},
            {"hma", "Hull Moving Average"},
            {"swma", "Symmetrically Weighted Moving Average"},
            {"vwap", "Volume Weighted Average Price"},
            {"accdist", "Accumulation/Distribution"},
            {"tsi", "True Strength Index"},
            {"kcw", "Keltner Channels Width"},
            {"pivot_point_levels", "Pivot Point Levels"},
            {"smc", "Stochastic Momentum Convergence"}
        };

        for (String[] func : additionalTaFunctions) {
            result.addElement(LookupElementBuilder.create("ta." + func[0])
                    .withTypeText(func[1])
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Chart functions (chart.point.*)
        String[] chartFunctions = {
            "point.new", "point.now", "point.from_time", "point.from_index", "point.copy"
        };

        for (String func : chartFunctions) {
            result.addElement(LookupElementBuilder.create("chart." + func)
                    .withTypeText("chart function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Log functions
        String[] logFunctions = {
            "error", "warning", "info"
        };

        for (String func : logFunctions) {
            result.addElement(LookupElementBuilder.create("log." + func)
                    .withTypeText("log function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Runtime functions
        result.addElement(LookupElementBuilder.create("runtime.error")
                .withTypeText("runtime error function")
                .withIcon(com.intellij.icons.AllIcons.Nodes.Function));

        // Syminfo functions (note: most syminfo.* are variables, but these are functions)
        String[] syminfoFunctions = {
            "ticker", "prefix"
        };

        for (String func : syminfoFunctions) {
            result.addElement(LookupElementBuilder.create("syminfo." + func)
                    .withTypeText("syminfo function")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Additional global functions
        String[][] globalFunctions = {
            {"time", "Current bar time"},
            {"time_close", "Bar close time"},
            {"timestamp", "Create timestamp"},
            {"year", "Extract year from time"},
            {"month", "Extract month from time"},
            {"weekofyear", "Extract week of year"},
            {"dayofmonth", "Extract day of month"},
            {"dayofweek", "Extract day of week"},
            {"hour", "Extract hour from time"},
            {"minute", "Extract minute from time"},
            {"second", "Extract second from time"},
            {"nz", "Replace NA with zero or value"},
            {"fixnan", "Fix NA values with previous value"},
            {"max_bars_back", "Set maximum bars back"},
            {"int", "Convert to int"},
            {"float", "Convert to float"},
            {"bool", "Convert to bool"},
            {"string", "Convert to string"},
            {"line", "Cast to line type"},
            {"label", "Cast to label type"},
            {"box", "Cast to box type"}
        };

        for (String[] func : globalFunctions) {
            result.addElement(LookupElementBuilder.create(func[0])
                    .withTypeText(func[1])
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Function));
        }

        // Syminfo variables (additional ones)
        String[] syminfoVars = {
            "syminfo.volumetype", "syminfo.country"
        };

        for (String var : syminfoVars) {
            result.addElement(LookupElementBuilder.create(var)
                    .withTypeText("syminfo variable")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Variable));
        }

        // Plot style constants
        String[] plotStyles = {
            "plot.style_line", "plot.style_linebr", "plot.style_stepline",
            "plot.style_stepline_diamond", "plot.style_histogram", "plot.style_cross",
            "plot.style_area", "plot.style_columns", "plot.style_circles", "plot.style_areabr"
        };

        for (String style : plotStyles) {
            result.addElement(LookupElementBuilder.create(style)
                    .withTypeText("plot style")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Display constants
        String[] displayConstants = {
            "display.none", "display.all", "display.data_window", "display.pane",
            "display.price_scale", "display.status_line"
        };

        for (String constant : displayConstants) {
            result.addElement(LookupElementBuilder.create(constant)
                    .withTypeText("display constant")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Location constants
        String[] locationConstants = {
            "location.abovebar", "location.belowbar", "location.top", "location.bottom",
            "location.absolute"
        };

        for (String constant : locationConstants) {
            result.addElement(LookupElementBuilder.create(constant)
                    .withTypeText("location constant")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Size constants
        String[] sizeConstants = {
            "size.auto", "size.tiny", "size.small", "size.normal", "size.large", "size.huge"
        };

        for (String constant : sizeConstants) {
            result.addElement(LookupElementBuilder.create(constant)
                    .withTypeText("size constant")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Shape constants
        String[] shapeConstants = {
            "shape.xcross", "shape.cross", "shape.circle", "shape.triangleup", "shape.triangledown",
            "shape.flag", "shape.arrowup", "shape.arrowdown", "shape.square", "shape.diamond",
            "shape.labelup", "shape.labeldown"
        };

        for (String constant : shapeConstants) {
            result.addElement(LookupElementBuilder.create(constant)
                    .withTypeText("shape constant")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Format constants
        String[] formatConstants = {
            "format.inherit", "format.price", "format.volume", "format.percent"
        };

        for (String constant : formatConstants) {
            result.addElement(LookupElementBuilder.create(constant)
                    .withTypeText("format constant")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Scale constants
        String[] scaleConstants = {
            "scale.right", "scale.left", "scale.none"
        };

        for (String constant : scaleConstants) {
            result.addElement(LookupElementBuilder.create(constant)
                    .withTypeText("scale constant")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Hline style constants
        String[] hlineStyles = {
            "hline.style_solid", "hline.style_dotted", "hline.style_dashed"
        };

        for (String style : hlineStyles) {
            result.addElement(LookupElementBuilder.create(style)
                    .withTypeText("hline style")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Line style constants
        String[] lineStyles = {
            "line.style_solid", "line.style_dotted", "line.style_dashed", "line.style_arrow_left",
            "line.style_arrow_right", "line.style_arrow_both"
        };

        for (String style : lineStyles) {
            result.addElement(LookupElementBuilder.create(style)
                    .withTypeText("line style")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }

        // Extend constants
        String[] extendConstants = {
            "extend.none", "extend.left", "extend.right", "extend.both"
        };

        for (String constant : extendConstants) {
            result.addElement(LookupElementBuilder.create(constant)
                    .withTypeText("extend constant")
                    .withIcon(com.intellij.icons.AllIcons.Nodes.Constant));
        }
    }
}

