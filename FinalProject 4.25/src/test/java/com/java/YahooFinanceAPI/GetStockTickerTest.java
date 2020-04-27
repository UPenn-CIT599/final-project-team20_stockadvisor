package com.java.YahooFinanceAPI;

import static org.junit.Assert.*;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * This class tests whether it can read the ticker information from the text
 * field
 */
public class GetStockTickerTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    /**
     * This test checks whether it can read the ticker information from the text
     * field
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
        assertEquals("AAPL", symbol);

    }

    /**
     * This default method sets up the window for JUnit testing.
     */
    @Override
    protected void onSetUp() {
        ParametersWindow frame = GuiActionRunner.execute(() -> new ParametersWindow());
        window = new FrameFixture(robot(), frame);
        window.show(); // shows the frame to test
        window.resizeHeightTo(455);
        window.resizeWidthTo(640);
    }

    /**
     * This default method closes the window and does the cleanup after the testing.
     */
    @Override
    protected void onTearDown() {
        super.onTearDown();
        window.cleanUp();
    }

}
