# Build Instructions

## Prerequisites

- Java 17 or later
- Gradle 8.5 or later

## Fixing the Gradle Wrapper Setup Error

If you encounter this error when running `gradle wrapper`:

```
Cannot create parent directories that are existing as file.
```

This means there's a **file** named `gradle` instead of a **directory**. Follow these steps to fix it:

### On Windows:

1. **Check if there's a file named `gradle` in your project root:**
   ```cmd
   dir gradle
   ```

2. **If it shows a file (not `<DIR>`), delete or rename it:**
   ```cmd
   del gradle
   ```
   OR
   ```cmd
   ren gradle gradle.old
   ```

3. **Now run the wrapper command:**
   ```cmd
   gradle wrapper
   ```

### On Linux/Mac:

1. **Check for the gradle file:**
   ```bash
   ls -la | grep gradle
   ```

2. **Remove the file if it exists:**
   ```bash
   rm gradle
   ```

3. **Run the wrapper command:**
   ```bash
   gradle wrapper
   ```

## Building the Plugin

Once the wrapper is set up:

1. **Pull latest changes:**
   ```bash
   git pull
   ```

2. **Build the plugin:**
   ```bash
   ./gradlew buildPlugin
   ```

3. **Find the plugin ZIP:**
   ```
   build/distributions/pycharm-pinescript-1.0.1.zip
   ```

## Installing the Plugin

1. Open IntelliJ IDEA or PyCharm
2. Go to **Settings** → **Plugins**
3. Click the **⚙️** icon → **Install Plugin from Disk...**
4. Select `build/distributions/pycharm-pinescript-1.0.1.zip`
5. Click **OK** and **Restart IDE**

## Testing the Fix

After restart:

1. Open or create a `.pine` or `.pinescript` file
2. The file should open without errors
3. Verify syntax highlighting works for keywords like `indicator`, `strategy`, `type`, `const`, `method`

## Troubleshooting

### Gradle Version Check

Check your Gradle version:
```bash
gradle --version
```

If you're using Gradle 10.x (pre-release), consider using Gradle 9.2.0 for better compatibility.

### Build Errors

If you encounter build errors:

1. **Clean the build:**
   ```bash
   ./gradlew clean
   ```

2. **Rebuild:**
   ```bash
   ./gradlew buildPlugin
   ```

3. **Check Java version:**
   ```bash
   java -version
   ```
   Must be Java 17 or later.

## What Was Fixed

### Version 1.0.1 Changes:

1. **Critical Lexer Bug Fix:**
   - Fixed token boundary tracking in `PineScriptLexer.java`
   - Both `getTokenStart()` and `getTokenEnd()` were returning the same value
   - This caused: `java.lang.IllegalStateException: Unexpected termination offset for lexer`

2. **Added Missing Keywords:**
   - Language keywords: `method`, `const`, `type`
   - Type names: `int`, `float`, `bool`, `string`, `color`, `array`, `matrix`, `map`

3. **Build System Updates:**
   - Migrated from Gradle IntelliJ Plugin 1.x to IntelliJ Platform Gradle Plugin 2.x
   - Updated to version 2.10.4 for latest features and bug fixes
   - Supports Gradle 8.5+ and newer versions

## Questions?

If you encounter any issues, please check:
- Java version (must be 17+)
- Gradle version (must be 8.5+)
- Project has no file named `gradle` blocking wrapper setup
