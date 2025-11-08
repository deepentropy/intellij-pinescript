#### Definition

The Arnaud Legoux Moving Average (ALMA) is different from other moving averages because of its specific design to use Gaussian distribution that is shifted with a calculated offset in order for the average to be biased towards more recent days, instead of more evenly centered on the window. Built on the generalized Moving Average Framework, ALMA is able to use various indicators in conjunction with its own capabilities and run on multiple time frames, with the inclusion of custom bar types.

#### History

The Arnaud Legoux Moving Average (ALMA) indicator was developed by both Arnaud Legoux and Dimitrios Douzis-Loukas while trying to create a new and improved moving average that would showcase advanced smoothness and responsiveness in comparison to other moving averages at the time of its development. Legoux claimed the ALMA moving average was inspired significantly by the Gaussian Filter and often compares his developed moving average to the Hull Moving Average (HMA), which is said to be outperformed by the ALMA in effectiveness and smoothness.

#### Calculations

1. To calculate the Arnaud Legoux Moving Average (ALMA) you’ll first need to compute a weighted sum of the window's size using your input series and weights given by a Gaussian function with a peak value determined by the offset, and a width determined by sigma.
2. This weighted sum is then divided by the total sum of the weights.

#### Takeaways

The main goal of the Arnaud Legoux Moving Average (ALMA) is to generate the most reliable signals in comparison to other moving averages. To accomplish this, ALMA applies the average from left to right, then right to left, in turn, creating a combo line. The combo signal, as a result, adjusts accordingly by applying a Gaussian Offset that can adjust the combo line to the current price and a sigma.

#### What to look for

The Arnaud Legoux Moving Average has three elements to it:

Window: This element is the period. By default, the window is set to 9 periods, but it can be customized to fit any trading style.

Offset: This element is the Gaussian that is applied to the combo line and can be aligned to the current price. It’s default is set to 0.85, but by setting it to 1, you can make it align fully to the current price (similar to how an Exponential Moving Average (EMA) with a setting of 0 is like a Simple Moving Average (SMA)). 0.85 is what is recommended, however, you can customize it like with the window element.

Sigma: This element is a standard deviation that is applied to the combo line in order for it to appear more sharp. The default is set to 6 and it is not recommended to change the setting. The value of 6 is inspired by the Six Sigma process.

#### Summary

To sum up, the Arnaud Legoux Moving Average is a moving average that is geared specifically for optimal smoothness and responsiveness. It was created to be set apart as a superior moving average at the time of its development and is often considered a prime average that is followed by many traders and investors for market screening. To follow this average without access to it in your screener, just adjust your preferred Exponential Moving Average (EMA) and/or Simple Moving Average (SMA) settings as described in the section above titled.