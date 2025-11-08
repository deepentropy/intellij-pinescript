#### 

#### Definition

Moving Average (MA) is a price based, lagging (or reactive) indicator that displays the average price of a security over a set period of time. A Moving Average is a good way to gauge momentum as well as to confirm trends, and define areas of support and resistance. Essentially, Moving Averages smooth out the “noise” when trying to interpret charts. Noise is made up of fluctuations of both price and volume. Because a Moving Average is a lagging indicator and reacts to events that have already happened, it is not used as a predictive indicator but rather an interpretive one, used for confirmations and analysis. In fact, Moving Averages form the basis of several other well-known technical analysis tools such as Bollinger Bands and the MACD. There are a few different types of Moving Averages which all take the same basic premise and add a variation. Most notable are the Simple Moving Average (SMA), the Exponential Moving Average (EMA) and the Weighted Moving Average (WMA).

#### Types

Moving Averages visualize the average price of a financial instrument over a specified period of time. However, there are a few different types of moving averages. They typically differ in the way that different data points are weighted or given significance.

##### Simple Moving Average (SMA)

Simple Moving Average is an unweighted Moving Average. This means that each day in the data set has equal importance and is weighted equally. As each new day ends, the oldest data point is dropped and the newest one is added to the beginning.

#### CALCULATION

An example of a 3 period SMA

```
Sum of Period Values / Number of Periods  
  
Closing Prices to be used: 5, 6, 7, 8, 9  
  
First Day of 3 Period SMA: (5 + 6 + 7) / 3 = 6  
Second Day of 3 Period SMA: (6 + 7 + 8) / 3 = 7  
Third Day of 3 Period SMA: (7 + 8 + 9) /3 = 8
```

##### Weighted Moving Average (WMA)

Weighted Moving Average is similar to the SMA, except the WMA adds significance to more recent data points. Each point within the period is assigned a multiplier (largest multiplier for the newest data point and then descends in order) which changes the weight or significance of that particular data point. Then, just like the SMA, once a new data point is added to the beginning, the oldest data point is thrown out.

###### Calculation

Is similar to the SMA except it adds a weight (multiplier) to each period. The most recent period has the most weight). An example of a 5 period WMA

```
  Sum of Period Values / Number of Periods   
  
Closing Prices to be used: 5, 6, 7, 8, 9  
  
Period        Weight          Price      Weighted Average  
    1           1        X      5              5  
    2           2        X      6              12  
    3           3        X      7              21  
    4           4        X      8              32  
    5           5        X      9              45  
  
TOTAL    =      15       X      35      =      525  
  
WMA = (Sum of Weighted Averages) / (Sum of Weight)  
  
WMA   115 / 15 = 7.6667
```

##### Exponential Moving Average (EMA)

Exponential Moving Average is very similar to (and is a type of) WMA. The major difference with the EMA is that old data points never leave the average. To clarify, old data points retain a multiplier (albeit declining to almost nothing) even if they are outside of the selected data series length.

###### Calculation

There are three steps to calculate the EMA. Here is the formula for a 5 Period EMA

1. Calculate the SMA

```
(Period Values / Number of Periods)
```

2. Calculate the Multiplier

```
(2 / (Number of Periods + 1) therefore (2 / (5+1) = 33.333%
```

3. Calculate the EMA  
For the first EMA, we use the SMA(previous day) instead of EMA(previous day).

```
EMA = {Close - EMA(previous day)} x multiplier + EMA(previous day)
```

##### Double Exponential Moving Average

###### Calculation

```
Double EMA = 2*EMA – EMA (EMA)
```

##### Triple Exponential Moving Average

###### Calculation

```
Triple EMA = (3*EMA – 3*EMA(EMA)) + EMA(EMA(EMA))
```

#### The basics

Moving Averages takes a set of data (closing prices over a specified time period) and outputs their average price. Now, unlike an oscillator, Moving Averages are not restricted to a number within a band or a set range of numbers. The MA can move right along with price.  
The timeframes or periods used can vary quite significantly depending on the type of technical analysis being done. One fact that most always be remembered however, is that Moving Averages have lag inherently built into them. What this means is actually pretty simple. The longer the timeframe being used, the more lag there will be. Likewise, the shorter the timeframe, the less lag there will be. Basically, Moving averages with shorter timeframes tend to stay close to prices and will move right after prices move. Longer timeframes have much more cumbersome data and their moves lag behind the market’s move much more significantly. As for what time frames should be used, it really is up to the trader’s discretion. Typically any period under 20 days would be considered short term, anything between 20 and 60 would be medium term and of course anything longer than 60 days would be viewed as long term.

Another option which boils down to the trader’s preference is which type of Moving Average to use. While all the different types of Moving Averages are rather similar, they do have some differences that the trader should be aware of. For example, the EMA has much less lag than the SMA (because it puts a greater importance on more recent prices) and therefore turns quicker than the SMA. However, since the SMA gives an equal weighting to all data points, no matter how recent, the SMA has a much closer relationship to areas of significance such as traditional Support and Resistance.

#### What to look for

When examining some of these common uses for Moving Averages, keep in mind that that it is the trader’s discretion which Moving Average in particular they wish to use. In the following examples, there will be written instances of; Moving Averages (MA), Simple Moving Averages (SMA), Exponential Moving Averages (EMA) and Weighted Moving Averages (WMA). Unless otherwise specified, these indicators can be considered interchangeable in terms of the governing principles behind their basic uses.

##### Basic Trend Identification

Using a Moving Average to confirm a trend in price is really one of the most basic, yet effecting ways of using the indicator. Consider that by design, Moving Averages “report” on what has already happened and that they also take into consideration a whole range of past events when calculating their formula. This is what makes a Moving Average such a good technical analysis tool for trend confirmations.  
The general rules of thumb are as follows:

* A Long-Term Moving Average that is clearly on the upswing is confirmation of a Bullish Trend.
* A Long-Term Moving Average that is clearly on the downswing is confirmation of a Bearish Trend.

Because of the large amounts of data considered when calculating a Long-Term Moving Average, it takes a considerable amount of movement in the market to cause the MA to change its course. A Long-Term MA is not very susceptible to rapid price changes in regards to the overall trend.

##### Support and Resistance

Another fairly basic use for Moving Averages is identifying areas of support and resistance. Generally speaking, Moving averages can provide support in an uptrend and also they can provide resistance in a downtrend. While this can work for shorter term periods (20 days or less), the support and resistance provided by Moving Averages, can become even more readily apparent in longer term situations.

##### Crossovers

Crossovers require the use of two Moving Averages of varying length on the same chart. The two Moving averages should be of two different term lengths. For example a 50 Day Simple Moving Average (medium-term) and a 200 Day Simple Moving Average (long-term) The signals or potential trading opportunities occur when the shorter term SMA crosses above or below the longer term SMA.  
*Bullish Crossover* – Occurs when the shorter term SMA crosses above the longer term SMA. Also known as a *Golden Cross*.

Bearish Crossover – Occurs when the shorter term SMA crosses below the longer term SMA. Also known as a *Dead Cross*;.

It is imperative however, that the trader realizes the inherent shortcomings in these signals. This is a system that is created by combining not just one but two lagging indicators. Both of these indicators react only to what has already happened and are not designed to make *predictions*. A system like this one definitely works best in a very strong trend. While in a strong trend, this system or a similar one can actually be quite valuable.

##### Price Crossovers

If you take the two Moving Averages setup that was discussed in the previous section and add in the third element of price, there is another type of setup called a Price Crossover. With a Price Crossover you start with two Moving Averages of different term lengths (just like with the previously mentioned Crossover). You basically use the longer term Moving Average to confirm long term trend. The signals then occur when Price crosses above or below the shorter term Moving Average going in the same direction of the main, longer term trend. Just like in the previous example, let’s use a 50 Day Simple Moving Average and a 200 Day Simple Moving Average.

*Bullish Price Crossover* – Price crosses above the 50 SMA while the 50 SMA is above the 200 SMA. The 200 SMA is confirming the trend. Price and short term SMA are generating signals in the same direction as the trend.

*Bearish Price Crossover* - Price crosses below the 50 SMA while the 50 SMA is below the 200 SMA. The 200 SMA is confirming the trend. Price and short term SMA are generating signals in the same direction as the trend.

#### Summary

An experienced technical analyst will know that they should be careful when using Moving Averages (Just like with any indicator). There is no doubt about the fact that they are trend identifiers. That can be quite a valuable bit of information. However, it is important to always be aware that they are lagging or reactive indicators. Moving Averages will never be on the cutting edge when it comes to predicting market moves. What they can do though, is just like many other indicators that have withstood the test of time, provide an added level of confidence to a trading strategy or system. When used in conjunction with more active indicators, you can at least be sure that in regards to the long term trend, you are looking to trade in the correct direction.

#### Inputs

##### Length

The time period to be used in calculating the Moving Average. 9 days is the default.

##### Source

Determines what data from each bar will be used in calculations. Close is the default.

##### Offset

Changing this number will move the Moving Average either Forwards or Backwards relative to the current market. 0 is the default.

#### Style

##### MA

Can toggle the visibility of the MA as well as the visibility of a price line showing the actual current value of the MA. Can also select the MA's color, line thickness and line style.