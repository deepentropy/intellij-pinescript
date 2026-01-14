package io.github.deepentropy.pinescript.inspection;

import com.intellij.codeInspection.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import io.github.deepentropy.pinescript.psi.PineScriptFile;
import io.github.deepentropy.pinescript.psi.PineScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Inspection for PineScript that checks for common issues and best practices.
 * Users can configure which inspections are enabled in IDE settings.
 */
public class PineScriptInspection extends LocalInspectionTool {

    private static final Pattern VERSION_PATTERN = Pattern.compile("//@version\\s*=\\s*(\\d+)");
    private static final Pattern SECURITY_CALL_PATTERN = Pattern.compile("request\\.security\\s*\\(");

    // Built-in variables that should not be reassigned
    private static final Set<String> BUILTIN_VARIABLES = new HashSet<>();
    static {
        BUILTIN_VARIABLES.add("open");
        BUILTIN_VARIABLES.add("high");
        BUILTIN_VARIABLES.add("low");
        BUILTIN_VARIABLES.add("close");
        BUILTIN_VARIABLES.add("volume");
        BUILTIN_VARIABLES.add("time");
        BUILTIN_VARIABLES.add("hl2");
        BUILTIN_VARIABLES.add("hlc3");
        BUILTIN_VARIABLES.add("ohlc4");
        BUILTIN_VARIABLES.add("hlcc4");
        BUILTIN_VARIABLES.add("bar_index");
        BUILTIN_VARIABLES.add("last_bar_index");
        BUILTIN_VARIABLES.add("timenow");
    }

    @NotNull
    @Override
    public String getShortName() {
        return "PineScriptInspection";
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "PineScript code inspection";
    }

    @NotNull
    @Override
    public String getGroupDisplayName() {
        return "Pine Script";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new PsiElementVisitor() {
            private boolean fileChecked = false;
            private int securityCallCount = 0;

            @Override
            public void visitFile(@NotNull PsiFile file) {
                if (!(file instanceof PineScriptFile)) {
                    return;
                }

                if (fileChecked) return;
                fileChecked = true;

                String text = file.getText();

                // Check version
                checkVersion(text, file, holder);

                // Check script declaration
                checkScriptDeclaration(text, file, holder);

                // Count security calls
                checkSecurityCallCount(text, file, holder);

                super.visitFile(file);
            }

            @Override
            public void visitElement(@NotNull PsiElement element) {
                if (element.getNode() == null) return;

                // Check for reassignment of built-in variables
                if (element.getNode().getElementType() == PineScriptTokenTypes.IDENTIFIER) {
                    checkBuiltinReassignment(element, holder);
                }

                // Check for deprecated patterns
                checkDeprecatedPatterns(element, holder);

                super.visitElement(element);
            }
        };
    }

    private void checkVersion(String text, PsiFile file, ProblemsHolder holder) {
        Matcher matcher = VERSION_PATTERN.matcher(text);
        if (!matcher.find()) {
            // Find the first non-whitespace element
            PsiElement firstChild = file.getFirstChild();
            if (firstChild != null) {
                holder.registerProblem(firstChild,
                    "Missing version annotation. Add '//@version=6' at the top of your script.",
                    ProblemHighlightType.WARNING);
            }
        } else {
            int version = Integer.parseInt(matcher.group(1));
            if (version < 5) {
                // Find the version annotation element
                PsiElement firstChild = file.getFirstChild();
                if (firstChild != null) {
                    holder.registerProblem(firstChild,
                        "Script uses PineScript v" + version + ". Consider upgrading to v5 or v6 for better features.",
                        ProblemHighlightType.WEAK_WARNING);
                }
            }
        }
    }

    private void checkScriptDeclaration(String text, PsiFile file, ProblemsHolder holder) {
        boolean hasDeclaration = text.contains("indicator(") || text.contains("strategy(") ||
                                  text.contains("library(");

        if (!hasDeclaration && VERSION_PATTERN.matcher(text).find()) {
            PsiElement firstChild = file.getFirstChild();
            if (firstChild != null) {
                holder.registerProblem(firstChild,
                    "Script must declare indicator(), strategy(), or library().",
                    ProblemHighlightType.ERROR);
            }
        }
    }

    private void checkSecurityCallCount(String text, PsiFile file, ProblemsHolder holder) {
        Matcher matcher = SECURITY_CALL_PATTERN.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }

        if (count > 40) {
            PsiElement firstChild = file.getFirstChild();
            if (firstChild != null) {
                holder.registerProblem(firstChild,
                    "Script has " + count + " request.security() calls. Maximum allowed is 40.",
                    ProblemHighlightType.ERROR);
            }
        } else if (count > 35) {
            PsiElement firstChild = file.getFirstChild();
            if (firstChild != null) {
                holder.registerProblem(firstChild,
                    "Script has " + count + " request.security() calls. Approaching limit of 40.",
                    ProblemHighlightType.WARNING);
            }
        }
    }

    private void checkBuiltinReassignment(PsiElement element, ProblemsHolder holder) {
        String name = element.getText();
        if (!BUILTIN_VARIABLES.contains(name)) {
            return;
        }

        // Check if followed by = or :=
        PsiElement next = element.getNextSibling();
        while (next != null && isWhitespace(next)) {
            next = next.getNextSibling();
        }

        if (next != null && next.getNode() != null &&
            next.getNode().getElementType() == PineScriptTokenTypes.OPERATOR) {
            String op = next.getText();
            if ("=".equals(op) || ":=".equals(op)) {
                holder.registerProblem(element,
                    "Reassigning built-in variable '" + name + "' will shadow it. " +
                    "Use a different variable name.",
                    ProblemHighlightType.WARNING);
            }
        }
    }

    private void checkDeprecatedPatterns(PsiElement element, ProblemsHolder holder) {
        if (element.getNode().getElementType() != PineScriptTokenTypes.BUILTIN_FUNCTION) {
            return;
        }

        String text = element.getText();

        // Check for deprecated functions
        if ("security".equals(text)) {
            holder.registerProblem(element,
                "'security()' is deprecated. Use 'request.security()' instead.",
                ProblemHighlightType.LIKE_DEPRECATED);
        }

        if ("study".equals(text)) {
            holder.registerProblem(element,
                "'study()' is deprecated. Use 'indicator()' instead.",
                ProblemHighlightType.LIKE_DEPRECATED);
        }
    }

    private boolean isWhitespace(PsiElement element) {
        return element.getNode() != null &&
               element.getNode().getElementType() == PineScriptTokenTypes.WHITE_SPACE;
    }
}
