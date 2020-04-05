package com.java.YahooFinanceAPI;

import java.util.ArrayList;

/**
 * This class processes the data of the user selected stock based on the user
 * inputs
 */
public class DataProcessor {
    private YahooFinanceDataReader reader;
    private ARIMAAnalysis AST;
    private ARMAAnalysis ALT;
    private String stockSymbol;
    private ArrayList<Double> prices;

    /**
     * Constructs data processor based on stock symbol
     * 
     * @param symbol
     */
    public DataProcessor(String symbol) {

    }

    /**
     * Constructs data processor
     * 
     */
    public DataProcessor() {
        
    }

    /**
     * This method calculates the average prices within the date range. It will be
     * used for comparison.
     * 
     * @param prices ArrayList of stock's close price within the date range.
     * @return average price
     */
    public double calculateAverage(ArrayList<Double> prices) {
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        double average = 0;
        if (prices.size() == 0) {
            average = -9999;
        }
        else {
            average = sum / prices.size();
        }
        return average;
    }

    /**
     * This method deals with data processing
     */
    public void dataProcessing() {

        UserInput input = new UserInput();
        System.out.println("Please enter your investment term, L for long term, S for short term");
        System.out.println("Long term for holding 180 days, short term for holding 14 days");
        String term = input.readInvestmentHorizon();

        double average_history = calculateAverage(prices);

        if (term == "L") {
            // Run ARMA
            double forcast_ARMA = ALT.runARMA();
            if (forcast_ARMA > average_history) {
                System.out.println("You can overweight the stock");
            }
            else {
                System.out.println("Please consider to underweight the stock");
            }

        }
        else {
            // Run ARIMA
            double forcast_ARIMA = AST.runARIMA();
            if (forcast_ARIMA > average_history) {
                System.out.println("You can overweight the stock");
            }
            else {
                System.out.println("Please consider to underweight the stock");
            }
        }

    }
}
