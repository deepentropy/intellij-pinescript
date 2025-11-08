package io.github.houseofai.pinescript;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.DisplayPriority;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides code style settings for PineScript.
 * Simplified implementation without deprecated APIs.
 */
public class PineScriptCodeStyleSettingsProvider extends CodeStyleSettingsProvider {

    @Nullable
    @Override
    public String getConfigurableDisplayName() {
        return "PineScript";
    }

    @Nullable
    @Override
    public Language getLanguage() {
        return PineScriptLanguage.INSTANCE;
    }

    @NotNull
    @Override
    public DisplayPriority getPriority() {
        return DisplayPriority.LANGUAGE_SETTINGS;
    }
}
