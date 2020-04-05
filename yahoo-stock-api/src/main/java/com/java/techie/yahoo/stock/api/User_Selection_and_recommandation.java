package com.java.techie.yahoo.stock.api;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.tools.javac.util.List;

import java.io.IOException;
// Long Term (more than 180 days) /Short Term (no more than 2 weeks)
// Stock Ticker
// Stock Price Start Date Range
// L - ARMA; S - ARIMA
// Output - API

public class User_Selection_and_recommandation {
	
	YahooStockAPI Data;
	ARIMA_Short_Term AST;
	ARMA_Long_Term ALT;
	
	public ArrayList<Double> getvalue(String ticker) throws IOException {
		Data = new YahooStockAPI();
		ArrayList<Double> stock_price = new ArrayList<Double>();
		stock_price = Data.getHistory(ticker);
		return stock_price;
	}
	
	public static double calculateAverage(ArrayList<Double> hp){

        double sum = 0.0;
        double monthlyTotal = 0.0;
 
       for(int i=0; i < hp.size(); i++) 
        {
            sum += hp.get(i);
          }
 
          return monthlyTotal/hp.size();
    }
	
	public static void main(String[] args) throws IOException {
		User_Selection_and_recommandation USR = new User_Selection_and_recommandation();
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter your stock ticker");
		String Ticker = reader.nextLine();
		ArrayList<Double> HP = new ArrayList<Double>();
		HP = USR.getvalue(Ticker);
		
		System.out.println("Please enter your investment term, L for long term, S for short term");
		System.out.println("Long term for holding 180 days, short term for holding 14 days");
		String Term = reader.nextLine();
		
		double average_history = calculateAverage(HP);

		if (Term == "L") {
			// Run ARMA
			double forcast_ARMA = ALT.forcast();
			if(forcast_ARMA > average_history) {
				System.out.println("You can overweight the stock");
			}else {
				System.out.println("Please consider to underweight the stock");
			}
			
		}else {
			// Run ARIMA
			double forcast_ARIMA = AST.forcast();
			if(forcast_ARIMA > average_history) {
				System.out.println("You can overweight the stock");
			}else {
				System.out.println("Please consider to underweight the stock");
			}
		}
		
		
	}

	
	
	
}