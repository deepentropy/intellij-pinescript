package io.github.houseofai.pinescript.parameterinfo;

import java.util.HashMap;
import java.util.Map;

import static io.github.houseofai.pinescript.parameterinfo.PineScriptFunctionSignature.Parameter;

/**
 * Repository of Pine Script function signatures.
 * Auto-generated from PineScript v6 documentation.
 * Contains 454 function signatures.
 */
public class PineScriptFunctionRepository {
    private static final Map<String, PineScriptFunctionSignature> SIGNATURES = new HashMap<>();

    static {

        // ARRAY functions
        SIGNATURES.put("array.abs", new PineScriptFunctionSignature("array.abs",
                new Parameter("id", "array<int/float>")
        ));
        SIGNATURES.put("array.avg", new PineScriptFunctionSignature("array.avg",
                new Parameter("id", "array<int/float>")
        ));
        SIGNATURES.put("array.binary_search", new PineScriptFunctionSignature("array.binary_search",
                new Parameter("id", "array<int/float>"),
                new Parameter("val", "series int/float")
        ));
        SIGNATURES.put("array.binary_search_leftmost", new PineScriptFunctionSignature("array.binary_search_leftmost",
                new Parameter("id", "array<int/float>"),
                new Parameter("val", "series int/float")
        ));
        SIGNATURES.put("array.binary_search_rightmost", new PineScriptFunctionSignature("array.binary_search_rightmost",
                new Parameter("id", "array<int/float>"),
                new Parameter("val", "series int/float")
        ));
        SIGNATURES.put("array.clear", new PineScriptFunctionSignature("array.clear",
                new Parameter("id", "any array type")
        ));
        SIGNATURES.put("array.concat", new PineScriptFunctionSignature("array.concat",
                new Parameter("id1", "any array type"),
                new Parameter("id2", "any array type")
        ));
        SIGNATURES.put("array.copy", new PineScriptFunctionSignature("array.copy",
                new Parameter("id", "any array type")
        ));
        SIGNATURES.put("array.covariance", new PineScriptFunctionSignature("array.covariance",
                new Parameter("id1", "array<int/float>"),
                new Parameter("id2", "array<int/float>"),
                new Parameter("biased", "series bool", "true")
        ));
        SIGNATURES.put("array.every", new PineScriptFunctionSignature("array.every",
                new Parameter("id", "array<bool>")
        ));
        SIGNATURES.put("array.fill", new PineScriptFunctionSignature("array.fill",
                new Parameter("id", "any array type"),
                new Parameter("value", "series <type of the array's elements>"),
                new Parameter("index_from", "series int", "0"),
                new Parameter("index_to", "series int", "na")
        ));
        SIGNATURES.put("array.first", new PineScriptFunctionSignature("array.first",
                new Parameter("id", "any array type")
        ));
        SIGNATURES.put("array.from", new PineScriptFunctionSignature("array.from",
                new Parameter("arg0", "any"),
                new Parameter("arg1", "any")
        ));
        SIGNATURES.put("array.get", new PineScriptFunctionSignature("array.get",
                new Parameter("id", "any array type"),
                new Parameter("index", "series int")
        ));
        SIGNATURES.put("array.includes", new PineScriptFunctionSignature("array.includes",
                new Parameter("id", "any array type"),
                new Parameter("value", "series <type of the array's elements>")
        ));
        SIGNATURES.put("array.indexof", new PineScriptFunctionSignature("array.indexof",
                new Parameter("id", "any array type"),
                new Parameter("value", "series <type of the array's elements>")
        ));
        SIGNATURES.put("array.insert", new PineScriptFunctionSignature("array.insert",
                new Parameter("id", "any array type"),
                new Parameter("index", "series int"),
                new Parameter("value", "series <type of the array's elements>")
        ));
        SIGNATURES.put("array.join", new PineScriptFunctionSignature("array.join",
                new Parameter("id", "array<int/float/string>"),
                new Parameter("separator", "series string")
        ));
        SIGNATURES.put("array.last", new PineScriptFunctionSignature("array.last",
                new Parameter("id", "any array type")
        ));
        SIGNATURES.put("array.lastindexof", new PineScriptFunctionSignature("array.lastindexof",
                new Parameter("id", "any array type"),
                new Parameter("value", "series <type of the array's elements>")
        ));
        SIGNATURES.put("array.max", new PineScriptFunctionSignature("array.max",
                new Parameter("id", "array<int/float>"),
                new Parameter("nth", "series int", "0")
        ));
        SIGNATURES.put("array.median", new PineScriptFunctionSignature("array.median",
                new Parameter("id", "array<int/float>")
        ));
        SIGNATURES.put("array.min", new PineScriptFunctionSignature("array.min",
                new Parameter("id", "array<int/float>"),
                new Parameter("nth", "series int", "0")
        ));
        SIGNATURES.put("array.mode", new PineScriptFunctionSignature("array.mode",
                new Parameter("id", "array<int/float>")
        ));
        SIGNATURES.put("array.new_bool", new PineScriptFunctionSignature("array.new_bool",
                new Parameter("size", "series int", "0"),
                new Parameter("initial_value", "series bool", "false")
        ));
        SIGNATURES.put("array.new_box", new PineScriptFunctionSignature("array.new_box",
                new Parameter("size", "series int", "0"),
                new Parameter("initial_value", "series box", "na")
        ));
        SIGNATURES.put("array.new_color", new PineScriptFunctionSignature("array.new_color",
                new Parameter("size", "series int", "0"),
                new Parameter("initial_value", "series color", "na")
        ));
        SIGNATURES.put("array.new_float", new PineScriptFunctionSignature("array.new_float",
                new Parameter("size", "series int", "0"),
                new Parameter("initial_value", "series int/float", "na")
        ));
        SIGNATURES.put("array.new_int", new PineScriptFunctionSignature("array.new_int",
                new Parameter("size", "series int", "0"),
                new Parameter("initial_value", "series int", "na")
        ));
        SIGNATURES.put("array.new_label", new PineScriptFunctionSignature("array.new_label",
                new Parameter("size", "series int", "0"),
                new Parameter("initial_value", "series label", "na")
        ));
        SIGNATURES.put("array.new_line", new PineScriptFunctionSignature("array.new_line",
                new Parameter("size", "series int", "0"),
                new Parameter("initial_value", "series line", "na")
        ));
        SIGNATURES.put("array.new_linefill", new PineScriptFunctionSignature("array.new_linefill",
                new Parameter("size", "series int"),
                new Parameter("initial_value", "series linefill")
        ));
        SIGNATURES.put("array.new_string", new PineScriptFunctionSignature("array.new_string",
                new Parameter("size", "series int", "0"),
                new Parameter("initial_value", "series string", "na")
        ));
        SIGNATURES.put("array.new_table", new PineScriptFunctionSignature("array.new_table",
                new Parameter("size", "series int", "0"),
                new Parameter("initial_value", "series table", "na")
        ));
        SIGNATURES.put("array.percentile_linear_interpolation", new PineScriptFunctionSignature("array.percentile_linear_interpolation",
                new Parameter("id", "array<int/float>"),
                new Parameter("percentage", "series int/float")
        ));
        SIGNATURES.put("array.percentile_nearest_rank", new PineScriptFunctionSignature("array.percentile_nearest_rank",
                new Parameter("id", "array<int/float>"),
                new Parameter("percentage", "series int/float")
        ));
        SIGNATURES.put("array.percentrank", new PineScriptFunctionSignature("array.percentrank",
                new Parameter("id", "array<int/float>"),
                new Parameter("index", "series int")
        ));
        SIGNATURES.put("array.pop", new PineScriptFunctionSignature("array.pop",
                new Parameter("id", "any array type")
        ));
        SIGNATURES.put("array.push", new PineScriptFunctionSignature("array.push",
                new Parameter("id", "any array type"),
                new Parameter("value", "series <type of the array's elements>")
        ));
        SIGNATURES.put("array.range", new PineScriptFunctionSignature("array.range",
                new Parameter("id", "array<int/float>")
        ));
        SIGNATURES.put("array.remove", new PineScriptFunctionSignature("array.remove",
                new Parameter("id", "any array type"),
                new Parameter("index", "series int")
        ));
        SIGNATURES.put("array.reverse", new PineScriptFunctionSignature("array.reverse",
                new Parameter("id", "any array type")
        ));
        SIGNATURES.put("array.set", new PineScriptFunctionSignature("array.set",
                new Parameter("id", "any array type"),
                new Parameter("index", "series int"),
                new Parameter("value", "series <type of the array's elements>")
        ));
        SIGNATURES.put("array.shift", new PineScriptFunctionSignature("array.shift",
                new Parameter("id", "any array type")
        ));
        SIGNATURES.put("array.size", new PineScriptFunctionSignature("array.size",
                new Parameter("id", "any array type")
        ));
        SIGNATURES.put("array.slice", new PineScriptFunctionSignature("array.slice",
                new Parameter("id", "any array type"),
                new Parameter("index_from", "series int"),
                new Parameter("index_to", "series int")
        ));
        SIGNATURES.put("array.some", new PineScriptFunctionSignature("array.some",
                new Parameter("id", "array<bool>")
        ));
        SIGNATURES.put("array.sort", new PineScriptFunctionSignature("array.sort",
                new Parameter("id", "array<int/float/string>"),
                new Parameter("order", "series sort_order", ") or order")
        ));
        SIGNATURES.put("array.sort_indices", new PineScriptFunctionSignature("array.sort_indices",
                new Parameter("id", "array<int/float/string>"),
                new Parameter("order", "series sort_order", "order")
        ));
        SIGNATURES.put("array.standardize", new PineScriptFunctionSignature("array.standardize",
                new Parameter("id", "array<int/float>")
        ));
        SIGNATURES.put("array.stdev", new PineScriptFunctionSignature("array.stdev",
                new Parameter("id", "array<int/float>"),
                new Parameter("biased", "series bool", "true")
        ));
        SIGNATURES.put("array.sum", new PineScriptFunctionSignature("array.sum",
                new Parameter("id", "array<int/float>")
        ));
        SIGNATURES.put("array.unshift", new PineScriptFunctionSignature("array.unshift",
                new Parameter("id", "any array type"),
                new Parameter("value", "series <type of the array's elements>")
        ));
        SIGNATURES.put("array.variance", new PineScriptFunctionSignature("array.variance",
                new Parameter("id", "array<int/float>"),
                new Parameter("biased", "series bool", "true")
        ));

        // BOX functions
        SIGNATURES.put("box.copy", new PineScriptFunctionSignature("box.copy",
                new Parameter("id", "series box")
        ));
        SIGNATURES.put("box.delete", new PineScriptFunctionSignature("box.delete",
                new Parameter("id", "series box")
        ));
        SIGNATURES.put("box.get_bottom", new PineScriptFunctionSignature("box.get_bottom",
                new Parameter("id", "series box")
        ));
        SIGNATURES.put("box.get_left", new PineScriptFunctionSignature("box.get_left",
                new Parameter("id", "series box")
        ));
        SIGNATURES.put("box.get_right", new PineScriptFunctionSignature("box.get_right",
                new Parameter("id", "series box")
        ));
        SIGNATURES.put("box.get_top", new PineScriptFunctionSignature("box.get_top",
                new Parameter("id", "series box")
        ));
        SIGNATURES.put("box.new", new PineScriptFunctionSignature("box.new",
                new Parameter("top_left", "chart.point"),
                new Parameter("bottom_right", "chart.point"),
                new Parameter("border_color", "series color", "color"),
                new Parameter("border_width", "series int", "1 pixel"),
                new Parameter("border_style", "series string", "line"),
                new Parameter("extend", "series string", "extend"),
                new Parameter("xloc", "series string", "xloc"),
                new Parameter("bgcolor", "series color", "color"),
                new Parameter("text", "series string", "empty string"),
                new Parameter("text_size", "series int/string", "size"),
                new Parameter("text_color", "series color", "color"),
                new Parameter("text_halign", "series string", "text"),
                new Parameter("text_valign", "series string", "text"),
                new Parameter("text_wrap", "series string", "text"),
                new Parameter("text_font_family", "series string", "font"),
                new Parameter("force_overlay", "const bool", "false"),
                new Parameter("text_formatting", "const text_format", "text")
        ));
        SIGNATURES.put("box.set_bgcolor", new PineScriptFunctionSignature("box.set_bgcolor",
                new Parameter("id", "series box"),
                new Parameter("color", "series color")
        ));
        SIGNATURES.put("box.set_border_color", new PineScriptFunctionSignature("box.set_border_color",
                new Parameter("id", "series box"),
                new Parameter("color", "series color")
        ));
        SIGNATURES.put("box.set_border_style", new PineScriptFunctionSignature("box.set_border_style",
                new Parameter("id", "series box"),
                new Parameter("style", "series string")
        ));
        SIGNATURES.put("box.set_border_width", new PineScriptFunctionSignature("box.set_border_width",
                new Parameter("id", "series box"),
                new Parameter("width", "series int")
        ));
        SIGNATURES.put("box.set_bottom", new PineScriptFunctionSignature("box.set_bottom",
                new Parameter("id", "series box"),
                new Parameter("bottom", "series int/float")
        ));
        SIGNATURES.put("box.set_bottom_right_point", new PineScriptFunctionSignature("box.set_bottom_right_point",
                new Parameter("id", "series box"),
                new Parameter("point", "chart.point")
        ));
        SIGNATURES.put("box.set_extend", new PineScriptFunctionSignature("box.set_extend",
                new Parameter("id", "series box"),
                new Parameter("extend", "series string")
        ));
        SIGNATURES.put("box.set_left", new PineScriptFunctionSignature("box.set_left",
                new Parameter("id", "series box"),
                new Parameter("left", "series int")
        ));
        SIGNATURES.put("box.set_lefttop", new PineScriptFunctionSignature("box.set_lefttop",
                new Parameter("id", "series box"),
                new Parameter("left", "series int"),
                new Parameter("top", "series int/float")
        ));
        SIGNATURES.put("box.set_right", new PineScriptFunctionSignature("box.set_right",
                new Parameter("id", "series box"),
                new Parameter("right", "series int")
        ));
        SIGNATURES.put("box.set_rightbottom", new PineScriptFunctionSignature("box.set_rightbottom",
                new Parameter("id", "series box"),
                new Parameter("right", "series int"),
                new Parameter("bottom", "series int/float")
        ));
        SIGNATURES.put("box.set_text", new PineScriptFunctionSignature("box.set_text",
                new Parameter("id", "series box"),
                new Parameter("text", "series string")
        ));
        SIGNATURES.put("box.set_text_color", new PineScriptFunctionSignature("box.set_text_color",
                new Parameter("id", "series box"),
                new Parameter("text_color", "series color")
        ));
        SIGNATURES.put("box.set_text_font_family", new PineScriptFunctionSignature("box.set_text_font_family",
                new Parameter("id", "series box"),
                new Parameter("text_font_family", "series string")
        ));
        SIGNATURES.put("box.set_text_formatting", new PineScriptFunctionSignature("box.set_text_formatting",
                new Parameter("id", "series box"),
                new Parameter("text_formatting", "const text_format", "text")
        ));
        SIGNATURES.put("box.set_text_halign", new PineScriptFunctionSignature("box.set_text_halign",
                new Parameter("id", "series box"),
                new Parameter("text_halign", "series string")
        ));
        SIGNATURES.put("box.set_text_size", new PineScriptFunctionSignature("box.set_text_size",
                new Parameter("id", "series box"),
                new Parameter("text_size", "series int/string")
        ));
        SIGNATURES.put("box.set_text_valign", new PineScriptFunctionSignature("box.set_text_valign",
                new Parameter("id", "series box"),
                new Parameter("text_valign", "series string")
        ));
        SIGNATURES.put("box.set_text_wrap", new PineScriptFunctionSignature("box.set_text_wrap",
                new Parameter("id", "series box"),
                new Parameter("text_wrap", "series string")
        ));
        SIGNATURES.put("box.set_top", new PineScriptFunctionSignature("box.set_top",
                new Parameter("id", "series box"),
                new Parameter("top", "series int/float")
        ));
        SIGNATURES.put("box.set_top_left_point", new PineScriptFunctionSignature("box.set_top_left_point",
                new Parameter("id", "series box"),
                new Parameter("point", "chart.point")
        ));
        SIGNATURES.put("box.set_xloc", new PineScriptFunctionSignature("box.set_xloc",
                new Parameter("id", "series box"),
                new Parameter("left", "series int"),
                new Parameter("right", "series int"),
                new Parameter("xloc", "series string")
        ));

        // CHART functions
        SIGNATURES.put("chart.point.copy", new PineScriptFunctionSignature("chart.point.copy",
                new Parameter("id", "chart.point")
        ));
        SIGNATURES.put("chart.point.from_index", new PineScriptFunctionSignature("chart.point.from_index",
                new Parameter("index", "series int"),
                new Parameter("price", "series int/float")
        ));
        SIGNATURES.put("chart.point.from_time", new PineScriptFunctionSignature("chart.point.from_time",
                new Parameter("time", "series int"),
                new Parameter("price", "series int/float")
        ));
        SIGNATURES.put("chart.point.new", new PineScriptFunctionSignature("chart.point.new",
                new Parameter("time", "series int"),
                new Parameter("index", "series int"),
                new Parameter("price", "series int/float")
        ));
        SIGNATURES.put("chart.point.now", new PineScriptFunctionSignature("chart.point.now",
                new Parameter("price", "series int/float", "close")
        ));

        // COLOR functions
        SIGNATURES.put("color.b", new PineScriptFunctionSignature("color.b",
                new Parameter("color", "const color")
        ));
        SIGNATURES.put("color.from_gradient", new PineScriptFunctionSignature("color.from_gradient",
                new Parameter("value", "series int/float"),
                new Parameter("bottom_value", "series int/float"),
                new Parameter("top_value", "series int/float"),
                new Parameter("bottom_color", "series color"),
                new Parameter("top_color", "series color")
        ));
        SIGNATURES.put("color.g", new PineScriptFunctionSignature("color.g",
                new Parameter("color", "const color")
        ));
        SIGNATURES.put("color.new", new PineScriptFunctionSignature("color.new",
                new Parameter("color", "const color"),
                new Parameter("transp", "const int/float")
        ));
        SIGNATURES.put("color.r", new PineScriptFunctionSignature("color.r",
                new Parameter("color", "const color")
        ));
        SIGNATURES.put("color.rgb", new PineScriptFunctionSignature("color.rgb",
                new Parameter("red", "const int/float"),
                new Parameter("green", "const int/float"),
                new Parameter("blue", "const int/float"),
                new Parameter("transp", "const int/float", "0")
        ));
        SIGNATURES.put("color.t", new PineScriptFunctionSignature("color.t",
                new Parameter("color", "const color")
        ));

        // CORE functions
        SIGNATURES.put("alert", new PineScriptFunctionSignature("alert",
                new Parameter("message", "series string"),
                new Parameter("freq", "input string", "alert")
        ));
        SIGNATURES.put("alertcondition", new PineScriptFunctionSignature("alertcondition",
                new Parameter("condition", "series bool"),
                new Parameter("title", "const string", "na"),
                new Parameter("message", "const string", "na")
        ));
        SIGNATURES.put("barcolor", new PineScriptFunctionSignature("barcolor",
                new Parameter("color", "series color"),
                new Parameter("offset", "simple int", "0"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("show_last", "input int", "na"),
                new Parameter("title", "const string", "na"),
                new Parameter("display", "input plot_simple_display", "display")
        ));
        SIGNATURES.put("bgcolor", new PineScriptFunctionSignature("bgcolor",
                new Parameter("color", "series color"),
                new Parameter("offset", "simple int", "0"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("show_last", "input int", "na"),
                new Parameter("title", "const string", "na"),
                new Parameter("display", "input plot_simple_display", "display"),
                new Parameter("force_overlay", "const bool", "false")
        ));
        SIGNATURES.put("bool", new PineScriptFunctionSignature("bool",
                new Parameter("x", "simple int/float/bool")
        ));
        SIGNATURES.put("box", new PineScriptFunctionSignature("box",
                new Parameter("x", "series box")
        ));
        SIGNATURES.put("color", new PineScriptFunctionSignature("color",
                new Parameter("x", "const color")
        ));
        SIGNATURES.put("dayofmonth", new PineScriptFunctionSignature("dayofmonth",
                new Parameter("time", "series int"),
                new Parameter("timezone", "series string", "syminfo")
        ));
        SIGNATURES.put("dayofweek", new PineScriptFunctionSignature("dayofweek",
                new Parameter("time", "series int"),
                new Parameter("timezone", "series string", "syminfo")
        ));
        SIGNATURES.put("fill", new PineScriptFunctionSignature("fill",
                new Parameter("hline1", "hline"),
                new Parameter("hline2", "hline"),
                new Parameter("color", "series color", "na"),
                new Parameter("title", "const string", "na"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("fillgaps", "const bool", "false"),
                new Parameter("display", "input plot_simple_display", "display")
        ));
        SIGNATURES.put("fixnan", new PineScriptFunctionSignature("fixnan",
                new Parameter("source", "series color")
        ));
        SIGNATURES.put("float", new PineScriptFunctionSignature("float",
                new Parameter("x", "const int/float")
        ));
        SIGNATURES.put("hline", new PineScriptFunctionSignature("hline",
                new Parameter("price", "input int/float"),
                new Parameter("title", "const string"),
                new Parameter("color", "input color", "na"),
                new Parameter("linestyle", "input hline_style", "na"),
                new Parameter("linewidth", "input int", "1"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("display", "input plot_simple_display", "display")
        ));
        SIGNATURES.put("hour", new PineScriptFunctionSignature("hour",
                new Parameter("time", "series int"),
                new Parameter("timezone", "series string", "syminfo")
        ));
        SIGNATURES.put("indicator", new PineScriptFunctionSignature("indicator",
                new Parameter("title", "const string"),
                new Parameter("shorttitle", "const string", "na"),
                new Parameter("overlay", "const bool", "false"),
                new Parameter("format", "const string", "format"),
                new Parameter("precision", "const int", "na"),
                new Parameter("scale", "const scale_type", "na"),
                new Parameter("max_bars_back", "const int", "0"),
                new Parameter("timeframe", "const string", "na"),
                new Parameter("timeframe_gaps", "const bool", "true"),
                new Parameter("explicit_plot_zorder", "const bool", "false"),
                new Parameter("max_lines_count", "const int", "50"),
                new Parameter("max_labels_count", "const int", "50"),
                new Parameter("max_boxes_count", "const int", "50"),
                new Parameter("calc_bars_count", "const int", "na"),
                new Parameter("max_polylines_count", "const int", "50"),
                new Parameter("dynamic_requests", "const bool", "true"),
                new Parameter("behind_chart", "const bool", "true")
        ));
        SIGNATURES.put("input", new PineScriptFunctionSignature("input",
                new Parameter("defval", "const int/float/bool/string/color or source-type built-ins"),
                new Parameter("title", "const string"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("display", "const plot_display", "na"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("int", new PineScriptFunctionSignature("int",
                new Parameter("x", "const int/float")
        ));
        SIGNATURES.put("label", new PineScriptFunctionSignature("label",
                new Parameter("x", "series label")
        ));
        SIGNATURES.put("library", new PineScriptFunctionSignature("library",
                new Parameter("title", "const string"),
                new Parameter("overlay", "const bool", "false"),
                new Parameter("dynamic_requests", "const bool", "true")
        ));
        SIGNATURES.put("line", new PineScriptFunctionSignature("line",
                new Parameter("x", "series line")
        ));
        SIGNATURES.put("linefill", new PineScriptFunctionSignature("linefill",
                new Parameter("x", "series linefill")
        ));
        SIGNATURES.put("max_bars_back", new PineScriptFunctionSignature("max_bars_back",
                new Parameter("var", "series int/float/bool/color/label/line"),
                new Parameter("num", "const int")
        ));
        SIGNATURES.put("minute", new PineScriptFunctionSignature("minute",
                new Parameter("time", "series int"),
                new Parameter("timezone", "series string", "syminfo")
        ));
        SIGNATURES.put("month", new PineScriptFunctionSignature("month",
                new Parameter("time", "series int"),
                new Parameter("timezone", "series string", "syminfo")
        ));
        SIGNATURES.put("na", new PineScriptFunctionSignature("na",
                new Parameter("x", "simple int/float")
        ));
        SIGNATURES.put("nz", new PineScriptFunctionSignature("nz",
                new Parameter("source", "simple color"),
                new Parameter("replacement", "simple color", "na")
        ));
        SIGNATURES.put("plot", new PineScriptFunctionSignature("plot",
                new Parameter("series", "series int/float"),
                new Parameter("title", "const string"),
                new Parameter("color", "series color", "na"),
                new Parameter("linewidth", "input int", "1"),
                new Parameter("style", "input plot_style", "plot"),
                new Parameter("trackprice", "input bool", "false"),
                new Parameter("histbase", "input int/float", "0"),
                new Parameter("offset", "simple int", "0"),
                new Parameter("join", "input bool", "false"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("show_last", "input int", "na"),
                new Parameter("display", "input plot_display", "display"),
                new Parameter("format", "input string", "na"),
                new Parameter("precision", "input int", "na"),
                new Parameter("force_overlay", "const bool", "false"),
                new Parameter("linestyle", "input plot_line_style", "plot")
        ));
        SIGNATURES.put("plotarrow", new PineScriptFunctionSignature("plotarrow",
                new Parameter("series", "series int/float"),
                new Parameter("title", "const string"),
                new Parameter("colorup", "series color", "na"),
                new Parameter("colordown", "series color", "na"),
                new Parameter("offset", "simple int", "0"),
                new Parameter("minheight", "input int", "5"),
                new Parameter("maxheight", "input int", "100"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("show_last", "input int", "na"),
                new Parameter("display", "input plot_display", "display"),
                new Parameter("format", "input string", "na"),
                new Parameter("precision", "input int", "na"),
                new Parameter("force_overlay", "const bool", "false")
        ));
        SIGNATURES.put("plotbar", new PineScriptFunctionSignature("plotbar",
                new Parameter("open", "series int/float"),
                new Parameter("high", "series int/float"),
                new Parameter("low", "series int/float"),
                new Parameter("close", "series int/float"),
                new Parameter("title", "const string", "na"),
                new Parameter("color", "series color", "na"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("show_last", "input int", "na"),
                new Parameter("display", "input plot_display", "display"),
                new Parameter("format", "input string", "na"),
                new Parameter("precision", "input int", "na"),
                new Parameter("force_overlay", "const bool", "false")
        ));
        SIGNATURES.put("plotcandle", new PineScriptFunctionSignature("plotcandle",
                new Parameter("open", "series int/float"),
                new Parameter("high", "series int/float"),
                new Parameter("low", "series int/float"),
                new Parameter("close", "series int/float"),
                new Parameter("title", "const string", "na"),
                new Parameter("color", "series color", "na"),
                new Parameter("wickcolor", "series color", "na"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("show_last", "input int", "na"),
                new Parameter("bordercolor", "series color", "na"),
                new Parameter("display", "input plot_display", "display"),
                new Parameter("format", "input string", "na"),
                new Parameter("precision", "input int", "na"),
                new Parameter("force_overlay", "const bool", "false")
        ));
        SIGNATURES.put("plotchar", new PineScriptFunctionSignature("plotchar",
                new Parameter("series", "series int/float/bool"),
                new Parameter("title", "const string"),
                new Parameter("char", "input string"),
                new Parameter("location", "input string", "location"),
                new Parameter("color", "series color", "na"),
                new Parameter("offset", "simple int", "0"),
                new Parameter("text", "const string"),
                new Parameter("textcolor", "series color", "na"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("size", "const string", "size"),
                new Parameter("show_last", "input int", "na"),
                new Parameter("display", "input plot_display", "display"),
                new Parameter("format", "input string", "na"),
                new Parameter("precision", "input int", "na"),
                new Parameter("force_overlay", "const bool", "false")
        ));
        SIGNATURES.put("plotshape", new PineScriptFunctionSignature("plotshape",
                new Parameter("series", "series int/float/bool"),
                new Parameter("title", "const string"),
                new Parameter("style", "input string", "shape"),
                new Parameter("location", "input string", "location"),
                new Parameter("color", "series color", "na"),
                new Parameter("offset", "simple int", "0"),
                new Parameter("text", "const string"),
                new Parameter("textcolor", "series color", "na"),
                new Parameter("editable", "input bool", "true"),
                new Parameter("size", "const string", "size"),
                new Parameter("show_last", "input int", "na"),
                new Parameter("display", "input plot_display", "display"),
                new Parameter("format", "input string", "na"),
                new Parameter("precision", "input int", "na"),
                new Parameter("force_overlay", "const bool", "false")
        ));
        SIGNATURES.put("second", new PineScriptFunctionSignature("second",
                new Parameter("time", "series int"),
                new Parameter("timezone", "series string", "syminfo")
        ));
        SIGNATURES.put("strategy", new PineScriptFunctionSignature("strategy",
                new Parameter("title", "const string"),
                new Parameter("shorttitle", "const string", "na"),
                new Parameter("overlay", "const bool", "false"),
                new Parameter("format", "const string", "format"),
                new Parameter("precision", "const int", "na"),
                new Parameter("scale", "const scale_type", "na"),
                new Parameter("pyramiding", "const int", "0"),
                new Parameter("calc_on_order_fills", "const bool", "false"),
                new Parameter("calc_on_every_tick", "const bool", "false"),
                new Parameter("max_bars_back", "const int", "0"),
                new Parameter("backtest_fill_limits_assumption", "const int", "0"),
                new Parameter("default_qty_type", "const string", "_qty_value`"),
                new Parameter("default_qty_value", "const int/float", "na"),
                new Parameter("initial_capital", "const int/float", "1000000"),
                new Parameter("currency", "const string", "syminfo"),
                new Parameter("slippage", "const int", "0"),
                new Parameter("commission_type", "const string", "strategy"),
                new Parameter("commission_value", "const int/float", "0"),
                new Parameter("process_orders_on_close", "const bool", "false"),
                new Parameter("close_entries_rule", "const string", "FIFO"),
                new Parameter("margin_long", "const int/float", "na"),
                new Parameter("margin_short", "const int/float", "na"),
                new Parameter("explicit_plot_zorder", "const bool", "false"),
                new Parameter("max_lines_count", "const int", "50"),
                new Parameter("max_labels_count", "const int", "50"),
                new Parameter("max_boxes_count", "const int", "50"),
                new Parameter("calc_bars_count", "const int", "na"),
                new Parameter("risk_free_rate", "const int/float", "2"),
                new Parameter("use_bar_magnifier", "const bool", "false"),
                new Parameter("fill_orders_on_standard_ohlc", "const bool", "false"),
                new Parameter("max_polylines_count", "const int", "50"),
                new Parameter("dynamic_requests", "const bool", "true"),
                new Parameter("behind_chart", "const bool", "true")
        ));
        SIGNATURES.put("string", new PineScriptFunctionSignature("string",
                new Parameter("x", "const string")
        ));
        SIGNATURES.put("table", new PineScriptFunctionSignature("table",
                new Parameter("x", "series table")
        ));
        SIGNATURES.put("time", new PineScriptFunctionSignature("time",
                new Parameter("timeframe", "series string"),
                new Parameter("session", "series string", "na"),
                new Parameter("bars_back", "series int", "0"),
                new Parameter("timeframe_bars_back", "series int", "0")
        ));
        SIGNATURES.put("time_close", new PineScriptFunctionSignature("time_close",
                new Parameter("timeframe", "series string"),
                new Parameter("session", "series string", "na"),
                new Parameter("bars_back", "series int", "0"),
                new Parameter("timeframe_bars_back", "series int", "0")
        ));
        SIGNATURES.put("timestamp", new PineScriptFunctionSignature("timestamp",
                new Parameter("dateString", "const string", "na")
        ));
        SIGNATURES.put("weekofyear", new PineScriptFunctionSignature("weekofyear",
                new Parameter("time", "series int"),
                new Parameter("timezone", "series string", "syminfo")
        ));
        SIGNATURES.put("year", new PineScriptFunctionSignature("year",
                new Parameter("time", "series int"),
                new Parameter("timezone", "series string", "syminfo")
        ));

        // INPUT functions
        SIGNATURES.put("input.bool", new PineScriptFunctionSignature("input.bool",
                new Parameter("defval", "const bool"),
                new Parameter("title", "const string"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.color", new PineScriptFunctionSignature("input.color",
                new Parameter("defval", "const color"),
                new Parameter("title", "const string"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.enum", new PineScriptFunctionSignature("input.enum",
                new Parameter("defval", "const enum"),
                new Parameter("title", "const string"),
                new Parameter("options", "tuple of enum fields: [enumName.field1, enumName.field2, ...]", ", the titles of all of the enum"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "`false`"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.float", new PineScriptFunctionSignature("input.float",
                new Parameter("defval", "const int/float"),
                new Parameter("title", "const string"),
                new Parameter("options", "tuple of const int/float values: [val1, val2, ...]"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.int", new PineScriptFunctionSignature("input.int",
                new Parameter("defval", "const int"),
                new Parameter("title", "const string"),
                new Parameter("options", "tuple of const int values: [val1, val2, ...]"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.price", new PineScriptFunctionSignature("input.price",
                new Parameter("defval", "const int/float"),
                new Parameter("title", "const string"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.session", new PineScriptFunctionSignature("input.session",
                new Parameter("defval", "const string"),
                new Parameter("title", "const string"),
                new Parameter("options", "tuple of const string values: [val1, val2, ...]"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.source", new PineScriptFunctionSignature("input.source",
                new Parameter("defval", "open/high/low/close/hl2/hlc3/ohlc4/hlcc4"),
                new Parameter("title", "const string"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true"),
                new Parameter("confirm", "const bool", "false")
        ));
        SIGNATURES.put("input.string", new PineScriptFunctionSignature("input.string",
                new Parameter("defval", "const string"),
                new Parameter("title", "const string"),
                new Parameter("options", "tuple of const string values: [val1, val2, ...]"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.symbol", new PineScriptFunctionSignature("input.symbol",
                new Parameter("defval", "const string"),
                new Parameter("title", "const string"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.text_area", new PineScriptFunctionSignature("input.text_area",
                new Parameter("defval", "const string"),
                new Parameter("title", "const string"),
                new Parameter("tooltip", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.time", new PineScriptFunctionSignature("input.time",
                new Parameter("defval", "const int"),
                new Parameter("title", "const string"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));
        SIGNATURES.put("input.timeframe", new PineScriptFunctionSignature("input.timeframe",
                new Parameter("defval", "const string"),
                new Parameter("title", "const string"),
                new Parameter("options", "tuple of const string values: [val1, val2, ...]"),
                new Parameter("tooltip", "const string"),
                new Parameter("inline", "const string"),
                new Parameter("group", "const string"),
                new Parameter("confirm", "const bool", "false"),
                new Parameter("display", "const plot_display", "display"),
                new Parameter("active", "input bool", "true")
        ));

        // LABEL functions
        SIGNATURES.put("label.copy", new PineScriptFunctionSignature("label.copy",
                new Parameter("id", "series label")
        ));
        SIGNATURES.put("label.delete", new PineScriptFunctionSignature("label.delete",
                new Parameter("id", "series label")
        ));
        SIGNATURES.put("label.get_text", new PineScriptFunctionSignature("label.get_text",
                new Parameter("id", "series label")
        ));
        SIGNATURES.put("label.get_x", new PineScriptFunctionSignature("label.get_x",
                new Parameter("id", "series label")
        ));
        SIGNATURES.put("label.get_y", new PineScriptFunctionSignature("label.get_y",
                new Parameter("id", "series label")
        ));
        SIGNATURES.put("label.new", new PineScriptFunctionSignature("label.new",
                new Parameter("point", "chart.point"),
                new Parameter("text", "series string", "empty string"),
                new Parameter("xloc", "series string", "xloc"),
                new Parameter("yloc", "series string", "yloc"),
                new Parameter("color", "series color"),
                new Parameter("style", "series string", "label"),
                new Parameter("textcolor", "series color"),
                new Parameter("size", "series int/string", "size"),
                new Parameter("textalign", "series string", "text"),
                new Parameter("tooltip", "series string"),
                new Parameter("text_font_family", "series string", "font"),
                new Parameter("force_overlay", "const bool", "false"),
                new Parameter("text_formatting", "const text_format", "text")
        ));
        SIGNATURES.put("label.set_color", new PineScriptFunctionSignature("label.set_color",
                new Parameter("id", "series label"),
                new Parameter("color", "series color")
        ));
        SIGNATURES.put("label.set_point", new PineScriptFunctionSignature("label.set_point",
                new Parameter("id", "series label"),
                new Parameter("point", "chart.point")
        ));
        SIGNATURES.put("label.set_size", new PineScriptFunctionSignature("label.set_size",
                new Parameter("id", "series label"),
                new Parameter("size", "series int/string", "size")
        ));
        SIGNATURES.put("label.set_style", new PineScriptFunctionSignature("label.set_style",
                new Parameter("id", "series label"),
                new Parameter("style", "series string")
        ));
        SIGNATURES.put("label.set_text", new PineScriptFunctionSignature("label.set_text",
                new Parameter("id", "series label"),
                new Parameter("text", "series string")
        ));
        SIGNATURES.put("label.set_text_font_family", new PineScriptFunctionSignature("label.set_text_font_family",
                new Parameter("id", "series label"),
                new Parameter("text_font_family", "series string")
        ));
        SIGNATURES.put("label.set_text_formatting", new PineScriptFunctionSignature("label.set_text_formatting",
                new Parameter("id", "series label"),
                new Parameter("text_formatting", "const text_format", "text")
        ));
        SIGNATURES.put("label.set_textalign", new PineScriptFunctionSignature("label.set_textalign",
                new Parameter("id", "series label"),
                new Parameter("textalign", "series string")
        ));
        SIGNATURES.put("label.set_textcolor", new PineScriptFunctionSignature("label.set_textcolor",
                new Parameter("id", "series label"),
                new Parameter("textcolor", "series color")
        ));
        SIGNATURES.put("label.set_tooltip", new PineScriptFunctionSignature("label.set_tooltip",
                new Parameter("id", "series label"),
                new Parameter("tooltip", "series string")
        ));
        SIGNATURES.put("label.set_x", new PineScriptFunctionSignature("label.set_x",
                new Parameter("id", "series label"),
                new Parameter("x", "series int")
        ));
        SIGNATURES.put("label.set_xloc", new PineScriptFunctionSignature("label.set_xloc",
                new Parameter("id", "series label"),
                new Parameter("x", "series int"),
                new Parameter("xloc", "series string")
        ));
        SIGNATURES.put("label.set_xy", new PineScriptFunctionSignature("label.set_xy",
                new Parameter("id", "series label"),
                new Parameter("x", "series int"),
                new Parameter("y", "series int/float")
        ));
        SIGNATURES.put("label.set_y", new PineScriptFunctionSignature("label.set_y",
                new Parameter("id", "series label"),
                new Parameter("y", "series int/float")
        ));
        SIGNATURES.put("label.set_yloc", new PineScriptFunctionSignature("label.set_yloc",
                new Parameter("id", "series label"),
                new Parameter("yloc", "series string")
        ));

        // LINE functions
        SIGNATURES.put("line.copy", new PineScriptFunctionSignature("line.copy",
                new Parameter("id", "series line")
        ));
        SIGNATURES.put("line.delete", new PineScriptFunctionSignature("line.delete",
                new Parameter("id", "series line")
        ));
        SIGNATURES.put("line.get_price", new PineScriptFunctionSignature("line.get_price",
                new Parameter("id", "series line"),
                new Parameter("x", "series int")
        ));
        SIGNATURES.put("line.get_x1", new PineScriptFunctionSignature("line.get_x1",
                new Parameter("id", "series line")
        ));
        SIGNATURES.put("line.get_x2", new PineScriptFunctionSignature("line.get_x2",
                new Parameter("id", "series line")
        ));
        SIGNATURES.put("line.get_y1", new PineScriptFunctionSignature("line.get_y1",
                new Parameter("id", "series line")
        ));
        SIGNATURES.put("line.get_y2", new PineScriptFunctionSignature("line.get_y2",
                new Parameter("id", "series line")
        ));
        SIGNATURES.put("line.new", new PineScriptFunctionSignature("line.new",
                new Parameter("first_point", "chart.point"),
                new Parameter("second_point", "chart.point"),
                new Parameter("xloc", "series string", "xloc"),
                new Parameter("extend", "series string", "extend"),
                new Parameter("color", "series color"),
                new Parameter("style", "series string"),
                new Parameter("width", "series int"),
                new Parameter("force_overlay", "const bool", "false")
        ));
        SIGNATURES.put("line.set_color", new PineScriptFunctionSignature("line.set_color",
                new Parameter("id", "series line"),
                new Parameter("color", "series color")
        ));
        SIGNATURES.put("line.set_extend", new PineScriptFunctionSignature("line.set_extend",
                new Parameter("id", "series line"),
                new Parameter("extend", "series string")
        ));
        SIGNATURES.put("line.set_first_point", new PineScriptFunctionSignature("line.set_first_point",
                new Parameter("id", "series line"),
                new Parameter("point", "chart.point")
        ));
        SIGNATURES.put("line.set_second_point", new PineScriptFunctionSignature("line.set_second_point",
                new Parameter("id", "series line"),
                new Parameter("point", "chart.point")
        ));
        SIGNATURES.put("line.set_style", new PineScriptFunctionSignature("line.set_style",
                new Parameter("id", "series line"),
                new Parameter("style", "series string")
        ));
        SIGNATURES.put("line.set_width", new PineScriptFunctionSignature("line.set_width",
                new Parameter("id", "series line"),
                new Parameter("width", "series int")
        ));
        SIGNATURES.put("line.set_x1", new PineScriptFunctionSignature("line.set_x1",
                new Parameter("id", "series line"),
                new Parameter("x", "series int")
        ));
        SIGNATURES.put("line.set_x2", new PineScriptFunctionSignature("line.set_x2",
                new Parameter("id", "series line"),
                new Parameter("x", "series int")
        ));
        SIGNATURES.put("line.set_xloc", new PineScriptFunctionSignature("line.set_xloc",
                new Parameter("id", "series line"),
                new Parameter("x1", "series int"),
                new Parameter("x2", "series int"),
                new Parameter("xloc", "series string")
        ));
        SIGNATURES.put("line.set_xy1", new PineScriptFunctionSignature("line.set_xy1",
                new Parameter("id", "series line"),
                new Parameter("x", "series int"),
                new Parameter("y", "series int/float")
        ));
        SIGNATURES.put("line.set_xy2", new PineScriptFunctionSignature("line.set_xy2",
                new Parameter("id", "series line"),
                new Parameter("x", "series int"),
                new Parameter("y", "series int/float")
        ));
        SIGNATURES.put("line.set_y1", new PineScriptFunctionSignature("line.set_y1",
                new Parameter("id", "series line"),
                new Parameter("y", "series int/float")
        ));
        SIGNATURES.put("line.set_y2", new PineScriptFunctionSignature("line.set_y2",
                new Parameter("id", "series line"),
                new Parameter("y", "series int/float")
        ));

        // LINEFILL functions
        SIGNATURES.put("linefill.delete", new PineScriptFunctionSignature("linefill.delete",
                new Parameter("id", "series linefill")
        ));
        SIGNATURES.put("linefill.get_line1", new PineScriptFunctionSignature("linefill.get_line1",
                new Parameter("id", "series linefill")
        ));
        SIGNATURES.put("linefill.get_line2", new PineScriptFunctionSignature("linefill.get_line2",
                new Parameter("id", "series linefill")
        ));
        SIGNATURES.put("linefill.new", new PineScriptFunctionSignature("linefill.new",
                new Parameter("line1", "series line"),
                new Parameter("line2", "series line"),
                new Parameter("color", "series color")
        ));
        SIGNATURES.put("linefill.set_color", new PineScriptFunctionSignature("linefill.set_color",
                new Parameter("id", "series linefill"),
                new Parameter("color", "series color")
        ));

        // LOG functions
        SIGNATURES.put("log.error", new PineScriptFunctionSignature("log.error",
                new Parameter("message", "series string")
        ));
        SIGNATURES.put("log.info", new PineScriptFunctionSignature("log.info",
                new Parameter("message", "series string")
        ));
        SIGNATURES.put("log.warning", new PineScriptFunctionSignature("log.warning",
                new Parameter("message", "series string")
        ));

        // MAP functions
        SIGNATURES.put("map.clear", new PineScriptFunctionSignature("map.clear",
                new Parameter("id", "any map type")
        ));
        SIGNATURES.put("map.contains", new PineScriptFunctionSignature("map.contains",
                new Parameter("id", "any map type"),
                new Parameter("key", "series <type of the map's elements>")
        ));
        SIGNATURES.put("map.copy", new PineScriptFunctionSignature("map.copy",
                new Parameter("id", "any map type")
        ));
        SIGNATURES.put("map.get", new PineScriptFunctionSignature("map.get",
                new Parameter("id", "any map type"),
                new Parameter("key", "series <type of the map's elements>")
        ));
        SIGNATURES.put("map.keys", new PineScriptFunctionSignature("map.keys",
                new Parameter("id", "any map type")
        ));
        SIGNATURES.put("map.put", new PineScriptFunctionSignature("map.put",
                new Parameter("id", "any map type"),
                new Parameter("key", "series <type of the map's elements>"),
                new Parameter("value", "series <type of the map's elements>")
        ));
        SIGNATURES.put("map.put_all", new PineScriptFunctionSignature("map.put_all",
                new Parameter("id", "any map type"),
                new Parameter("id2", "any map type")
        ));
        SIGNATURES.put("map.remove", new PineScriptFunctionSignature("map.remove",
                new Parameter("id", "any map type"),
                new Parameter("key", "series <type of the map's elements>")
        ));
        SIGNATURES.put("map.size", new PineScriptFunctionSignature("map.size",
                new Parameter("id", "any map type")
        ));
        SIGNATURES.put("map.values", new PineScriptFunctionSignature("map.values",
                new Parameter("id", "any map type")
        ));

        // MATH functions
        SIGNATURES.put("math.abs", new PineScriptFunctionSignature("math.abs",
                new Parameter("number", "const int")
        ));
        SIGNATURES.put("math.acos", new PineScriptFunctionSignature("math.acos",
                new Parameter("angle", "const int/float")
        ));
        SIGNATURES.put("math.asin", new PineScriptFunctionSignature("math.asin",
                new Parameter("angle", "const int/float")
        ));
        SIGNATURES.put("math.atan", new PineScriptFunctionSignature("math.atan",
                new Parameter("angle", "const int/float")
        ));
        SIGNATURES.put("math.avg", new PineScriptFunctionSignature("math.avg",
                new Parameter("number0", "any"),
                new Parameter("number1", "any")
        ));
        SIGNATURES.put("math.ceil", new PineScriptFunctionSignature("math.ceil",
                new Parameter("number", "const int/float")
        ));
        SIGNATURES.put("math.cos", new PineScriptFunctionSignature("math.cos",
                new Parameter("angle", "const int/float")
        ));
        SIGNATURES.put("math.exp", new PineScriptFunctionSignature("math.exp",
                new Parameter("number", "const int/float")
        ));
        SIGNATURES.put("math.floor", new PineScriptFunctionSignature("math.floor",
                new Parameter("number", "const int/float")
        ));
        SIGNATURES.put("math.log", new PineScriptFunctionSignature("math.log",
                new Parameter("number", "const int/float")
        ));
        SIGNATURES.put("math.log10", new PineScriptFunctionSignature("math.log10",
                new Parameter("number", "const int/float")
        ));
        SIGNATURES.put("math.max", new PineScriptFunctionSignature("math.max",
                new Parameter("number0", "any"),
                new Parameter("number1", "any")
        ));
        SIGNATURES.put("math.min", new PineScriptFunctionSignature("math.min",
                new Parameter("number0", "any"),
                new Parameter("number1", "any")
        ));
        SIGNATURES.put("math.pow", new PineScriptFunctionSignature("math.pow",
                new Parameter("base", "const int/float"),
                new Parameter("exponent", "const int/float")
        ));
        SIGNATURES.put("math.random", new PineScriptFunctionSignature("math.random",
                new Parameter("min", "series int/float", "0"),
                new Parameter("max", "series int/float", "1"),
                new Parameter("seed", "series int", "na")
        ));
        SIGNATURES.put("math.round", new PineScriptFunctionSignature("math.round",
                new Parameter("number", "const int/float")
        ));
        SIGNATURES.put("math.round_to_mintick", new PineScriptFunctionSignature("math.round_to_mintick",
                new Parameter("number", "simple int/float")
        ));
        SIGNATURES.put("math.sign", new PineScriptFunctionSignature("math.sign",
                new Parameter("number", "const int/float")
        ));
        SIGNATURES.put("math.sin", new PineScriptFunctionSignature("math.sin",
                new Parameter("angle", "const int/float")
        ));
        SIGNATURES.put("math.sqrt", new PineScriptFunctionSignature("math.sqrt",
                new Parameter("number", "const int/float")
        ));
        SIGNATURES.put("math.sum", new PineScriptFunctionSignature("math.sum",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("math.tan", new PineScriptFunctionSignature("math.tan",
                new Parameter("angle", "const int/float")
        ));
        SIGNATURES.put("math.todegrees", new PineScriptFunctionSignature("math.todegrees",
                new Parameter("radians", "series int/float")
        ));
        SIGNATURES.put("math.toradians", new PineScriptFunctionSignature("math.toradians",
                new Parameter("degrees", "series int/float")
        ));

        // MATRIX functions
        SIGNATURES.put("matrix.add_col", new PineScriptFunctionSignature("matrix.add_col",
                new Parameter("id", "any matrix type"),
                new Parameter("column", "series int", "`matrix"),
                new Parameter("array_id", "any array type", "na")
        ));
        SIGNATURES.put("matrix.add_row", new PineScriptFunctionSignature("matrix.add_row",
                new Parameter("id", "any matrix type"),
                new Parameter("row", "series int", "`matrix"),
                new Parameter("array_id", "any array type", "na")
        ));
        SIGNATURES.put("matrix.avg", new PineScriptFunctionSignature("matrix.avg",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.col", new PineScriptFunctionSignature("matrix.col",
                new Parameter("id", "any matrix type"),
                new Parameter("column", "series int")
        ));
        SIGNATURES.put("matrix.columns", new PineScriptFunctionSignature("matrix.columns",
                new Parameter("id", "any matrix type")
        ));
        SIGNATURES.put("matrix.concat", new PineScriptFunctionSignature("matrix.concat",
                new Parameter("id1", "any matrix type"),
                new Parameter("id2", "any matrix type")
        ));
        SIGNATURES.put("matrix.copy", new PineScriptFunctionSignature("matrix.copy",
                new Parameter("id", "any matrix type")
        ));
        SIGNATURES.put("matrix.det", new PineScriptFunctionSignature("matrix.det",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.diff", new PineScriptFunctionSignature("matrix.diff",
                new Parameter("id1", "matrix<int>"),
                new Parameter("id2", "series int/float/matrix<int>")
        ));
        SIGNATURES.put("matrix.eigenvalues", new PineScriptFunctionSignature("matrix.eigenvalues",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.eigenvectors", new PineScriptFunctionSignature("matrix.eigenvectors",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.elements_count", new PineScriptFunctionSignature("matrix.elements_count",
                new Parameter("id", "any matrix type")
        ));
        SIGNATURES.put("matrix.fill", new PineScriptFunctionSignature("matrix.fill",
                new Parameter("id", "any matrix type"),
                new Parameter("value", "series <type of the matrix's elements>"),
                new Parameter("from_row", "series int", "0"),
                new Parameter("to_row", "series int", "matrix"),
                new Parameter("from_column", "series int", "0"),
                new Parameter("to_column", "series int", "matrix")
        ));
        SIGNATURES.put("matrix.get", new PineScriptFunctionSignature("matrix.get",
                new Parameter("id", "any matrix type"),
                new Parameter("row", "series int"),
                new Parameter("column", "series int")
        ));
        SIGNATURES.put("matrix.inv", new PineScriptFunctionSignature("matrix.inv",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.is_antidiagonal", new PineScriptFunctionSignature("matrix.is_antidiagonal",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.is_antisymmetric", new PineScriptFunctionSignature("matrix.is_antisymmetric",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.is_binary", new PineScriptFunctionSignature("matrix.is_binary",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.is_diagonal", new PineScriptFunctionSignature("matrix.is_diagonal",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.is_identity", new PineScriptFunctionSignature("matrix.is_identity",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.is_square", new PineScriptFunctionSignature("matrix.is_square",
                new Parameter("id", "any matrix type")
        ));
        SIGNATURES.put("matrix.is_stochastic", new PineScriptFunctionSignature("matrix.is_stochastic",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.is_symmetric", new PineScriptFunctionSignature("matrix.is_symmetric",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.is_triangular", new PineScriptFunctionSignature("matrix.is_triangular",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.is_zero", new PineScriptFunctionSignature("matrix.is_zero",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.kron", new PineScriptFunctionSignature("matrix.kron",
                new Parameter("id1", "matrix<int/float>"),
                new Parameter("id2", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.max", new PineScriptFunctionSignature("matrix.max",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.median", new PineScriptFunctionSignature("matrix.median",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.min", new PineScriptFunctionSignature("matrix.min",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.mode", new PineScriptFunctionSignature("matrix.mode",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.mult", new PineScriptFunctionSignature("matrix.mult",
                new Parameter("id1", "matrix<int>"),
                new Parameter("id2", "array<int>")
        ));
        SIGNATURES.put("matrix.pinv", new PineScriptFunctionSignature("matrix.pinv",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.pow", new PineScriptFunctionSignature("matrix.pow",
                new Parameter("id", "matrix<int/float>"),
                new Parameter("power", "series int")
        ));
        SIGNATURES.put("matrix.rank", new PineScriptFunctionSignature("matrix.rank",
                new Parameter("id", "any matrix type")
        ));
        SIGNATURES.put("matrix.remove_col", new PineScriptFunctionSignature("matrix.remove_col",
                new Parameter("id", "any matrix type"),
                new Parameter("column", "series int", "matrix")
        ));
        SIGNATURES.put("matrix.remove_row", new PineScriptFunctionSignature("matrix.remove_row",
                new Parameter("id", "any matrix type"),
                new Parameter("row", "series int", "matrix")
        ));
        SIGNATURES.put("matrix.reshape", new PineScriptFunctionSignature("matrix.reshape",
                new Parameter("id", "any matrix type"),
                new Parameter("rows", "series int"),
                new Parameter("columns", "series int")
        ));
        SIGNATURES.put("matrix.reverse", new PineScriptFunctionSignature("matrix.reverse",
                new Parameter("id", "any matrix type")
        ));
        SIGNATURES.put("matrix.row", new PineScriptFunctionSignature("matrix.row",
                new Parameter("id", "any matrix type"),
                new Parameter("row", "series int")
        ));
        SIGNATURES.put("matrix.rows", new PineScriptFunctionSignature("matrix.rows",
                new Parameter("id", "any matrix type")
        ));
        SIGNATURES.put("matrix.set", new PineScriptFunctionSignature("matrix.set",
                new Parameter("id", "any matrix type"),
                new Parameter("row", "series int"),
                new Parameter("column", "series int"),
                new Parameter("value", "series <type of the matrix's elements>")
        ));
        SIGNATURES.put("matrix.sort", new PineScriptFunctionSignature("matrix.sort",
                new Parameter("id", "matrix<int/float/string>"),
                new Parameter("column", "series int", "0"),
                new Parameter("order", "series sort_order", "), order")
        ));
        SIGNATURES.put("matrix.submatrix", new PineScriptFunctionSignature("matrix.submatrix",
                new Parameter("id", "any matrix type"),
                new Parameter("from_row", "series int", "0"),
                new Parameter("to_row", "series int", "matrix"),
                new Parameter("from_column", "series int", "0"),
                new Parameter("to_column", "series int", "matrix")
        ));
        SIGNATURES.put("matrix.sum", new PineScriptFunctionSignature("matrix.sum",
                new Parameter("id1", "matrix<int>"),
                new Parameter("id2", "series int/float/matrix<int>")
        ));
        SIGNATURES.put("matrix.swap_columns", new PineScriptFunctionSignature("matrix.swap_columns",
                new Parameter("id", "any matrix type"),
                new Parameter("column1", "series int"),
                new Parameter("column2", "series int")
        ));
        SIGNATURES.put("matrix.swap_rows", new PineScriptFunctionSignature("matrix.swap_rows",
                new Parameter("id", "any matrix type"),
                new Parameter("row1", "series int"),
                new Parameter("row2", "series int")
        ));
        SIGNATURES.put("matrix.trace", new PineScriptFunctionSignature("matrix.trace",
                new Parameter("id", "matrix<int/float>")
        ));
        SIGNATURES.put("matrix.transpose", new PineScriptFunctionSignature("matrix.transpose",
                new Parameter("id", "any matrix type")
        ));

        // POLYLINE functions
        SIGNATURES.put("polyline.delete", new PineScriptFunctionSignature("polyline.delete",
                new Parameter("id", "series polyline")
        ));
        SIGNATURES.put("polyline.new", new PineScriptFunctionSignature("polyline.new",
                new Parameter("points", "array<chart.point>"),
                new Parameter("curved", "series bool", "false"),
                new Parameter("closed", "series bool", "false"),
                new Parameter("xloc", "series string", "xloc"),
                new Parameter("line_color", "series color", "color"),
                new Parameter("fill_color", "series color", "na"),
                new Parameter("line_style", "series string", "line"),
                new Parameter("line_width", "series int", "1"),
                new Parameter("force_overlay", "const bool", "false")
        ));

        // REQUEST functions
        SIGNATURES.put("request.currency_rate", new PineScriptFunctionSignature("request.currency_rate",
                new Parameter("from", "series string"),
                new Parameter("to", "series string"),
                new Parameter("ignore_invalid_currency", "series bool", "false")
        ));
        SIGNATURES.put("request.dividends", new PineScriptFunctionSignature("request.dividends",
                new Parameter("ticker", "series string"),
                new Parameter("field", "series string", "dividends"),
                new Parameter("gaps", "simple barmerge_gaps", "barmerge"),
                new Parameter("lookahead", "simple barmerge_lookahead", "barmerge"),
                new Parameter("ignore_invalid_symbol", "input bool", "false"),
                new Parameter("currency", "series string", "syminfo")
        ));
        SIGNATURES.put("request.earnings", new PineScriptFunctionSignature("request.earnings",
                new Parameter("ticker", "series string"),
                new Parameter("field", "series string", "earnings"),
                new Parameter("gaps", "simple barmerge_gaps", "barmerge"),
                new Parameter("lookahead", "simple barmerge_lookahead", "barmerge"),
                new Parameter("ignore_invalid_symbol", "input bool", "false"),
                new Parameter("currency", "series string", "syminfo")
        ));
        SIGNATURES.put("request.economic", new PineScriptFunctionSignature("request.economic",
                new Parameter("country_code", "series string"),
                new Parameter("field", "series string"),
                new Parameter("gaps", "simple barmerge_gaps", "barmerge"),
                new Parameter("ignore_invalid_symbol", "input bool", "false")
        ));
        SIGNATURES.put("request.financial", new PineScriptFunctionSignature("request.financial",
                new Parameter("symbol", "series string"),
                new Parameter("financial_id", "series string"),
                new Parameter("period", "series string"),
                new Parameter("gaps", "simple barmerge_gaps", "barmerge"),
                new Parameter("ignore_invalid_symbol", "input bool", "false"),
                new Parameter("currency", "series string", "syminfo")
        ));
        SIGNATURES.put("request.quandl", new PineScriptFunctionSignature("request.quandl",
                new Parameter("ticker", "series string"),
                new Parameter("gaps", "simple barmerge_gaps", "barmerge"),
                new Parameter("index", "series int"),
                new Parameter("ignore_invalid_symbol", "input bool", "false")
        ));
        SIGNATURES.put("request.security", new PineScriptFunctionSignature("request.security",
                new Parameter("symbol", "series string"),
                new Parameter("timeframe", "series string"),
                new Parameter("expression", "variable, function, object, array, matrix, or map of series int/float/bool/string/color/enum, or a tuple of these"),
                new Parameter("gaps", "simple barmerge_gaps", "barmerge"),
                new Parameter("lookahead", "simple barmerge_lookahead", "barmerge"),
                new Parameter("ignore_invalid_symbol", "input bool", "false"),
                new Parameter("currency", "series string", "syminfo"),
                new Parameter("calc_bars_count", "simple int", "na")
        ));
        SIGNATURES.put("request.security_lower_tf", new PineScriptFunctionSignature("request.security_lower_tf",
                new Parameter("symbol", "series string"),
                new Parameter("timeframe", "series string"),
                new Parameter("expression", "variable, object or function of series int/float/bool/string/color/enum, or a tuple of these"),
                new Parameter("ignore_invalid_symbol", "series bool", "false"),
                new Parameter("currency", "series string", "syminfo"),
                new Parameter("ignore_invalid_timeframe", "series bool", "false"),
                new Parameter("calc_bars_count", "simple int", "na")
        ));
        SIGNATURES.put("request.seed", new PineScriptFunctionSignature("request.seed",
                new Parameter("source", "series string"),
                new Parameter("symbol", "series string"),
                new Parameter("expression", "<arg_expr_type>"),
                new Parameter("ignore_invalid_symbol", "input bool", "false"),
                new Parameter("calc_bars_count", "simple int", "100,000")
        ));
        SIGNATURES.put("request.splits", new PineScriptFunctionSignature("request.splits",
                new Parameter("ticker", "series string"),
                new Parameter("field", "series string"),
                new Parameter("gaps", "simple barmerge_gaps", "barmerge"),
                new Parameter("lookahead", "simple barmerge_lookahead", "barmerge"),
                new Parameter("ignore_invalid_symbol", "input bool", "false")
        ));

        // RUNTIME functions
        SIGNATURES.put("runtime.error", new PineScriptFunctionSignature("runtime.error",
                new Parameter("message", "series string")
        ));

        // STR functions
        SIGNATURES.put("str.contains", new PineScriptFunctionSignature("str.contains",
                new Parameter("source", "const string"),
                new Parameter("str", "const string")
        ));
        SIGNATURES.put("str.endswith", new PineScriptFunctionSignature("str.endswith",
                new Parameter("source", "const string"),
                new Parameter("str", "const string")
        ));
        SIGNATURES.put("str.format", new PineScriptFunctionSignature("str.format",
                new Parameter("formatString", "simple string"),
                new Parameter("arg0", "any"),
                new Parameter("arg1", "any")
        ));
        SIGNATURES.put("str.format_time", new PineScriptFunctionSignature("str.format_time",
                new Parameter("time", "series int"),
                new Parameter("format", "series string", "yyyy-MM-dd"),
                new Parameter("timezone", "series string", "syminfo")
        ));
        SIGNATURES.put("str.length", new PineScriptFunctionSignature("str.length",
                new Parameter("string", "const string")
        ));
        SIGNATURES.put("str.lower", new PineScriptFunctionSignature("str.lower",
                new Parameter("source", "const string")
        ));
        SIGNATURES.put("str.match", new PineScriptFunctionSignature("str.match",
                new Parameter("source", "simple string"),
                new Parameter("regex", "simple string")
        ));
        SIGNATURES.put("str.pos", new PineScriptFunctionSignature("str.pos",
                new Parameter("source", "const string"),
                new Parameter("str", "const string")
        ));
        SIGNATURES.put("str.repeat", new PineScriptFunctionSignature("str.repeat",
                new Parameter("source", "const string"),
                new Parameter("repeat", "const int"),
                new Parameter("separator", "const string", "empty string")
        ));
        SIGNATURES.put("str.replace", new PineScriptFunctionSignature("str.replace",
                new Parameter("source", "const string"),
                new Parameter("target", "const string"),
                new Parameter("replacement", "const string"),
                new Parameter("occurrence", "const int", "0")
        ));
        SIGNATURES.put("str.replace_all", new PineScriptFunctionSignature("str.replace_all",
                new Parameter("source", "simple string"),
                new Parameter("target", "simple string"),
                new Parameter("replacement", "simple string")
        ));
        SIGNATURES.put("str.split", new PineScriptFunctionSignature("str.split",
                new Parameter("string", "series string"),
                new Parameter("separator", "series string")
        ));
        SIGNATURES.put("str.startswith", new PineScriptFunctionSignature("str.startswith",
                new Parameter("source", "const string"),
                new Parameter("str", "const string")
        ));
        SIGNATURES.put("str.substring", new PineScriptFunctionSignature("str.substring",
                new Parameter("source", "const string"),
                new Parameter("begin_pos", "const int"),
                new Parameter("end_pos", "const int", "the length of the `source` string")
        ));
        SIGNATURES.put("str.tonumber", new PineScriptFunctionSignature("str.tonumber",
                new Parameter("string", "const string")
        ));
        SIGNATURES.put("str.tostring", new PineScriptFunctionSignature("str.tostring",
                new Parameter("value", "const enum")
        ));
        SIGNATURES.put("str.trim", new PineScriptFunctionSignature("str.trim",
                new Parameter("source", "const string")
        ));
        SIGNATURES.put("str.upper", new PineScriptFunctionSignature("str.upper",
                new Parameter("source", "const string")
        ));

        // STRATEGY functions
        SIGNATURES.put("strategy.cancel", new PineScriptFunctionSignature("strategy.cancel",
                new Parameter("id", "series string")
        ));
        SIGNATURES.put("strategy.cancel_all", new PineScriptFunctionSignature("strategy.cancel_all"));
        SIGNATURES.put("strategy.close", new PineScriptFunctionSignature("strategy.close",
                new Parameter("id", "series string"),
                new Parameter("comment", "series string", "an empty string"),
                new Parameter("qty", "series int/float", "na"),
                new Parameter("qty_percent", "series int/float", "100"),
                new Parameter("alert_message", "series string", "an empty string"),
                new Parameter("immediately", "series bool", "false"),
                new Parameter("disable_alert", "series bool", "false")
        ));
        SIGNATURES.put("strategy.close_all", new PineScriptFunctionSignature("strategy.close_all",
                new Parameter("comment", "series string", "an empty string"),
                new Parameter("alert_message", "series string", "an empty string"),
                new Parameter("immediately", "series bool", "false"),
                new Parameter("disable_alert", "series bool", "false")
        ));
        SIGNATURES.put("strategy.closedtrades.commission", new PineScriptFunctionSignature("strategy.closedtrades.commission",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.entry_bar_index", new PineScriptFunctionSignature("strategy.closedtrades.entry_bar_index",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.entry_comment", new PineScriptFunctionSignature("strategy.closedtrades.entry_comment",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.entry_id", new PineScriptFunctionSignature("strategy.closedtrades.entry_id",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.entry_price", new PineScriptFunctionSignature("strategy.closedtrades.entry_price",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.entry_time", new PineScriptFunctionSignature("strategy.closedtrades.entry_time",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.exit_bar_index", new PineScriptFunctionSignature("strategy.closedtrades.exit_bar_index",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.exit_comment", new PineScriptFunctionSignature("strategy.closedtrades.exit_comment",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.exit_id", new PineScriptFunctionSignature("strategy.closedtrades.exit_id",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.exit_price", new PineScriptFunctionSignature("strategy.closedtrades.exit_price",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.exit_time", new PineScriptFunctionSignature("strategy.closedtrades.exit_time",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.max_drawdown", new PineScriptFunctionSignature("strategy.closedtrades.max_drawdown",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.max_drawdown_percent", new PineScriptFunctionSignature("strategy.closedtrades.max_drawdown_percent",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.max_runup", new PineScriptFunctionSignature("strategy.closedtrades.max_runup",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.max_runup_percent", new PineScriptFunctionSignature("strategy.closedtrades.max_runup_percent",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.profit", new PineScriptFunctionSignature("strategy.closedtrades.profit",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.profit_percent", new PineScriptFunctionSignature("strategy.closedtrades.profit_percent",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.closedtrades.size", new PineScriptFunctionSignature("strategy.closedtrades.size",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.convert_to_account", new PineScriptFunctionSignature("strategy.convert_to_account",
                new Parameter("value", "series int/float")
        ));
        SIGNATURES.put("strategy.convert_to_symbol", new PineScriptFunctionSignature("strategy.convert_to_symbol",
                new Parameter("value", "series int/float")
        ));
        SIGNATURES.put("strategy.default_entry_qty", new PineScriptFunctionSignature("strategy.default_entry_qty",
                new Parameter("fill_price", "series int/float", "order quantity")
        ));
        SIGNATURES.put("strategy.entry", new PineScriptFunctionSignature("strategy.entry",
                new Parameter("id", "series string"),
                new Parameter("direction", "series strategy_direction"),
                new Parameter("qty", "series int/float", "na"),
                new Parameter("limit", "series int/float", "na"),
                new Parameter("stop", "series int/float", "na"),
                new Parameter("oca_name", "series string", "na"),
                new Parameter("oca_type", "input string", "strategy"),
                new Parameter("comment", "series string", "an empty string"),
                new Parameter("alert_message", "series string", "an empty string"),
                new Parameter("disable_alert", "series bool", "false")
        ));
        SIGNATURES.put("strategy.exit", new PineScriptFunctionSignature("strategy.exit",
                new Parameter("id", "series string"),
                new Parameter("from_entry", "series string", "na"),
                new Parameter("qty", "series int/float", "na"),
                new Parameter("qty_percent", "series int/float", "100"),
                new Parameter("profit", "series int/float", "na"),
                new Parameter("limit", "series int/float", "na"),
                new Parameter("loss", "series int/float", "na"),
                new Parameter("stop", "series int/float", "na"),
                new Parameter("trail_price", "series int/float", "na"),
                new Parameter("trail_points", "series int/float", "na"),
                new Parameter("trail_offset", "series int/float", "na"),
                new Parameter("oca_name", "series string", "na"),
                new Parameter("comment", "series string", "an empty string"),
                new Parameter("comment_profit", "series string", "an empty string"),
                new Parameter("comment_loss", "series string", "an empty string"),
                new Parameter("comment_trailing", "series string", "an empty string"),
                new Parameter("alert_message", "series string", "an empty string"),
                new Parameter("alert_profit", "series string", "an empty string"),
                new Parameter("alert_loss", "series string", "an empty string"),
                new Parameter("alert_trailing", "series string", "an empty string"),
                new Parameter("disable_alert", "series bool", "false")
        ));
        SIGNATURES.put("strategy.opentrades.commission", new PineScriptFunctionSignature("strategy.opentrades.commission",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.entry_bar_index", new PineScriptFunctionSignature("strategy.opentrades.entry_bar_index",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.entry_comment", new PineScriptFunctionSignature("strategy.opentrades.entry_comment",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.entry_id", new PineScriptFunctionSignature("strategy.opentrades.entry_id",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.entry_price", new PineScriptFunctionSignature("strategy.opentrades.entry_price",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.entry_time", new PineScriptFunctionSignature("strategy.opentrades.entry_time",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.max_drawdown", new PineScriptFunctionSignature("strategy.opentrades.max_drawdown",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.max_drawdown_percent", new PineScriptFunctionSignature("strategy.opentrades.max_drawdown_percent",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.max_runup", new PineScriptFunctionSignature("strategy.opentrades.max_runup",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.max_runup_percent", new PineScriptFunctionSignature("strategy.opentrades.max_runup_percent",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.profit", new PineScriptFunctionSignature("strategy.opentrades.profit",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.profit_percent", new PineScriptFunctionSignature("strategy.opentrades.profit_percent",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.opentrades.size", new PineScriptFunctionSignature("strategy.opentrades.size",
                new Parameter("trade_num", "series int")
        ));
        SIGNATURES.put("strategy.order", new PineScriptFunctionSignature("strategy.order",
                new Parameter("id", "series string"),
                new Parameter("direction", "series strategy_direction"),
                new Parameter("qty", "series int/float", "na"),
                new Parameter("limit", "series int/float", "na"),
                new Parameter("stop", "series int/float", "na"),
                new Parameter("oca_name", "series string", "na"),
                new Parameter("oca_type", "input string", "strategy"),
                new Parameter("comment", "series string", "an empty string"),
                new Parameter("alert_message", "series string", "an empty string"),
                new Parameter("disable_alert", "series bool", "false")
        ));
        SIGNATURES.put("strategy.risk.allow_entry_in", new PineScriptFunctionSignature("strategy.risk.allow_entry_in",
                new Parameter("value", "simple string")
        ));
        SIGNATURES.put("strategy.risk.max_cons_loss_days", new PineScriptFunctionSignature("strategy.risk.max_cons_loss_days",
                new Parameter("count", "simple int"),
                new Parameter("alert_message", "simple string", "na")
        ));
        SIGNATURES.put("strategy.risk.max_drawdown", new PineScriptFunctionSignature("strategy.risk.max_drawdown",
                new Parameter("value", "simple int/float"),
                new Parameter("type", "simple string"),
                new Parameter("alert_message", "simple string", "na")
        ));
        SIGNATURES.put("strategy.risk.max_intraday_filled_orders", new PineScriptFunctionSignature("strategy.risk.max_intraday_filled_orders",
                new Parameter("count", "simple int"),
                new Parameter("alert_message", "simple string", "na")
        ));
        SIGNATURES.put("strategy.risk.max_intraday_loss", new PineScriptFunctionSignature("strategy.risk.max_intraday_loss",
                new Parameter("value", "simple int/float"),
                new Parameter("type", "simple string"),
                new Parameter("alert_message", "simple string", "na")
        ));
        SIGNATURES.put("strategy.risk.max_position_size", new PineScriptFunctionSignature("strategy.risk.max_position_size",
                new Parameter("contracts", "simple int/float")
        ));

        // SYMINFO functions
        SIGNATURES.put("syminfo.prefix", new PineScriptFunctionSignature("syminfo.prefix",
                new Parameter("symbol", "simple string")
        ));
        SIGNATURES.put("syminfo.ticker", new PineScriptFunctionSignature("syminfo.ticker",
                new Parameter("symbol", "simple string")
        ));

        // TA functions
        SIGNATURES.put("ta.alma", new PineScriptFunctionSignature("ta.alma",
                new Parameter("series", "series int/float"),
                new Parameter("length", "series int"),
                new Parameter("offset", "simple int/float"),
                new Parameter("sigma", "simple int/float"),
                new Parameter("floor", "simple bool", "false")
        ));
        SIGNATURES.put("ta.atr", new PineScriptFunctionSignature("ta.atr",
                new Parameter("length", "simple int")
        ));
        SIGNATURES.put("ta.barssince", new PineScriptFunctionSignature("ta.barssince",
                new Parameter("condition", "series bool")
        ));
        SIGNATURES.put("ta.bb", new PineScriptFunctionSignature("ta.bb",
                new Parameter("series", "series int/float"),
                new Parameter("length", "series int"),
                new Parameter("mult", "simple int/float")
        ));
        SIGNATURES.put("ta.bbw", new PineScriptFunctionSignature("ta.bbw",
                new Parameter("series", "series int/float"),
                new Parameter("length", "series int"),
                new Parameter("mult", "simple int/float")
        ));
        SIGNATURES.put("ta.cci", new PineScriptFunctionSignature("ta.cci",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.change", new PineScriptFunctionSignature("ta.change",
                new Parameter("source", "series int"),
                new Parameter("length", "series int", "1")
        ));
        SIGNATURES.put("ta.cmo", new PineScriptFunctionSignature("ta.cmo",
                new Parameter("series", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.cog", new PineScriptFunctionSignature("ta.cog",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.correlation", new PineScriptFunctionSignature("ta.correlation",
                new Parameter("source1", "series int/float"),
                new Parameter("source2", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.cross", new PineScriptFunctionSignature("ta.cross",
                new Parameter("source1", "series int/float"),
                new Parameter("source2", "series int/float")
        ));
        SIGNATURES.put("ta.crossover", new PineScriptFunctionSignature("ta.crossover",
                new Parameter("source1", "series int/float"),
                new Parameter("source2", "series int/float")
        ));
        SIGNATURES.put("ta.crossunder", new PineScriptFunctionSignature("ta.crossunder",
                new Parameter("source1", "series int/float"),
                new Parameter("source2", "series int/float")
        ));
        SIGNATURES.put("ta.cum", new PineScriptFunctionSignature("ta.cum",
                new Parameter("source", "series int/float")
        ));
        SIGNATURES.put("ta.dev", new PineScriptFunctionSignature("ta.dev",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.dmi", new PineScriptFunctionSignature("ta.dmi",
                new Parameter("diLength", "simple int"),
                new Parameter("adxSmoothing", "simple int")
        ));
        SIGNATURES.put("ta.ema", new PineScriptFunctionSignature("ta.ema",
                new Parameter("source", "series int/float"),
                new Parameter("length", "simple int")
        ));
        SIGNATURES.put("ta.falling", new PineScriptFunctionSignature("ta.falling",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.highest", new PineScriptFunctionSignature("ta.highest",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.highestbars", new PineScriptFunctionSignature("ta.highestbars",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.hma", new PineScriptFunctionSignature("ta.hma",
                new Parameter("source", "series int/float"),
                new Parameter("length", "simple int")
        ));
        SIGNATURES.put("ta.kc", new PineScriptFunctionSignature("ta.kc",
                new Parameter("series", "series int/float"),
                new Parameter("length", "simple int"),
                new Parameter("mult", "simple int/float"),
                new Parameter("useTrueRange", "simple bool", "true")
        ));
        SIGNATURES.put("ta.kcw", new PineScriptFunctionSignature("ta.kcw",
                new Parameter("series", "series int/float"),
                new Parameter("length", "simple int"),
                new Parameter("mult", "simple int/float"),
                new Parameter("useTrueRange", "simple bool", "true")
        ));
        SIGNATURES.put("ta.linreg", new PineScriptFunctionSignature("ta.linreg",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int"),
                new Parameter("offset", "simple int")
        ));
        SIGNATURES.put("ta.lowest", new PineScriptFunctionSignature("ta.lowest",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.lowestbars", new PineScriptFunctionSignature("ta.lowestbars",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.macd", new PineScriptFunctionSignature("ta.macd",
                new Parameter("source", "series int/float"),
                new Parameter("fastlen", "simple int"),
                new Parameter("slowlen", "simple int"),
                new Parameter("siglen", "simple int")
        ));
        SIGNATURES.put("ta.max", new PineScriptFunctionSignature("ta.max",
                new Parameter("source", "series int/float")
        ));
        SIGNATURES.put("ta.median", new PineScriptFunctionSignature("ta.median",
                new Parameter("source", "series int"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.mfi", new PineScriptFunctionSignature("ta.mfi",
                new Parameter("series", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.min", new PineScriptFunctionSignature("ta.min",
                new Parameter("source", "series int/float")
        ));
        SIGNATURES.put("ta.mode", new PineScriptFunctionSignature("ta.mode",
                new Parameter("source", "series int"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.mom", new PineScriptFunctionSignature("ta.mom",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.percentile_linear_interpolation", new PineScriptFunctionSignature("ta.percentile_linear_interpolation",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int"),
                new Parameter("percentage", "simple int/float")
        ));
        SIGNATURES.put("ta.percentile_nearest_rank", new PineScriptFunctionSignature("ta.percentile_nearest_rank",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int"),
                new Parameter("percentage", "simple int/float")
        ));
        SIGNATURES.put("ta.percentrank", new PineScriptFunctionSignature("ta.percentrank",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.pivot_point_levels", new PineScriptFunctionSignature("ta.pivot_point_levels",
                new Parameter("type", "series string"),
                new Parameter("anchor", "series bool"),
                new Parameter("developing", "series bool", "false")
        ));
        SIGNATURES.put("ta.pivothigh", new PineScriptFunctionSignature("ta.pivothigh",
                new Parameter("leftbars", "series int/float"),
                new Parameter("rightbars", "series int/float")
        ));
        SIGNATURES.put("ta.pivotlow", new PineScriptFunctionSignature("ta.pivotlow",
                new Parameter("leftbars", "series int/float"),
                new Parameter("rightbars", "series int/float")
        ));
        SIGNATURES.put("ta.range", new PineScriptFunctionSignature("ta.range",
                new Parameter("source", "series int"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.rci", new PineScriptFunctionSignature("ta.rci",
                new Parameter("source", "series int/float"),
                new Parameter("length", "simple int")
        ));
        SIGNATURES.put("ta.rising", new PineScriptFunctionSignature("ta.rising",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.rma", new PineScriptFunctionSignature("ta.rma",
                new Parameter("source", "series int/float"),
                new Parameter("length", "simple int")
        ));
        SIGNATURES.put("ta.roc", new PineScriptFunctionSignature("ta.roc",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.rsi", new PineScriptFunctionSignature("ta.rsi",
                new Parameter("source", "series int/float"),
                new Parameter("length", "simple int")
        ));
        SIGNATURES.put("ta.sar", new PineScriptFunctionSignature("ta.sar",
                new Parameter("start", "simple int/float"),
                new Parameter("inc", "simple int/float"),
                new Parameter("max", "simple int/float")
        ));
        SIGNATURES.put("ta.sma", new PineScriptFunctionSignature("ta.sma",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.stdev", new PineScriptFunctionSignature("ta.stdev",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int"),
                new Parameter("biased", "series bool", "true")
        ));
        SIGNATURES.put("ta.stoch", new PineScriptFunctionSignature("ta.stoch",
                new Parameter("source", "series int/float"),
                new Parameter("high", "series int/float"),
                new Parameter("low", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.supertrend", new PineScriptFunctionSignature("ta.supertrend",
                new Parameter("factor", "series int/float"),
                new Parameter("atrPeriod", "simple int")
        ));
        SIGNATURES.put("ta.swma", new PineScriptFunctionSignature("ta.swma",
                new Parameter("source", "series int/float")
        ));
        SIGNATURES.put("ta.tr", new PineScriptFunctionSignature("ta.tr",
                new Parameter("handle_na", "simple bool")
        ));
        SIGNATURES.put("ta.tsi", new PineScriptFunctionSignature("ta.tsi",
                new Parameter("source", "series int/float"),
                new Parameter("short_length", "simple int"),
                new Parameter("long_length", "simple int")
        ));
        SIGNATURES.put("ta.valuewhen", new PineScriptFunctionSignature("ta.valuewhen",
                new Parameter("condition", "series bool"),
                new Parameter("source", "series color"),
                new Parameter("occurrence", "simple int")
        ));
        SIGNATURES.put("ta.variance", new PineScriptFunctionSignature("ta.variance",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int"),
                new Parameter("biased", "series bool", "true")
        ));
        SIGNATURES.put("ta.vwap", new PineScriptFunctionSignature("ta.vwap",
                new Parameter("source", "series int/float"),
                new Parameter("anchor", "series bool", "equivalent to passing timeframe")
        ));
        SIGNATURES.put("ta.vwma", new PineScriptFunctionSignature("ta.vwma",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.wma", new PineScriptFunctionSignature("ta.wma",
                new Parameter("source", "series int/float"),
                new Parameter("length", "series int")
        ));
        SIGNATURES.put("ta.wpr", new PineScriptFunctionSignature("ta.wpr",
                new Parameter("length", "series int")
        ));

        // TABLE functions
        SIGNATURES.put("table.cell", new PineScriptFunctionSignature("table.cell",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("text", "series string", "empty string"),
                new Parameter("width", "series int/float", "na"),
                new Parameter("height", "series int/float", "na"),
                new Parameter("text_color", "series color", "color"),
                new Parameter("text_halign", "series string", "text"),
                new Parameter("text_valign", "series string", "text"),
                new Parameter("text_size", "series int/string", "size"),
                new Parameter("bgcolor", "series color", "no color"),
                new Parameter("tooltip", "series string", "na"),
                new Parameter("text_font_family", "series string", "font"),
                new Parameter("text_formatting", "const text_format", "text")
        ));
        SIGNATURES.put("table.cell_set_bgcolor", new PineScriptFunctionSignature("table.cell_set_bgcolor",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("bgcolor", "series color")
        ));
        SIGNATURES.put("table.cell_set_height", new PineScriptFunctionSignature("table.cell_set_height",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("height", "series int/float")
        ));
        SIGNATURES.put("table.cell_set_text", new PineScriptFunctionSignature("table.cell_set_text",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("text", "series string")
        ));
        SIGNATURES.put("table.cell_set_text_color", new PineScriptFunctionSignature("table.cell_set_text_color",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("text_color", "series color")
        ));
        SIGNATURES.put("table.cell_set_text_font_family", new PineScriptFunctionSignature("table.cell_set_text_font_family",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("text_font_family", "series string")
        ));
        SIGNATURES.put("table.cell_set_text_formatting", new PineScriptFunctionSignature("table.cell_set_text_formatting",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("text_formatting", "const text_format", "text")
        ));
        SIGNATURES.put("table.cell_set_text_halign", new PineScriptFunctionSignature("table.cell_set_text_halign",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("text_halign", "series string")
        ));
        SIGNATURES.put("table.cell_set_text_size", new PineScriptFunctionSignature("table.cell_set_text_size",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("text_size", "series int/string", "size")
        ));
        SIGNATURES.put("table.cell_set_text_valign", new PineScriptFunctionSignature("table.cell_set_text_valign",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("text_valign", "series string")
        ));
        SIGNATURES.put("table.cell_set_tooltip", new PineScriptFunctionSignature("table.cell_set_tooltip",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("tooltip", "series string")
        ));
        SIGNATURES.put("table.cell_set_width", new PineScriptFunctionSignature("table.cell_set_width",
                new Parameter("table_id", "series table"),
                new Parameter("column", "series int"),
                new Parameter("row", "series int"),
                new Parameter("width", "series int/float")
        ));
        SIGNATURES.put("table.clear", new PineScriptFunctionSignature("table.clear",
                new Parameter("table_id", "series table"),
                new Parameter("start_column", "series int"),
                new Parameter("start_row", "series int"),
                new Parameter("end_column", "series int", "na"),
                new Parameter("end_row", "series int", "na")
        ));
        SIGNATURES.put("table.delete", new PineScriptFunctionSignature("table.delete",
                new Parameter("table_id", "series table")
        ));
        SIGNATURES.put("table.merge_cells", new PineScriptFunctionSignature("table.merge_cells",
                new Parameter("table_id", "series table"),
                new Parameter("start_column", "series int"),
                new Parameter("start_row", "series int"),
                new Parameter("end_column", "series int"),
                new Parameter("end_row", "series int")
        ));
        SIGNATURES.put("table.new", new PineScriptFunctionSignature("table.new",
                new Parameter("position", "series string"),
                new Parameter("columns", "series int"),
                new Parameter("rows", "series int"),
                new Parameter("bgcolor", "series color", "no color"),
                new Parameter("frame_color", "series color", "no color"),
                new Parameter("frame_width", "series int", "0"),
                new Parameter("border_color", "series color", "no color"),
                new Parameter("border_width", "series int", "0"),
                new Parameter("force_overlay", "const bool", "false")
        ));
        SIGNATURES.put("table.set_bgcolor", new PineScriptFunctionSignature("table.set_bgcolor",
                new Parameter("table_id", "series table"),
                new Parameter("bgcolor", "series color", "no color")
        ));
        SIGNATURES.put("table.set_border_color", new PineScriptFunctionSignature("table.set_border_color",
                new Parameter("table_id", "series table"),
                new Parameter("border_color", "series color", "no color")
        ));
        SIGNATURES.put("table.set_border_width", new PineScriptFunctionSignature("table.set_border_width",
                new Parameter("table_id", "series table"),
                new Parameter("border_width", "series int", "0")
        ));
        SIGNATURES.put("table.set_frame_color", new PineScriptFunctionSignature("table.set_frame_color",
                new Parameter("table_id", "series table"),
                new Parameter("frame_color", "series color", "no color")
        ));
        SIGNATURES.put("table.set_frame_width", new PineScriptFunctionSignature("table.set_frame_width",
                new Parameter("table_id", "series table"),
                new Parameter("frame_width", "series int", "0")
        ));
        SIGNATURES.put("table.set_position", new PineScriptFunctionSignature("table.set_position",
                new Parameter("table_id", "series table"),
                new Parameter("position", "series string")
        ));

        // TICKER functions
        SIGNATURES.put("ticker.heikinashi", new PineScriptFunctionSignature("ticker.heikinashi",
                new Parameter("symbol", "simple string")
        ));
        SIGNATURES.put("ticker.inherit", new PineScriptFunctionSignature("ticker.inherit",
                new Parameter("from_tickerid", "simple string"),
                new Parameter("symbol", "simple string")
        ));
        SIGNATURES.put("ticker.kagi", new PineScriptFunctionSignature("ticker.kagi",
                new Parameter("symbol", "simple string"),
                new Parameter("reversal", "simple int/float")
        ));
        SIGNATURES.put("ticker.linebreak", new PineScriptFunctionSignature("ticker.linebreak",
                new Parameter("symbol", "simple string"),
                new Parameter("number_of_lines", "simple int")
        ));
        SIGNATURES.put("ticker.modify", new PineScriptFunctionSignature("ticker.modify",
                new Parameter("tickerid", "simple string"),
                new Parameter("session", "simple string", "na"),
                new Parameter("adjustment", "simple string", "na"),
                new Parameter("backadjustment", "simple backadjustment", "backadjustment"),
                new Parameter("settlement_as_close", "simple settlement", "settlement_as_close")
        ));
        SIGNATURES.put("ticker.new", new PineScriptFunctionSignature("ticker.new",
                new Parameter("prefix", "simple string"),
                new Parameter("ticker", "simple string"),
                new Parameter("session", "simple string", "na"),
                new Parameter("adjustment", "simple string", "na"),
                new Parameter("backadjustment", "simple backadjustment", "backadjustment"),
                new Parameter("settlement_as_close", "simple settlement", "settlement_as_close")
        ));
        SIGNATURES.put("ticker.pointfigure", new PineScriptFunctionSignature("ticker.pointfigure",
                new Parameter("symbol", "simple string"),
                new Parameter("source", "simple string"),
                new Parameter("style", "simple string"),
                new Parameter("param", "simple int/float"),
                new Parameter("reversal", "simple int")
        ));
        SIGNATURES.put("ticker.renko", new PineScriptFunctionSignature("ticker.renko",
                new Parameter("symbol", "simple string"),
                new Parameter("style", "simple string"),
                new Parameter("param", "simple int/float"),
                new Parameter("request_wicks", "simple bool", "false"),
                new Parameter("source", "simple string", "Close")
        ));
        SIGNATURES.put("ticker.standard", new PineScriptFunctionSignature("ticker.standard",
                new Parameter("symbol", "simple string", "syminfo")
        ));

        // TIMEFRAME functions
        SIGNATURES.put("timeframe.change", new PineScriptFunctionSignature("timeframe.change",
                new Parameter("timeframe", "series string")
        ));
        SIGNATURES.put("timeframe.from_seconds", new PineScriptFunctionSignature("timeframe.from_seconds",
                new Parameter("seconds", "simple int")
        ));
        SIGNATURES.put("timeframe.in_seconds", new PineScriptFunctionSignature("timeframe.in_seconds",
                new Parameter("timeframe", "simple string", "timeframe")
        ));
    }

    public static PineScriptFunctionSignature getSignature(String functionName) {
        return SIGNATURES.get(functionName);
    }

    public static boolean hasSignature(String functionName) {
        return SIGNATURES.containsKey(functionName);
    }

    public static int getSignatureCount() {
        return SIGNATURES.size();
    }
}
