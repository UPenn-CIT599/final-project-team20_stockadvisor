package com.java.YahooFinanceAPI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class tests the getStock method in YahooFinanceDataReader
 */
class YahooFinanceDataReaderTest {

    YahooFinanceDataReader reader = new YahooFinanceDataReader();

    /**
     * This method tests whether we can get the correct data from YahooFinance after
     * we enter the ticker information.
     */
    @Test
    void getStockTest() {
        String ticker = "";
        try {
            ticker = reader.getStock("AAPL").getSymbol();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals("AAPL", ticker);
    }

}
