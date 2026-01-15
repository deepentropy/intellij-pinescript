package io.github.houseofai.pinescript.lexer;

import com.intellij.psi.tree.IElementType;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for PineScriptLexer
 */
public class PineScriptLexerTest {

    private List<TokenInfo> tokenize(String text) {
        PineScriptLexer lexer = new PineScriptLexer();
        lexer.start(text, 0, text.length(), 0);

        List<TokenInfo> tokens = new ArrayList<>();
        while (lexer.getTokenType() != null) {
            tokens.add(new TokenInfo(
                lexer.getTokenType(),
                text.substring(lexer.getTokenStart(), lexer.getTokenEnd())
            ));
            lexer.advance();
        }
        return tokens;
    }

    // ========== Keywords ==========

    @Test
    public void testKeywords() {
        // Control flow and declaration keywords
        String[] keywords = {"if", "else", "for", "while", "switch", "break", "continue", "return",
                             "function", "method", "var", "varip", "type", "enum", "import", "export"};

        for (String keyword : keywords) {
            List<TokenInfo> tokens = tokenize(keyword);
            assertEquals("Keyword: " + keyword, 1, tokens.size());
            assertEquals("Keyword: " + keyword, PineScriptTokenTypes.KEYWORD, tokens.get(0).type);
        }
    }

    @Test
    public void testScriptTypeKeywords() {
        // Script type declarations are BUILTIN_FUNCTION (they're used like functions)
        String[] scriptTypes = {"indicator", "strategy", "library"};

        for (String type : scriptTypes) {
            List<TokenInfo> tokens = tokenize(type);
            assertEquals("Script type: " + type, 1, tokens.size());
            assertEquals("Script type: " + type, PineScriptTokenTypes.BUILTIN_FUNCTION, tokens.get(0).type);
        }
    }

    @Test
    public void testTypeKeywords() {
        String[] types = {"int", "float", "bool", "string", "color", "array", "matrix", "map"};

        for (String type : types) {
            List<TokenInfo> tokens = tokenize(type);
            assertEquals("Type: " + type, 1, tokens.size());
            assertEquals("Type: " + type, PineScriptTokenTypes.TYPE_KEYWORD, tokens.get(0).type);
        }
    }

    @Test
    public void testBooleans() {
        List<TokenInfo> tokens = tokenize("true false");
        assertEquals(3, tokens.size());
        assertEquals(PineScriptTokenTypes.BOOLEAN, tokens.get(0).type);
        assertEquals(PineScriptTokenTypes.WHITE_SPACE, tokens.get(1).type);
        assertEquals(PineScriptTokenTypes.BOOLEAN, tokens.get(2).type);
    }

    @Test
    public void testConstant() {
        List<TokenInfo> tokens = tokenize("na");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.CONSTANT, tokens.get(0).type);
    }

    // ========== Comments ==========

    @Test
    public void testLineComment() {
        List<TokenInfo> tokens = tokenize("// this is a comment");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.COMMENT, tokens.get(0).type);
    }

    @Test
    public void testBlockComment() {
        List<TokenInfo> tokens = tokenize("/* block\ncomment */");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.COMMENT, tokens.get(0).type);
    }

    @Test
    public void testUnterminatedBlockComment() {
        List<TokenInfo> tokens = tokenize("/* unterminated");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.BAD_CHARACTER, tokens.get(0).type);
    }

    @Test
    public void testAnnotation() {
        List<TokenInfo> tokens = tokenize("//@version=6");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.ANNOTATION, tokens.get(0).type);
    }

    // ========== Strings ==========

    @Test
    public void testDoubleQuotedString() {
        List<TokenInfo> tokens = tokenize("\"hello world\"");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.STRING, tokens.get(0).type);
        assertEquals("\"hello world\"", tokens.get(0).text);
    }

    @Test
    public void testSingleQuotedString() {
        List<TokenInfo> tokens = tokenize("'hello world'");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.STRING, tokens.get(0).type);
    }

    @Test
    public void testStringWithEscapes() {
        List<TokenInfo> tokens = tokenize("\"hello\\nworld\"");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.STRING, tokens.get(0).type);
    }

    @Test
    public void testUnterminatedString() {
        List<TokenInfo> tokens = tokenize("\"unterminated");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.BAD_CHARACTER, tokens.get(0).type);
    }

    @Test
    public void testUnterminatedStringWithNewline() {
        List<TokenInfo> tokens = tokenize("\"unterminated\nvalue\"");
        assertEquals(4, tokens.size());
        assertEquals(PineScriptTokenTypes.BAD_CHARACTER, tokens.get(0).type);
        assertEquals(PineScriptTokenTypes.WHITE_SPACE, tokens.get(1).type);
        assertEquals(PineScriptTokenTypes.IDENTIFIER, tokens.get(2).type); // "value" is an identifier
        assertEquals(PineScriptTokenTypes.BAD_CHARACTER, tokens.get(3).type);
    }

    // ========== Numbers ==========

    @Test
    public void testInteger() {
        List<TokenInfo> tokens = tokenize("42");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.NUMBER, tokens.get(0).type);
    }

    @Test
    public void testFloat() {
        List<TokenInfo> tokens = tokenize("3.14");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.NUMBER, tokens.get(0).type);
    }

    @Test
    public void testFloatWithoutLeadingDigit() {
        // .5 should be treated as DOT + NUMBER
        List<TokenInfo> tokens = tokenize(".5");
        assertEquals(2, tokens.size());
        assertEquals(PineScriptTokenTypes.DOT, tokens.get(0).type);
        assertEquals(PineScriptTokenTypes.NUMBER, tokens.get(1).type);
    }

    // ========== Hex Colors ==========

    @Test
    public void testHexColor6() {
        List<TokenInfo> tokens = tokenize("#FF5733");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.HEX_COLOR, tokens.get(0).type);
    }

    @Test
    public void testHexColor8() {
        List<TokenInfo> tokens = tokenize("#FF5733AA");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.HEX_COLOR, tokens.get(0).type);
    }

    @Test
    public void testInvalidHexColor() {
        List<TokenInfo> tokens = tokenize("#FFF");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.BAD_CHARACTER, tokens.get(0).type);
    }

    // ========== Operators ==========

    @Test
    public void testTwoCharOperators() {
        String[] operators = {"==", "!=", "<=", ">=", "&&", "||", "=>", ":="};

        for (String op : operators) {
            List<TokenInfo> tokens = tokenize(op);
            assertEquals("Operator: " + op, 1, tokens.size());
            assertEquals("Operator: " + op, PineScriptTokenTypes.OPERATOR, tokens.get(0).type);
        }
    }

    @Test
    public void testSingleCharOperators() {
        String operators = "+-*/%=<>!&|^~?";

        for (char op : operators.toCharArray()) {
            List<TokenInfo> tokens = tokenize(String.valueOf(op));
            assertEquals("Operator: " + op, 1, tokens.size());
            assertEquals("Operator: " + op, PineScriptTokenTypes.OPERATOR, tokens.get(0).type);
        }
    }

    @Test
    public void testLogicalOperators() {
        String[] logicalOps = {"and", "or", "not"};

        for (String op : logicalOps) {
            List<TokenInfo> tokens = tokenize(op);
            assertEquals("Logical op: " + op, 1, tokens.size());
            assertEquals("Logical op: " + op, PineScriptTokenTypes.OPERATOR, tokens.get(0).type);
        }
    }

    // ========== Built-in Functions ==========

    @Test
    public void testBuiltinFunctions() {
        String[] functions = {"ta.sma", "ta.ema", "math.abs", "input.int", "request.security"};

        for (String func : functions) {
            List<TokenInfo> tokens = tokenize(func);
            assertEquals("Function: " + func, 1, tokens.size());
            assertEquals("Function: " + func, PineScriptTokenTypes.BUILTIN_FUNCTION, tokens.get(0).type);
        }
    }

    @Test
    public void testStandaloneFunctions() {
        String[] functions = {"plot", "plotshape", "hline", "fill", "bgcolor", "alert"};

        for (String func : functions) {
            List<TokenInfo> tokens = tokenize(func);
            assertEquals("Function: " + func, 1, tokens.size());
            assertEquals("Function: " + func, PineScriptTokenTypes.BUILTIN_FUNCTION, tokens.get(0).type);
        }
    }

    // ========== Namespace Constants ==========

    @Test
    public void testNamespaceConstants() {
        String[] constants = {"format.price", "display.all", "barstate.isconfirmed", "syminfo.ticker"};

        for (String constant : constants) {
            List<TokenInfo> tokens = tokenize(constant);
            assertEquals("Constant: " + constant, 1, tokens.size());
            // Note: syminfo.ticker is actually BUILTIN_FUNCTION, others are NAMESPACE_CONSTANT
            assertTrue("Constant: " + constant,
                tokens.get(0).type == PineScriptTokenTypes.NAMESPACE_CONSTANT ||
                tokens.get(0).type == PineScriptTokenTypes.BUILTIN_FUNCTION);
        }
    }

    // ========== Brackets ==========

    @Test
    public void testBrackets() {
        List<TokenInfo> tokens = tokenize("(){}[]");
        assertEquals(6, tokens.size());
        assertEquals(PineScriptTokenTypes.LPAREN, tokens.get(0).type);
        assertEquals(PineScriptTokenTypes.RPAREN, tokens.get(1).type);
        assertEquals(PineScriptTokenTypes.LBRACE, tokens.get(2).type);
        assertEquals(PineScriptTokenTypes.RBRACE, tokens.get(3).type);
        assertEquals(PineScriptTokenTypes.LBRACKET, tokens.get(4).type);
        assertEquals(PineScriptTokenTypes.RBRACKET, tokens.get(5).type);
    }

    // ========== Punctuation ==========

    @Test
    public void testPunctuation() {
        List<TokenInfo> tokens = tokenize(",;:.");
        assertEquals(4, tokens.size());
        assertEquals(PineScriptTokenTypes.COMMA, tokens.get(0).type);
        assertEquals(PineScriptTokenTypes.SEMICOLON, tokens.get(1).type);
        assertEquals(PineScriptTokenTypes.COLON, tokens.get(2).type);
        assertEquals(PineScriptTokenTypes.DOT, tokens.get(3).type);
    }

    // ========== Identifiers ==========

    @Test
    public void testIdentifier() {
        List<TokenInfo> tokens = tokenize("myVariable");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.IDENTIFIER, tokens.get(0).type);
    }

    @Test
    public void testIdentifierWithUnderscore() {
        List<TokenInfo> tokens = tokenize("my_variable_123");
        assertEquals(1, tokens.size());
        assertEquals(PineScriptTokenTypes.IDENTIFIER, tokens.get(0).type);
    }

    // ========== Complex Expressions ==========

    @Test
    public void testSimpleExpression() {
        List<TokenInfo> tokens = tokenize("sma = ta.sma(close, 20)");

        assertEquals(11, tokens.size());
        assertEquals(PineScriptTokenTypes.IDENTIFIER, tokens.get(0).type); // sma
        assertEquals(PineScriptTokenTypes.WHITE_SPACE, tokens.get(1).type);
        assertEquals(PineScriptTokenTypes.OPERATOR, tokens.get(2).type);   // =
        assertEquals(PineScriptTokenTypes.WHITE_SPACE, tokens.get(3).type);
        assertEquals(PineScriptTokenTypes.BUILTIN_FUNCTION, tokens.get(4).type); // ta.sma
        assertEquals(PineScriptTokenTypes.LPAREN, tokens.get(5).type);
        assertEquals(PineScriptTokenTypes.IDENTIFIER, tokens.get(6).type); // close
        assertEquals(PineScriptTokenTypes.COMMA, tokens.get(7).type);
        assertEquals(PineScriptTokenTypes.WHITE_SPACE, tokens.get(8).type);
        assertEquals(PineScriptTokenTypes.NUMBER, tokens.get(9).type);     // 20
        assertEquals(PineScriptTokenTypes.RPAREN, tokens.get(10).type);    // )
    }

    @Test
    public void testIndicatorDeclaration() {
        String code = "//@version=6\nindicator(\"My Indicator\", overlay=true)";
        List<TokenInfo> tokens = tokenize(code);

        assertTrue(tokens.size() > 0);
        assertEquals(PineScriptTokenTypes.ANNOTATION, tokens.get(0).type);
    }

    // ========== Helper class ==========

    private static class TokenInfo {
        final IElementType type;
        final String text;

        TokenInfo(IElementType type, String text) {
            this.type = type;
            this.text = text;
        }

        @Override
        public String toString() {
            return type + ": \"" + text + "\"";
        }
    }
}
