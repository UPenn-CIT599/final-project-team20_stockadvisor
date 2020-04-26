package com.java.YahooFinanceAPI;

public class ResultGenerator {

    public String process(String tickerInput, String term) {

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
        String termSelection ="";
        String footnote = "As reference: The S&P 500, or simply the S&P, is a stock market index that measures the stock performance of 500 large companies listed on stock exchanges in the United States. It is one of the most commonly followed equity indices, and many consider it to be one of the best representations of the U.S. stock market." 
        		+"\n"+"\n"+
        		"Risks to Rating and Price Target\n" + 
        		"Downside risks include 1) potential for a return to heavy investment spending and margin compression; 2) continued competition for hiring talents; and 3) increased regulatory scrutiny; and 4) increased competition from other players"
        		+"\n"+"\n"+
        		"This robo-advisor core engine is driven by the autoregressive integrated moving average (ARIMA) model, and we set the parameters as (3,1,2).\n" + 
        		"\n" + 
        		"As reference: ARIMA(p,d,q) where parameters p, d, and q are non-negative integers, p is the order (number of time lags) of the autoregressive model, d is the degree of differencing (the number of times the data have had past values subtracted), and q is the order of the moving-average model.";
        
        if (term.equals("S")) {
        	termSelection = "Short-term";
        }
        else {
        	termSelection = "Long-term";
        }
        
        if (benchmarkSlope >= clientSlope) {
            recommendation = "We rate "+ tickerInput.toUpperCase() +" as "+"Underweight and view it as a core holding given its weak competitive position in "+termSelection + " across most key secular growth segments in its industry and under perform the selected benchmark (S&P 500)." +"\n"+"\n"+ footnote;
            }
        else {
            recommendation = "We rate "+ tickerInput.toUpperCase() +" as "+"Overweight and view it as a core holding given its strong competitive position in "+termSelection + " across most key secular growth segments in its industry and over perform the selected benchmark (S&P 500)." +"\n"+"\n"+ footnote;
        }
        
        return recommendation;

    }
}
