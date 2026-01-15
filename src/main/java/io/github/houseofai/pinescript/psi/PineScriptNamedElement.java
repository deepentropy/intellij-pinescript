package io.github.houseofai.pinescript.psi;

import com.intellij.psi.PsiNameIdentifierOwner;

/**
 * Interface for PineScript elements that have a name (functions, variables, types, etc.).
 * This enables go-to-definition, find usages, and rename refactoring.
 */
public interface PineScriptNamedElement extends PsiNameIdentifierOwner {
}
