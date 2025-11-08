package io.github.houseofai.pinescript.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import io.github.houseofai.pinescript.PineScriptFileType;
import io.github.houseofai.pinescript.PineScriptLanguage;
import org.jetbrains.annotations.NotNull;

/**
 * PSI file representation for Pine Script.
 */
public class PineScriptFile extends PsiFileBase {
    public PineScriptFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, PineScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return PineScriptFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Pine Script File";
    }
}
