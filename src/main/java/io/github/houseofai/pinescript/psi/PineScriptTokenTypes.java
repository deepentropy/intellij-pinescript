package io.github.houseofai.pinescript.psi;

import com.intellij.psi.tree.IElementType;
import io.github.houseofai.pinescript.PineScriptLanguage;

public interface PineScriptTokenTypes {
    IElementType KEYWORD = new IElementType("KEYWORD", PineScriptLanguage.INSTANCE);
    IElementType STORAGE_KEYWORD = new IElementType("STORAGE_KEYWORD", PineScriptLanguage.INSTANCE);
    IElementType BOOLEAN = new IElementType("BOOLEAN", PineScriptLanguage.INSTANCE);
    IElementType NAMESPACE_CONSTANT = new IElementType("NAMESPACE_CONSTANT", PineScriptLanguage.INSTANCE);
    IElementType CONSTANT = new IElementType("CONSTANT", PineScriptLanguage.INSTANCE);
    IElementType BUILTIN_FUNCTION = new IElementType("BUILTIN_FUNCTION", PineScriptLanguage.INSTANCE);
    IElementType PARAMETER_NAME = new IElementType("PARAMETER_NAME", PineScriptLanguage.INSTANCE);
    IElementType IDENTIFIER = new IElementType("IDENTIFIER", PineScriptLanguage.INSTANCE);
    IElementType STRING = new IElementType("STRING", PineScriptLanguage.INSTANCE);
    IElementType NUMBER = new IElementType("NUMBER", PineScriptLanguage.INSTANCE);
    IElementType HEX_COLOR = new IElementType("HEX_COLOR", PineScriptLanguage.INSTANCE);
    IElementType COMMENT = new IElementType("COMMENT", PineScriptLanguage.INSTANCE);
    IElementType OPERATOR = new IElementType("OPERATOR", PineScriptLanguage.INSTANCE);

    IElementType LPAREN = new IElementType("LPAREN", PineScriptLanguage.INSTANCE);
    IElementType RPAREN = new IElementType("RPAREN", PineScriptLanguage.INSTANCE);
    IElementType LBRACE = new IElementType("LBRACE", PineScriptLanguage.INSTANCE);
    IElementType RBRACE = new IElementType("RBRACE", PineScriptLanguage.INSTANCE);
    IElementType LBRACKET = new IElementType("LBRACKET", PineScriptLanguage.INSTANCE);
    IElementType RBRACKET = new IElementType("RBRACKET", PineScriptLanguage.INSTANCE);

    IElementType COMMA = new IElementType("COMMA", PineScriptLanguage.INSTANCE);
    IElementType SEMICOLON = new IElementType("SEMICOLON", PineScriptLanguage.INSTANCE);
    IElementType COLON = new IElementType("COLON", PineScriptLanguage.INSTANCE);
    IElementType DOT = new IElementType("DOT", PineScriptLanguage.INSTANCE);

    IElementType WHITE_SPACE = new IElementType("WHITE_SPACE", PineScriptLanguage.INSTANCE);
    IElementType BAD_CHARACTER = new IElementType("BAD_CHARACTER", PineScriptLanguage.INSTANCE);
}
