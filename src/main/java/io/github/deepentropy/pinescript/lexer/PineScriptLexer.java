package io.github.deepentropy.pinescript.lexer;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;
import io.github.deepentropy.pinescript.psi.PineScriptTokenTypes;

public class PineScriptLexer extends LexerBase {
    private CharSequence myBuffer;
    private int myEndOffset;
    private int myCurrentOffset;
    private int myTokenStart;
    private IElementType myTokenType;

    @Override
    public void start(CharSequence buffer, int startOffset, int endOffset, int initialState) {
        myBuffer = buffer;
        myEndOffset = endOffset;
        myCurrentOffset = startOffset;
        myTokenStart = startOffset;
        myTokenType = null;
        advance();
    }

    @Override
    public int getState() {
        return 0;
    }

    @Override
    public IElementType getTokenType() {
        return myTokenType;
    }

    @Override
    public int getTokenStart() {
        return myTokenStart;
    }

    @Override
    public int getTokenEnd() {
        return myCurrentOffset;
    }

    @Override
    public void advance() {
        // Clear previous token type
        myTokenType = null;

        if (myCurrentOffset >= myEndOffset) {
            myTokenStart = myCurrentOffset;
            return;
        }

        myTokenStart = myCurrentOffset;

        // Bounds check - should never happen but defensive
        if (myCurrentOffset >= myBuffer.length() || myCurrentOffset >= myEndOffset) {
            return;
        }

        char c = myBuffer.charAt(myCurrentOffset);

        // Skip whitespace
        if (Character.isWhitespace(c)) {
            myCurrentOffset++;
            while (myCurrentOffset < myEndOffset && Character.isWhitespace(myBuffer.charAt(myCurrentOffset))) {
                myCurrentOffset++;
            }
            myTokenType = PineScriptTokenTypes.WHITE_SPACE;
            return;
        }

        // Handle line comments and annotations
        if (c == '/' && myCurrentOffset + 1 < myEndOffset && myBuffer.charAt(myCurrentOffset + 1) == '/') {
            myCurrentOffset += 2;

            // Check if this is an annotation (starts with //@)
            if (myCurrentOffset < myEndOffset && myBuffer.charAt(myCurrentOffset) == '@') {
                // Skip to end of line
                while (myCurrentOffset < myEndOffset && myBuffer.charAt(myCurrentOffset) != '\n') {
                    myCurrentOffset++;
                }
                myTokenType = PineScriptTokenTypes.ANNOTATION;
                return;
            }

            // Regular comment
            while (myCurrentOffset < myEndOffset && myBuffer.charAt(myCurrentOffset) != '\n') {
                myCurrentOffset++;
            }
            myTokenType = PineScriptTokenTypes.COMMENT;
            return;
        }

        // Handle block comments
        if (c == '/' && myCurrentOffset + 1 < myEndOffset && myBuffer.charAt(myCurrentOffset + 1) == '*') {
            myCurrentOffset += 2;
            boolean terminated = false;
            while (myCurrentOffset < myEndOffset) {
                if (myCurrentOffset + 1 < myEndOffset &&
                    myBuffer.charAt(myCurrentOffset) == '*' &&
                    myBuffer.charAt(myCurrentOffset + 1) == '/') {
                    myCurrentOffset += 2;
                    terminated = true;
                    break;
                }
                myCurrentOffset++;
            }
            myTokenType = terminated ? PineScriptTokenTypes.COMMENT : PineScriptTokenTypes.BAD_CHARACTER;
            return;
        }

        // Handle strings
        if (c == '"' || c == '\'') {
            char quote = c;
            myCurrentOffset++;
            boolean terminated = false;
            while (myCurrentOffset < myEndOffset) {
                char ch = myBuffer.charAt(myCurrentOffset);
                if (ch == '\n') {
                    // Newline without closing quote - unterminated string
                    break;
                }
                if (ch == quote) {
                    myCurrentOffset++;
                    terminated = true;
                    break;
                }
                if (ch == '\\' && myCurrentOffset + 1 < myEndOffset) {
                    myCurrentOffset += 2; // Skip backslash and next character
                } else {
                    myCurrentOffset++;
                }
            }
            myTokenType = terminated ? PineScriptTokenTypes.STRING : PineScriptTokenTypes.BAD_CHARACTER;
            return;
        }

        // Handle hex colors (#RRGGBB or #RRGGBBAA)
        if (c == '#') {
            myCurrentOffset++;
            int hexCount = 0;
            while (myCurrentOffset < myEndOffset && hexCount < 8) {
                char ch = myBuffer.charAt(myCurrentOffset);
                if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {
                    myCurrentOffset++;
                    hexCount++;
                } else {
                    break;
                }
            }
            if (hexCount == 6 || hexCount == 8) {
                myTokenType = PineScriptTokenTypes.HEX_COLOR;
            } else {
                myTokenType = PineScriptTokenTypes.BAD_CHARACTER;
            }
            return;
        }

        // Handle numbers
        if (Character.isDigit(c)) {
            myCurrentOffset++;
            boolean hasDecimal = false;
            while (myCurrentOffset < myEndOffset) {
                char ch = myBuffer.charAt(myCurrentOffset);
                if (Character.isDigit(ch)) {
                    myCurrentOffset++;
                } else if (ch == '.' && !hasDecimal && myCurrentOffset + 1 < myEndOffset && Character.isDigit(myBuffer.charAt(myCurrentOffset + 1))) {
                    // Only treat dot as decimal if followed by digit
                    hasDecimal = true;
                    myCurrentOffset++;
                } else {
                    break;
                }
            }
            myTokenType = PineScriptTokenTypes.NUMBER;
            return;
        }

        // Handle identifiers and keywords
        if (Character.isLetter(c) || c == '_') {
            myCurrentOffset++;
            while (myCurrentOffset < myEndOffset) {
                char ch = myBuffer.charAt(myCurrentOffset);
                if (Character.isLetterOrDigit(ch) || ch == '_' || ch == '.') {
                    myCurrentOffset++;
                } else {
                    break;
                }
            }

            String text = myBuffer.subSequence(myTokenStart, myCurrentOffset).toString();
            myTokenType = getKeywordTokenType(text);
            if (myTokenType == null) {
                // Check if this identifier is followed by '(' - makes it a function call
                if (isFollowedByOpenParen()) {
                    myTokenType = PineScriptTokenTypes.BUILTIN_FUNCTION;
                } else {
                    myTokenType = PineScriptTokenTypes.IDENTIFIER;
                }
            }
            return;
        }

        // Handle two-character operators
        if (myCurrentOffset + 1 < myEndOffset) {
            String twoChar = myBuffer.subSequence(myCurrentOffset, myCurrentOffset + 2).toString();
            switch (twoChar) {
                case "==":
                case "!=":
                case "<=":
                case ">=":
                case "&&":
                case "||":
                case "=>":
                case ":=":
                    myCurrentOffset += 2;
                    myTokenType = PineScriptTokenTypes.OPERATOR;
                    return;
            }
        }

        // Handle single-character tokens
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
            case '=':
            case '<':
            case '>':
            case '!':
            case '&':
            case '|':
            case '^':
            case '~':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.OPERATOR;
                break;
            case '(':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.LPAREN;
                break;
            case ')':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.RPAREN;
                break;
            case '{':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.LBRACE;
                break;
            case '}':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.RBRACE;
                break;
            case '[':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.LBRACKET;
                break;
            case ']':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.RBRACKET;
                break;
            case ',':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.COMMA;
                break;
            case ';':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.SEMICOLON;
                break;
            case ':':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.COLON;
                break;
            case '.':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.DOT;
                break;
            case '?':
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.OPERATOR;
                break;
            default:
                myCurrentOffset++;
                myTokenType = PineScriptTokenTypes.BAD_CHARACTER;
        }
    }

    @Override
    public CharSequence getBufferSequence() {
        return myBuffer;
    }

    @Override
    public int getBufferEnd() {
        return myEndOffset;
    }

    private IElementType getKeywordTokenType(String text) {
        // Check for color.* - functions are blue, color constants are pink
        if (text.startsWith("color.")) {
            String colorPart = text.substring(6);
            // Color constants (color.red, color.green, etc.) - pink
            if (isColorConstant(colorPart)) {
                return PineScriptTokenTypes.NAMESPACE_CONSTANT;
            }
            // Color functions (color.rgb, color.new, color.from_gradient) - blue
            return PineScriptTokenTypes.BUILTIN_FUNCTION;
        }

        // Check for namespace constants (format.*, display.*, etc.) - pink
        if (text.startsWith("format.") || text.startsWith("display.") ||
            text.startsWith("position.") || text.startsWith("size.") ||
            text.startsWith("extend.") || text.startsWith("shape.") ||
            text.startsWith("location.") || text.startsWith("xloc.") ||
            text.startsWith("yloc.") || text.startsWith("plot.style_") ||
            text.startsWith("hline.style_") || text.startsWith("line.style_") ||
            text.startsWith("label.style_") || text.startsWith("scale.")) {
            return PineScriptTokenTypes.NAMESPACE_CONSTANT;
        }

        // Check for built-in variable namespaces (these are namespace constants - pink)
        if (text.startsWith("barstate.") || text.startsWith("session.") ||
            text.startsWith("dayofweek.") || text.startsWith("adjustment.") ||
            text.startsWith("currency.") || text.startsWith("earnings.") ||
            text.startsWith("dividends.") || text.startsWith("splits.") ||
            text.equals("timenow")) {
            return PineScriptTokenTypes.NAMESPACE_CONSTANT;
        }

        // Check for syminfo.* - mostly constants (pink)
        if (text.startsWith("syminfo.")) {
            return PineScriptTokenTypes.NAMESPACE_CONSTANT;
        }

        // Check for built-in function namespaces (input., ta., math., etc.) - blue
        if (text.startsWith("input.") || text.startsWith("ta.") || text.startsWith("math.") ||
            text.startsWith("request.") ||
            text.startsWith("array.") || text.startsWith("matrix.") || text.startsWith("map.") ||
            text.startsWith("strategy.") || text.startsWith("str.") || text.startsWith("line.") ||
            text.startsWith("label.") || text.startsWith("box.") || text.startsWith("table.") ||
            text.startsWith("ticker.") || text.startsWith("timeframe.") ||
            text.startsWith("polyline.") || text.startsWith("linefill.") ||
            text.startsWith("chart.") || text.startsWith("log.") || text.startsWith("runtime.")) {
            return PineScriptTokenTypes.BUILTIN_FUNCTION;
        }

        switch (text) {
            // Control flow keywords - blue
            case "if":
            case "else":
            case "for":
            case "while":
            case "switch":
            case "break":
            case "continue":
            case "return":
            // Declaration keywords - blue
            case "function":
            case "method":
            case "var":
            case "varip":
            case "type":
            case "enum":
            // Module keywords - blue
            case "import":
            case "export":
                return PineScriptTokenTypes.KEYWORD;

            // Script type declarations (also function-like) - blue
            case "indicator":
            case "strategy":
            case "library":
            // Built-in standalone functions - blue
            case "plot":
            case "plotshape":
            case "plotchar":
            case "plotarrow":
            case "plotbar":
            case "plotcandle":
            case "hline":
            case "fill":
            case "bgcolor":
            case "barcolor":
            case "alert":
            case "alertcondition":
            case "time":
            case "time_close":
            case "timestamp":
            case "year":
            case "month":
            case "weekofyear":
            case "dayofmonth":
            case "dayofweek":
            case "hour":
            case "minute":
            case "second":
            case "nz":
            case "fixnan":
                return PineScriptTokenTypes.BUILTIN_FUNCTION;

            // Boolean constants - pink
            case "true":
            case "false":
                return PineScriptTokenTypes.BOOLEAN;

            // Special constant - pink
            case "na":
                return PineScriptTokenTypes.CONSTANT;

            // Logical operators (v6 style) - teal
            case "and":
            case "or":
            case "not":
                return PineScriptTokenTypes.OPERATOR;

            // Type keywords - green
            case "int":
            case "float":
            case "bool":
            case "string":
            case "color":
            case "array":
            case "matrix":
            case "map":
            case "series":
            case "simple":
            case "label":
            case "line":
            case "box":
            case "table":
            case "linefill":
            case "polyline":
                return PineScriptTokenTypes.TYPE_KEYWORD;

            // Storage keywords - teal
            case "const":
                return PineScriptTokenTypes.STORAGE_KEYWORD;
        }
        return null;
    }

    /**
     * Check if the current position is followed by '(' (possibly with whitespace in between).
     * This is used to detect function calls.
     */
    private boolean isFollowedByOpenParen() {
        int pos = myCurrentOffset;
        // Skip whitespace
        while (pos < myEndOffset) {
            char ch = myBuffer.charAt(pos);
            if (ch == ' ' || ch == '\t') {
                pos++;
            } else if (ch == '(') {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean isColorConstant(String name) {
        switch (name) {
            case "aqua":
            case "black":
            case "blue":
            case "fuchsia":
            case "gray":
            case "green":
            case "lime":
            case "maroon":
            case "navy":
            case "olive":
            case "orange":
            case "purple":
            case "red":
            case "silver":
            case "teal":
            case "white":
            case "yellow":
                return true;
            default:
                return false;
        }
    }
}
