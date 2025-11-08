The Time Weighted Average Price (TWAP) is a trading indicator used to help traders manage their positions in the market. It is calculated by dividing the total value of a security traded over a specific period of time by the total number of shares traded during that period. The resulting value provides a simple and effective way to measure the average price at which a security is traded over a given timeframe.

TWAP is most commonly used to facilitate execution of bigger orders without excessive impact on the market price. The order is split into separate smaller orders which are executed with a delay between them to ensure that the size of the orders does not affect the market negatively. The TWAP value represents the average price for the specified period and can be used to automatically specify a proper price for the order.

#### Inputs

##### Anchor Period

Indicator calculation period. This setting specifies the Anchor, i.e. how frequently the TWAP calculation will be reset. For TWAP to work properly, each TWAP period should include several bars inside of it, so e.g. setting both and timeframe to '1D' is not useful because the indicator will be reset on every bar.

Adding a new custom timeframe through the Interval menu above the chart will also add said timeframe to the Anchor Period dropdown in the indicator settings.

##### Source

The source for the TWAP calculation. Traditionally, the bar's average value is used as the source. By default, the source is ohlc4.

##### Offset

Changing this number will move the TWAP either Forwards or Backwards, relative to the current market. Zero is the default.