#### Definition

The Pivot Extension Strategy is based on Pivot Points. The strategy scans the last X+Y bars (where X and Y are leftBars and rightBars inputs in the indicator settings) to find a pivot. When a high pivot is located, the strategy will open a short position. If a low pivot is found, it will enter a long. Note that the strategy will lag Y bars behind because the chart needs to draw Y new bars after a potential pivot to detect the pivot.

#### Summary

The Pivot Extension Strategy was created for pivot traders and those looking for swing trades or specific levels of support and resistance. When a high pivot occurs, the strategy will open a short position and when a low pivot occurs, it will enter a long position. What’s important to note is that the strategy scans the last X+Y bars, which are inputs in the strategy settings as leftBars and rightBars. It’s important for the user to define these bars to make the strategy work effectively.