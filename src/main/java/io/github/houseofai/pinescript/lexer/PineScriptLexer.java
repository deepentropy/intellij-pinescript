package io.github.houseofai.pinescript.lexer;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;

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
        if (myCurrentOffset >= myEndOffset) {
            myTokenType = null;
            return;
        }

        // Save the start position of the new token
        myTokenStart = myCurrentOffset;
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

        // Handle line comments
        if (c == '/' && myCurrentOffset + 1 < myEndOffset && myBuffer.charAt(myCurrentOffset + 1) == '/') {
            myCurrentOffset += 2;
            while (myCurrentOffset < myEndOffset && myBuffer.charAt(myCurrentOffset) != '\n') {
                myCurrentOffset++;
            }
            myTokenType = PineScriptTokenTypes.COMMENT;
            return;
        }

        // Handle block comments
        if (c == '/' && myCurrentOffset + 1 < myEndOffset && myBuffer.charAt(myCurrentOffset + 1) == '*') {
            myCurrentOffset += 2;
            while (myCurrentOffset < myEndOffset) {
                if (myCurrentOffset + 1 < myEndOffset &&
                    myBuffer.charAt(myCurrentOffset) == '*' &&
                    myBuffer.charAt(myCurrentOffset + 1) == '/') {
                    myCurrentOffset += 2;
                    break;
                }
                myCurrentOffset++;
            }
            myTokenType = PineScriptTokenTypes.COMMENT;
            return;
        }

        // Handle strings
        if (c == '"' || c == '\'') {
            char quote = c;
            myCurrentOffset++;
            while (myCurrentOffset < myEndOffset) {
                char ch = myBuffer.charAt(myCurrentOffset);
                if (ch == quote) {
                    myCurrentOffset++;
                    break;
                }
                if (ch == '\\') {
                    myCurrentOffset++; // Skip backslash
                    if (myCurrentOffset < myEndOffset) {
                        myCurrentOffset++; // Skip escaped character
                    }
                } else {
                    myCurrentOffset++; // Skip regular character
                }
            }
            myTokenType = PineScriptTokenTypes.STRING;
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
                } else if (ch == '.' && !hasDecimal) {
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
            int start = myCurrentOffset;
            myCurrentOffset++;
            while (myCurrentOffset < myEndOffset) {
                char ch = myBuffer.charAt(myCurrentOffset);
                if (Character.isLetterOrDigit(ch) || ch == '_' || ch == '.') {
                    myCurrentOffset++;
                } else {
                    break;
                }
            }

            String text = myBuffer.subSequence(start, myCurrentOffset).toString();
            myTokenType = getKeywordTokenType(text);
            if (myTokenType == null) {
                myTokenType = PineScriptTokenTypes.IDENTIFIER;
            }
            return;
        }

        // Handle operators and punctuation
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
                    myCurrentOffset += 2;
                    myTokenType = PineScriptTokenTypes.OPERATOR;
                    return;
            }
        }

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
            case '?':
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
        // Check for color constants (color.red, color.green, etc.) - blue
        if (text.startsWith("color.")) {
            return PineScriptTokenTypes.BUILTIN_FUNCTION;
        }

        // Check for namespace constants (format.*, display.*, etc.) - pink
        if (text.startsWith("format.") || text.startsWith("display.") ||
            text.startsWith("position.") || text.startsWith("size.") ||
            text.startsWith("extend.") || text.startsWith("shape.") ||
            text.startsWith("location.") || text.startsWith("xloc.") ||
            text.startsWith("yloc.") || text.startsWith("plot.style_") ||
            text.startsWith("hline.style_") || text.startsWith("line.style_")) {
            return PineScriptTokenTypes.NAMESPACE_CONSTANT;
        }

        // Check for built-in function namespaces (input., ta., math., etc.)
        if (text.startsWith("input.") || text.startsWith("ta.") || text.startsWith("math.") ||
            text.startsWith("request.") ||
            text.startsWith("array.") || text.startsWith("matrix.") || text.startsWith("map.") ||
            text.startsWith("strategy.") || text.startsWith("str.") || text.startsWith("line.") ||
            text.startsWith("label.") || text.startsWith("box.") || text.startsWith("table.") ||
            text.startsWith("ticker.") || text.startsWith("timeframe.")) {
            return PineScriptTokenTypes.BUILTIN_FUNCTION;
        }

        // Check for built-in variable namespaces (these are namespace constants - pink)
        if (text.startsWith("barstate.") || text.startsWith("session.") ||
            text.startsWith("syminfo.") || text.startsWith("timenow")) {
            return PineScriptTokenTypes.NAMESPACE_CONSTANT;
        }

        switch (text) {
            // Storage keywords (var, varip, const, switch) - teal color
            case "var":
            case "varip":
            case "const":
            case "switch":
                return PineScriptTokenTypes.STORAGE_KEYWORD;

            // Keywords
            case "if":
            case "else":
            case "for":
            case "while":
            case "break":
            case "continue":
            case "return":
            case "function":
            case "method":
            case "import":
            case "export":
            case "type":
                return PineScriptTokenTypes.KEYWORD;

            // Annotation keywords (also highlighted as keywords)
            case "indicator":
            case "strategy":
            case "library":
                return PineScriptTokenTypes.KEYWORD;

            // Built-in standalone functions
            case "plot":
            case "plotshape":
            case "plotchar":
            case "plotarrow":
            case "plotbar":
            case "plotcandle":
            case "hline":
            case "fill":
            case "bgcolor":
            case "alert":
            case "alertcondition":
                return PineScriptTokenTypes.BUILTIN_FUNCTION;

            // Booleans - pink
            case "true":
            case "false":
                return PineScriptTokenTypes.BOOLEAN;

            // Other constants - orange
            case "na":
                return PineScriptTokenTypes.CONSTANT;

            // Type keywords (treated as built-in types, should be blue like keywords)
            case "int":
            case "float":
            case "bool":
            case "string":
            case "color":
            case "array":
            case "matrix":
            case "map":
                return PineScriptTokenTypes.KEYWORD;
        }
        return null;
    }
}
