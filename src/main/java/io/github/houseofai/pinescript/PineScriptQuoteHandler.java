package io.github.houseofai.pinescript;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import io.github.houseofai.pinescript.psi.PineScriptTokenTypes;

public class PineScriptQuoteHandler extends SimpleTokenSetQuoteHandler {
    public PineScriptQuoteHandler() {
        super(PineScriptTokenTypes.STRING);
    }
}
