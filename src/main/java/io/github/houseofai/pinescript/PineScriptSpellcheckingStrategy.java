package io.github.houseofai.pinescript;

import com.intellij.psi.PsiElement;
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy;
import com.intellij.spellchecker.tokenizer.Tokenizer;
import org.jetbrains.annotations.NotNull;

/**
 * Disables spell checking for Pine Script code to prevent false typo warnings
 * for Pine Script-specific identifiers like 'hline', 'ta', etc.
 */
public class PineScriptSpellcheckingStrategy extends SpellcheckingStrategy {
    @NotNull
    @Override
    public Tokenizer getTokenizer(PsiElement element) {
        // Return EMPTY_TOKENIZER to disable spell checking for all Pine Script elements
        return EMPTY_TOKENIZER;
    }
}
