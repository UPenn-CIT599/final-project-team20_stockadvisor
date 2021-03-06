package com.java.YahooFinanceAPI;

import com.github.signaflo.timeseries.TimeSeries;
import com.github.signaflo.timeseries.forecast.Forecast;
//import com.github.signaflo.timeseries.model.Model;
import com.github.signaflo.timeseries.model.arima.Arima;
import com.github.signaflo.timeseries.model.arima.ArimaOrder;

import static com.github.signaflo.data.visualization.Plots.plot;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TimeSeriesExample {
    
    public static void main(String[] args) throws IOException {
     int days = 10;
        
        YahooFinanceDataReader reader = new YahooFinanceDataReader();
        reader.getStock("NKE");
        double[] prices = reader.generatePriceList(180);

        TimeSeries series = TimeSeries.from(prices);

        ArimaOrder modelOrder = ArimaOrder.order(0, 1, 1, 0, 1, 1); // Note that intercept fitting will automatically be turned off
        Arima model = Arima.model(series, modelOrder);
        
        System.out.println(model.aic()); // Get and display the model AIC
        
        System.out.println("LOL");
        
        System.out.println(model.coefficients()); // Get and display the estimated coefficients
        
        System.out.println("LOL2");
        
        System.out.println(java.util.Arrays.toString(model.stdErrors()));
        plot(model.predictionErrors(), "Prediction Errors");
        Forecast forecast = model.forecast(days); // To specify the alpha significance level, add it as a second argument.
        plot(forecast.pointEstimates(), "Price Change");
        TimeSeries FP = forecast.pointEstimates();
        double[] fprices = FP.asArray();
        System.out.println(java.util.Arrays.toString(fprices));
        
        ArrayList<Double> Adjust_Price  = new ArrayList<Double>();
        
        double starterPrice = prices[109];

        //System.out.println("HELLO"+Arrays.toString(prices));
        //System.out.println("FINAL" + starterPrice);
        
        for (int i = 0; i < fprices.length; i++) {
        	starterPrice = starterPrice + fprices[i];
        	Adjust_Price.add(starterPrice);
        }
        
 /**       ArrayList<Double> Adjust_Price_FINAL12  = new ArrayList<Double>();
        for (int i = 59; i < Adjust_Price.size(); i++) {
        	Adjust_Price_FINAL12.add(Adjust_Price.get(i));
        }
        
    **/    
        System.out.println(Adjust_Price);
        //plot(Adjust_Price);
        
        
    }

}