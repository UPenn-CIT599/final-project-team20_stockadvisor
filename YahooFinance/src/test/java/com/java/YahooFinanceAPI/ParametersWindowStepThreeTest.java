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
 * This class tests whether it could handle the error of user's missing input
 */
public class ParametersWindowStepThreeTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    /**
     * This test checks the case when user does not complete step 1 - put in the
     * ticker information.
     */
    @Test
    public void stepOneMissingTest() {

        JRadioButtonFixture button1 = window.radioButton("Short Term");
        button1.requireVisible().requireEnabled();

        button1.click();

        JButtonFixture button = window.button("Continue");
        button.requireVisible().requireEnabled().click();
        JOptionPaneFixture option = window.optionPane();
        option.requireInformationMessage();
    }

    /**
     * This test checks the case when user does not complete step 2 - select
     * investment horizon.
     */
    @Test
    public void stepTwoMissingTest() {

        JTextComponentFixture textbox = window.textBox("Ticker Field");
        textbox.requireVisible().requireEnabled().requireEditable();

        textbox.enterText("AAPL");
        textbox.requireText("AAPL");

        JButtonFixture button1 = window.button("Check");
        button1.requireVisible().requireEnabled().click();
        JOptionPaneFixture option1 = window.optionPane();
        option1.yesButton().click();

        JButtonFixture button2 = window.button("Continue");
        button2.requireVisible().requireEnabled().click();
        JOptionPaneFixture option2 = window.optionPane();
        option2.requireInformationMessage();
    }

    /**
     * This test checks the case when user does not provide any input and directly
     * click the "Continue" button.
     */
    @Test
    public void bothStepsMissingTest() {

        JButtonFixture button = window.button("Continue");
        button.requireVisible().requireEnabled().click();
        JOptionPaneFixture option1 = window.optionPane();
        option1.requireInformationMessage();
        option1.okButton().click();
        JOptionPaneFixture option2 = window.optionPane();
        option2.requireInformationMessage();
        option2.okButton().click();

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
