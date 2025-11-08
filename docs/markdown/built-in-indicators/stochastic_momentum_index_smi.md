The Stochastic Momentum Index (SMI) is an enhanced version of the regular stochastic oscillator, designed to be a more reliable indicator that minimizes false swings by measuring the distance between the current closing price and the median of the high/low price range. On TradingView, the indicator shows both the SMI and the EMA calculated based on it.

SMI values typically fall within the range of +100 to -100, with positive values indicating that the closing price is higher than the midpoint of the high/low range. In contrast, negative values signal that the closing price is lower than the midpoint.

Like the stochastic oscillator, traders and analysts use the SMI to identify overbought or oversold conditions in the market. Additionally, when combined with volume indicators, it reveals the presence of significant buying or selling pressure in the momentum. Additionally, it can be used for trend analysis, with values above 40 often interpreted as signs of a bullish trend and values below -40 as bearish.

#### Calculation

First, we calculate the highest and lowest values in the window (defined by the "%K Length" input in the indicator settings). We subtract their average from the current close to get the "relativeRange" of those values:

```
`highestLowestRange = highestHigh - lowestLowrelativeRange = close - (highestHigh + lowestLow) / 2`
```

After that, we calculate the SMI value, which can be calculated with the following formula:

```
`smi = 200 * (emaEma(relativeRange, lengthD) / emaEma(highestLowestRange, lengthD))`
```

Where 'lengthD' is the value from the "%D Length" input in the indicator's settings, and "emaEma" is an Exponential Moving Average of an Exponential Moving Average (both calculated with the same length):

```
`emaEma(source, length) => ta.ema(ta.ema(source, length), length)`
```

#### Inputs

#### 

##### %K Length

Number of bars back (window) to be used in calculating highest high and lowest low. 10 is the default.

##### %D Length

Number of bars back (window) to be used in calculating SMI. 3 is the default.

##### EMA Length

Determines the number of bars back (window) to be used in calculating the SMI-based EMA.

##### Timeframe

Specifies the timeframe that the indicator is calculated on. This option allows calculating SMI based on data from another timeframe, e.g. having SMI calculated on a 1H chart be displayed on a 5m chart.,

##### Wait for timeframe closes

Specifies the behavior when the indicator's timeframe is higher than the chart's. When 'Wait for timeframe closes' is checked, higher timeframe values only come in and are interconnected on the chart when the higher timeframe completes.

#### Style

##### SMI

Can toggle the visibility of the SMI as well as the visibility of a price line showing the actual current price of the SMI. Can also select the SMI's color, line thickness, and line style.

##### SMI-based EMA

Can toggle the visibility of the SMI-based EMA as well as the visibility of a price line showing the actual current EMA value. Can also select its color, line thickness, and line style.

##### Overbought Line

Can toggle the visibility of the Overbought Line as well as the visibility of a price line showing its value. Can also select its color, line thickness, and line style.

##### Oversold Line

Can toggle the visibility of the Oversold Line as well as the visibility of a price line showing its value. Can also select its color, line thickness, and line style.

##### Middle Line

Can toggle the visibility of the Middle Line as well as sets the boundary, on the scale of 1-100, for the Upper Band (70 is the default). The color, line thickness, and line style can also be determined.

##### Hlines Background

Toggles the visibility of a Background color between the SMI's boundaries. Can also change the Color itself as well as the opacity.

##### Overbought Gradient Fill

Toggles the visibility of a background gradient color of the overbought area (higher than the overbought line 40). Can also change the Color itself as well as the opacity with the first colorpicker.

##### Oversold Gradient Fill

Toggles the visibility of a background gradient color of the oversold area (lower than the oversold line -40). Can also change the Color itself as well as the opacity with the second colorpicker.

##### Precision

Sets the number of decimal places to be left on the indicator's value before rounding up. The higher this number, the more decimal points will be on the indicator's value.