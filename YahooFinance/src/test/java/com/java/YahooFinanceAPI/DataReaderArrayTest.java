package com.java.YahooFinanceAPI;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * This class tests the GeneratePriceList method in YahooFinanceDataReader.
 */
class DataReaderArrayTest {

    YahooFinanceDataReader reader = new YahooFinanceDataReader();

    /**
     * This method tests whether the price list array has a correct size. If size is
     * incorrect, 0 will be stored in the array.
     * 
     * @throws IOException
     */
    @Test
    void testGeneratePriceList() throws IOException {

        reader.getStock("AAPL");

        double[] prices = reader.generatePriceList(180);
        for (int i = 0; i < prices.length; i++) {
            // Print out the close prices for comparing with that on the YahooFinance website. Note that
            // the very last value will be the current price if the program is run during
            // trading hours.
            System.out.println(prices[i]);
            assertNotEquals(0, prices[i]);
        }
    }

}
