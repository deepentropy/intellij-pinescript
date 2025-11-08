#### Definition

The Stochastic Momentum Index (SMI) Ergodic indicator works much like the True Strength Index, except it uses a signal line in its market analysis. By providing double moving averages of price minus the price of the previous price over two timeframes to traders, the SMI Ergodic indicator is able to trigger helpful trading signals. The signal line that aids this effort is an Exponential Moving Average (EMA) of the SMI indicator itself.

#### Calculations

The following is a condensed code for the SMI Ergodic indicator.

//price (user defined, default is closing price)

//method = moving average (user defined, default is EMA)

//prevP = previousPrice

//abs = absolute value

//ma = moving average, index = current bar number

//MT = moreThan

//LT = lessThan

prevP = price[index-1];

change = price - prevP;

absChange = abs(price - prevP);

tempChange = ma(method, index, fastPeriod, change);

tempAbsC = ma(method, index, fastPeriod, absChange);

tempChange = ma(method, index, slowPeriod, tempChange);

tempAbsC = ma(method, index, slowPeriod, tempAbsC);

Plot1: SMI = tempChange / tempAbsC;

Plot2: SIGNAL = ma(method, index, sigPeriod, SMI);

//Signals

highSell = smi for last sell signal, reset to max\_negative at each  buy signal;

lowBuy = smi for last buy signal, reset to max\_positive at each sell signal;

sell=crossedBelow(SMI, SIGNAL) AND smi MT topGuide  AND smi MT highSell;

buy=crossedAbove(SMI, SIGNAL) AND smi LT bottomGuide AND smi LT lowBuy;

#### Takeaways and what to look for

In order to control both the quality and quantity of trading associated with this indicator, the trader should look into adjusting the top and bottom guides of the Stochastic Momentum Index. If the signal line is crossed by the SMI, this points to a change in trend. A sell signal is sent to the trader if the SMI is above the top guide and then crosses below the SMI signal line. Inversely, a buy signal is sent to the trader if the SMI is below the bottom guide and then crosses the signal line.

While using this indicator, the 0 that can be seen on the chart divides the bulls from the bears. The bulls are shown above and the bears reference below the signal line.

#### Summary

The SMI Ergodic indicator uses a signal line in its market analysis and shows double moving averages of price minus the price of the previous price over two timeframes. These timeframes can be adjusted and reset by the trader based on preference and trade needs. The indicator triggers helpful trading signals to the trader to aid them in their market analysis.