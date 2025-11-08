The RCI Ribbon indicator visualizes how the typical direction of price movements aligns across multiple periods by plotting a set of three Rank Correlation Index (RCI) oscillators with different lookback lengths.

The RCI helps traders gauge the directional consistency of price changes. It evaluates how closely prices follow a **monotonic trend** within a given lookback period. Unlike other momentum oscillators, the RCI measures the correlation between bar indices and price ranks, making it sensitive to the **relative ordering** of prices rather than their absolute values.

By analyzing three RCI oscillators together, traders can see whether the direction of price changes is relatively consistent across multiple time periods, or if short-term directional shifts diverge from the longer-term structure.

#### Calculation

The RCI Ribbon relies on the same calculation as the standard RCI. Each oscillator represents a scaled version of Spearman's rank correlation coefficient between prices and bar indices over one of the specified lookback periods. To calculate the RCI value, the indicator:

1. **Ranks the prices** by sorting them in ascending order. The position of each sorted price represents its initial rank. The lowest price has rank 0, and the rank of the highest price is N - 1, where N is the number of bars in the period. For example, if the analyzed prices are 10, 12, 15, and 12, their initial ranks are 0, 1, 3, and 2.
2. **Adjusts the ranks for ties**. If two or more prices are equal, it assigns each the average of their ordered positions as the final rank. For instance, the final ranks for the hypothetical prices shown in the previous step are 0, 1.5, 3, and 1.5, because the values with ranks 1 and 2 are equal, and the average of 1 and 2 is 1.5.
3. **Computes the correlation coefficient** between the sequences of price ranks and bar indices, then multiplies the value by 100.

The result oscillates within the range between -100 and +100, where:

* A value of +100 indicates that the prices consistently increased over the analyzed period
* A value of -100 indicates that the prices consistently decreased over the period
* A value near 0 indicates that the prices in the period have little to no directional consistency

This indicator calculates and plots three separate RCI oscillators:

* Short RCI (blue line)
* Middle RCI (red line)
* Long RCI (green line)

Additionally, it displays horizontal lines at the levels -80, 0, and +80. An oscillator value outside this range suggests strong upward or downward consistency across one of the periods. The alignment of positive or negative RCI values can indicate strengthening trends, especially if the values are near the edges of the range. Divergences between the oscillators can help traders identify short-term momentum shifts and potential mean reversion opportunities.

#### Inputs

#### Source

The source series that the indicator uses to calculate each RCI. By default, it uses the symbol's closing prices.

#### Short RCI Length

The number of bars in the short-term RCI calculation.

#### Middle RCI Length

The number of bars in the medium-term RCI calculation.

#### Long RCI Length

The number of bars in the long-term RCI calculation.