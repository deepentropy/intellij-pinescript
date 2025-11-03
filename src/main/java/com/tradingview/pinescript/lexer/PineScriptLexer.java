package com.tradingview.pinescript.lexer;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;
import com.tradingview.pinescript.psi.PineScriptTokenTypes;

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

        // Handle line comments and annotations
        if (c == '/' && myCurrentOffset + 1 < myEndOffset && myBuffer.charAt(myCurrentOffset + 1) == '/') {
            int commentStart = myCurrentOffset;
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
            while (myCurrentOffset + 1 < myEndOffset) {
                if (myBuffer.charAt(myCurrentOffset) == '*' && myBuffer.charAt(myCurrentOffset + 1) == '/') {
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
                    myCurrentOffset++;
                }
                myCurrentOffset++;
            }
            myTokenType = PineScriptTokenTypes.STRING;
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
        switch (text) {
            // Control flow keywords
            case "if":
            case "else":
            case "for":
            case "while":
            case "switch":
            case "break":
            case "continue":
            case "return":
            // Declaration keywords
            case "function":
            case "method":
            case "var":
            case "varip":
            case "type":
            case "enum":
            // Module keywords
            case "import":
            case "export":
            // Script type keywords
            case "indicator":
            case "strategy":
            case "library":
                return PineScriptTokenTypes.KEYWORD;
            // Boolean and special constants
            case "true":
            case "false":
            case "na":
                return PineScriptTokenTypes.CONSTANT;
            // Logical operators (v6 style)
            case "and":
            case "or":
            case "not":
                return PineScriptTokenTypes.OPERATOR;
        }
        return null;
    }
}