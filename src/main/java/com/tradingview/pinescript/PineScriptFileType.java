package com.tradingview.pinescript;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
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
        return "PineScript programming language";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "pine";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        // Return null for now - you can add an icon later
        return null;
    }
}