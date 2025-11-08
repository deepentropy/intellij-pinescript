#### Definition

MACD is an extremely popular indicator used in technical analysis. MACD can be used to identify aspects of a security's overall trend. Most notably these aspects are momentum, as well as trend direction and duration. What makes MACD so informative is that it is actually the combination of two different types of indicators. First, MACD employs two Moving Averages of varying lengths (which are lagging indicators) to identify trend direction and duration. Then, MACD takes the difference in values between those two Moving Averages (MACD Line) and an EMA of those Moving Averages (Signal Line) and plots that difference between the two lines as a histogram which oscillates above and below a center Zero Line. The histogram is used as a good indication of a security's momentum.

#### History

The creation of the MACD as we know it can be split into two separate events.

1. In the 1970's, Gerald Appel created the MACD line.
2. In 1986, Thomas Aspray added the histogram feature to Apple's MACD.

Aspray's contribution served as a way to anticipate (and therefore cut down on lag) possible MACD crossovers which are a fundamental part of the indicator.

#### Calculation

```
MACD Line: (12-day EMA - 26-day EMA) 
Signal Line: 9-day EMA of MACD Line
MACD Histogram: MACD Line - Signal Line
```

#### The basics

To fully understand the MACD indicator, it is first necessary to break down each of the indicator's components.

##### The three major components

1. The MACD Line.  
   MACD Line is a result of taking a longer term EMA and subtracting it from a shorter term EMA.The most commonly used values are 26 days for the longer term EMA and 12 days for the shorter term EMA, but it is the trader's choice.
2. The Signal Line.  
   The Signal Line is an EMA of the MACD Line described in Component 1. The trader can choose what period length EMA to use for the Signal Line however 9 is the most common.
3. The MACD Histogram.  
   As time advances, the difference between the MACD Line and Signal Line will continually differ. The MACD histogram takes that difference and plots it into an easily readable histogram. The difference between the two lines oscillates around a Zero Line.

A general interpretation of MACD is that when MACD is positive and the histogram value is increasing, then upside momentum is increasing. When MACD is negative and the histogram value is decreasing, then downside momentum is increasing.

#### What to look for

The MACD indicator is typically good for identifying three types of basic signals; Signal Line Crossovers, Zero Line Crossovers, and Divergence.

##### SIGNAL LINE CROSSOVERS

A Signal Line Crossover is the most common signal produced by the MACD. First one must consider that the Signal Line is essentially an indicator of an indicator. The Signal Line is calculating the Moving Average of the MACD Line. Therefore the Signal Line lags behind the MACD line. That being said, on the occasions where the MACD Line crosses above or below the Signal Line, that can signify a potentially strong move.

The strength of the move is what determines the duration of Signal Line Crossover. Understanding and being able to analyze move strength, as well as being able to recognize false signals, is a skill that comes with experience.

The first type of Signal Line Crossover to examine is the Bullish Signal Line Crossover. Bullish Signal Line Crossovers occur when the MACD Line crosses above the Signal Line.

The second type of Signal Line Crossover to examine is the Bearish Signal Line Crossover. Bearish Signal Line Crossovers occur when the MACD Line crosses below the Signal Line.

#### Zero line crossovers

Zero Line Crossovers have a very similar premise to Signal Line Crossovers. Instead of crossing the Signal Line, Zero Line Crossovers occur when the MACD Line crossed the Zero Line and either becomes positive (above 0) or negative (below 0).

The first type of Zero Line Crossover to examine is the Bullish Zero Line Crossover. Bullish Zero Line Crossovers occur when the MACD Line crosses above the Zero Line and go from negative to positive.

The second type of Zero Line Crossover to examine is the Bearish Zero Line Crossover. Bearish Zero Line Crossovers occur when the MACD Line crosses below the Zero Line and go from positive to negative.

#### Divergence

Divergence is another signal created by the MACD. Simply put, divergence is when the MACD and actual price are not in agreement.

For example, Bullish Divergence occurs when price records a lower low, but the MACD records a higher low. The movement of price can provide evidence of the current trend, however changes in momentum as evidenced by the MACD can sometimes precede a significant reversal.

Bearish Divergence is, of course, the opposite. Bearish Divergence occurs when price records a higher high while the MACD records a lower high.

#### Summary

What makes the MACD such a valuable tool for technical analysis is that it is almost like two indicators in one. It can help to identify not just trends, but it can measure momentum as well. It takes two separate lagging indicators and adds the aspect of momentum which is much more active or predictive That kind of versatility is why it has been and is used by trader's and analysts across the entire spectrum of finance.

Despite MACD's obvious attributes, just like with any indicator, the trader or analyst needs to exercise caution. There are just some things that MACD doesn't do well which may tempt a trader regardless. Most notably, traders may be tempted into using MACD as a way to find overbought or oversold conditions. This is not a good idea. Remember, MACD is not bound to a range, so what is considered to be highly positive or negative for one instrument may not translate well to a different instrument.

With sufficient time and experience, almost anybody who wants to analyze chart data should be able to make good use out of the MACD.

#### Inputs

##### Fast Length

The time period of the shorter term EMA. 12 days is the default.

##### Slow Length

The time period of the longer term EMA. 26 days is the default.

##### Source

Determines what data from each bar will be used in calculations. Close is the default.

##### Signal Smoothing

The time period for the EMA of the MACD Line otherwise known as the Signal Line. 9 Days is the default.

##### Simple Ma (Oscillator)

##### Simple Ma (Signal Line)

#### Style

##### Histogram

Can toggle the visibility of the Histogram as well as the visibility of a price line showing the actual current value of the Histogram. Can also select the Histogram's color, line thickness and visual type (Histogram is the default).

##### MACD

Can toggle the visibility of the MACD Line as well as the visibility of a price line showing the actual current value of the MACD Line. Can also select the MACD Line's color, line thickness and visual type (Line is the default).

##### Signal

Can toggle the visibility of the Signal Line as well as the visibility of a price line showing the actual current value of the Signal Line. Can also select the Signal Line's color, line thickness and visual type (Line is the default).

##### Precision

Sets the number of decimal places to be left on the indicator's value before rounding up. The higher this number, the more decimal points will be on the indicator's value.