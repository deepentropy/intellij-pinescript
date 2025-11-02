package com.tradingview.pinescript.highlighting;

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
        new AttributesDescriptor("Constant", PineScriptSyntaxHighlighter.CONSTANT),
        new AttributesDescriptor("String", PineScriptSyntaxHighlighter.STRING),
        new AttributesDescriptor("Number", PineScriptSyntaxHighlighter.NUMBER),
        new AttributesDescriptor("Comment", PineScriptSyntaxHighlighter.COMMENT),
        new AttributesDescriptor("Annotation", PineScriptSyntaxHighlighter.ANNOTATION),
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
            //@description A PineScript v6 example with user-defined types
            indicator("My Indicator", overlay=true)

            //@type Custom price bar type
            type PriceBar
                float open
                float high
                float low
                float close

            //@enum Chart timeframes
            enum Timeframe
                m1 = "1 minute"
                m5 = "5 minutes"
                h1 = "1 hour"

            // Calculate SMA using v6 syntax
            method calculateSMA(series float src, simple int length) =>
                ta.sma(src, length)

            sma = close.calculateSMA(20)

            // Plot the result
            plot(sma, color=color.blue, title="SMA")
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
        return "PineScript";
    }
}