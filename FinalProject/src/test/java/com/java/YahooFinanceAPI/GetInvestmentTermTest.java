package com.java.YahooFinanceAPI;

import static org.junit.Assert.*;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JRadioButtonFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * This class tests whether it can read the investment horizon information from
 * the radio button
 */
public class GetInvestmentTermTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    /**
     * This test checks whether it can read the investment horizon information from
     * the radio button
     */
    @Test
    public void getInvestmentTermTest() {

        JRadioButtonFixture button1 = window.radioButton("Short Term");
        button1.requireVisible().requireEnabled();

        JRadioButtonFixture button2 = window.radioButton("Long Term");
        button2.requireVisible().requireEnabled();

        button1.click();
        String term = ParametersWindow.getInvestTerm();
        assertEquals("S", term);

        button2.click();
        term = ParametersWindow.getInvestTerm();
        assertEquals("L", term);

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
