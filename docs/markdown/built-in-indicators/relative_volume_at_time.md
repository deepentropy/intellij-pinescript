#### Definition

Volume is the total amount of assets traded within a specific period of time. The Relative Volume at Time indicator compares the regular or cumulative volume at a particular moment within a period to its average over similar historical time points. This comparison helps identify uncharacteristically large fluctuations in trading activity relative to historical expectations at a given time.

#### Calculation

To understand the logic behind this indicator, one should first understand how it chooses the data points for its calculations. The indicator checks the time offset between the current bar and the start (anchor) of the most recent period, then selects the bars with corresponding time differences from a specified number of historical anchors. The indicator calculates the average volume using the selected data points from each period. The "Anchor Timeframe" input defines the size of each period. A new period begins whenever a new bar opens on the specified timeframe. The "Length" input governs the number of periods the indicator includes in its average.

For example, suppose the Anchor Timeframe is one day, the Length is 5, and the chart uses the 30m timeframe. In this scenario, let's say each period starts at 9:30, and let's say the current time is 12:15, meaning the most recent bar's opening time is 12:00. In this case, the indicator will calculate the time offset of the last bar from the start of the current period (12:00 - 9:30 = 2 hours and 30 minutes), then find all bars over the last five days that opened 2.5 hours after the start of their respective periods. After that, it will calculate the average volume from these bars and plot the ratio of the current volume value to this average value on the chart, i.e., current volume divided by average volume.

The last setting, Calculation Mode, controls the type of volume used in the calculation:

* With Cumulative (by default), the indicator uses the total volume accumulated since the last period anchor. In the context of the example above, it would calculate the total volume in the current period from 9:30 to 12:15 and the average volume accumulation from 9:30-12:30 over five days.
* With Regular, the indicator uses the non-cumulative volume at the time offset. The example above would use the value from the current 12:00 bar and calculate the historical average of corresponding values over five days.

Note the current value will be lower than it should be in both cases, as the most recent bar is not yet closed. The difference is less significant when using Cumulative mode, especially on a period's latter bars, as the value on a bar represents the volume accumulated up to that point within the period. Switching to a lower timeframe can help improve the fidelity of the calculation by decreasing the time that the current bar remains open.

If a historical period does not have a bar at a specific offset from its anchor, the indicator will use the last available bar before that offset in its calculations.

#### Inputs

#### 

#### Anchor Timeframe

Specifies the size of the period used in the Relative Volume calculation, as described in the Calculation section above. If the "Anchor Timeframe" value is less than or equal to the chart's timeframe, the period will reset on every chart bar, which means the indicator will only use the last N bars in its calculation (where N is the "Length" value).

#### Length

Specifies the number of historical periods used in the average volume calculation at the current time point.

#### Calculation Mode

Specifies the type of volume used in the calculation. If Cumulative, the indicator uses accumulated volume from the beginning of each period. If Regular, it uses non-cumulative volume.