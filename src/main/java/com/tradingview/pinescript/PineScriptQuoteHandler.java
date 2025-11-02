package com.tradingview.pinescript;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import com.tradingview.pinescript.psi.PineScriptTokenTypes;

public class PineScriptQuoteHandler extends SimpleTokenSetQuoteHandler {
    public PineScriptQuoteHandler() {
        super(PineScriptTokenTypes.STRING);
    }
}