package io.github.deepentropy.pinescript.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import io.github.deepentropy.pinescript.psi.PineScriptElementTypes;
import io.github.deepentropy.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Parser for Pine Script.
 * Builds a PSI tree that recognizes definitions (functions, variables, types)
 * to enable go-to-definition and find usages.
 */
public class PineScriptParser implements PsiParser {
    @NotNull
    @Override
    public ASTNode parse(@NotNull IElementType root, @NotNull PsiBuilder builder) {
        PsiBuilder.Marker rootMarker = builder.mark();

        while (!builder.eof()) {
            parseStatement(builder);
        }

        rootMarker.done(root);
        return builder.getTreeBuilt();
    }

    private void parseStatement(PsiBuilder builder) {
        IElementType tokenType = builder.getTokenType();

        if (tokenType == null) {
            return;
        }

        // Handle function/method definitions
        if (tokenType == PineScriptTokenTypes.KEYWORD) {
            String keyword = builder.getTokenText();
            if ("function".equals(keyword) || "method".equals(keyword)) {
                parseFunctionDefinition(builder, keyword);
                return;
            } else if ("type".equals(keyword)) {
                parseTypeDefinition(builder);
                return;
            } else if ("enum".equals(keyword)) {
                parseEnumDefinition(builder);
                return;
            } else if ("var".equals(keyword) || "varip".equals(keyword)) {
                parseVariableDefinition(builder);
                return;
            }
        }

        // Handle assignment statements (variable definitions)
        if (tokenType == PineScriptTokenTypes.IDENTIFIER) {
            if (lookAheadForAssignment(builder)) {
                parseAssignment(builder);
                return;
            }
        }

        // Default: consume the token
        builder.advanceLexer();
    }

    private void parseFunctionDefinition(PsiBuilder builder, String keyword) {
        PsiBuilder.Marker marker = builder.mark();

        // Consume 'function' or 'method' keyword
        builder.advanceLexer();
        skipWhitespace(builder);

        // Expect identifier (function name)
        if (builder.getTokenType() == PineScriptTokenTypes.IDENTIFIER) {
            builder.advanceLexer();
            skipWhitespace(builder);

            // Expect opening paren
            if (builder.getTokenType() == PineScriptTokenTypes.LPAREN) {
                // Skip to closing paren (simple approach)
                skipBalancedParens(builder);
                skipWhitespace(builder);

                // Look for => (function body marker)
                if (builder.getTokenType() == PineScriptTokenTypes.OPERATOR &&
                    "=>".equals(builder.getTokenText())) {
                    builder.advanceLexer();
                }
            }

            IElementType elementType = "method".equals(keyword)
                ? PineScriptElementTypes.METHOD_DEFINITION
                : PineScriptElementTypes.FUNCTION_DEFINITION;
            marker.done(elementType);
            return;
        }

        marker.drop();
        builder.advanceLexer();
    }

    private void parseTypeDefinition(PsiBuilder builder) {
        PsiBuilder.Marker marker = builder.mark();

        // Consume 'type' keyword
        builder.advanceLexer();
        skipWhitespace(builder);

        // Expect identifier (type name)
        if (builder.getTokenType() == PineScriptTokenTypes.IDENTIFIER) {
            builder.advanceLexer();
            marker.done(PineScriptElementTypes.TYPE_DEFINITION);
            return;
        }

        marker.drop();
    }

    private void parseEnumDefinition(PsiBuilder builder) {
        PsiBuilder.Marker marker = builder.mark();

        // Consume 'enum' keyword
        builder.advanceLexer();
        skipWhitespace(builder);

        // Expect identifier (enum name)
        if (builder.getTokenType() == PineScriptTokenTypes.IDENTIFIER) {
            builder.advanceLexer();
            marker.done(PineScriptElementTypes.ENUM_DEFINITION);
            return;
        }

        marker.drop();
    }

    private void parseVariableDefinition(PsiBuilder builder) {
        PsiBuilder.Marker marker = builder.mark();

        // Consume 'var' or 'varip' keyword
        builder.advanceLexer();
        skipWhitespace(builder);

        // Expect identifier (variable name)
        if (builder.getTokenType() == PineScriptTokenTypes.IDENTIFIER) {
            builder.advanceLexer();
            skipWhitespace(builder);

            // Consume = and the value
            if (builder.getTokenType() == PineScriptTokenTypes.OPERATOR) {
                String op = builder.getTokenText();
                if ("=".equals(op) || ":=".equals(op)) {
                    builder.advanceLexer();
                    // Skip the rest of the assignment expression (until newline or EOF)
                    skipToEndOfLine(builder);
                }
            }

            marker.done(PineScriptElementTypes.VARIABLE_DEFINITION);
            return;
        }

        marker.drop();
    }

    private void parseAssignment(PsiBuilder builder) {
        PsiBuilder.Marker marker = builder.mark();

        // Consume identifier
        builder.advanceLexer();
        skipWhitespace(builder);

        // Consume = or :=
        if (builder.getTokenType() == PineScriptTokenTypes.OPERATOR) {
            String op = builder.getTokenText();
            if ("=".equals(op) || ":=".equals(op)) {
                builder.advanceLexer();
                // Skip the rest of the assignment expression
                skipToEndOfLine(builder);
                marker.done(PineScriptElementTypes.VARIABLE_DEFINITION);
                return;
            }
        }

        marker.drop();
    }

    private boolean lookAheadForAssignment(PsiBuilder builder) {
        // Use look-ahead to check if this identifier is followed by = or :=
        PsiBuilder.Marker marker = builder.mark();
        builder.advanceLexer(); // skip identifier
        skipWhitespace(builder);

        boolean isAssignment = false;
        if (builder.getTokenType() == PineScriptTokenTypes.OPERATOR) {
            String op = builder.getTokenText();
            isAssignment = "=".equals(op) || ":=".equals(op);
        }

        marker.rollbackTo();
        return isAssignment;
    }

    private void skipWhitespace(PsiBuilder builder) {
        while (builder.getTokenType() == PineScriptTokenTypes.WHITE_SPACE ||
               builder.getTokenType() == PineScriptTokenTypes.COMMENT) {
            builder.advanceLexer();
        }
    }

    private void skipBalancedParens(PsiBuilder builder) {
        if (builder.getTokenType() != PineScriptTokenTypes.LPAREN) {
            return;
        }

        int depth = 0;
        while (!builder.eof()) {
            IElementType type = builder.getTokenType();
            if (type == PineScriptTokenTypes.LPAREN) {
                depth++;
            } else if (type == PineScriptTokenTypes.RPAREN) {
                depth--;
                if (depth == 0) {
                    builder.advanceLexer();
                    return;
                }
            }
            builder.advanceLexer();
        }
    }

    private void skipToEndOfLine(PsiBuilder builder) {
        while (!builder.eof()) {
            IElementType type = builder.getTokenType();
            if (type == PineScriptTokenTypes.WHITE_SPACE) {
                String text = builder.getTokenText();
                if (text != null && text.contains("\n")) {
                    builder.advanceLexer();
                    return;
                }
            }
            builder.advanceLexer();
        }
    }
}
