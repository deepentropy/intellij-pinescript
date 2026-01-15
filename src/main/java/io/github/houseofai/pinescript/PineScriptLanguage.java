package io.github.houseofai.pinescript;

import com.intellij.lang.Language;

public final class PineScriptLanguage extends Language {
    public static final PineScriptLanguage INSTANCE = new PineScriptLanguage();

    private PineScriptLanguage() {
        super("PineScript");
    }
}
