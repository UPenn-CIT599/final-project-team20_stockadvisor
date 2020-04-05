package com.java.YahooFinanceAPI;

import java.util.*;

/**
 * This method gets the user input which is necessary for data processing.
 */
public class UserInput {
    private Scanner s = new Scanner(System.in);
    /**
     * This method reads the stock symbol from user input.
     * 
     * @return user entered stock symbol
     */
    public String readStockTickerSymbol() {
        String stockSymbol = "";
        stockSymbol = s.next();
        return stockSymbol;
    }

    /**
     * This method reads the date range that the user would like to get the stock to
     * be analyzed.
     * 
     * @return user selected date range
     */
    public String readDateRange() {
        String date = "";
        date = s.next();
        return date;
    }

    /**
     * This method reads the user selection of investment horizon, either "Long
     * Term" or "Short Term".
     * 
     * @return user selected investment horizon, Long Term or Short Term
     */
    public String readInvestmentHorizon() {
        String horizon = "";
        horizon  = s.next();
        return horizon;
    }

}
