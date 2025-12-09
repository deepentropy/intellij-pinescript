package io.github.deepentropy.pinescript;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import io.github.deepentropy.pinescript.psi.PineScriptTokenTypes;

public class PineScriptQuoteHandler extends SimpleTokenSetQuoteHandler {
    public PineScriptQuoteHandler() {
        super(PineScriptTokenTypes.STRING);
    }
}
