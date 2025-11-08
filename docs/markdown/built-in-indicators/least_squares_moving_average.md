#### Definition

Least Squares Moving Average is a curve showing linear regression calculations. On each bar, the indicator displays a linear regression based on the prices for a period that is specified by the Length value in settings.

#### Calculations

##### Pine Script

```
//@version=5
indicator(title = "Least Squares Moving Average", shorttitle="LSMA", overlay=true, timeframe="", timeframe_gaps=true)
length = input(title="Length", defval=25)
offset = input(title="Offset", defval=0)
src = input(close, title="Source")
lsma = ta.linreg(src, length, offset)
plot(lsma)
```

#### Summary

The Least Squares Moving Average can be used as a trend indicator and reversal indicator. It is used as an alternative to other traditional indicators like the moving average or exponential moving average. The Least Squares Moving Average has a different calculation than both of those moving averages. The indicator displays a linear regression based on the prices for a specific period of time. This period of time can be defined in the indicator settings.