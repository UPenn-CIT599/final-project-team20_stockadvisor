package com.java.YahooFinanceAPI;

import com.github.signaflo.timeseries.TimeSeries;
import com.github.signaflo.timeseries.forecast.Forecast;
import com.github.signaflo.timeseries.model.arima.Arima;
import com.github.signaflo.timeseries.model.arima.ArimaOrder;

import static com.github.signaflo.data.visualization.Plots.plot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * The 'SPYBenchmark' class achieves two main purposes - 
 * 1. Run ARIMA model on SPY (SPDR S&P 500 ETF Trust) to predict the future price trend of next 12 trading days;
 * 2. Find the slope of the trend (linear regression) and set as a benchmark. 
 */

public class SPYBenchmark {
	
	//constructor
	public SPYBenchmark() {
	}
	
    public double getBenchmark(String ticker) {
        YahooFinanceDataReader reader = new YahooFinanceDataReader();        
        try {
			reader.getStock(ticker); //hard coded SPY ETF ticker
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
        double[] prices = new double [180];
		try {
			prices = reader.generatePriceList(180); //received the closing prices of past 180 trading days. 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        TimeSeries series = TimeSeries.from(prices);
        ArimaOrder modelOrder = ArimaOrder.order(3, 1, 2, 3, 1, 2); // Note that intercept fitting will automatically be turned off
        
        Arima model = Arima.model(series, modelOrder); //feed timeseries and modelOrder into ARIMA model
        
        Forecast forecast = model.forecast(21); //To specify the alpha significance level, add it as a second argument.
        //hard coded for next 12 trading days
        plot(forecast.pointEstimates(), ticker.toUpperCase() + " Predicted Price");
        
        TimeSeries FP = forecast.pointEstimates();
        
        double[] fprices = FP.asArray();
//        System.out.println(Arrays.toString(fprices));
        
        //find the slope
        Point p1 = new Point(1,fprices[0]);
        Point p2 = new Point(2,fprices[11]);
        findSlope spySlope = new findSlope(p1,p2);
        
//        ArrayList<Double> Adjust_Price  = new ArrayList<Double>();
////        double starterPrice = prices[0];
////
////        for (int i = 0; i < fprices.length; i++) {
////        	starterPrice = starterPrice + fprices[i];
////        	Adjust_Price.add(starterPrice);
////        }
//        
// /**       ArrayList<Double> Adjust_Price_FINAL12  = new ArrayList<Double>();
//        for (int i = 59; i < Adjust_Price.size(); i++) {
//        	Adjust_Price_FINAL12.add(Adjust_Price.get(i));
//        }
//        
//    **/    
//        //System.out.println(Adjust_Price);
//        
//        //find the slope
//        Point p11 = new Point(1,Adjust_Price.get(0));
//        Point p22 = new Point(2,Adjust_Price.get(11));
//        findSlope spySlopeAdjustPrice = new findSlope(p1,p2);
//       // System.out.println("Adjust Price Slope = " + spySlopeAdjustPrice.getSlope());
//        
        return spySlope.getSlope();
    }

}