package io.github.houseofai.pinescript.psi;

import com.intellij.psi.tree.IElementType;
import io.github.houseofai.pinescript.PineScriptLanguage;

/**
 * Element types for composite PSI elements (non-leaf nodes in the parse tree).
 */
public interface PineScriptElementTypes {
    // Definition elements
    IElementType FUNCTION_DEFINITION = new PineScriptElementType("FUNCTION_DEFINITION");
    IElementType METHOD_DEFINITION = new PineScriptElementType("METHOD_DEFINITION");
    IElementType VARIABLE_DEFINITION = new PineScriptElementType("VARIABLE_DEFINITION");
    IElementType TYPE_DEFINITION = new PineScriptElementType("TYPE_DEFINITION");
    IElementType ENUM_DEFINITION = new PineScriptElementType("ENUM_DEFINITION");
    IElementType PARAMETER_DEFINITION = new PineScriptElementType("PARAMETER_DEFINITION");

    // Reference elements
    IElementType IDENTIFIER_REFERENCE = new PineScriptElementType("IDENTIFIER_REFERENCE");

    // Expression elements
    IElementType FUNCTION_CALL = new PineScriptElementType("FUNCTION_CALL");
    IElementType ASSIGNMENT = new PineScriptElementType("ASSIGNMENT");

    class PineScriptElementType extends IElementType {
        public PineScriptElementType(String debugName) {
            super(debugName, PineScriptLanguage.INSTANCE);
        }
    }
}
