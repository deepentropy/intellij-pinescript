package io.github.houseofai.pinescript.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import io.github.houseofai.pinescript.PineScriptLanguage;
import io.github.houseofai.pinescript.lexer.PineScriptLexer;
import io.github.houseofai.pinescript.psi.PineScriptFile;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Parser definition for Pine Script.
 * This is required for IntelliJ to properly parse Pine Script files.
 */
public class PineScriptParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(PineScriptLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new PineScriptLexer();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new PineScriptParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return TokenSet.create(PineScriptTokenTypes.COMMENT, PineScriptTokenTypes.ANNOTATION);
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.create(PineScriptTokenTypes.STRING);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return new PineScriptPsiElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new PineScriptFile(viewProvider);
    }
}
