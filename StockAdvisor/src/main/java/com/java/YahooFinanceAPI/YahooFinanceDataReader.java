package com.java.yahoo.stock.api;

import java.io.IOException;
import java.util.*;

import yahoofinance.*;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 * This class gets stock data from Yahoo Finance using YahooFinanceAPI and
 * stores for further analysis
 */
public class YahooFinanceDataReader {
//    private ArrayList<Double> historicalPrices;
//    private double[] historicalPrices;
//    private UserInput in;
    private String stockName;

    /**
     * Constructs the data reader to pull stock data from Yahoo Finance
     */
    public YahooFinanceDataReader() {
//        historicalPrices = new ArrayList<Double>();
//        stockName = in.readStockTickerSymbol();
    }

    /**
     * This method gets the stock object based on the symbol for data extraction
     * from Yahoo Finance
     * 
     * @param stockName Stock symbol
     * @return Stock object for getting price information
     * @throws IOException
     */
    public Stock getStock(String stockName) throws IOException {
        this.stockName = stockName;
        return YahooFinance.get(stockName);
    }
    
    public boolean isGood(String stockTicker) {
        Stock ticker = new Stock(stockTicker);
        return ticker.isValid();
    }
    
    public String getStockName(String stockTicker) {
        Stock ticker = new Stock(stockTicker);
        return ticker.getName();
    }


    /**
     * This method stores historical stock close price to the historicalPrices
     * ArrayList, for further data analysis. For short term analysis, we will pull
     * 14 days' price data; for long term analysis, we will pull 180 days' price
     * data.
     * 
     * @param numOfDays number of days, is 14 for short term analysis, and is 180
     *                  for long term analysis
     * @throws IOException
     */
    public double[] generatePriceList(int numOfDays) throws IOException {

        // to date is set as current date as default
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.DATE, -numOfDays);

        Stock stock = getStock(stockName);
        List<HistoricalQuote> stockHistQuotes = stock.getHistory(from, to, Interval.DAILY);
        
        ArrayList<Double> historicalPrices = new ArrayList<Double>();

        for (HistoricalQuote quote : stockHistQuotes) {
            String close = quote.getClose().toString();
            double historicalPrice = Double.parseDouble(close);
            historicalPrices.add(historicalPrice);
        }
        
        int size = historicalPrices.size();
        double[] closePrices = new double[size];
        for (int i = 0; i < size; i++) {
            closePrices[i] = historicalPrices.get(i);
        }
        return closePrices;
    }

    /**
     * This method gets the historicalPrices ArrayList used for data analysis
     * 
     * @return historicalPrices ArrayList
     * @throws IOException 
     */
//    public ArrayList<Double> getHistoricalPrices() {
//        return historicalPrices;
//    }

    public static void main(String[] args) throws IOException {
        YahooFinanceDataReader reader = new YahooFinanceDataReader();
        reader.getStock("OK");
        double[] prices = reader.generatePriceList(180);
        System.out.println(Arrays.toString(prices));
        
    }
}
