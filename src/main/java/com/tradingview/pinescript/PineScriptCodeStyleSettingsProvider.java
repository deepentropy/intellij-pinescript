package com.tradingview.pinescript;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PineScriptCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
    @Override
    public CodeStyleAbstractConfigurable createConfigurable(@NotNull CodeStyleSettings settings, @NotNull CodeStyleAbstractConfigurable parent) {
        return new CodeStyleAbstractConfigurable(settings, parent, "PineScript") {
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
        protected void resetImpl(CodeStyleSettings settings) {
        }

        @Override
        public void apply(CodeStyleSettings settings) {
        }

        @Override
        public boolean isModified(CodeStyleSettings settings) {
            return false;
        }

        @Nullable
        @Override
        public JComponent getPanel() {
            return new javax.swing.JPanel();
        }
    }
}