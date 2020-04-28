package com.java.YahooFinanceAPI;

import java.io.IOException;
import java.util.*;

import yahoofinance.*;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 * This class gets stock data from YahooFinance using YahooFinanceAPI and stores
 * for further analysis
 */
public class YahooFinanceDataReader {

    private String stockName;

    /**
     * This method gets the stock object based on the symbol for data extraction
     * from YahooFinance
     * 
     * @param stockName Stock symbol
     * @return Stock object for getting price information
     * @throws IOException
     */
    public Stock getStock(String stockName) throws IOException {
        this.stockName = stockName;
        return YahooFinance.get(stockName);
    }

    /**
     * This method checks whether the stock ticker is valid
     * 
     * @param stockTicker
     * @return true if valid; false if not.
     */
    public boolean isGood(String stockTicker) {
        Stock ticker = new Stock(stockTicker);
        return ticker.isValid();
    }

    /**
     * This method gets the full name for the stock/ETF
     * 
     * @param stockTicker
     * @return String of the full name
     */
    public String getStockName(String stockTicker) {
        Stock ticker = new Stock(stockTicker);
        return ticker.getName();
    }

    /**
     * This method generates historical stock close price double Array, for further
     * data analysis. We will pull the determined number of calendar days' price
     * data for our time series trend analysis
     * 
     * @param numOfDays number of days
     * @throws IOException
     */
    public double[] generatePriceList(int numOfDays) throws IOException {

        // to Date is set as current date as default
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

}
