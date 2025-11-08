#### Definition

Moving Average Envelopes (ENV) are a banded indicator. ENV displays an upper envelope above a basis line and a lower envelope below the basis line. The basis line is a moving average, either a simple moving average or an exponential moving average. The envelopes are set a (user defined) percentage away from the basis line. Envelopes are a good indicator for trend identification as well as identifying overbought and oversold conditions.

#### Calculation

A Moving Average Envelope (ENV) is actually fairly simple to calculate. For this example we will use a 20 Period SMA with 10% Envelopes:

```
Basis = 20 Period SMA

Upper Envelope = 20 Period SMA + (20 Period SMA x 0.1)

Lower Envelope = 20 Period SMA - (20 Period SMA x 0.1)
```

#### The basics

Moving Average Envelopes (ENV) are a trend following indicator. Because moving averages lag behind price, the envelopes will as well. That being said, any price movements that break through either of the envelopes should not go unnoticed. ENV is designed to have the majority of price action occur within the envelopes. Therefore, when price breaks through, this is a sign of strength and can indicate a significant price move. For example, in an strong trend (in either direction) a breakthrough above the upper envelope may indicate that the uptrend is strengthening and will continue. Another example is that during a sideways trend, a breakthrough above the upper envelope may signal an overbought condition leading to price falling back within the envelopes.

As with many indicators, the trick to using ENV efficiently and effectively is using the correct parameters. This is the difficult part. This mostly comes by experimentation and experience. Historical analysis can also help the technical analyst to discover historical levels for a particular security. Another technique is overlaying several Moving Average Envelopes onto each other and setting the envelopes varying percentages away. This can give the technical analyst additional breakthrough points to consider.

#### What to look for

##### Trend Confirmation

Frequently, during a strong, clearly defined trend, a breakthrough into overbought or oversold territory is a sign of strength. This can be used to confirmed the likelihood of a continuing trend.

During a Bullish Trend, a breakthrough above the upper envelope can be seen as a sign of strength and the uptrend is likely to continue.

During a Bearish Trend, a breakthrough below the lower envelope can be seen as a sign of strength and the downtrend is likely to continue.

##### Overbought and Oversold

When a market is choppy or trading sideways, Moving Average Envelopes can be useful for identifying overbought and oversold conditions. These conditions can typically lead to price corrections where price moves back towards the moving average.

#### Summary

Despite having a very simple premise, Moving Average Envelopes (ENV) can actually be quite effective. Being able to help identify trends as well as overbought and oversold conditions is a valuable trait in an indicator and one that can greatly help technical analysts. When combined with additional technical analysis tools such as pattern analysis or momentum indicators, ENV can become an integral part of a sound trading strategy.

#### Inputs

##### Length

The time period to be used in calculating the MA which creates the base for the Upper and Lower Envelopes (20 is the default).

##### Percent

The percentage to be applied to the bands.

##### Source

Determines what data from each bar will be used in calculations. Close is the default.

##### Exponential

Determines if a simple or exponential moving average will be used for the basis.

##### STYLE

##### Basis

Can toggle the visibility of the Basis as well as the visibility of a price line showing the actual current value of the Basis. Can also select the Basis' color, line thickness and line style.

##### Upper

Can toggle the visibility of the Upper Band as well as the visibility of a price line showing the actual current value of the Upper Band. Can also select the Upper Band's color, line thickness and line style.

##### Lower

Can toggle the visibility of the Lower Band as well as the visibility of a price line showing the actual current value of the Lower Band. Can also select the Lower Band's color, line thickness and line style.

##### Background

Toggles the visibility of a Background color within the Bands. Can also change the Color itself as well as the opacity.