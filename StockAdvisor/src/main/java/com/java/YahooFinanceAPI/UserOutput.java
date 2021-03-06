package com.java.YahooFinanceAPI;

/**
 * This class deals with user output: generates visual results and provides
 * investment recommendation for the current stock according to the data
 * processing results
 */
public class UserOutput {

    private DataProcessor processor;

    /**
     * This method generates graph for data visualization
     */
    public void dataVisualization() {

    }

    /**
     * This method generates investment recommendation for user
     * 
     * @return investment recommendation, overweight, underweight
     */
    public String giveRecommendation() {
        String recommendation = processor.getRecommendation();
        return recommendation;
    }
}
