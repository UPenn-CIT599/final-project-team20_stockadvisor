package com.java.YahooFinanceAPI;



import com.github.signaflo.timeseries.TimeSeries;
import com.github.signaflo.timeseries.forecast.Forecast;
//import com.github.signaflo.timeseries.model.Model;
import com.github.signaflo.timeseries.model.arima.Arima;
import com.github.signaflo.timeseries.model.arima.ArimaOrder;

import static com.github.signaflo.data.visualization.Plots.plot;

import java.io.IOException;

public class TimeSeriesExample {
    
    public static void main(String[] args) throws IOException {
        
        YahooFinanceDataReader reader = new YahooFinanceDataReader();
        reader.getStock("GOOGL");
        double[] prices = reader.generatePriceList(180);

        TimeSeries series = TimeSeries.from(prices);

        ArimaOrder modelOrder = ArimaOrder.order(0, 1, 1, 0, 1, 1); // Note that intercept fitting will automatically be turned off
        Arima model = Arima.model(series, modelOrder);
        
        System.out.println(model.aic()); // Get and display the model AIC
        System.out.println(model.coefficients()); // Get and display the estimated coefficients
        System.out.println(java.util.Arrays.toString(model.stdErrors()));
        plot(model.predictionErrors());
        Forecast forecast = model.forecast(12); // To specify the alpha significance level, add it as a second argument.
        System.out.println(forecast);
    }
    
}
