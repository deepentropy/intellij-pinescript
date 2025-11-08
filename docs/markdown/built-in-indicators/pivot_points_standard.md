The Pivot Points Standard technical indicator displays levels at which price might meet support or resistance. The Pivot Points indicator defines a single pivot point (P) level and several support (S) and resistance (R) levels.

#### Inputs

  

#### Type

Specifies the type of pivot point calculation. Each pivot point type uses a different calculation logic (described in the Calculation section below) and draws its own number of levels.

#### Pivots Timeframe

The timeframe used for the pivots calculation. All available timeframes are daily or higher. For example, if "Weekly" is chosen, the indicator uses the current week's open and the previous week's open, high, low, and close (OHLC) to calculate the pivot point levels, and as a result, the levels change once a week.

The “Auto” setting selects the following pivot timeframes:

* 1D for chart resolutions up to and including 15 min
* 1W for chart resolutions greater than 15 min and less than 1 day
* 1M for chart resolutions from 1 day and above

#### Number of Pivots Back

Specifies how many sets of pivots the indicator displays. For example, with “Pivot Timeframe” set to “Weekly”, the default “Number of Pivots Back” value of 15 means that the indicator displays pivots for each of the last 15 weeks.

Note that the indicator can draw no more than 500 lines regardless of the value of this input.

#### Use Daily-based Values

Timeframes higher than 1D are built using daily data (for example, the weekly high is the highest daily high that week), and are called “daily-based” for this reason.

By default, this setting is turned on, and the indicator requests data directly from the higher timeframe defined by the “Pivots Timeframe” setting (which is always daily or higher). With this setting off, the indicator constructs higher timeframe data from the chart data.

Therefore, if the chart timeframe is 1D or above, this setting does not affect the pivot points calculation. However, intraday data on many symbols is a separate data feed from higher timeframe data with different OHLC values, and this difference can affect the pivot calculations. Turning this setting off on intraday charts can help to mitigate issues in some cases.

Stocks can have different values for these reasons:

* Intraday and daily data sets often include different trades, resulting in different prices.
* Extended hours data, if provided, is usually not included in the daily candle. As a result, the Pivot Points calculated on intraday extended hours and those calculated on a daily-based chart are very different.

Futures can have different values for these reasons:

* The daily close usually represents the settlement price, which is an average value and not specifically the price of the last trade (unless the "Use settlement as close" option is explicitly turned off). On intraday timeframes, the last price of the session is the price of the last trade.
* The daily candle uses Electronic Trading Hours, while the intraday charts might allow switching between different sessions.

An advantage of having the “Use Daily-based Values” option turned on is that the pivot values remain consistent between intraday and higher timeframes. However, in some cases you might want to turn it off:

* To include Extended Trading Hours data for a stock such as AAPL, turn the setting off — the extended hours data exists only on intraday timeframes, and the daily-based calculation does not include it.
* To include Regular Trading Hours data on ES1! futures, turn the setting off — the daily data is always based on the Extended Trading Hours session.
* To calculate the Pivot Points on AAPL or ES1! and ensure that the pivots displayed on your 1 hour chart and the pivots on the 1 day chart have the same values, turn this option on. Otherwise, the pivots are calculated on the 1 hour dataset, which differs from the 1 day dataset, and the results are also different.

Note: For all symbols, the number of bars of intraday data available on the chart is limited by your subscription, while the daily data is always presented in full regardless of your plan. If you use a small timeframe on the chart (for example, 1 minute) and a large timeframe as the Pivot Timeframe (for example, Yearly), your chart only has a few months of 1-minute data — not enough to match the higher timeframe. In this case, the indicator returns an error, prompting you to switch this setting on to ensure that the indicator has enough data to calculate pivots.

#### Show Labels/Prices

Specify whether to show the labels ("P", "R1", "S1", etc.) and their associated prices beside the pivot lines.

#### Labels Position

Specifies whether to display the labels and prices to the left or the right of the pivot line.

#### Line Width

Specifies the width of the pivot lines.

#### P, S1, R1, etc.

Specify whether to draw particular support and resistance lines, and set their color. Note that not all pivot types include the full set of lines: for example, only Traditional and Camarilla pivots calculate S5 and R5 lines; all other pivot types do not display them even if the P5 and S5 inputs are checked.

#### Calculation

The pivot, resistance, and support values are calculated in different ways depending on the pivot point type set in the “Type” input.

#### Types

The Standard Pivot Points indicator uses the following types of pivot:

* Traditional
* Fibonacci
* Woodie
* Classic
* DM
* Camarilla

The calculation formulas for each type are given below. The "current" and "previous" values refer to the current and previous bar of the timeframe selected in the “Pivots Timeframe” option.

###### Traditional

```
`P = (prevHigh + prevLow + prevClose) / 3
R1 = P * 2 - prevLow
S1 = P * 2 - prevHigh
R2 = P + (prevHigh - prevLow)
S2 = P - (prevHigh - prevLow)
R3 = P * 2 + (prevHigh - 2 * prevLow)
S3 = P * 2 - (2 * prevHigh - prevLow)
R4 = P * 3 + (prevHigh - 3 * prevLow)
S4 = P * 3 - (3 * prevHigh - prevLow)
R5 = P * 4 + (prevHigh - 4 * prevLow)
S5 = P * 4 - (4 * prevHigh - prevLow)`
```

###### Fibonacci

```
`P = (prevHigh + prevLow + prevClose) / 3
R1 = P + 0.382 * (prevHigh - prevLow)
S1 = P - 0.382 * (prevHigh - prevLow)
R2 = P + 0.618 * (prevHigh - prevLow)
S2 = P - 0.618 * (prevHigh - prevLow)
R3 = P + (prevHigh - prevLow)
S3 = P - (prevHigh - prevLow)`
```

###### Woodie

```
`P = (prevHigh + prevLow + 2 * currOpen) / 4
R1 = 2 * P - prevLow
S1 = 2 * P - prevHigh
R2 = P + (prevHigh - prevLow)
S2 = P - (prevHigh - prevLow)
R3 = prevHigh + 2 * (P -  prevLow)
S3 = prevLow  - 2 * (prevHigh - P)
R4 = R3 + (prevHigh - prevLow)
S4 = S3 - (prevHigh - prevLow)`
```

###### Classic

```
`P = (prevHigh + prevLow + prevClose) / 3
R1 = 2 * P - prevLow
S1 = 2 * P - prevHigh
R2 = P + (prevHigh - prevLow)
S2 = P - (prevHigh - prevLow)
R3 = P + 2 * (prevHigh - prevLow)
S3 = P - 2 * (prevHigh - prevLow)
R4 = P + 3 * (prevHigh - prevLow)
S4 = P - 3 * (prevHigh - prevLow)`
```

###### DM

```
`if prevOpen == prevClose
    X = prevHigh + prevLow + 2 * prevClose
else if prevClose >  prevOpen
    X = 2 * prevHigh + prevLow + prevClose
else
    X = 2 * prevLow + prevHigh + prevClose
P = X / 4
R1 = X / 2 - prevLow
S1 = X / 2 - prevHigh`
```

###### Camarilla

```
`P = (prevHigh + prevLow + prevClose) / 3
R1 = prevClose + 1.1 * (prevHigh - prevLow) / 12
S1 = prevClose - 1.1 * (prevHigh - prevLow) / 12
R2 = prevClose + 1.1 * (prevHigh - prevLow) / 6
S2 = prevClose - 1.1 * (prevHigh - prevLow) / 6
R3 = prevClose + 1.1 * (prevHigh - prevLow) / 4
S3 = prevClose - 1.1 * (prevHigh - prevLow) / 4
R4 = prevClose + 1.1 * (prevHigh - prevLow) / 2
S4 = prevClose - 1.1 * (prevHigh - prevLow) / 2
R5 = (prevHigh / prevLow) * prevClose
S5 = prevClose - (R5 - prevClose)`
```