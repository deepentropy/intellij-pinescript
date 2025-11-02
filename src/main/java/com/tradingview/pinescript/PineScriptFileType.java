package com.tradingview.pinescript;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class PineScriptFileType implements FileType {
    public static final PineScriptFileType INSTANCE = new PineScriptFileType();

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

    @Override
    public Icon getIcon() {
        return IconLoader.getIcon("/icons/pine.png", PineScriptFileType.class);
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public String getCharset(@NotNull com.intellij.openapi.vfs.VirtualFile file, @NotNull CharSequence content) {
        return "UTF-8";
    }
}