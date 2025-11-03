# PineScript Language Support

Professional PineScript language support plugin for IntelliJ-based IDEs (IntelliJ IDEA, PyCharm, WebStorm, etc.).

## Features

- **Accurate Syntax Highlighting**: Matches TradingView's official Pine Script editor color scheme
- **PineScript v5 Support**: Full support for the latest PineScript version
- **Built-in Function Recognition**: All major namespaces including ta.*, math.*, input.*, color.*, array.*, etc.
- **Smart Code Completion**: Autocomplete for built-in functions and variables
- **Proper Token Recognition**: Handles hex colors, operators, ternary operators, and special syntax
- **No False Warnings**: Spell checking disabled for PineScript-specific identifiers

## Installation

### From JetBrains Marketplace

1. Open your IntelliJ-based IDE
2. Go to `Settings/Preferences` → `Plugins`
3. Click `Marketplace` tab
4. Search for "PineScript Language Support"
5. Click `Install`
6. Restart the IDE

### From Disk

1. Download the plugin ZIP from releases
2. Open `Settings/Preferences` → `Plugins`
3. Click the gear icon → `Install Plugin from Disk...`
4. Select the downloaded ZIP file
5. Restart the IDE

## Usage

The plugin automatically activates for files with `.pine` or `.pinescript` extensions. Simply open or create a Pine Script file and start coding with full IDE support.

## Supported PineScript Features

### Keywords
- Control flow: `if`, `else`, `for`, `while`, `switch`
- Declarations: `var`, `varip`, `const`
- Functions: `function`, `method`
- Types: `int`, `float`, `bool`, `string`, `color`, `array`, `matrix`, `map`

### Built-in Namespaces
- Technical Analysis: `ta.*`
- Mathematics: `math.*`
- Input Functions: `input.*`
- Color Functions: `color.*`
- Array Operations: `array.*`, `matrix.*`, `map.*`
- Request Functions: `request.*`
- Display Constants: `display.*`, `format.*`
- And many more

### Syntax Highlighting Colors

The plugin uses TradingView's official color scheme:

- **Blue (#5B9CF6)**: Keywords, built-in functions, color constants
- **Green (#388E3C)**: String literals
- **Teal (#42BDA8)**: Storage keywords (var, const, switch), operators
- **Orange (#CB6B16)**: Numbers, na constant
- **Pink (#E27275)**: Booleans, namespace constants, hex colors
- **Light Gray (#CACACA)**: Variable names

## Development

### Building from Source

```bash
git clone https://github.com/yourusername/pycharm-pinescript.git
cd pycharm-pinescript
./gradlew buildPlugin
```

The plugin ZIP will be created in `build/distributions/`.

### Running in Development Mode

```bash
./gradlew runIde
```

This launches a sandboxed IDE instance with the plugin loaded for testing.

## Requirements

- IntelliJ Platform version 2023.1 or later
- Compatible with IntelliJ IDEA, PyCharm, WebStorm, and other IntelliJ-based IDEs

## Contributing

Contributions are welcome! Please feel free to submit issues or pull requests.

## License

This project is licensed under the MIT License.

## Acknowledgments

- TradingView for creating PineScript
- The PineScript community for feedback and suggestions

## Support

For issues, feature requests, or questions:
- GitHub Issues: [Report an issue](https://github.com/yourusername/pycharm-pinescript/issues)
- TradingView Community: Join the discussion

## Screenshots

The plugin provides accurate syntax highlighting that matches TradingView's editor, making it easy to develop and test your Pine Script strategies and indicators locally before deploying them to TradingView.
