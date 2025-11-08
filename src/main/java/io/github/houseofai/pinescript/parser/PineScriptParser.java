package io.github.houseofai.pinescript.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Simple parser for Pine Script.
 * This just consumes all tokens and builds a flat PSI tree.
 * For now, we don't need a complex grammar - the lexer handles tokenization.
 */
public class PineScriptParser implements PsiParser {
    @NotNull
    @Override
    public ASTNode parse(@NotNull IElementType root, @NotNull PsiBuilder builder) {
        PsiBuilder.Marker rootMarker = builder.mark();

        // Simply consume all tokens - we don't need complex parsing for autocomplete/highlighting
        while (!builder.eof()) {
            builder.advanceLexer();
        }

        rootMarker.done(root);
        return builder.getTreeBuilt();
    }
}
