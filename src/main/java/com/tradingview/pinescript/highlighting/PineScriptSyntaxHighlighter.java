package com.tradingview.pinescript.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.tradingview.pinescript.lexer.PineScriptLexer;
import com.tradingview.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;

public class PineScriptSyntaxHighlighter extends SyntaxHighlighterBase {

    // Define text attribute keys for different token types
    public static final TextAttributesKey KEYWORD =
        TextAttributesKey.createTextAttributesKey("PINE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey CONSTANT =
        TextAttributesKey.createTextAttributesKey("PINE_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);

    public static final TextAttributesKey STRING =
        TextAttributesKey.createTextAttributesKey("PINE_STRING", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey NUMBER =
        TextAttributesKey.createTextAttributesKey("PINE_NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey COMMENT =
        TextAttributesKey.createTextAttributesKey("PINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey IDENTIFIER =
        TextAttributesKey.createTextAttributesKey("PINE_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);

    public static final TextAttributesKey OPERATOR =
        TextAttributesKey.createTextAttributesKey("PINE_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    public static final TextAttributesKey BUILTIN_FUNCTION =
        TextAttributesKey.createTextAttributesKey("PINE_BUILTIN", DefaultLanguageHighlighterColors.FUNCTION_CALL);

    public static final TextAttributesKey ANNOTATION =
        TextAttributesKey.createTextAttributesKey("PINE_ANNOTATION", DefaultLanguageHighlighterColors.METADATA);

    public static final TextAttributesKey BAD_CHARACTER =
        TextAttributesKey.createTextAttributesKey("PINE_BAD_CHAR", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] EMPTY = new TextAttributesKey[0];

    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] CONSTANT_KEYS = new TextAttributesKey[]{CONSTANT};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] ANNOTATION_KEYS = new TextAttributesKey[]{ANNOTATION};
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
        } else if (tokenType == PineScriptTokenTypes.CONSTANT) {
            return CONSTANT_KEYS;
        } else if (tokenType == PineScriptTokenTypes.STRING) {
            return STRING_KEYS;
        } else if (tokenType == PineScriptTokenTypes.NUMBER) {
            return NUMBER_KEYS;
        } else if (tokenType == PineScriptTokenTypes.COMMENT) {
            return COMMENT_KEYS;
        } else if (tokenType == PineScriptTokenTypes.ANNOTATION) {
            return ANNOTATION_KEYS;
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