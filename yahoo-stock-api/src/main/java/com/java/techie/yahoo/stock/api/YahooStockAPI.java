package com.java.techie.yahoo.stock.api;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import com.java.techie.yahoo.stock.api.dto.StockDto;
import com.sun.tools.javac.util.List;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;


// User selection - Time series close price

public class YahooStockAPI 
{

	public StockDto getStock(String StockName) throws IOException{
		StockDto dto = null;
		Stock stock = YahooFinance.get(StockName);
		dto = new StockDto(stock.getName(),stock.getQuote().getPrice(), stock.getQuote().getChange(), stock.getCurrency(), stock.getQuote().getBid());
		
		return dto;
	}
	
	public List<HistoricalQuote> getHistory(String stockname) throws IOException{
		Stock stock = YahooFinance.get(stockname);
		List<HistoricalQuote> stockp = stock.getHistory();
		for(HistoricalQuote quote:history) {
			System.out.println(quote.getClose());
		}
		return history;
		
	}
	
	
	
	
	
    public static void main( String[] args ) throws IOException
    {
    	YahooStockAPI yahooStockAPI = new YahooStockAPI();
    	System.out.println(yahooStockAPI.getStock("GOOG"));
    	yahooStockAPI.getHistory("GOOG");

    }
}