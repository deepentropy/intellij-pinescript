package com.tradingview.pinescript;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
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
    }
}