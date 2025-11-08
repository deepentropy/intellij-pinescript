package io.github.houseofai.pinescript.parser;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * Basic PSI element for Pine Script.
 */
public class PineScriptPsiElement extends ASTWrapperPsiElement {
    public PineScriptPsiElement(@NotNull ASTNode node) {
        super(node);
    }
}
