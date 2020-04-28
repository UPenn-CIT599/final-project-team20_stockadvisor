package com.java.YahooFinanceAPI;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * This class checks the function of ticker text field and the "Check" button.
 */
public class ParametersWindowStepOneTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    /**
     * This test checks the case when entering a valid ticker and then selecting a
     * "No".
     */
    @Test
    public void validTickerCancel() {

        JTextComponentFixture textbox = window.textBox("Ticker Field");
        textbox.requireVisible().requireEnabled().requireEditable();

        textbox.enterText("AAPL");
        textbox.requireText("AAPL");

        JButtonFixture button = window.button("Check");
        button.requireVisible().requireEnabled().click();
        JOptionPaneFixture option = window.optionPane();
        option.noButton().click();

        textbox.requireText("");
        textbox.requireEditable();
    }

    /**
     * This test checks the case when entering a valid ticker and then selecting a
     * "Yes".
     */
    @Test
    public void validTickerConfirm() {

        JTextComponentFixture textbox = window.textBox("Ticker Field");
        textbox.requireVisible().requireEnabled().requireEditable();

        textbox.enterText("AAPL");
        textbox.requireText("AAPL");

        JButtonFixture button = window.button("Check");
        button.requireVisible().requireEnabled().click();
        JOptionPaneFixture option = window.optionPane();
        option.yesButton().click();

        textbox.requireText("AAPL");
        textbox.requireNotEditable();
    }

    /**
     * This test checks the case when entering an invalid ticker.
     */
    @Test
    public void invalidTicker() {

        JTextComponentFixture textbox = window.textBox("Ticker Field");
        textbox.requireVisible().requireEnabled().requireEditable();

        textbox.enterText("OK");
        textbox.requireText("OK");

        JButtonFixture button = window.button("Check");
        button.requireVisible().requireEnabled().click();
        JOptionPaneFixture option = window.optionPane();
        option.requireErrorMessage();
        option.okButton().click();

        textbox.requireText("");
        textbox.requireEditable();

    }

    /**
     * This test checks the case when not entering a ticker.
     */
    @Test
    public void emptyTicker() {

        JTextComponentFixture textbox = window.textBox("Ticker Field");
        textbox.requireVisible().requireEnabled().requireEditable();

        JButtonFixture button = window.button("Check");
        button.requireVisible().requireEnabled().click();
        JOptionPaneFixture option = window.optionPane();
        option.requireErrorMessage();
        option.okButton().click();

        textbox.requireText("");
        textbox.requireEditable();

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
