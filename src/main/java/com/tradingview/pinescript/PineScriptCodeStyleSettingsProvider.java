package com.tradingview.pinescript;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.tradingview.pinescript.highlighting.PineScriptSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class PineScriptCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
    @NotNull
    @Override
    public CodeStyleAbstractConfigurable createConfigurable(@NotNull CodeStyleSettings settings,
                                                            @NotNull CodeStyleSettings modelSettings) {
        return new CodeStyleAbstractConfigurable(settings, modelSettings, "PineScript") {
            @Override
            protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
                return new PineScriptCodeStylePanel(settings);
            }
        };
    }

    private static class PineScriptCodeStylePanel extends CodeStyleAbstractPanel {
        protected PineScriptCodeStylePanel(CodeStyleSettings settings) {
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

        @Nullable
        @Override
        protected String getPreviewText() {
            return """
                //@version=6
                indicator("Example", overlay=true)

                type Bar
                    float open
                    float close

                sma = ta.sma(close, 20)
                plot(sma)
                """;
        }

        @NotNull
        @Override
        protected FileType getFileType() {
            return PineScriptFileType.INSTANCE;
        }

        @NotNull
        @Override
        protected EditorHighlighter createHighlighter(@NotNull EditorColorsScheme scheme) {
            return com.intellij.openapi.editor.highlighter.EditorHighlighterFactory
                    .getInstance()
                    .createEditorHighlighter(new PineScriptSyntaxHighlighter(), scheme);
        }

        @Override
        protected int getRightMargin() {
            return 120;
        }
    }
}