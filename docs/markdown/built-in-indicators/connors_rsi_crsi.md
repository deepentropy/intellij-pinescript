#### 

#### Definition

Connors RSI (CRSI) is a technical analysis indicator created by Larry Connors that is actually a composite of three separate components. The Relative Strength Index (RSI), developed by J. Welles Wilder, plays an integral role in Connors RSI. In fact, Wilder's RSI is used in two of the indicator's three components. The three components; The RSI, UpDown Length, and Rate-of-Change, combine to form a momentum oscillator. Connors RSI outputs a value between 0 and 100, which is then used to identify short-term overbought and oversold conditions.

#### History

Connors RSI was developed by Connors Research.

#### Calculation

There are three major components to Connors RSI

* RSI = Standard RSI developed by Wilder. This is typically a short-term RSI. In this example it is a 3 Period RSI.
* UpDown Length = The number of consecutive days that a security price has either closed up (higher than previous day) or closed down (lower than previous days). Closing up values represented in positive numbers and closing down is represented with negative numbers. If a security closes at the same price on back to back days, the UpDown Length is 0. Connors RSI then applies a short-term RSI to the UpDown Streak Value. In this example it is a 2 period RSI.
* ROC = The Rate-of-Change. The ROC takes a user-defined look-back period and calculates a percentage of the number of values within that look back period that are below the current day price change percentage.

The final CRSI calculation then simply finding the average value of the three components.

```
CRSI(3,2,100) = [ RSI(3) + RSI(UpDown Length,2) + ROC(100) ] / 3
```

#### The basics

Connors RSI (CRSI) uses the above formula to generate a value between 0 and 100. This is primarily used to identify overbought and oversold levels. Connor's original definition of these levels is that a value over 90 should be considered overbought and a value under 10 should be considered oversold. On occasion, signals occur during slight corrections during a trend. For example, when the market is in an uptrend, Connors RSI might generate short term sell signals. When the market is in a downtrend, Connors RSI might generate short term buy signals.

A technical analyst should also be aware of the value of adapting or tweaking the Connor RSI. One of the issues with Connor RSI is that signals oftentimes occur early. For example, in an uptrend, a sell signal may present itself. However, the market continues to rise, thus a false signal. One potential safeguard against potential false signals would be combining the Connors RSI with additional technical analysis tools such as basic chart pattern analysis or additional indicators used to measure trend strength.

Another issue worth noting regarding the Connor RSI, is the placement of the overbought and oversold thresholds levels. For some trading instruments, the thresholds for overbought may need to be raised even higher and for oversold even lower. For example 95 and 5 respectively. These levels should generally be set after research and historical analysis. Making sure thresholds are in the proper place, should also help to cut down on false signals.

#### What to look for

Connors RSI is designed to define overbought and oversold levels and therefore trade signals based on those levels.

A bullish signal occurs when Connors RSI enters oversold territory.

A bearish signal occurs when Connors RSI enters overbought territory.

\*As previously mentioned, signals occasionally occur in the opposite direction of an overall trend.

#### Summary

Connors RSI indicator is a tool that takes a well established indicator, The Relative Strength Index (RSI) and applies it to its own theories. It can be a good way to define overbought and oversold levels and identify possible trading opportunities. That being said, Connors RSI does have a tendency to produce false signals. Therefore an astute technical analyst should experiment with what parameters work best for the security being traded. Also, combining Connors RSI with additional indicators will potentially increase its efficiency.

#### Inputs

##### RSI Length

The time period to be used in calculating the RSI. 3 is the default.

##### UpDown Length

Determines the time period of the UpDown RSI calculation, 2 is the default length.

##### ROC Length

The lookback for the ROC calculation. 100 is the default.

#### Style

##### CRSI

Can toggle the visibility of the CRSI Line as well as the visibility of a price line showing the actual current value of the CRSI. Can also select the CRSI Line's color, line thickness and visual style (Line is the Default).

##### Upper Band

Can toggle the visibility of the Upper Band Line. Can also select the Upper Band Line's value, color, line thickness and line style.

##### Lower Band

Can toggle the visibility of the Lower Band Line. Can also select the Lower Band Line's value, color, line thickness and line style.

##### Background

Can toggle the visibility of the Background. Can also select the Background's color and opacity.

##### Precision

Sets the number of decimal places to be left on the indicator's value before rounding up. The higher this number, the more decimal points will be on the indicator's value.