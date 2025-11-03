package com.tradingview.pinescript;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.editor.highlighter.EditorHighlighterFactory;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PineScriptCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
    @Override
    public @NotNull CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings, @NotNull CodeStyleSettings modelSettings) {
        return new CodeStyleAbstractConfigurable(settings, modelSettings, "PineScript") {
            @Override
            protected @NotNull CodeStyleAbstractPanel createPanel(@NotNull CodeStyleSettings settings) {
                return new PineScriptCodeStylePanel(settings);
            }

            @Override
            public String getHelpTopic() {
                return null;
            }
        };
    }

    @Nullable
    @Override
    public String getConfigurableDisplayName() {
        return "PineScript";
    }

    private static class PineScriptCodeStylePanel extends CodeStyleAbstractPanel {
        protected PineScriptCodeStylePanel(@NotNull CodeStyleSettings settings) {
            super(settings);
        }

        @Override
        protected void resetImpl(@NotNull CodeStyleSettings settings) {
        }

        @Override
        public void apply(@NotNull CodeStyleSettings settings) {
        }

        @Override
        public boolean isModified(CodeStyleSettings settings) {
            return false;
        }

        @Nullable
        @Override
        public JComponent getPanel() {
            return new JPanel();
        }

        @Override
        protected @NotNull String getPreviewText() {
            return """
                    //@version=5
                    indicator("My Script", overlay=true)

                    // Calculate moving average
                    length = input.int(14, "Length")
                    src = close
                    ma = ta.sma(src, length)

                    // Plot
                    plot(ma, color=color.blue, linewidth=2)
                    """;
        }

        @NotNull
        @Override
        public com.intellij.openapi.fileTypes.FileType getFileType() {
            return PineScriptFileType.INSTANCE;
        }

        @Nullable
        @Override
        public Language getDefaultLanguage() {
            return PineScriptLanguage.INSTANCE;
        }

        @NotNull
        @Override
        protected EditorHighlighter createHighlighter(@NotNull EditorColorsScheme scheme) {
            return EditorHighlighterFactory.getInstance().createEditorHighlighter(getFileType(), scheme, null);
        }

        @Override
        protected int getRightMargin() {
            return 120;
        }
    }
}