The Rank Correlation Index (RCI) is an oscillator that helps traders gauge the directional consistency of price movements. It evaluates how closely prices follow a **monotonic trend** within a given lookback period. Unlike momentum oscillators that rely on differences in price levels, the RCI measures the correlation between bar indices and price ranks, making it sensitive to the **relative ordering** of prices rather than their absolute values.

Traders often use the RCI to identify potential turning points, analyze price momentum, and assess the persistence of trends.

#### Calculation

The RCI represents a scaled version of Spearman's rank correlation coefficient between prices and bar indices over a lookback period. To calculate the RCI value, the indicator:

1. **Ranks the prices** by sorting them in ascending order. The position of each sorted price represents its initial rank. The lowest price has rank 0, and the rank of the highest price is N - 1, where N is the number of bars in the period. For example, if the analyzed prices are 10, 12, 15, and 12, their initial ranks are 0, 1, 3, and 2.
2. **Adjusts the ranks for ties**. If two or more prices are equal, it assigns each of them the average of their ordered positions as the final rank. For instance, the final ranks for the hypothetical prices shown in the previous step are 0, 1.5, 3, and 1.5, because the values with ranks 1 and 2 are equal, and the average of 1 and 2 is 1.5.
3. **Computes the correlation coefficient** between the sequences of price ranks and bar indices, then multiplies the value by 100.

The result is an oscillator that moves between -100 and +100, where:

* A value of +100 indicates that the prices consistently increased over the analyzed period
* A value of -100 indicates that the prices consistently decreased over the period
* A value near 0 indicates that the prices in the period have little to no directional consistency

The indicator plots the RCI as a blue line, and it displays horizontal lines at the levels -80, 0, and +80. Values outside this range suggest strong upward or downward consistency across the period. Values that cross back into the range might indicate potential momentum shifts.

If you specify a smoothing type in the "Settings/Inputs" tab, the indicator displays a yellow moving average on top of the RCI line. If the type is "SMA + Bollinger Bands", it also displays a green envelope to show standard deviation ranges above and below the average.

#### Inputs

#### Source

The source series that the indicator uses to calculate the RCI. By default, it uses the symbol's closing prices.

#### RCI Length

The number of bars in the RCI calculation. Smaller values make the oscillator more responsive to minor fluctuations; larger values offer a smoother response for analyzing trends.

#### Type

Specifies the moving average type for smoothing the RCI, and whether the indicator includes Bollinger Bands in its display. The options are:

* **None**: No smoothing
* **SMA**: Simple Moving Average of the RCI
* **SMA + Bollinger Bands**: SMA of the RCI, with Bollinger Bands plotted around it
* **EMA**: Exponential Moving Average
* **SMMA (RMA)**: Smoothed Moving Average
* **WMA**: Weighted Moving Average
* **VWMA**: Volume-Weighted Moving Average

#### 

#### Length

The length of the smoothing calculation, and of the Bollinger Bands when the indicator uses the "SMA + Bollinger Bands" option.

#### BB StdDev

The standard deviation multiplier. The value determines the width of the Bollinger Bands. This input is active only if the indicator uses the "SMA + Bollinger Bands" option.