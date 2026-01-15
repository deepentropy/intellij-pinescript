package io.github.houseofai.pinescript.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import io.github.houseofai.pinescript.PineScriptLanguage;
import org.jetbrains.annotations.NotNull;

/**
 * Contributes references for PineScript identifiers.
 * This enables go-to-definition for user-defined variables, functions, types, etc.
 */
public class PineScriptReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        // Provide references for all elements in PineScript files
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement().withLanguage(PineScriptLanguage.INSTANCE),
            new PsiReferenceProvider() {
                @Override
                public @NotNull PsiReference @NotNull [] getReferencesByElement(
                        @NotNull PsiElement element,
                        @NotNull ProcessingContext context) {

                    // Only provide references for identifier tokens
                    if (element.getNode() == null) {
                        return PsiReference.EMPTY_ARRAY;
                    }

                    if (element.getNode().getElementType() == PineScriptTokenTypes.IDENTIFIER) {
                        // Check if this identifier is part of a definition (not a usage)
                        if (isDefinition(element)) {
                            return PsiReference.EMPTY_ARRAY;
                        }

                        // Create a reference to resolve this identifier
                        TextRange range = new TextRange(0, element.getTextLength());
                        return new PsiReference[]{new PineScriptReference(element, range)};
                    }

                    return PsiReference.EMPTY_ARRAY;
                }
            }
        );
    }

    /**
     * Check if this identifier is a definition (left side of assignment, function name, etc.)
     */
    private boolean isDefinition(@NotNull PsiElement element) {
        PsiElement parent = element.getParent();

        // Check if parent is a named element (definition)
        if (parent instanceof PineScriptNamedElement) {
            PsiElement nameIdentifier = ((PineScriptNamedElement) parent).getNameIdentifier();
            return element.equals(nameIdentifier);
        }

        // Check for simple assignment pattern: identifier = ...
        // Look at what comes after this identifier
        PsiElement next = element.getNextSibling();

        // Skip whitespace
        while (next != null && isWhitespace(next)) {
            next = next.getNextSibling();
        }

        if (next != null && next.getNode() != null) {
            // Check for = operator (but not ==)
            if (next.getNode().getElementType() == PineScriptTokenTypes.OPERATOR) {
                String text = next.getText();
                if ("=".equals(text) || ":=".equals(text)) {
                    // This is the left side of an assignment - it's a definition
                    return true;
                }
            }
        }

        // Check for function/method definition pattern: functionName(params) =>
        // Look for ( after identifier
        if (next != null && next.getNode() != null &&
            next.getNode().getElementType() == PineScriptTokenTypes.LPAREN) {
            // This might be a function definition - check what comes after the closing paren
            return checkForFunctionDefinition(element);
        }

        return false;
    }

    /**
     * Check if this identifier is the name of a function definition
     */
    private boolean checkForFunctionDefinition(@NotNull PsiElement identifier) {
        // Look back to see if we have 'function' or 'method' keyword
        PsiElement prev = identifier.getPrevSibling();

        while (prev != null && isWhitespace(prev)) {
            prev = prev.getPrevSibling();
        }

        if (prev != null && prev.getNode() != null) {
            if (prev.getNode().getElementType() == PineScriptTokenTypes.KEYWORD) {
                String keyword = prev.getText();
                return "function".equals(keyword) || "method".equals(keyword);
            }
        }

        return false;
    }

    private boolean isWhitespace(@NotNull PsiElement element) {
        return element.getNode() != null &&
               element.getNode().getElementType() == PineScriptTokenTypes.WHITE_SPACE;
    }
}
