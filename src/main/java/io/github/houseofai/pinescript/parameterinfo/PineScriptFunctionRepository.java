package io.github.houseofai.pinescript.parameterinfo;

import java.util.HashMap;
import java.util.Map;

import static io.github.houseofai.pinescript.parameterinfo.PineScriptFunctionSignature.Parameter;

/**
 * Repository of Pine Script function signatures.
 */
public class PineScriptFunctionRepository {
    private static final Map<String, PineScriptFunctionSignature> SIGNATURES = new HashMap<>();

    static {
        // Plot functions
        SIGNATURES.put("plot", new PineScriptFunctionSignature("plot",
                new Parameter("series", "series"),
                new Parameter("title", "string", "\"\""),
                new Parameter("color", "color", "color.blue"),
                new Parameter("linewidth", "int", "1"),
                new Parameter("style", "plot_style", "plot.style_line"),
                new Parameter("trackprice", "bool", "false"),
                new Parameter("histbase", "float", "0.0"),
                new Parameter("offset", "int", "0"),
                new Parameter("join", "bool", "false"),
                new Parameter("editable", "bool", "true"),
                new Parameter("show_last", "int", "na"),
                new Parameter("display", "plot_display", "display.all")
        ));

        SIGNATURES.put("plotshape", new PineScriptFunctionSignature("plotshape",
                new Parameter("series", "series"),
                new Parameter("title", "string", "\"\""),
                new Parameter("style", "string", "shape.xcross"),
                new Parameter("location", "string", "location.abovebar"),
                new Parameter("color", "color", "color.red"),
                new Parameter("offset", "int", "0"),
                new Parameter("text", "string", "\"\""),
                new Parameter("textcolor", "color", "color.black"),
                new Parameter("editable", "bool", "true"),
                new Parameter("size", "string", "size.auto"),
                new Parameter("show_last", "int", "na"),
                new Parameter("display", "plot_display", "display.all")
        ));

        SIGNATURES.put("plotchar", new PineScriptFunctionSignature("plotchar",
                new Parameter("series", "series"),
                new Parameter("title", "string", "\"\""),
                new Parameter("char", "string", "\"\""),
                new Parameter("location", "string", "location.abovebar"),
                new Parameter("color", "color", "color.red"),
                new Parameter("offset", "int", "0"),
                new Parameter("text", "string", "\"\""),
                new Parameter("textcolor", "color", "color.black"),
                new Parameter("editable", "bool", "true"),
                new Parameter("size", "string", "size.auto"),
                new Parameter("show_last", "int", "na"),
                new Parameter("display", "plot_display", "display.all")
        ));

        SIGNATURES.put("hline", new PineScriptFunctionSignature("hline",
                new Parameter("price", "float"),
                new Parameter("title", "string", "\"\""),
                new Parameter("color", "color", "color.black"),
                new Parameter("linestyle", "hline_style", "hline.style_solid"),
                new Parameter("linewidth", "int", "1"),
                new Parameter("editable", "bool", "true"),
                new Parameter("display", "plot_display", "display.all")
        ));

        SIGNATURES.put("fill", new PineScriptFunctionSignature("fill",
                new Parameter("hline1", "hline/plot"),
                new Parameter("hline2", "hline/plot"),
                new Parameter("color", "color", "color.blue"),
                new Parameter("title", "string", "\"\""),
                new Parameter("editable", "bool", "true"),
                new Parameter("show_last", "int", "na"),
                new Parameter("fillgaps", "bool", "false")
        ));

        SIGNATURES.put("bgcolor", new PineScriptFunctionSignature("bgcolor",
                new Parameter("color", "color"),
                new Parameter("offset", "int", "0"),
                new Parameter("editable", "bool", "true"),
                new Parameter("show_last", "int", "na"),
                new Parameter("title", "string", "\"\""),
                new Parameter("display", "plot_display", "display.all")
        ));

        // Technical Analysis functions
        SIGNATURES.put("ta.sma", new PineScriptFunctionSignature("ta.sma",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.ema", new PineScriptFunctionSignature("ta.ema",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.rsi", new PineScriptFunctionSignature("ta.rsi",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.macd", new PineScriptFunctionSignature("ta.macd",
                new Parameter("source", "series"),
                new Parameter("fastlen", "int"),
                new Parameter("slowlen", "int"),
                new Parameter("siglen", "int")
        ));

        SIGNATURES.put("ta.stoch", new PineScriptFunctionSignature("ta.stoch",
                new Parameter("source", "series"),
                new Parameter("high", "series"),
                new Parameter("low", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.bb", new PineScriptFunctionSignature("ta.bb",
                new Parameter("source", "series"),
                new Parameter("length", "int"),
                new Parameter("mult", "float")
        ));

        SIGNATURES.put("ta.atr", new PineScriptFunctionSignature("ta.atr",
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.crossover", new PineScriptFunctionSignature("ta.crossover",
                new Parameter("source1", "series"),
                new Parameter("source2", "series")
        ));

        SIGNATURES.put("ta.crossunder", new PineScriptFunctionSignature("ta.crossunder",
                new Parameter("source1", "series"),
                new Parameter("source2", "series")
        ));

        SIGNATURES.put("ta.cross", new PineScriptFunctionSignature("ta.cross",
                new Parameter("source1", "series"),
                new Parameter("source2", "series")
        ));

        SIGNATURES.put("ta.wma", new PineScriptFunctionSignature("ta.wma",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.rma", new PineScriptFunctionSignature("ta.rma",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.vwma", new PineScriptFunctionSignature("ta.vwma",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.swma", new PineScriptFunctionSignature("ta.swma",
                new Parameter("source", "series")
        ));

        SIGNATURES.put("ta.hma", new PineScriptFunctionSignature("ta.hma",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.alma", new PineScriptFunctionSignature("ta.alma",
                new Parameter("series", "series"),
                new Parameter("length", "int"),
                new Parameter("offset", "float", "0.85"),
                new Parameter("sigma", "float", "6.0")
        ));

        SIGNATURES.put("ta.cci", new PineScriptFunctionSignature("ta.cci",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.mfi", new PineScriptFunctionSignature("ta.mfi",
                new Parameter("series", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.roc", new PineScriptFunctionSignature("ta.roc",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.mom", new PineScriptFunctionSignature("ta.mom",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.change", new PineScriptFunctionSignature("ta.change",
                new Parameter("source", "series"),
                new Parameter("length", "int", "1")
        ));

        SIGNATURES.put("ta.rising", new PineScriptFunctionSignature("ta.rising",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.falling", new PineScriptFunctionSignature("ta.falling",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.highest", new PineScriptFunctionSignature("ta.highest",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.lowest", new PineScriptFunctionSignature("ta.lowest",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.highestbars", new PineScriptFunctionSignature("ta.highestbars",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.lowestbars", new PineScriptFunctionSignature("ta.lowestbars",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.stdev", new PineScriptFunctionSignature("ta.stdev",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.variance", new PineScriptFunctionSignature("ta.variance",
                new Parameter("source", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.correlation", new PineScriptFunctionSignature("ta.correlation",
                new Parameter("source1", "series"),
                new Parameter("source2", "series"),
                new Parameter("length", "int")
        ));

        SIGNATURES.put("ta.barssince", new PineScriptFunctionSignature("ta.barssince",
                new Parameter("condition", "bool")
        ));

        SIGNATURES.put("ta.valuewhen", new PineScriptFunctionSignature("ta.valuewhen",
                new Parameter("condition", "bool"),
                new Parameter("source", "series"),
                new Parameter("occurrence", "int")
        ));

        SIGNATURES.put("ta.pivothigh", new PineScriptFunctionSignature("ta.pivothigh",
                new Parameter("source", "series"),
                new Parameter("leftbars", "int"),
                new Parameter("rightbars", "int")
        ));

        SIGNATURES.put("ta.pivotlow", new PineScriptFunctionSignature("ta.pivotlow",
                new Parameter("source", "series"),
                new Parameter("leftbars", "int"),
                new Parameter("rightbars", "int")
        ));

        SIGNATURES.put("ta.cum", new PineScriptFunctionSignature("ta.cum",
                new Parameter("source", "series")
        ));

        SIGNATURES.put("ta.tr", new PineScriptFunctionSignature("ta.tr",
                new Parameter("handle_na", "bool", "false")
        ));

        // Strategy functions
        SIGNATURES.put("strategy.entry", new PineScriptFunctionSignature("strategy.entry",
                new Parameter("id", "string"),
                new Parameter("direction", "strategy_direction"),
                new Parameter("qty", "float", "na"),
                new Parameter("limit", "float", "na"),
                new Parameter("stop", "float", "na"),
                new Parameter("oca_name", "string", "\"\""),
                new Parameter("oca_type", "string", "na"),
                new Parameter("comment", "string", "\"\""),
                new Parameter("when", "bool", "true"),
                new Parameter("alert_message", "string", "na")
        ));

        SIGNATURES.put("strategy.exit", new PineScriptFunctionSignature("strategy.exit",
                new Parameter("id", "string"),
                new Parameter("from_entry", "string", "\"\""),
                new Parameter("qty", "float", "na"),
                new Parameter("qty_percent", "float", "na"),
                new Parameter("profit", "float", "na"),
                new Parameter("limit", "float", "na"),
                new Parameter("loss", "float", "na"),
                new Parameter("stop", "float", "na"),
                new Parameter("trail_price", "float", "na"),
                new Parameter("trail_points", "float", "na"),
                new Parameter("trail_offset", "float", "na"),
                new Parameter("oca_name", "string", "\"\""),
                new Parameter("comment", "string", "\"\""),
                new Parameter("when", "bool", "true"),
                new Parameter("alert_message", "string", "na")
        ));

        SIGNATURES.put("strategy.close", new PineScriptFunctionSignature("strategy.close",
                new Parameter("id", "string"),
                new Parameter("when", "bool", "true"),
                new Parameter("comment", "string", "\"\""),
                new Parameter("qty", "float", "na"),
                new Parameter("qty_percent", "float", "na"),
                new Parameter("alert_message", "string", "na")
        ));

        SIGNATURES.put("strategy.close_all", new PineScriptFunctionSignature("strategy.close_all",
                new Parameter("when", "bool", "true"),
                new Parameter("comment", "string", "\"\""),
                new Parameter("alert_message", "string", "na")
        ));

        // Request functions
        SIGNATURES.put("request.security", new PineScriptFunctionSignature("request.security",
                new Parameter("symbol", "string"),
                new Parameter("timeframe", "string"),
                new Parameter("expression", "series"),
                new Parameter("gaps", "barmerge_gaps", "barmerge.gaps_off"),
                new Parameter("lookahead", "barmerge_lookahead", "barmerge.lookahead_off"),
                new Parameter("ignore_invalid_symbol", "bool", "false"),
                new Parameter("currency", "string", "na")
        ));

        // Input functions
        SIGNATURES.put("input.int", new PineScriptFunctionSignature("input.int",
                new Parameter("defval", "int"),
                new Parameter("title", "string", "\"\""),
                new Parameter("minval", "int", "na"),
                new Parameter("maxval", "int", "na"),
                new Parameter("step", "int", "1"),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.float", new PineScriptFunctionSignature("input.float",
                new Parameter("defval", "float"),
                new Parameter("title", "string", "\"\""),
                new Parameter("minval", "float", "na"),
                new Parameter("maxval", "float", "na"),
                new Parameter("step", "float", "0.1"),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.bool", new PineScriptFunctionSignature("input.bool",
                new Parameter("defval", "bool"),
                new Parameter("title", "string", "\"\""),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.string", new PineScriptFunctionSignature("input.string",
                new Parameter("defval", "string"),
                new Parameter("title", "string", "\"\""),
                new Parameter("options", "string[]", "na"),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.color", new PineScriptFunctionSignature("input.color",
                new Parameter("defval", "color"),
                new Parameter("title", "string", "\"\""),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.source", new PineScriptFunctionSignature("input.source",
                new Parameter("defval", "series"),
                new Parameter("title", "string", "\"\""),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\"")
        ));

        SIGNATURES.put("input.timeframe", new PineScriptFunctionSignature("input.timeframe",
                new Parameter("defval", "string"),
                new Parameter("title", "string", "\"\""),
                new Parameter("options", "string[]", "na"),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.session", new PineScriptFunctionSignature("input.session",
                new Parameter("defval", "string"),
                new Parameter("title", "string", "\"\""),
                new Parameter("options", "string[]", "na"),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.symbol", new PineScriptFunctionSignature("input.symbol",
                new Parameter("defval", "string"),
                new Parameter("title", "string", "\"\""),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.price", new PineScriptFunctionSignature("input.price",
                new Parameter("defval", "float"),
                new Parameter("title", "string", "\"\""),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.time", new PineScriptFunctionSignature("input.time",
                new Parameter("defval", "int"),
                new Parameter("title", "string", "\"\""),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("inline", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        SIGNATURES.put("input.text_area", new PineScriptFunctionSignature("input.text_area",
                new Parameter("defval", "string"),
                new Parameter("title", "string", "\"\""),
                new Parameter("tooltip", "string", "\"\""),
                new Parameter("group", "string", "\"\""),
                new Parameter("confirm", "bool", "false")
        ));

        // Math functions
        SIGNATURES.put("math.abs", new PineScriptFunctionSignature("math.abs",
                new Parameter("x", "number")
        ));

        SIGNATURES.put("math.max", new PineScriptFunctionSignature("math.max",
                new Parameter("x", "number"),
                new Parameter("y", "number")
        ));

        SIGNATURES.put("math.min", new PineScriptFunctionSignature("math.min",
                new Parameter("x", "number"),
                new Parameter("y", "number")
        ));

        SIGNATURES.put("math.round", new PineScriptFunctionSignature("math.round",
                new Parameter("x", "number"),
                new Parameter("precision", "int", "0")
        ));

        SIGNATURES.put("math.pow", new PineScriptFunctionSignature("math.pow",
                new Parameter("base", "number"),
                new Parameter("exponent", "number")
        ));

        // Alert functions
        SIGNATURES.put("alert", new PineScriptFunctionSignature("alert",
                new Parameter("message", "string"),
                new Parameter("freq", "string", "alert.freq_once_per_bar")
        ));

        SIGNATURES.put("alertcondition", new PineScriptFunctionSignature("alertcondition",
                new Parameter("condition", "bool"),
                new Parameter("title", "string", "\"\""),
                new Parameter("message", "string", "\"\"")
        ));

        // Additional commonly used functions
        SIGNATURES.put("barcolor", new PineScriptFunctionSignature("barcolor",
                new Parameter("color", "color"),
                new Parameter("offset", "int", "0"),
                new Parameter("editable", "bool", "true"),
                new Parameter("show_last", "int", "na"),
                new Parameter("title", "string", "\"\""),
                new Parameter("display", "plot_display", "display.all")
        ));

        SIGNATURES.put("plotarrow", new PineScriptFunctionSignature("plotarrow",
                new Parameter("series", "series"),
                new Parameter("title", "string", "\"\""),
                new Parameter("colorup", "color", "color.green"),
                new Parameter("colordown", "color", "color.red"),
                new Parameter("offset", "int", "0"),
                new Parameter("minheight", "int", "5"),
                new Parameter("maxheight", "int", "100"),
                new Parameter("editable", "bool", "true"),
                new Parameter("show_last", "int", "na"),
                new Parameter("display", "plot_display", "display.all")
        ));

        SIGNATURES.put("plotbar", new PineScriptFunctionSignature("plotbar",
                new Parameter("open", "series"),
                new Parameter("high", "series"),
                new Parameter("low", "series"),
                new Parameter("close", "series"),
                new Parameter("title", "string", "\"\""),
                new Parameter("color", "color", "color.blue"),
                new Parameter("editable", "bool", "true"),
                new Parameter("show_last", "int", "na"),
                new Parameter("display", "plot_display", "display.all")
        ));

        SIGNATURES.put("plotcandle", new PineScriptFunctionSignature("plotcandle",
                new Parameter("open", "series"),
                new Parameter("high", "series"),
                new Parameter("low", "series"),
                new Parameter("close", "series"),
                new Parameter("title", "string", "\"\""),
                new Parameter("color", "color", "color.green"),
                new Parameter("wickcolor", "color", "color.black"),
                new Parameter("editable", "bool", "true"),
                new Parameter("show_last", "int", "na"),
                new Parameter("bordercolor", "color", "na"),
                new Parameter("display", "plot_display", "display.all")
        ));

        SIGNATURES.put("time", new PineScriptFunctionSignature("time",
                new Parameter("timeframe", "string"),
                new Parameter("session", "string", "\"\""),
                new Parameter("timezone", "string", "\"\"")
        ));

        SIGNATURES.put("time_close", new PineScriptFunctionSignature("time_close",
                new Parameter("timeframe", "string"),
                new Parameter("session", "string", "\"\""),
                new Parameter("timezone", "string", "\"\"")
        ));

        SIGNATURES.put("timestamp", new PineScriptFunctionSignature("timestamp",
                new Parameter("year", "int"),
                new Parameter("month", "int"),
                new Parameter("day", "int"),
                new Parameter("hour", "int"),
                new Parameter("minute", "int"),
                new Parameter("second", "int", "0")
        ));

        // Indicator/Strategy declaration
        SIGNATURES.put("indicator", new PineScriptFunctionSignature("indicator",
                new Parameter("title", "string"),
                new Parameter("shorttitle", "string", "\"\""),
                new Parameter("overlay", "bool", "false"),
                new Parameter("format", "string", "format.inherit"),
                new Parameter("precision", "int", "na"),
                new Parameter("scale", "string", "scale.right"),
                new Parameter("max_bars_back", "int", "na"),
                new Parameter("timeframe", "string", "\"\""),
                new Parameter("timeframe_gaps", "bool", "true"),
                new Parameter("explicit_plot_zorder", "bool", "false"),
                new Parameter("max_lines_count", "int", "50"),
                new Parameter("max_labels_count", "int", "50"),
                new Parameter("max_boxes_count", "int", "50")
        ));

        SIGNATURES.put("strategy", new PineScriptFunctionSignature("strategy",
                new Parameter("title", "string"),
                new Parameter("shorttitle", "string", "\"\""),
                new Parameter("overlay", "bool", "false"),
                new Parameter("format", "string", "format.inherit"),
                new Parameter("precision", "int", "na"),
                new Parameter("scale", "string", "scale.right"),
                new Parameter("pyramiding", "int", "0"),
                new Parameter("calc_on_order_fills", "bool", "false"),
                new Parameter("calc_on_every_tick", "bool", "false"),
                new Parameter("max_bars_back", "int", "na"),
                new Parameter("backtest_fill_limits_assumption", "int", "0"),
                new Parameter("default_qty_type", "string", "strategy.fixed"),
                new Parameter("default_qty_value", "float", "1"),
                new Parameter("initial_capital", "float", "1000000"),
                new Parameter("currency", "string", "currency.NONE"),
                new Parameter("slippage", "int", "0"),
                new Parameter("commission_type", "string", "strategy.commission.percent"),
                new Parameter("commission_value", "float", "0"),
                new Parameter("process_orders_on_close", "bool", "false"),
                new Parameter("close_entries_rule", "string", "\"\""),
                new Parameter("margin_long", "float", "0"),
                new Parameter("margin_short", "float", "0"),
                new Parameter("explicit_plot_zorder", "bool", "false"),
                new Parameter("max_lines_count", "int", "50"),
                new Parameter("max_labels_count", "int", "50"),
                new Parameter("max_boxes_count", "int", "50"),
                new Parameter("risk_free_rate", "float", "0")
        ));
    }

    public static PineScriptFunctionSignature getSignature(String functionName) {
        return SIGNATURES.get(functionName);
    }

    public static boolean hasSignature(String functionName) {
        return SIGNATURES.containsKey(functionName);
    }
}
