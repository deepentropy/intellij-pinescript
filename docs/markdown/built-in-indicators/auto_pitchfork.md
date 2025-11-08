#### Definition

Auto Pitchfork is a tool that aims to identify possible support and resistance levels and forecast the future price movement based on the previous trends. Auto pitchfork is an indicator that draws the Pitchfork drawing tool automatically based on past price movement.

  

The basic idea behind the use of a pitchfork is that it essentially creates a type of trend channel. A trend is considered active as long as price stays within the Pitchfork channel. Reversals occur when price breaks out of a Pitchfork channel. The pitchfork has a center median line (trend line) as well as two more sets of lines above and below that median line. The additional lines are set a specified number of standard deviations away from the median.

The indicator is written in Pine Script and its source code can be accessed, copied and modified. You can access it from the Source code icon to the right of the indicator's name on the chart, or from the Pine Editor, by using the Open button, then clicking on New default built-in script… and finding Auto Pitchfork in the menu there.

  

#### Inputs

  

#### Depth

The minimum number of bars that will be taken into account when calculating the indicator. Increasing this number will result in pitchforks that skip smaller price peaks and troughs in favor of bigger ones. For example, with Depth set to 10, each of the three points found by the indicator must be highest or lowest among the nearest 10 bars (five on the left and five on the right).

#### Type

There are four different types of Auto Pitchfork, based on four different Pitchfork drawings available on TradingView. Changing the option changes the calculation of the pitchfork’s slope, which allows the indicator to react to the price slopes it found differently.

The indicator is drawn using three points, and the slope is based on how these points are used to draw the median:

* Original. The median connects the first point found by the indicator with the middle of the line connecting points 2 and 3.
* Schiff. An additional point is calculated, based on the X coordinate of the point 1 and the Y coordinate of the middle between point 1 and point 2. The median connects that additional point to the middle of the line between points 2 and 3.
* Modified Schiff. The median connects the middle of the line between points 1 and 2 to the middle of the line between points 2 and 3.
* Inside. The median connects the middle of the line between points 1 and 2 to point 3.

#### Background Transparency

The transparency of the background between the Pitchfork lines, from 0 (fully visible) to 100 (fully transparent).

#### Extend Left

If selected, the pitchfork lines will extend both ways.

#### Level settings

Level settings allow you to tweak each level of the pitchfork separately. You can change the visibility (turn on/off), Fibonacci ratio used to calculate the line, color that the line and its background use, width of the line, and its type.