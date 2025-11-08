package io.github.houseofai.pinescript.hints;

import com.intellij.codeInsight.hints.*;
import com.intellij.codeInsight.hints.presentation.InlayPresentation;
import com.intellij.codeInsight.hints.presentation.PresentationFactory;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import io.github.houseofai.pinescript.PineScriptLanguage;
import io.github.houseofai.pinescript.parameterinfo.PineScriptFunctionRepository;
import io.github.houseofai.pinescript.parameterinfo.PineScriptFunctionSignature;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides inline parameter hints for Pine Script function calls.
 * Shows parameter names inline as you type: plot(close, title: "My Plot")
 */
@SuppressWarnings("UnstableApiUsage")
public class PineScriptInlayParameterHintsProvider implements InlayHintsProvider<NoSettings> {

    @Override
    public boolean isVisibleInSettings() {
        return true;
    }

    @NotNull
    @Override
    public SettingsKey<NoSettings> getKey() {
        return new SettingsKey<>("PineScript.parameter.hints");
    }

    @NotNull
    @Override
    public String getName() {
        return "Pine Script parameter hints";
    }

    @Nullable
    @Override
    public String getPreviewText() {
        return "plot(close, title=\"My Plot\", color=color.blue)";
    }

    @NotNull
    @Override
    public ImmediateConfigurable createConfigurable(@NotNull NoSettings settings) {
        return changeListener -> new JPanel();
    }

    @NotNull
    @Override
    public NoSettings createSettings() {
        return new NoSettings();
    }

    @NotNull
    @Override
    public InlayHintsCollector getCollectorFor(@NotNull PsiFile file,
                                                @NotNull Editor editor,
                                                @NotNull NoSettings settings,
                                                @NotNull InlayHintsSink sink) {
        return new ParameterHintsCollector(editor, sink);
    }

    @Override
    public boolean isLanguageSupported(@NotNull Language language) {
        return language.is(PineScriptLanguage.INSTANCE);
    }

    private static class ParameterHintsCollector extends FactoryInlayHintsCollector {
        private final InlayHintsSink sink;

        public ParameterHintsCollector(@NotNull Editor editor, @NotNull InlayHintsSink sink) {
            super(editor);
            this.sink = sink;
        }

        @Override
        public boolean collect(@NotNull PsiElement element, @NotNull Editor editor, @NotNull InlayHintsSink sink) {
            // Only process on complete file parse, not during typing
            // This prevents interference with autocomplete
            IElementType elementType = element.getNode() != null ? element.getNode().getElementType() : null;

            // Look for arguments in function calls - but only after commas or opening parens
            if (elementType == PineScriptTokenTypes.COMMA) {
                // After a comma, check what follows
                PsiElement next = getNextNonWhitespace(element);
                if (next != null && !isNamedParameter(next)) {
                    FunctionCallInfo callInfo = findFunctionCall(element);
                    if (callInfo != null) {
                        PineScriptFunctionSignature signature = PineScriptFunctionRepository.getSignature(callInfo.functionName);
                        if (signature != null) {
                            int paramIndex = getParameterIndex(next, callInfo.openParen);
                            if (paramIndex >= 0 && paramIndex < signature.getParameterCount()) {
                                String paramName = signature.getParameters().get(paramIndex).getName();
                                PresentationFactory factory = getFactory();
                                InlayPresentation presentation = factory.smallText(paramName + ": ");

                                sink.addInlineElement(
                                    next.getTextRange().getStartOffset(),
                                    false,
                                    presentation,
                                    false
                                );
                            }
                        }
                    }
                }
            }

            return true;
        }

        private PsiElement getNextNonWhitespace(PsiElement element) {
            PsiElement next = element.getNextSibling();
            while (next != null && isWhitespace(next)) {
                next = next.getNextSibling();
            }
            return next;
        }

        /**
         * Check if this element is part of a named parameter (e.g., "title" in title="value")
         */
        private boolean isNamedParameter(PsiElement element) {
            PsiElement next = element.getNextSibling();
            while (next != null && isWhitespace(next)) {
                next = next.getNextSibling();
            }
            if (next != null) {
                IElementType type = next.getNode() != null ? next.getNode().getElementType() : null;
                return type == PineScriptTokenTypes.OPERATOR && "=".equals(next.getText());
            }
            return false;
        }

        /**
         * Get the parameter index for the current element
         */
        private int getParameterIndex(PsiElement element, PsiElement openParen) {
            if (openParen == null) {
                return -1;
            }

            int commaCount = 0;
            int parenDepth = 0;
            PsiElement current = openParen.getNextSibling();

            while (current != null && current.getTextRange().getStartOffset() < element.getTextRange().getStartOffset()) {
                IElementType type = current.getNode() != null ? current.getNode().getElementType() : null;

                if (type == PineScriptTokenTypes.LPAREN) {
                    parenDepth++;
                } else if (type == PineScriptTokenTypes.RPAREN) {
                    if (parenDepth == 0) {
                        break;
                    }
                    parenDepth--;
                } else if (type == PineScriptTokenTypes.COMMA && parenDepth == 0) {
                    commaCount++;
                }

                current = current.getNextSibling();
            }

            return commaCount;
        }

        /**
         * Find the function call context for the given element
         */
        private FunctionCallInfo findFunctionCall(PsiElement element) {
            PsiElement current = element;
            int parenDepth = 0;

            // Navigate backwards to find the opening parenthesis
            while (current != null) {
                IElementType type = current.getNode() != null ? current.getNode().getElementType() : null;

                if (type == PineScriptTokenTypes.RPAREN) {
                    parenDepth++;
                } else if (type == PineScriptTokenTypes.LPAREN) {
                    if (parenDepth == 0) {
                        // Found the opening paren, now find the function name
                        String functionName = getFunctionName(current);
                        if (functionName != null) {
                            return new FunctionCallInfo(functionName, current);
                        }
                        return null;
                    }
                    parenDepth--;
                }

                current = current.getPrevSibling();
                if (current == null && element.getParent() != null) {
                    current = element.getParent().getPrevSibling();
                }
            }

            return null;
        }

        /**
         * Get the function name before the opening parenthesis
         */
        private String getFunctionName(PsiElement openParen) {
            PsiElement current = openParen.getPrevSibling();

            // Skip whitespace
            while (current != null && isWhitespace(current)) {
                current = current.getPrevSibling();
            }

            if (current == null) {
                return null;
            }

            // Build the function name (might include namespace like "ta.sma")
            StringBuilder nameBuilder = new StringBuilder();
            while (current != null) {
                IElementType type = current.getNode() != null ? current.getNode().getElementType() : null;

                if (type == PineScriptTokenTypes.IDENTIFIER ||
                    type == PineScriptTokenTypes.BUILTIN_FUNCTION) {
                    nameBuilder.insert(0, current.getText());
                    current = current.getPrevSibling();

                    // Skip whitespace
                    while (current != null && isWhitespace(current)) {
                        current = current.getPrevSibling();
                    }

                    // Check for dot (namespace separator)
                    if (current != null) {
                        type = current.getNode() != null ? current.getNode().getElementType() : null;
                        if (type == PineScriptTokenTypes.DOT) {
                            nameBuilder.insert(0, ".");
                            current = current.getPrevSibling();

                            // Skip whitespace
                            while (current != null && isWhitespace(current)) {
                                current = current.getPrevSibling();
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }

            return nameBuilder.length() > 0 ? nameBuilder.toString() : null;
        }

        private boolean isWhitespace(PsiElement element) {
            if (element == null) {
                return false;
            }
            IElementType type = element.getNode() != null ? element.getNode().getElementType() : null;
            return type == PineScriptTokenTypes.WHITE_SPACE;
        }

        private static class FunctionCallInfo {
            final String functionName;
            final PsiElement openParen;

            FunctionCallInfo(String functionName, PsiElement openParen) {
                this.functionName = functionName;
                this.openParen = openParen;
            }
        }
    }
}
