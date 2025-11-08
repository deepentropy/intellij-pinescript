#### Definition

The BarUpDn strategy enters a long position if the current bar is green (close > open) and opens above the close of the previous bar. If the current bar is red and its open is below the close of the previous bar, it will enter short. If the loss percent per day exceeds the number specified in the indicator settings, all positions will be closed.

#### Calculations

##### Pine Script code

```
//@version=5
strategy("BarUpDn Strategy", overlay=true, default_qty_type = strategy.percent_of_equity, default_qty_value = 10)
maxIdLossPcnt = input.float(1, "Max Intraday Loss(%)")
strategy.risk.max_intraday_loss(maxIdLossPcnt, strategy.percent_of_equity)
if (close > open and open > close[1])
	strategy.entry("BarUp", strategy.long)
if (close < open and open < close[1])
	strategy.entry("BarDn", strategy.short)
//plot(strategy.equity, title="equity", color=color.red, linewidth=2, style=plot.style_areabr)
```

#### Conclusion

The BarUpDn strategy is based on whether or not a specific bar is green and higher than the previous bar or red and lower than the previous bar. The strategy is looking for quick changes in price and attempting to trade those changes, potentially jumping into the start of an uptrend or a downtrend. The BarUpDn strategy is also relatively simple and can be used as an educational starting point for those new to Pine strategies.