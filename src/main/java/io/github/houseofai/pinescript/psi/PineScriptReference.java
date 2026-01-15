package io.github.houseofai.pinescript.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Reference from an identifier usage to its definition.
 * Enables go-to-definition (Ctrl+Click or Ctrl+B).
 */
public class PineScriptReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String name;

    public PineScriptReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        this.name = element.getText();
    }

    @Override
    public @NotNull ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        List<ResolveResult> results = new ArrayList<>();

        PsiFile file = myElement.getContainingFile();
        if (file == null) {
            return ResolveResult.EMPTY_ARRAY;
        }

        // Search for definitions in the file
        file.accept(new PsiRecursiveElementVisitor() {
            @Override
            public void visitElement(@NotNull PsiElement element) {
                if (element instanceof PineScriptNamedElement) {
                    PineScriptNamedElement namedElement = (PineScriptNamedElement) element;
                    if (name.equals(namedElement.getName())) {
                        // Don't resolve to self
                        if (element != myElement && !PsiTreeUtil.isAncestor(element, myElement, false)) {
                            results.add(new PsiElementResolveResult(element));
                        }
                    }
                }
                super.visitElement(element);
            }
        });

        return results.toArray(ResolveResult.EMPTY_ARRAY);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] results = multiResolve(false);
        return results.length == 1 ? results[0].getElement() : null;
    }

    @Override
    public @NotNull Object @NotNull [] getVariants() {
        // Return completion variants - could be used for autocomplete
        return EMPTY_ARRAY;
    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        // For now, rename is not fully supported
        throw new IncorrectOperationException("Rename not yet implemented for PineScript");
    }
}
