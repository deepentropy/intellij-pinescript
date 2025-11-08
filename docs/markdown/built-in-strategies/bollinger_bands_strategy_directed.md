#### Definition

"Strategy Direction" specifies what types of orders the strategy is allowed to create. If the setting value is 0, it can be both long and short. If the setting is -1 it can only short and if it’s 1 it can only go long. The Bollinger Bands Strategy Direction enters long when the symbol crosses below the lower band of the Bollinger bands and it enters short if the symbol crosses above the upper band. But remember, in the strategy settings you can adjust the direction to be only long, only short or both.

#### Calculations

##### Pine Script

Pine Script®

//@version=5  
strategy("Bollinger Bands Strategy directed", overlay=true)  
source = close  
length = input.int(20, minval=1)  
mult = input.float(2.0, minval=0.001, maxval=50)  
direction = input.int(0, title = "Strategy Direction", minval=-1, maxval=1)  
strategy.risk.allow\_entry\_in(direction == 0 ? strategy.direction.all : (direction < 0 ? strategy.direction.short : strategy.direction.long))  
basis = ta.sma(source, length)  
dev = mult \* ta.stdev(source, length)  
upper = basis + dev  
lower = basis - dev  
if (ta.crossover(source, lower))  
    strategy.entry("BBandLE", strategy.long, stop=lower, oca\_name="BollingerBands", oca\_type=strategy.oca.cancel, comment="BBandLE")  
else  
    strategy.cancel(id="BBandLE")  
if (ta.crossunder(source, upper))  
    strategy.entry("BBandSE", strategy.short, stop=upper, oca\_name="BollingerBands", oca\_type=strategy.oca.cancel, comment="BBandSE")  
else  
    strategy.cancel(id="BBandSE")  
//plot(strategy.equity, title="equity", color=color.red, linewidth=2, style=plot.style\_areabr)

Expand 15 lines

#### Summary

The Bollinger Bands Strategy Directed was created to buy or sell when a symbol is potentially overextended from its average price. For example, the strategy can be directed to buy if a symbol falls below its lower Bollinger Band or sell if it goes above its upper Bollinger Band. Some traders might view this as mean reversion because Bollinger Bands are created using a standard deviation of a symbols average price. Remember, the strategy is directed and in the settings you can control the value i.e. if it’s 0 it will be both long and short. If the setting is -1 it can only short and if it’s 1 it can only go long.