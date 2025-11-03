# Publishing Guide for PineScript Language Support Plugin

## Plugin Information

- **Plugin ID**: com.tradingview.pinescript
- **Name**: PineScript Language Support
- **Version**: 1.0.0
- **Compatibility**: IntelliJ Platform 2023.1 - 2026.1.*

## Distribution File

The plugin distribution is located at:
```
build/distributions/pycharm-pinescript-1.0.0.zip
```

## Publishing to JetBrains Marketplace

### Prerequisites

1. Create a JetBrains account at https://account.jetbrains.com/
2. Join the JetBrains Marketplace at https://plugins.jetbrains.com/

### Publishing Steps

1. **Go to JetBrains Marketplace**
   - Visit https://plugins.jetbrains.com/
   - Sign in with your JetBrains account
   - Click "Upload plugin"

2. **Upload the Plugin**
   - Select the plugin ZIP file: `build/distributions/pycharm-pinescript-1.0.0.zip`
   - The marketplace will automatically extract plugin information from plugin.xml

3. **Fill in Additional Information**
   - **Icon**: Upload `docs/pinetreeicon.png` as the plugin icon (will be converted to required format)
   - **Screenshots**: Consider adding screenshots showing:
     - Syntax highlighting in action
     - Code completion features
     - File icon in project tree
   - **Category**: Select "Custom Languages" or "Code Tools"
   - **Tags**: Add relevant tags like "pinescript", "tradingview", "trading", "syntax"

4. **Review and Submit**
   - Review all information
   - Click "Publish"
   - Wait for JetBrains approval (usually 1-3 business days)

### Publishing via Gradle (Alternative)

If you have plugin signing configured:

```bash
# Set environment variables
export PUBLISH_TOKEN=your_marketplace_token
export CERTIFICATE_CHAIN=your_certificate_chain
export PRIVATE_KEY=your_private_key
export PRIVATE_KEY_PASSWORD=your_key_password

# Publish
./gradlew publishPlugin
```

## Marketplace Requirements Checklist

- [x] Plugin has unique ID
- [x] Version follows semantic versioning
- [x] Description is clear and informative
- [x] Change notes are provided
- [x] Compatible IDE versions are specified
- [x] Plugin icon is provided
- [x] License file is included (MIT)
- [x] README documentation exists
- [x] No malicious code or telemetry without disclosure

## Post-Publishing

After approval:

1. **Monitor Feedback**: Check plugin reviews and respond to user feedback
2. **Track Issues**: Monitor GitHub issues for bug reports
3. **Plan Updates**: Maintain a roadmap for future features
4. **Update Documentation**: Keep README and docs up to date

## Marketing

- Share on TradingView community forums
- Post on Reddit (r/TradingView, r/algotrading)
- Tweet about the release
- Write a blog post about developing Pine Script locally

## Support

Users can get support through:
- GitHub Issues: https://github.com/yourusername/pycharm-pinescript/issues
- JetBrains Marketplace plugin page
- TradingView community forums

## Version Updates

For future releases:

1. Update version in `build.gradle.kts`
2. Update change notes in `plugin.xml`
3. Run `./gradlew clean buildPlugin`
4. Upload new version to marketplace
5. Create GitHub release with changelog

## Plugin Features to Highlight

- TradingView-accurate syntax highlighting
- Support for all PineScript v5 features
- Smart code completion
- No false spell-check warnings
- Professional development experience
- Works with all JetBrains IDEs
