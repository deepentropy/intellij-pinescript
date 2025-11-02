# PineScript v6 Language Support for PyCharm/IntelliJ IDEA

A comprehensive plugin that adds full PineScript v6 language support to PyCharm and IntelliJ IDEA, enabling syntax highlighting, code completion, and intelligent editing features for TradingView's PineScript language.

## Features

### PineScript v6 Support
- **Full v6 Syntax**: Complete support for PineScript v6 features including:
  - `type` keyword for user-defined types (UDTs)
  - `enum` keyword for enumerations
  - `method` keyword for method declarations
  - `switch` statement support
  - Logical operators: `and`, `or`, `not`

### Syntax Highlighting
- **Smart Highlighting**: Distinct colors for keywords, constants, strings, numbers, comments, identifiers, operators, and annotations
- **Annotation Support**: Special highlighting for PineScript annotations:
  - `@version` - Script version specification
  - `@type` - Type documentation
  - `@enum` - Enumeration documentation
  - `@field` - Field documentation
  - `@function` - Function documentation
  - `@param` - Parameter documentation
  - `@returns` - Return value documentation
  - `@variable` - Variable documentation
  - `@description` - General description

### Code Completion
Over **500+ autocomplete items** covering all major PineScript namespaces:

#### Technical Analysis (ta.*)
50+ functions including:
- Moving averages: `sma`, `ema`, `wma`, `vwma`, `rma`, `alma`, `kama`
- Oscillators: `rsi`, `macd`, `stoch`, `cci`, `mfi`, `tsi`
- Channels: `bb`, `bbw`, `kc`
- Volatility: `atr`, `tr`, `stdev`, `variance`
- Trend: `sar`, `supertrend`, `adx`, `dmi`, `aroon`
- Statistics: `correlation`, `median`, `mode`, `percentrank`
- Utilities: `cross`, `crossover`, `crossunder`, `change`, `valuewhen`, `barssince`

#### Arrays (array.*)
- Constructors: `new_float`, `new_int`, `new_bool`, `new_string`, `new_color`, `new_line`, `new_label`, `new_box`
- Operations: `get`, `set`, `push`, `pop`, `shift`, `unshift`, `insert`, `remove`, `clear`
- Manipulation: `concat`, `copy`, `slice`, `reverse`, `sort`, `sort_indices`
- Search: `includes`, `indexof`, `lastindexof`, `binary_search`
- Statistics: `min`, `max`, `sum`, `avg`, `median`, `mode`, `stdev`, `variance`

#### Maps (map.*) - v6
- `new`, `get`, `put`, `put_all`, `remove`, `clear`
- `contains`, `keys`, `values`, `size`, `copy`

#### Matrices (matrix.*) - v6
- Creation: `new`, `copy`, `submatrix`
- Access: `get`, `set`, `row`, `col`, `rows`, `columns`
- Manipulation: `add_row`, `add_col`, `remove_row`, `remove_col`, `swap_rows`, `swap_columns`
- Operations: `transpose`, `reshape`, `concat`, `mult`, `pow`, `diff`, `reverse`, `fill`
- Linear algebra: `det`, `inv`, `pinv`, `rank`, `trace`, `eigenvalues`, `eigenvectors`
- Statistics: `sum`, `avg`, `median`, `mode`, `max`, `min`, `range`, `stdev`, `variance`
- Predicates: `is_square`, `is_identity`, `is_binary`, `is_zero`, `is_stochastic`, `is_symmetric`, `is_antisymmetric`

#### Drawing Objects
- **Lines** (line.*): `new`, `delete`, `get_*`, `set_*`, `copy`, `all`
- **Labels** (label.*): `new`, `delete`, `get_*`, `set_*`, `copy`, `all`
- **Boxes** (box.*): `new`, `delete`, `get_*`, `set_*`, `copy`, `all`
- **Polylines** (polyline.*) - v6: `new`, `delete`, `copy`, `all`
- **Linefills** (linefill.*) - v6: `new`, `delete`, `get_line1`, `get_line2`, `set_color`, `copy`

#### Colors (color.*)
- Functions: `rgb`, `new`, `from_gradient`
- Constants: `aqua`, `black`, `blue`, `fuchsia`, `gray`, `green`, `lime`, `maroon`, `navy`, `olive`, `orange`, `purple`, `red`, `silver`, `teal`, `white`, `yellow`

#### Other Namespaces
- **Strings** (str.*): `tostring`, `tonumber`, `format`, `substring`
- **Math** (math.*): 20+ mathematical functions
- **Request** (request.*): `security`, `earnings`, `dividends`
- **Strategy** (strategy.*): `entry`, `exit`, `order`, `position_avg_price`, `position_size`
- **Input** (input.*): `bool`, `color`, `float`, `int`, `string`, `session`, `timeframe`, `symbol`, `enum`
- **Timeframe** (timeframe.*): `in_seconds`, `from_seconds`
- **Ticker** (ticker.*): `new`, `heikinashi`, `renko`, `linebreak`, `kagi`, `pointfigure`
- **Table** (table.*): Table creation and manipulation functions
- **Chart** (chart.*): Chart type constants and variables

#### Built-in Variables
- OHLCV: `open`, `high`, `low`, `close`, `volume`, `time`
- Derived prices: `hl2`, `hlc3`, `ohlc4`, `hlcc4`
- Bar state: `barstate.*` (isconfirmed, isfirst, ishistory, islast, isnew, isrealtime)
- Symbol info: `syminfo.*` (basecurrency, currency, description, ticker, timezone, type, etc.)
- Timeframe: `timeframe.*` (period, multiplier, isdaily, isintraday, isweekly, ismonthly, etc.)
- Chart: `chart.*` (is_standard, bg_color, left_visible_bar_time, etc.)

### Smart Editing Features
- **Bracket Matching**: Automatic matching for `()`, `{}`, `[]`
- **Quote Handling**: Smart quote pairing for strings
- **Code Style**: Configurable code style settings

### File Type Support
- File extensions: `.pine`, `.pinescript`
- Proper file type icons and associations

## Requirements

- **IntelliJ IDEA** or **PyCharm**: Version 2023.1 or later (up to 2024.1)
- **Java Development Kit (JDK)**: Version 17 or higher
- **Gradle**: Version 7.0 or higher (for building from source)

## Installation

### Option 1: Install from Marketplace (Recommended)
1. Open PyCharm or IntelliJ IDEA
2. Go to **File** → **Settings** (or **IntelliJ IDEA** → **Preferences** on macOS)
3. Navigate to **Plugins**
4. Search for "PineScript Language Support"
5. Click **Install**
6. Restart the IDE

### Option 2: Install from Disk
1. Download the latest `.zip` file from the [Releases](https://github.com/yourusername/pycharm-pinescript/releases) page
2. Open PyCharm or IntelliJ IDEA
3. Go to **File** → **Settings** → **Plugins**
4. Click the gear icon ⚙️ and select **Install Plugin from Disk...**
5. Select the downloaded `.zip` file
6. Restart the IDE

### Option 3: Build from Source
See the **Building the Plugin** section below.

## Building the Plugin

### Prerequisites
1. **Install JDK 17 or higher**
   ```bash
   # Verify Java installation
   java -version
   ```

2. **Install Gradle** (if not already installed)
   ```bash
   # On macOS with Homebrew
   brew install gradle

   # On Linux (Debian/Ubuntu)
   sudo apt-get install gradle

   # On Windows with Chocolatey
   choco install gradle

   # Verify Gradle installation
   gradle --version
   ```

### Build Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/pycharm-pinescript.git
   cd pycharm-pinescript
   ```

2. **Generate Gradle Wrapper** (if not present)
   ```bash
   gradle wrapper
   ```

3. **Build the plugin**
   ```bash
   ./gradlew buildPlugin
   ```

   Or on Windows:
   ```cmd
   gradlew.bat buildPlugin
   ```

4. **Locate the built plugin**

   The plugin `.zip` file will be created in:
   ```
   build/distributions/pycharm-pinescript-1.0.0.zip
   ```

### Build Troubleshooting

If you encounter issues with the IntelliJ Gradle plugin, try:

1. **Clear Gradle caches**
   ```bash
   ./gradlew clean
   rm -rf ~/.gradle/caches
   ```

2. **Use offline mode** (if you have cached dependencies)
   ```bash
   ./gradlew buildPlugin --offline
   ```

3. **Check network connectivity**

   Ensure you can access:
   - https://plugins.gradle.org/
   - https://repo1.maven.org/maven2/

4. **Verify settings.gradle.kts**

   Ensure `settings.gradle.kts` contains:
   ```kotlin
   pluginManagement {
       repositories {
           gradlePluginPortal()
           mavenCentral()
       }
   }
   ```

### Alternative Build Method (Manual Compilation)

If Gradle build fails, you can manually compile:

```bash
# Create output directory
mkdir -p build/classes/java/main

# Compile Java sources (you'll need IntelliJ SDK jars)
javac -d build/classes/java/main \
      -cp "/path/to/intellij/lib/*" \
      $(find src/main/java -name "*.java")

# Create JAR
cd build/classes/java/main
jar cvf ../../../../pycharm-pinescript.jar .
cd ../../../..

# Package as plugin (create META-INF and add plugin.xml)
mkdir -p plugin/lib
cp pycharm-pinescript.jar plugin/lib/
cp plugin.xml plugin/META-INF/
cd plugin
zip -r ../pycharm-pinescript-1.0.0.zip .
```

## Integration into PyCharm IDE

### After Installation

1. **Restart PyCharm/IntelliJ IDEA** after installation

2. **Verify Installation**
   - Go to **File** → **Settings** → **Plugins**
   - Look for "PineScript Language Support" in the installed plugins list
   - Ensure it's enabled (checkbox is checked)

3. **Open or Create PineScript Files**
   - Create a new file with `.pine` or `.pinescript` extension
   - The file should automatically be recognized with proper syntax highlighting

4. **Test Code Completion**
   - Type `ta.` and press `Ctrl+Space` (or `Cmd+Space` on macOS)
   - You should see autocomplete suggestions for technical analysis functions
   - Try typing `@version` in a comment to see annotation highlighting

5. **Configure Color Scheme** (Optional)
   - Go to **File** → **Settings** → **Editor** → **Color Scheme** → **PineScript**
   - Customize colors for keywords, strings, comments, annotations, etc.

### Creating a PineScript File

1. **New File Method 1:**
   - Right-click in the Project view
   - Select **New** → **File**
   - Name it with `.pine` extension (e.g., `my_indicator.pine`)

2. **New File Method 2:**
   - Use **File** → **New** → **File**
   - Enter filename: `my_indicator.pine`

3. **Start Coding:**
   ```pinescript
   //@version=6
   //@description My custom indicator
   indicator("My Indicator", overlay=true)

   //@type Price bar structure
   type PriceBar
       float open
       float high
       float low
       float close

   // Calculate SMA
   smaValue = ta.sma(close, 20)

   // Plot
   plot(smaValue, color=color.blue, title="SMA 20")
   ```

### Keyboard Shortcuts

- **Code Completion**: `Ctrl+Space` (Windows/Linux) or `Cmd+Space` (macOS)
- **Parameter Info**: `Ctrl+P` (Windows/Linux) or `Cmd+P` (macOS)
- **Quick Documentation**: `Ctrl+Q` (Windows/Linux) or `F1` (macOS)
- **Reformat Code**: `Ctrl+Alt+L` (Windows/Linux) or `Cmd+Opt+L` (macOS)

## PineScript v6 Examples

### User-Defined Types
```pinescript
//@version=6
indicator("UDT Example")

//@type Represents a candlestick pattern
type Candle
    float open
    float high
    float low
    float close
    bool isBullish = close > open

candle = Candle.new()
plot(candle.close)
```

### Enumerations
```pinescript
//@version=6
indicator("Enum Example")

//@enum Trading session types
enum Session
    asian = "Asian Session"
    european = "European Session"
    american = "American Session"

selectedSession = input.enum(Session.american, "Session")
```

### Methods
```pinescript
//@version=6
indicator("Method Example")

//@function Calculates percentage change
method pctChange(series float src, simple int length) =>
    (src - src[length]) / src[length] * 100

pct = close.pctChange(10)
plot(pct, title="10-bar % Change")
```

### Switch Statements
```pinescript
//@version=6
indicator("Switch Example")

maType = input.string("EMA", "MA Type", options=["SMA", "EMA", "WMA"])

ma = switch maType
    "SMA" => ta.sma(close, 20)
    "EMA" => ta.ema(close, 20)
    => ta.wma(close, 20)

plot(ma)
```

## Project Structure

```
pycharm-pinescript/
├── src/main/java/com/tradingview/pinescript/
│   ├── PineScriptLanguage.java           # Core language definition
│   ├── PineScriptFileType.java           # File type registration
│   ├── PineScriptBraceMatcher.java       # Bracket matching
│   ├── PineScriptQuoteHandler.java       # Quote handling
│   ├── PineScriptCodeStyleSettingsProvider.java
│   ├── lexer/
│   │   └── PineScriptLexer.java          # Lexical analyzer
│   ├── psi/
│   │   └── PineScriptTokenTypes.java     # Token definitions
│   ├── highlighting/
│   │   ├── PineScriptSyntaxHighlighter.java
│   │   ├── PineScriptSyntaxHighlighterFactory.java
│   │   └── PineScriptColorSettingsPage.java
│   └── completion/
│       └── PineScriptCompletionContributor.java
├── docs/reference/                        # PineScript v6 reference docs
│   ├── keywords/                          # Language keywords
│   ├── functions/                         # Built-in functions
│   ├── variables/                         # Built-in variables
│   ├── constants/                         # Constants
│   ├── types/                             # Type definitions
│   ├── annotations/                       # Annotation docs
│   └── operators/                         # Operators
├── plugin.xml                             # Plugin configuration
├── build.gradle.kts                       # Build configuration
├── settings.gradle.kts                    # Gradle settings
└── README.md                              # This file
```

## Development

### Running in Development Mode

1. **Open project in IntelliJ IDEA**
   ```bash
   idea .
   ```

2. **Run the plugin in development**
   ```bash
   ./gradlew runIde
   ```

   This launches a new IntelliJ IDEA instance with the plugin installed

3. **Enable debug mode**
   ```bash
   ./gradlew runIde --debug-jvm
   ```

### Making Changes

1. Modify source files in `src/main/java/`
2. Test changes with `./gradlew runIde`
3. Build final plugin with `./gradlew buildPlugin`

## Contributing

Contributions are welcome! Please:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- **TradingView** for creating PineScript
- **JetBrains** for the IntelliJ Platform SDK
- The PineScript community for feedback and suggestions

## Support

- **Issues**: [GitHub Issues](https://github.com/yourusername/pycharm-pinescript/issues)
- **Discussions**: [GitHub Discussions](https://github.com/yourusername/pycharm-pinescript/discussions)
- **Documentation**: [PineScript v6 Reference](https://www.tradingview.com/pine-script-docs/)

## Version History

### 1.0.0 - PineScript v6 Support
- Full PineScript v6 syntax support
- 500+ autocomplete items
- User-defined types, enums, and methods
- Annotation highlighting
- Comprehensive namespace coverage

---

**Made with ❤️ for the PineScript community**
