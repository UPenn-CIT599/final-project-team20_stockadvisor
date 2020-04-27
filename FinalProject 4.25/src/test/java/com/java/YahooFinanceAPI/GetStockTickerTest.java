package com.java.YahooFinanceAPI;

import static org.junit.Assert.*;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class GetStockTickerTest extends AssertJSwingJUnitTestCase {

private FrameFixture window;
    
    /**
     * This test checks the function of radio buttons.
     */
    @Test
    public void getInvestmentTermTest() {
        
        String symbol = ParametersWindow.getStockSymbol();
        assertEquals(symbol, "");
        
        JTextComponentFixture textbox = window.textBox("Ticker Field");
        textbox.requireVisible().requireEnabled().requireEditable();

        textbox.enterText("AAPL");
        textbox.requireText("AAPL");

        JButtonFixture button = window.button("Check");
        button.requireVisible().requireEnabled().click();
        JOptionPaneFixture option = window.optionPane();
        option.yesButton().click();
        
        symbol = ParametersWindow.getStockSymbol();
        assertEquals(symbol, "AAPL");
        
    }


    @Override
    protected void onSetUp() {
        ParametersWindow frame = GuiActionRunner.execute(() -> new ParametersWindow());
        window = new FrameFixture(robot(), frame);
        window.show(); // shows the frame to test
        window.resizeHeightTo(455);
        window.resizeWidthTo(640);
    }
    
    @Override
    protected void onTearDown() {
        super.onTearDown();
        window.cleanUp();
    }

}
