package com.tradingview.pinescript;

import com.intellij.lang.Language;

public class PineScriptLanguage extends Language {
    public static final PineScriptLanguage INSTANCE = new PineScriptLanguage();

    public PineScriptLanguage() {
        super("PineScript", "application/x-pine-script");
    }
}