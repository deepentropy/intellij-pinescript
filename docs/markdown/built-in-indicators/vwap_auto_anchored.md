VWAP Auto Anchored is an indicator that displays a Volume Weighted Average Price calculation for a single user-defined period. The general VWAP calculation mechanism and the basics of the concept are described in this Help Center article.

VWAP Auto Anchored differs from other VWAP indicators and drawings in that it’s automatically tied to the beginning of the last period available on the chart and is only displayed from that point.

Please note that the VWAP Auto Anchored indicator is not written in Pine and thus there is no way to examine its source code.

#### Inputs

##### Anchor Period

Anchor Period specifies the anchor of the VWAP calculation, i.e. how often VWAP recalculates and where it starts. The available options are:

*Auto*- The starting point of the VWAP calculation depends on the timeframe on the chart:

* "Session" on all intraday timeframes
* "Month" on the 1D timeframe
* "Quarter" on all timeframes between 2D and 10D
* "Year" on all timeframes between 11D and 60D
* "Decade" on all timeframes above 61D

*Highest High* - VWAP starts on the bar with the highest high among the last X bars, where X is specified in the Length argument.

*Lowest Low*- VWAP starts on the bar with the lowest low among the last X bars, where X is specified in the Length argument.

*Highest Volume* - VWAP starts on the bar with the highest volume among the last X bars, where X is specified in the Length argument.

*Session*- VWAP starts at the beginning of the last daily session.

*Week*- VWAP starts at the beginning of the last week.

*Month*- VWAP starts at the beginning of the last month.

*Year*- VWAP starts at the beginning of the last year.

*Quarter*- VWAP starts at the beginning of the last quarter (three-month period: Jan-Mar, Apr-Jun, Jul-Sep, Oct-Dec).

*Decade*- VWAP starts at the beginning of the last decade.

*Century*- VWAP starts at the beginning of the last century.

*Earnings*- VWAP starts at the bar with the last earnings report for the current symbol.

*Dividends*- VWAP starts at the bar with the last dividends report for the current symbol.

*Splits*- VWAP starts at the bar with the last split for the current symbol.

##### Source

The source for the VWAP calculation. Traditionally, the bar's average value is used as the source. By default, the source is hlc3, but hl2 is another common option.

This option does not affect the Anchor Period calculation, i.e. the Highest High anchor always compares the ‘high’ data, no matter what is chosen as the source.

##### Length

A rolling window that specifies the number of bars that the indicator analyses when searching for the anchor. Applies only to Highest High, Lowest Low, and Highest Volume anchor periods. E.g. with the Highest High anchor period and the length of 100, the indicator will search for the last 100 bars for the bar with the highest ‘high’ value to start the VWAP calculation on.

##### Bands Calculation mode

Determines the units used to calculate the distance of the bands. When 'Percentage' is selected, a multiplier of 1 means 1%.

##### Bands Multiplier

The value the Standard Deviation bands will be multiplied by before being plotted on the chart.

##### Offset

Changing this number will move the VWAP either Forwards or Backwards, relative to the current market. Zero is the default.

#### Style

##### VWAP

Can toggle the visibility of the VWAP as well as the visibility of a price line showing the actual current value of the VWAP. Can also select the VWAP Line's color, line thickness, and line style.

##### Upper Band #1-3, Lower Band #1-3

Can toggle the visibility of the VWAP standard deviation bands and set their colors and line types.

##### Backround

Can change whether to fill the space between the standard deviation bands and tune the color.

##### Precision

Sets the number of decimal places to be left on the indicator's value before rounding up. The higher this number, the more decimal points will be on the indicator's value.