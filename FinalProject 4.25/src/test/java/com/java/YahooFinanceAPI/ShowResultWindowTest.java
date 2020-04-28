package com.java.YahooFinanceAPI;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.assertj.swing.fixture.JRadioButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * This class tests whether it will bring the result window after the user
 * correctly entered all the required information.
 */
public class ShowResultWindowTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    /**
     * This test checks the case when user completes all the required information.
     */
    @Test
    public void stepThreeCompleteTest() {

        JTextComponentFixture textbox = window.textBox("Ticker Field");
        textbox.requireVisible().requireEnabled().requireEditable();

        textbox.enterText("AAPL");
        textbox.requireText("AAPL");

        JButtonFixture button1 = window.button("Check");
        button1.requireVisible().requireEnabled().click();
        JOptionPaneFixture option1 = window.optionPane();
        option1.yesButton().click();

        JRadioButtonFixture button2 = window.radioButton("Short Term");
        button2.requireVisible().requireEnabled();

        button2.click();

        JButtonFixture button3 = window.button("Continue");
        button3.requireVisible().requireEnabled().click();
        window.requireNotVisible();
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
