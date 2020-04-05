package com.java.YahooFinanceAPI;

import java.io.IOException;
import java.util.*;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 * This class gets stock data from Yahoo Finance using YahooFinanceAPI and
 * stores for further analysis
 */
public class YahooFinanceDataReader {
    public Stock getStock(String stockName) throws IOException {
        return YahooFinance.get(stockName);
    }

    public static void main(String[] args) throws IOException {
        YahooFinanceDataReader yahooFinanceDataReader = new YahooFinanceDataReader();
        System.out.println(yahooFinanceDataReader.getStock("AAPL"));

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, -1); // from 1 year ago

        Stock google = YahooFinance.get("GOOG");
        List<HistoricalQuote> googleHistQuotes = google.getHistory(from, to, Interval.DAILY);
        for (HistoricalQuote quote : googleHistQuotes) {
            String info = quote.toString();
            String adjPrice = info.substring(info.lastIndexOf("(") + 1, info.length() - 1);
            System.out.println(adjPrice);
        }
    }

}
