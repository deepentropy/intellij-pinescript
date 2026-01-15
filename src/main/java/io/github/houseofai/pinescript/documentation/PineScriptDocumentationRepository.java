package io.github.houseofai.pinescript.documentation;

import com.intellij.openapi.diagnostic.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Repository for Pine Script function documentation.
 * Loads documentation from bundled markdown files.
 */
public class PineScriptDocumentationRepository {
    private static final Logger LOG = Logger.getInstance(PineScriptDocumentationRepository.class);
    private static final Map<String, FunctionDoc> DOCS = new HashMap<>();
    private static boolean initialized = false;

    /**
     * Represents documentation for a single function.
     */
    public static class FunctionDoc {
        private final String name;
        private final String description;
        private final String syntax;
        private final String arguments;
        private final String returns;
        private final String example;
        private final String remarks;
        private final String seeAlso;

        public FunctionDoc(String name, String description, String syntax, String arguments,
                          String returns, String example, String remarks, String seeAlso) {
            this.name = name;
            this.description = description;
            this.syntax = syntax;
            this.arguments = arguments;
            this.returns = returns;
            this.example = example;
            this.remarks = remarks;
            this.seeAlso = seeAlso;
        }

        public String getName() { return name; }
        public String getDescription() { return description; }
        public String getSyntax() { return syntax; }
        public String getArguments() { return arguments; }
        public String getReturns() { return returns; }
        public String getExample() { return example; }
        public String getRemarks() { return remarks; }
        public String getSeeAlso() { return seeAlso; }
    }

    /**
     * Initialize the documentation repository by loading all docs.
     */
    public static synchronized void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;
        loadBuiltInDocs();
    }

    /**
     * Get documentation for a function by name.
     */
    public static FunctionDoc getDocumentation(String functionName) {
        if (!initialized) {
            initialize();
        }
        return DOCS.get(functionName);
    }

    /**
     * Check if documentation exists for a function.
     */
    public static boolean hasDocumentation(String functionName) {
        if (!initialized) {
            initialize();
        }
        return DOCS.containsKey(functionName);
    }

    /**
     * Load built-in documentation from resources.
     */
    private static void loadBuiltInDocs() {
        // Load the function index file
        try (InputStream is = PineScriptDocumentationRepository.class.getResourceAsStream("/docs/function_docs.txt")) {
            if (is == null) {
                LOG.warn("Function documentation index not found, using fallback docs");
                loadFallbackDocs();
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String content = reader.lines().reduce("", (a, b) -> a + "\n" + b);
            parseFunctionDocs(content);
            LOG.info("Loaded " + DOCS.size() + " function documentations");
        } catch (Exception e) {
            LOG.warn("Failed to load function documentation: " + e.getMessage());
            loadFallbackDocs();
        }
    }

    /**
     * Parse function documentation from the combined docs file.
     */
    private static void parseFunctionDocs(String content) {
        // Split by function markers
        String[] entries = content.split("\\n---FUNCTION---\\n");

        for (String entry : entries) {
            if (entry.trim().isEmpty()) {
                continue;
            }

            try {
                FunctionDoc doc = parseEntry(entry);
                if (doc != null && doc.getName() != null) {
                    DOCS.put(doc.getName(), doc);
                }
            } catch (Exception e) {
                // Skip malformed entries
            }
        }
    }

    /**
     * Parse a single function documentation entry.
     */
    private static FunctionDoc parseEntry(String entry) {
        String name = extractSection(entry, "NAME:");
        String description = extractSection(entry, "DESCRIPTION:");
        String syntax = extractSection(entry, "SYNTAX:");
        String arguments = extractSection(entry, "ARGUMENTS:");
        String returns = extractSection(entry, "RETURNS:");
        String example = extractSection(entry, "EXAMPLE:");
        String remarks = extractSection(entry, "REMARKS:");
        String seeAlso = extractSection(entry, "SEE_ALSO:");

        if (name == null || name.isEmpty()) {
            return null;
        }

        return new FunctionDoc(name, description, syntax, arguments, returns, example, remarks, seeAlso);
    }

    /**
     * Extract a section from the entry.
     */
    private static String extractSection(String entry, String sectionName) {
        int start = entry.indexOf(sectionName);
        if (start < 0) {
            return null;
        }

        start += sectionName.length();

        // Find the next section or end
        String[] sections = {"NAME:", "DESCRIPTION:", "SYNTAX:", "ARGUMENTS:", "RETURNS:", "EXAMPLE:", "REMARKS:", "SEE_ALSO:"};
        int end = entry.length();
        for (String section : sections) {
            if (!section.equals(sectionName)) {
                int idx = entry.indexOf("\n" + section, start);
                if (idx > start && idx < end) {
                    end = idx;
                }
            }
        }

        return entry.substring(start, end).trim();
    }

    /**
     * Load fallback documentation for the most common functions.
     */
    private static void loadFallbackDocs() {
        // Core plotting functions
        addDoc("plot", "Plots a series of data on the chart.",
               "plot(series, title, color, linewidth, style, trackprice, histbase, offset, join, editable, show_last, display) -> plot",
               "series (series int/float) - Series of data to be plotted\ntitle (const string) - Title of the plot\ncolor (series color) - Color of the plot",
               "A plot object that can be used in fill()");

        addDoc("plotshape", "Plots visual shapes on the chart.",
               "plotshape(series, title, style, location, color, offset, text, textcolor, editable, size, show_last, display) -> void",
               "series (series bool) - Series of data to be plotted as shapes\nstyle (input string) - Shape style",
               "void");

        addDoc("indicator", "Declares the script as an indicator and sets its properties.",
               "indicator(title, shorttitle, overlay, format, precision, scale, max_bars_back) -> void",
               "title (const string) - The title of the indicator\noverlay (const bool) - If true, the indicator is displayed on the main chart",
               "void");

        addDoc("strategy", "Declares the script as a strategy and sets its properties.",
               "strategy(title, shorttitle, overlay, format, precision, scale, pyramiding, calc_on_order_fills) -> void",
               "title (const string) - The title of the strategy\noverlay (const bool) - If true, the strategy is displayed on the main chart",
               "void");

        // Technical Analysis functions
        addDoc("ta.sma", "Simple Moving Average. Returns the moving average of source for length bars back.",
               "ta.sma(source, length) -> series float",
               "source (series int/float) - Series of values to process\nlength (series int) - Number of bars (length)",
               "Simple moving average of source for length bars back");

        addDoc("ta.ema", "Exponential Moving Average. Returns the exponentially weighted moving average.",
               "ta.ema(source, length) -> series float",
               "source (series int/float) - Series of values to process\nlength (simple int) - Number of bars (length)",
               "Exponential moving average of source for length bars back");

        addDoc("ta.rsi", "Relative Strength Index. Measures the speed and magnitude of price changes.",
               "ta.rsi(source, length) -> series float",
               "source (series int/float) - Series of values to process\nlength (simple int) - Number of bars (length)",
               "Relative strength index value");

        addDoc("ta.macd", "Moving Average Convergence Divergence. A trend-following momentum indicator.",
               "ta.macd(source, fastlen, slowlen, siglen) -> [series float, series float, series float]",
               "source (series int/float) - Series of values to process\nfastlen (simple int) - Fast length\nslowlen (simple int) - Slow length\nsiglen (simple int) - Signal length",
               "Tuple of [macdLine, signalLine, histogram]");

        addDoc("ta.crossover", "Returns true when source1 crosses over source2.",
               "ta.crossover(source1, source2) -> series bool",
               "source1 (series int/float) - First series\nsource2 (series int/float) - Second series",
               "true when source1 crosses over source2, false otherwise");

        addDoc("ta.crossunder", "Returns true when source1 crosses under source2.",
               "ta.crossunder(source1, source2) -> series bool",
               "source1 (series int/float) - First series\nsource2 (series int/float) - Second series",
               "true when source1 crosses under source2, false otherwise");

        // Input functions
        addDoc("input.int", "Adds an integer input to the script settings.",
               "input.int(defval, title, minval, maxval, step, tooltip, inline, group, confirm) -> input int",
               "defval (const int) - Default value\ntitle (const string) - Title in the settings dialog",
               "Value of the input");

        addDoc("input.float", "Adds a float input to the script settings.",
               "input.float(defval, title, minval, maxval, step, tooltip, inline, group, confirm) -> input float",
               "defval (const float) - Default value\ntitle (const string) - Title in the settings dialog",
               "Value of the input");

        addDoc("input.bool", "Adds a boolean input to the script settings.",
               "input.bool(defval, title, tooltip, inline, group, confirm) -> input bool",
               "defval (const bool) - Default value\ntitle (const string) - Title in the settings dialog",
               "Value of the input");

        addDoc("input.string", "Adds a string input to the script settings.",
               "input.string(defval, title, options, tooltip, inline, group, confirm) -> input string",
               "defval (const string) - Default value\ntitle (const string) - Title in the settings dialog",
               "Value of the input");

        addDoc("input.source", "Adds a source input to the script settings.",
               "input.source(defval, title, tooltip, inline, group) -> series float",
               "defval (series int/float) - Default value\ntitle (const string) - Title in the settings dialog",
               "Value of the input");

        addDoc("input.color", "Adds a color input to the script settings.",
               "input.color(defval, title, tooltip, inline, group, confirm) -> input color",
               "defval (const color) - Default value\ntitle (const string) - Title in the settings dialog",
               "Value of the input");

        // Array functions
        addDoc("array.new_float", "Creates a new array of float type elements.",
               "array.new_float(size, initial_value) -> array<float>",
               "size (series int) - Initial size of the array. Default is 0\ninitial_value (series int/float) - Initial value of all elements. Default is na",
               "The ID of an array object");

        addDoc("array.get", "Returns the value of the element at the specified index.",
               "array.get(id, index) -> series <type>",
               "id (any array type) - An array object\nindex (series int) - The index of the element",
               "The array element's value");

        addDoc("array.set", "Sets the value of the element at the specified index.",
               "array.set(id, index, value) -> void",
               "id (any array type) - An array object\nindex (series int) - The index of the element\nvalue - The new value",
               "void");

        addDoc("array.push", "Appends a value to the end of the array.",
               "array.push(id, value) -> void",
               "id (any array type) - An array object\nvalue - The value to append",
               "void");

        addDoc("array.size", "Returns the number of elements in the array.",
               "array.size(id) -> series int",
               "id (any array type) - An array object",
               "The number of elements in the array");

        // Strategy functions
        addDoc("strategy.entry", "Generates a market entry order.",
               "strategy.entry(id, direction, qty, limit, stop, oca_name, oca_type, comment, when, alert_message) -> void",
               "id (series string) - Order identifier\ndirection (strategy_direction) - Market position direction: strategy.long or strategy.short",
               "void");

        addDoc("strategy.exit", "Generates a market exit order.",
               "strategy.exit(id, from_entry, qty, qty_percent, profit, limit, loss, stop, trail_price, trail_points, trail_offset) -> void",
               "id (series string) - Order identifier\nfrom_entry (series string) - The identifier of the entry order to exit",
               "void");

        addDoc("strategy.close", "Closes the market position.",
               "strategy.close(id, when, comment, qty, qty_percent, alert_message) -> void",
               "id (series string) - Order identifier to close",
               "void");

        // Request functions
        addDoc("request.security", "Requests data from another symbol and/or timeframe.",
               "request.security(symbol, timeframe, expression, gaps, lookahead, ignore_invalid_symbol, currency) -> series <type>",
               "symbol (simple string) - Symbol\ntimeframe (simple string) - Timeframe\nexpression (series) - Expression to calculate",
               "Requested series");

        // Alert functions
        addDoc("alert", "Creates an alert event.",
               "alert(message, freq) -> void",
               "message (series string) - Alert message\nfreq (input string) - Frequency of alerts",
               "void");

        addDoc("alertcondition", "Creates an alert condition.",
               "alertcondition(condition, title, message) -> void",
               "condition (series bool) - Condition to trigger alert\ntitle (const string) - Title of the condition",
               "void");
    }

    private static void addDoc(String name, String description, String syntax, String arguments, String returns) {
        DOCS.put(name, new FunctionDoc(name, description, syntax, arguments, returns, null, null, null));
    }
}
