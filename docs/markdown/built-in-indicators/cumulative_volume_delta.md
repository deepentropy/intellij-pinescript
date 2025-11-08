The Cumulative Volume Delta indicator uses intrabar volume and price fluctuations to estimate the difference (delta) between buying and selling pressure within each chart bar, and it accumulates each bar's results over a specified period to provide a broader perspective on the relationship between volume and price activity.

The indicator analyzes each chart bar from an intrabar timeframe (i.e., a timeframe lower than the chart's), categorizing each intrabar's volume as positive or negative. It gradually accumulates the polarized volume values throughout a chart bar to calculate the volume delta, and it keeps track of the highest and lowest volume delta values achieved over the bar's duration.

Unlike the Volume Delta indicator, which only estimates the volume delta for individual chart bars, the Cumulative Volume Delta indicator accumulates volume delta across a period to provide a broader perspective. Each new bar's volume delta adds to the cumulative value calculated on the previous bar. The only exception is when a new period starts, which resets the cumulative calculation.

After calculating the period's cumulative values on a bar, the indicator plots a candle to represent the results:

* The candle's open value is the starting point of the bar's calculation. When the bar is the first in a period, the candle always opens at 0. Otherwise, the open equals the closing value from the previous CVD candle.
* The candle's close value represents the sum of the bar's final volume delta value and the total volume delta accumulated from previous bars within the period.
* The high reflects the highest cumulative volume delta calculated throughout the bar's duration.
* The low reflects the lowest cumulative volume delta calculated throughout the bar's duration.

#### Calculation

The Cumulative Volume Delta indicator scans volume and price action across lower-timeframe bars within each chart bar to calculate and accumulate volume delta values. To do this, it must first determine the intrabar timeframe to analyze.

Users can decide the lower timeframe manually or let the indicator determine the timeframe. By default, it selects the timeframe automatically based on the chart's timeframe using the following rules:

|  |  |
| --- | --- |
| Chart timeframe | Timeframe used for the calculation |
| Seconds | 1S |
| Minutes or Hours | 1 |
| Daily | 5 |
| Others | 60 |

When selecting an intrabar timeframe manually, it's important to note that lower timeframes provide higher precision at the cost of less chart bar coverage. Higher timeframes provide more historical data, but the volume delta values will be less precise.

After timeframe selection, the indicator analyzes the direction of the available intrabars to categorize their volume and calculate the delta on each bar.

If the intrabar's opening price is not equal to the closing price:

* It considers the intrabar's volume positive and adds the value to the chart bar's total if the closing price exceeds the opening price.
* It considers the intrabar's volume negative and subtracts it from the chart bar's total if the closing price is below the opening price.

If the intrabar's opening and closing prices are equal:

* It considers the intrabar's volume positive and adds the value to the chart bar's total if the closing price exceeds the close of the previous intrabar.
* It considers the intrabar's volume negative and subtracts it from the chart bar's total if the closing price is below the previous intrabar's close.
* If the closing price equals that of the previous intrabar, the indicator assigns the previous intrabar's positive/negative status to the current intrabar.

Lastly, after computing a bar's volume delta values, the indicator adds those values to the current period's running total to calculate the opening, high, low, and closing cumulative volume delta on that bar. The running total resets to 0 each time a new period starts.

#### Inputs

#### Anchor period

Specifies the size of the calculation period. At the start of each new period, the indicator resets its volume delta accumulation, and the current bar's CVD candle starts at 0. On other bars, the indicator adds each bar's volume delta to the period's running total, and the current CVD candle's opening value aligns with the previous candle's closing value.

#### Use custom timeframe

Determines whether the user manually chooses the lower timeframe. If unchecked (default), the indicator selects the timeframe automatically. Otherwise, it uses the value specified in the "Timeframe" input below.

#### Timeframe

Specifies the intrabar timeframe used for volume delta calculation when "Use custom timeframe" is enabled. Higher timeframes provide more historical data at the cost of reduced precision. Lower timeframes cover fewer chart bars but offer higher precision.