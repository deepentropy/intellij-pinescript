package io.github.houseofai.pinescript.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import io.github.houseofai.pinescript.lexer.PineScriptLexer;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.Color;

public class PineScriptSyntaxHighlighter extends SyntaxHighlighterBase {

    // Syntax highlighting colors
    private static final Color BLUE_COLOR = new JBColor(new Color(0x5B9CF6), new Color(0x5B9CF6));
    private static final Color GREEN_COLOR = new JBColor(new Color(0x388E3C), new Color(0x388E3C));
    private static final Color TEAL_COLOR = new JBColor(new Color(0x42BDA8), new Color(0x42BDA8));
    private static final Color ORANGE_COLOR = new JBColor(new Color(0xCB6B16), new Color(0xCB6B16));
    private static final Color PINK_COLOR = new JBColor(new Color(0xE27275), new Color(0xE27275));
    private static final Color LIGHT_GRAY_COLOR = new JBColor(new Color(0xCACACA), new Color(0xCACACA));

    // Define text attribute keys for different token types
    public static final TextAttributesKey KEYWORD =
        TextAttributesKey.createTextAttributesKey("PINE_KEYWORD",
            new TextAttributes(BLUE_COLOR, null, null, null, 0));

    // Storage keywords (var, varip, const) use teal color
    public static final TextAttributesKey STORAGE_KEYWORD =
        TextAttributesKey.createTextAttributesKey("PINE_STORAGE_KEYWORD",
            new TextAttributes(TEAL_COLOR, null, null, null, 0));

    // Booleans (true, false) use pink color
    public static final TextAttributesKey BOOLEAN =
        TextAttributesKey.createTextAttributesKey("PINE_BOOLEAN",
            new TextAttributes(PINK_COLOR, null, null, null, 0));

    // Namespace constants (format.*, display.*, barstate.*) use pink color
    public static final TextAttributesKey NAMESPACE_CONSTANT =
        TextAttributesKey.createTextAttributesKey("PINE_NAMESPACE_CONSTANT",
            new TextAttributes(PINK_COLOR, null, null, null, 0));

    // Other constants (na) use orange color
    public static final TextAttributesKey CONSTANT =
        TextAttributesKey.createTextAttributesKey("PINE_CONSTANT",
            new TextAttributes(ORANGE_COLOR, null, null, null, 0));

    // Parameter names (like 'color' in function calls) use teal color
    public static final TextAttributesKey PARAMETER_NAME =
        TextAttributesKey.createTextAttributesKey("PINE_PARAMETER_NAME",
            new TextAttributes(TEAL_COLOR, null, null, null, 0));

    public static final TextAttributesKey STRING =
        TextAttributesKey.createTextAttributesKey("PINE_STRING",
            new TextAttributes(GREEN_COLOR, null, null, null, 0));

    public static final TextAttributesKey NUMBER =
        TextAttributesKey.createTextAttributesKey("PINE_NUMBER",
            new TextAttributes(ORANGE_COLOR, null, null, null, 0));

    // Hex colors (#RRGGBB) use pink color
    public static final TextAttributesKey HEX_COLOR =
        TextAttributesKey.createTextAttributesKey("PINE_HEX_COLOR",
            new TextAttributes(PINK_COLOR, null, null, null, 0));

    public static final TextAttributesKey COMMENT =
        TextAttributesKey.createTextAttributesKey("PINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    // Variable names use light gray
    public static final TextAttributesKey IDENTIFIER =
        TextAttributesKey.createTextAttributesKey("PINE_IDENTIFIER",
            new TextAttributes(LIGHT_GRAY_COLOR, null, null, null, 0));

    public static final TextAttributesKey OPERATOR =
        TextAttributesKey.createTextAttributesKey("PINE_OPERATOR",
            new TextAttributes(TEAL_COLOR, null, null, null, 0));

    // Built-in functions use blue color (same as keywords)
    public static final TextAttributesKey BUILTIN_FUNCTION =
        TextAttributesKey.createTextAttributesKey("PINE_BUILTIN",
            new TextAttributes(BLUE_COLOR, null, null, null, 0));

    public static final TextAttributesKey BAD_CHARACTER =
        TextAttributesKey.createTextAttributesKey("PINE_BAD_CHAR", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] EMPTY = new TextAttributesKey[0];

    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] STORAGE_KEYWORD_KEYS = new TextAttributesKey[]{STORAGE_KEYWORD};
    private static final TextAttributesKey[] BOOLEAN_KEYS = new TextAttributesKey[]{BOOLEAN};
    private static final TextAttributesKey[] NAMESPACE_CONSTANT_KEYS = new TextAttributesKey[]{NAMESPACE_CONSTANT};
    private static final TextAttributesKey[] CONSTANT_KEYS = new TextAttributesKey[]{CONSTANT};
    private static final TextAttributesKey[] BUILTIN_FUNCTION_KEYS = new TextAttributesKey[]{BUILTIN_FUNCTION};
    private static final TextAttributesKey[] PARAMETER_NAME_KEYS = new TextAttributesKey[]{PARAMETER_NAME};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] HEX_COLOR_KEYS = new TextAttributesKey[]{HEX_COLOR};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new PineScriptLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType == PineScriptTokenTypes.KEYWORD) {
            return KEYWORD_KEYS;
        } else if (tokenType == PineScriptTokenTypes.STORAGE_KEYWORD) {
            return STORAGE_KEYWORD_KEYS;
        } else if (tokenType == PineScriptTokenTypes.BOOLEAN) {
            return BOOLEAN_KEYS;
        } else if (tokenType == PineScriptTokenTypes.NAMESPACE_CONSTANT) {
            return NAMESPACE_CONSTANT_KEYS;
        } else if (tokenType == PineScriptTokenTypes.CONSTANT) {
            return CONSTANT_KEYS;
        } else if (tokenType == PineScriptTokenTypes.BUILTIN_FUNCTION) {
            return BUILTIN_FUNCTION_KEYS;
        } else if (tokenType == PineScriptTokenTypes.PARAMETER_NAME) {
            return PARAMETER_NAME_KEYS;
        } else if (tokenType == PineScriptTokenTypes.STRING) {
            return STRING_KEYS;
        } else if (tokenType == PineScriptTokenTypes.NUMBER) {
            return NUMBER_KEYS;
        } else if (tokenType == PineScriptTokenTypes.HEX_COLOR) {
            return HEX_COLOR_KEYS;
        } else if (tokenType == PineScriptTokenTypes.COMMENT) {
            return COMMENT_KEYS;
        } else if (tokenType == PineScriptTokenTypes.IDENTIFIER) {
            return IDENTIFIER_KEYS;
        } else if (tokenType == PineScriptTokenTypes.OPERATOR) {
            return OPERATOR_KEYS;
        } else if (tokenType == PineScriptTokenTypes.BAD_CHARACTER) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY;
    }
}
