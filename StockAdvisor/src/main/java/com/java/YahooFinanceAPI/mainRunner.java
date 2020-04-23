package com.java.YahooFinanceAPI;
import java.util.Scanner;

public class mainRunner {

	public static void main(String[] args) {
		
		System.out.println("Please choose a stock: ");
		Scanner in = new Scanner (System.in);
		String tickerInput = in.nextLine();
		
		SPYBenchmark m = new SPYBenchmark();
		System.out.println(m.getBenchmark("SPY"));
		System.out.println(m.getBenchmark(tickerInput));
		
		double benchmarkSlope = m.getBenchmark("SPY");
		double clientSlope = m.getBenchmark(tickerInput);
		
		if (benchmarkSlope>0 && clientSlope>0) {
			if (benchmarkSlope>=clientSlope) {
				System.out.println("Dont Buy "+ tickerInput);
				System.out.println("this stock underperforms SP500.");
			}
			else {
				System.out.println("Buy "+ tickerInput);
				System.out.println("this stock overperforms SP500.");
				}
			}
		else if (benchmarkSlope<0 && clientSlope<0) {
			if (Math.abs(benchmarkSlope)>=Math.abs(clientSlope)) {
				System.out.println("Buy "+ tickerInput);
				System.out.println("this stock overperforms SP500.");
			}
			else {
				System.out.println("Dont Buy "+ tickerInput);
				System.out.println("this stock underperforms SP500.");
				}
			}
		else if (benchmarkSlope<0 && clientSlope>0) {
			System.out.println("Buy "+ tickerInput);
			System.out.println("this stock overperforms SP500.");
		}
		else if (benchmarkSlope>0 && clientSlope<0) {
			System.out.println("Dont Buy "+ tickerInput);
			System.out.println("this stock underperforms SP500.");
		}
	}
}