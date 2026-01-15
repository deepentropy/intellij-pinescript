package io.github.houseofai.pinescript.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import io.github.houseofai.pinescript.psi.PineScriptNamedElement;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Implementation of a named PineScript element.
 * Supports go-to-definition and rename refactoring.
 */
public class PineScriptNamedElementImpl extends ASTWrapperPsiElement implements PineScriptNamedElement {

    public PineScriptNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getText() : null;
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        // For now, rename is not fully supported
        // A full implementation would create a new identifier token and replace the old one
        throw new IncorrectOperationException("Rename not yet implemented for PineScript");
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        // Find the first IDENTIFIER child
        ASTNode identifierNode = getNode().findChildByType(PineScriptTokenTypes.IDENTIFIER);
        return identifierNode != null ? identifierNode.getPsi() : null;
    }

    @Override
    public int getTextOffset() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getTextOffset() : super.getTextOffset();
    }

    @Override
    public PsiReference getReference() {
        return null; // Definitions don't have references, they ARE the target
    }
}
