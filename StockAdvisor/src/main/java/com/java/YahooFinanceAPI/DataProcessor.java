package com.java.YahooFinanceAPI;

import java.util.*;

/**
 * This class processes the data of the user selected stock based on the user
 * inputs
 */
public class DataProcessor {
    private YahooFinanceDataReader reader;
    private ARIMAAnalysis AST;
    private ARMAAnalysis ALT;
    private ArrayList<Double> prices;
    private String recommendation;

    /**
     * Constructs data processor
     */
    public DataProcessor() {
        prices = reader.getHistoricalPrices();
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
            // The denominator of division function should not be 0. Use -9999 as an invalid
            // value showing the error.
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
                recommendation = "Overweight";
            }
            else {
                System.out.println("Please consider to underweight the stock");
                recommendation = "Underweight";
            }

        }
        else {
            // Run ARIMA
            double forcast_ARIMA = AST.runARIMA();
            if (forcast_ARIMA > average_history) {
                System.out.println("You can overweight the stock");
                recommendation = "Overweight";
            }
            else {
                System.out.println("Please consider to underweight the stock");
                recommendation = "Underweight";
            }
        }

    }

    /**
     * This method gets the investment recommendation for the stock based on the
     * result from data processing, will pass the information to user output.
     * 
     * @return recommendation result for user
     */
    public String getRecommendation() {
        return recommendation;
    }

}
