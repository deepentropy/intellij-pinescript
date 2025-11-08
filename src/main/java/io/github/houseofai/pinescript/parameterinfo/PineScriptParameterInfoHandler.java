package io.github.houseofai.pinescript.parameterinfo;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.lang.parameterInfo.*;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import io.github.houseofai.pinescript.PineScriptLanguage;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides parameter information hints for Pine Script functions.
 */
public class PineScriptParameterInfoHandler implements ParameterInfoHandler<PsiElement, PineScriptFunctionSignature> {

    @Override
    public @Nullable PsiElement findElementForParameterInfo(@NotNull CreateParameterInfoContext context) {
        PsiFile file = context.getFile();
        if (!isPineScriptFile(file)) {
            return null;
        }

        int offset = context.getOffset();
        PsiElement element = file.findElementAt(offset);
        if (element == null) {
            return null;
        }

        // Find the function call context
        FunctionCallContext callContext = findFunctionCall(element);
        if (callContext == null) {
            return null;
        }

        // Get the function signature
        PineScriptFunctionSignature signature = PineScriptFunctionRepository.getSignature(callContext.functionName);
        if (signature != null) {
            context.setItemsToShow(new Object[]{signature});
            return callContext.anchor;
        }

        return null;
    }

    @Override
    public void showParameterInfo(@NotNull PsiElement element, @NotNull CreateParameterInfoContext context) {
        context.showHint(element, element.getTextRange().getStartOffset(), this);
    }

    @Override
    public @Nullable PsiElement findElementForUpdatingParameterInfo(@NotNull UpdateParameterInfoContext context) {
        PsiFile file = context.getFile();
        if (!isPineScriptFile(file)) {
            return null;
        }

        int offset = context.getOffset();
        PsiElement element = file.findElementAt(offset);
        if (element == null) {
            return null;
        }

        FunctionCallContext callContext = findFunctionCall(element);
        return callContext != null ? callContext.anchor : null;
    }

    @Override
    public void updateParameterInfo(@NotNull PsiElement place, @NotNull UpdateParameterInfoContext context) {
        // Find the current parameter index
        int parameterIndex = getCurrentParameterIndex(place, context.getOffset());
        context.setCurrentParameter(parameterIndex);
    }

    @Override
    public void updateUI(@Nullable PineScriptFunctionSignature signature, @NotNull ParameterInfoUIContext context) {
        if (signature == null) {
            context.setUIComponentEnabled(false);
            return;
        }

        // Build the parameter list text
        StringBuilder text = new StringBuilder();
        int currentIndex = context.getCurrentParameterIndex();
        int highlightStart = -1;
        int highlightEnd = -1;

        for (int i = 0; i < signature.getParameterCount(); i++) {
            if (i > 0) {
                text.append(", ");
            }

            int paramStart = text.length();
            String paramText = signature.getParameterText(i);
            text.append(paramText);
            int paramEnd = text.length();

            // Highlight the current parameter
            if (i == currentIndex) {
                highlightStart = paramStart;
                highlightEnd = paramEnd;
            }
        }

        context.setupUIComponentPresentation(
                text.toString(),
                highlightStart,
                highlightEnd,
                !context.isUIComponentEnabled(),
                false,
                false,
                context.getDefaultParameterColor()
        );
    }

    /**
     * Finds the function call context for the given element.
     */
    private FunctionCallContext findFunctionCall(PsiElement element) {
        if (element == null) {
            return null;
        }

        // Navigate backwards to find the opening parenthesis
        PsiElement current = element;
        int parenDepth = 0;
        PsiElement openParen = null;

        // First, check if we're inside parentheses
        while (current != null) {
            IElementType type = current.getNode() != null ? current.getNode().getElementType() : null;

            if (type == PineScriptTokenTypes.RPAREN) {
                parenDepth++;
            } else if (type == PineScriptTokenTypes.LPAREN) {
                if (parenDepth == 0) {
                    openParen = current;
                    break;
                }
                parenDepth--;
            }

            current = current.getPrevSibling();
            if (current == null) {
                current = element.getParent();
                if (current != null) {
                    current = current.getPrevSibling();
                }
            }
        }

        if (openParen == null) {
            return null;
        }

        // Find the function name (identifier before the opening paren)
        PsiElement functionNameElement = openParen.getPrevSibling();
        while (functionNameElement != null && isWhitespace(functionNameElement)) {
            functionNameElement = functionNameElement.getPrevSibling();
        }

        if (functionNameElement == null) {
            return null;
        }

        String functionName = extractFunctionName(functionNameElement);
        if (functionName == null || functionName.isEmpty()) {
            return null;
        }

        return new FunctionCallContext(functionName, openParen);
    }

    /**
     * Extracts the function name from a PSI element.
     */
    private String extractFunctionName(PsiElement element) {
        if (element == null) {
            return null;
        }

        IElementType type = element.getNode() != null ? element.getNode().getElementType() : null;

        if (type == PineScriptTokenTypes.IDENTIFIER || type == PineScriptTokenTypes.BUILTIN_FUNCTION) {
            return element.getText();
        }

        // Try to get the full identifier including dots (e.g., "ta.sma")
        StringBuilder name = new StringBuilder();
        PsiElement current = element;

        while (current != null) {
            IElementType currentType = current.getNode() != null ? current.getNode().getElementType() : null;

            if (currentType == PineScriptTokenTypes.IDENTIFIER ||
                currentType == PineScriptTokenTypes.BUILTIN_FUNCTION ||
                currentType == PineScriptTokenTypes.DOT) {
                name.insert(0, current.getText());
                current = current.getPrevSibling();

                // Skip whitespace
                while (current != null && isWhitespace(current)) {
                    current = current.getPrevSibling();
                }
            } else {
                break;
            }
        }

        return name.length() > 0 ? name.toString() : element.getText();
    }

    /**
     * Gets the current parameter index based on cursor position.
     */
    private int getCurrentParameterIndex(PsiElement element, int offset) {
        if (element == null) {
            return 0;
        }

        // Find the opening parenthesis
        PsiElement current = element;
        int parenDepth = 0;
        PsiElement openParen = null;

        while (current != null) {
            IElementType type = current.getNode() != null ? current.getNode().getElementType() : null;

            if (type == PineScriptTokenTypes.RPAREN) {
                parenDepth++;
            } else if (type == PineScriptTokenTypes.LPAREN) {
                if (parenDepth == 0) {
                    openParen = current;
                    break;
                }
                parenDepth--;
            }

            current = current.getPrevSibling();
            if (current == null && element.getParent() != null) {
                current = element.getParent().getPrevSibling();
            }
        }

        if (openParen == null) {
            return 0;
        }

        // Count commas between opening paren and cursor position
        int commaCount = 0;
        current = openParen.getNextSibling();
        int currentParenDepth = 0;

        while (current != null && current.getTextRange().getStartOffset() < offset) {
            IElementType type = current.getNode() != null ? current.getNode().getElementType() : null;

            if (type == PineScriptTokenTypes.LPAREN) {
                currentParenDepth++;
            } else if (type == PineScriptTokenTypes.RPAREN) {
                if (currentParenDepth == 0) {
                    break;
                }
                currentParenDepth--;
            } else if (type == PineScriptTokenTypes.COMMA && currentParenDepth == 0) {
                commaCount++;
            }

            current = current.getNextSibling();
            if (current == null && openParen.getParent() != null) {
                PsiElement parent = openParen.getParent();
                current = getNextSiblingInTree(parent, offset);
            }
        }

        return commaCount;
    }

    /**
     * Helper to get next sibling in tree.
     */
    private PsiElement getNextSiblingInTree(PsiElement element, int maxOffset) {
        PsiElement current = element;
        while (current != null) {
            PsiElement next = current.getNextSibling();
            if (next != null && next.getTextRange().getStartOffset() < maxOffset) {
                return next;
            }
            current = current.getParent();
        }
        return null;
    }

    private boolean isWhitespace(PsiElement element) {
        if (element == null) {
            return false;
        }
        IElementType type = element.getNode() != null ? element.getNode().getElementType() : null;
        return type == PineScriptTokenTypes.WHITE_SPACE;
    }

    private boolean isPineScriptFile(PsiFile file) {
        return file != null && file.getLanguage() == PineScriptLanguage.INSTANCE;
    }

    /**
     * Context for a function call.
     */
    private static class FunctionCallContext {
        final String functionName;
        final PsiElement anchor;

        FunctionCallContext(String functionName, PsiElement anchor) {
            this.functionName = functionName;
            this.anchor = anchor;
        }
    }
}
