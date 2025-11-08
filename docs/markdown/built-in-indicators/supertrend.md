#### 

#### Definition

Supertrend is a trend-following indicator based on Average True Range (ATR). The calculation of its single line combines trend detection and volatility. It can be used to detect changes in trend direction and to position stops.

#### History

The Supertrend indicator was created by Olivier Seban.

#### Calculations

To calculate bands of the Supertrend, use the following formulas:

```
hl2 = (high + low) / 2  
basicUpperBand = hl2 + (multiplier × ATR)  
basicLowerBand = hl2 - (multiplier × ATR)  
  
upperBand = basicUpperBand < prev upperBand or  
			prev close > prev upperBand ? basicUpperBand : prev upperBand  
lowerBand = basicLowerBand > prev lowerBand or  
			prev close < prev lowerBand ? basicLowerBand : prev lowerBand  
  
superTrend = trendDirection == isUpTrend ? lowerBand : upperBand
```

The trendDirection is determined based on the fulfillment of the following conditions:

```
Until the ATR value is calculated trendDirection = isDownTrend  
else if prev superTrend == prev upperBand  
    trendDirection := close > upperBand ? isUpTrend : isDownTrend  
else  
    trendDirection := close < lowerBand ? isDownTrend : isUpTrend
```

#### The basics

The Supertrend is a trend-following indicator. It is overlaid on the main chart and their plots indicate the current trend. A Supertrend can be used with varying periods (daily, weekly, intraday etc.) and on varying instruments (stocks, futures or forex).

The Supertrend has several inputs that you can adjust to match your trading strategy. Adjusting these settings allows you to make the indicator more or less sensitive to price changes.

For the Supertrend inputs, you can adjust atrLength and multiplier:

* the atrLength setting is the lookback length for the ATR calculation;
* multiplier is what the ATR is multiplied by to offset the bands from price.

#### What to look for

When the price falls below the indicator curve, it turns red and indicates a downtrend. Conversely, when the price rises above the curve, the indicator turns green and indicates an uptrend. After each close above or below Supertrend, a new trend appears.

#### Summary

The Supertrend helps you make the right trading decisions. However, there are times when it generates false signals. Therefore, it is best to use the right combination of several indicators. Like any other indicator, Supertrend works best when used with other indicators such as MACD, Parabolic SAR, or RSI.

Also read:

* How to trade on TradingView
* Paper Trading — main functionality
* The technical analysis essentials
* Introduction to fundamental analysis
* Portfolios: track your assets, know your trades