package com.java.YahooFinanceAPI;

import com.github.signaflo.timeseries.TimeSeries;
import com.github.signaflo.timeseries.forecast.Forecast;
import com.github.signaflo.timeseries.model.arima.Arima;
import com.github.signaflo.timeseries.model.arima.ArimaOrder;

import static com.github.signaflo.data.visualization.Plots.plot;

import java.io.IOException;

/**
 * The 'SPYBenchmark' class achieves two main purposes - 1. Run ARIMA model on
 * SPY (SPDR S&P 500 ETF Trust) to predict the future price trend of next 21
 * trading days; 2. Find the slope of the trend (linear regression) and set as a
 * benchmark.
 */

public class SPYBenchmark {

    /**
     * This method calculate the slope for SPY benchmark or user selected stock for
     * getting the investment recommendation.
     * 
     * @param ticker
     * @return the slope for further analysis
     */
    public double getBenchmark(String ticker) {
        YahooFinanceDataReader reader = new YahooFinanceDataReader();
        try {
            reader.getStock(ticker); // hard coded SPY ETF ticker
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        double[] prices = new double[180];
        try {
            // received the closing prices of past 180 calendar days.
            prices = reader.generatePriceList(180);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        TimeSeries series = TimeSeries.from(prices);
        // Set the Arima analysis parameter, p is the order (number of time lags) of the
        // autoregressive model, d is the degree of differencing (the number of times
        // the data have had past values subtracted), and q is the order of the
        // moving-average model."
        ArimaOrder modelOrder = ArimaOrder.order(3, 1, 2, 3, 1, 2);

        Arima model = Arima.model(series, modelOrder); // feed time series and modelOrder into ARIMA
                                                       // model

        // hard coded for next 21 trading days
        Forecast forecast = model.forecast(21);

        plot(forecast.pointEstimates(), ticker.toUpperCase() + " Predicted Price");

        TimeSeries FP = forecast.pointEstimates();

        double[] fprices = FP.asArray();

        // find the slope
        Point p1 = new Point(1, fprices[0]);
        Point p2 = new Point(2, fprices[6]);
        Point p3 = new Point(2, fprices[20]);

        findSlope STSlope = new findSlope(p1, p2); // short term
        findSlope LTSlope = new findSlope(p1, p3); // long term

        double STS = STSlope.getSlope();
        double LTS = LTSlope.getSlope();

        if (ParametersWindow.getInvestTerm().equals("S")) {
            return STS;
        }
        else {
            return LTS;
        }
    }

}