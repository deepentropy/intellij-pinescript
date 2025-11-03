package io.github.houseofai.pinescript.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PineScriptColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
        new AttributesDescriptor("Keyword", PineScriptSyntaxHighlighter.KEYWORD),
        new AttributesDescriptor("Storage Keyword (var, varip, const)", PineScriptSyntaxHighlighter.STORAGE_KEYWORD),
        new AttributesDescriptor("Boolean (true, false)", PineScriptSyntaxHighlighter.BOOLEAN),
        new AttributesDescriptor("Namespace Constant (format.*, display.*)", PineScriptSyntaxHighlighter.NAMESPACE_CONSTANT),
        new AttributesDescriptor("Constant (na)", PineScriptSyntaxHighlighter.CONSTANT),
        new AttributesDescriptor("Built-in Function", PineScriptSyntaxHighlighter.BUILTIN_FUNCTION),
        new AttributesDescriptor("Parameter Name", PineScriptSyntaxHighlighter.PARAMETER_NAME),
        new AttributesDescriptor("String", PineScriptSyntaxHighlighter.STRING),
        new AttributesDescriptor("Number", PineScriptSyntaxHighlighter.NUMBER),
        new AttributesDescriptor("Hex Color", PineScriptSyntaxHighlighter.HEX_COLOR),
        new AttributesDescriptor("Comment", PineScriptSyntaxHighlighter.COMMENT),
        new AttributesDescriptor("Identifier", PineScriptSyntaxHighlighter.IDENTIFIER),
        new AttributesDescriptor("Operator", PineScriptSyntaxHighlighter.OPERATOR)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new PineScriptSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return """
            //@version=6
            indicator("Relative Strength Index", shorttitle="RSI", format=format.price)

            // Input settings
            rsiLength = input.int(14, minval=1, title="RSI Length")
            rsiSource = input.source(close, "Source")

            // Calculate RSI
            change = ta.change(rsiSource)
            up = ta.rma(math.max(change, 0), rsiLength)
            down = ta.rma(-math.min(change, 0), rsiLength)
            rsi = down == 0 ? 100 : up == 0 ? 0 : 100 - (100 / (1 + up / down))

            // Plot the result
            plot(rsi, "RSI", color=color.blue)
            hline(70, "Upper Band", color=color.red)
            hline(50, "Middle Band", color=color.gray)
            hline(30, "Lower Band", color=color.green)

            // Alert condition
            var bool oversold = na
            if rsi < 30
                oversold = true
            """;
    }

    @Nullable
    @Override
    public java.util.Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Pine Script";
    }
}
