package com.java.YahooFinanceAPI;

import java.util.Scanner;

public class ResultGenerator {

    public String process(String tickerInput) {

//        System.out.println("Please choose a stock: ");
//  Scanner in = new Scanner (System.in);
//  String tickerInput = in.nextLine();
//        tickerInput = ParametersWindow.getStockSymbol();

        SPYBenchmark m = new SPYBenchmark();
//        System.out.println(m.getBenchmark("SPY"));
//        System.out.println(m.getBenchmark(tickerInput));

        double benchmarkSlope = m.getBenchmark("SPY");
        double clientSlope = m.getBenchmark(tickerInput);
        
        String recommendation = "";
        
        if (benchmarkSlope >= clientSlope) {
            recommendation = "Don't Buy " + tickerInput.toUpperCase() + "\nThis stock underperforms SP500.";
        }
        else {
            recommendation = "Buy " + tickerInput.toUpperCase() + "\nThis stock overperforms SP500.";
        }
        
        return recommendation;
//
//        if (benchmarkSlope > 0 && clientSlope > 0) {
//            if (benchmarkSlope >= clientSlope) {
//                System.out.println("Don't Buy " + tickerInput);
//                System.out.println("This stock underperforms SP500.");
//            }
//            else {
//                System.out.println("Buy " + tickerInput);
//                System.out.println("This stock overperforms SP500.");
//            }
//        }
//        else if (benchmarkSlope < 0 && clientSlope < 0) {
//            if (Math.abs(benchmarkSlope) >= Math.abs(clientSlope)) {
//                System.out.println("Buy " + tickerInput);
//                System.out.println("This stock overperforms SP500.");
//            }
//            else {
//                System.out.println("Don't Buy " + tickerInput);
//                System.out.println("This stock underperforms SP500.");
//            }
//        }
//        else if (benchmarkSlope < 0 && clientSlope > 0) {
//            System.out.println("Buy " + tickerInput);
//            System.out.println("This stock overperforms SP500.");
//        }
//        else if (benchmarkSlope > 0 && clientSlope < 0) {
//            System.out.println("Don't Buy " + tickerInput);
//            System.out.println("This stock underperforms SP500.");
//        }
    }
}
