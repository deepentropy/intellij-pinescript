package io.github.houseofai.pinescript;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PineScriptFileType extends LanguageFileType {
    public static final PineScriptFileType INSTANCE = new PineScriptFileType();

    private PineScriptFileType() {
        super(PineScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "PineScript";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Pine Script programming language";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "pine";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return IconLoader.getIcon("/icons/pinescript.png", PineScriptFileType.class);
    }
}
