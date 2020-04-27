package com.java.YahooFinanceAPI;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JOptionPaneFixture;
import org.assertj.swing.fixture.JRadioButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class ParametersWindowStepThreeTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;
    
    /**
     * This test checks the case when entering a valid ticker and then selecting a "No".
     */
    @Test
    public void stepOneMissing() {
        
        JRadioButtonFixture button1 = window.radioButton("Short Term");
        button1.requireVisible().requireEnabled();
        
        button1.click();
                
        JButtonFixture button = window.button("Continue");
        button.requireVisible().requireEnabled().click();
        JOptionPaneFixture option = window.optionPane();
        option.requireInformationMessage();
    }

    /**
     * This test checks the case when entering a valid ticker and then selecting a "Yes".
     */
    @Test
    public void stepTwoMissing() {

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
     * This test checks the case when entering an invalid ticker.
     */
    @Test
    public void bothStepsMissing() {

        JButtonFixture button = window.button("Continue");
        button.requireVisible().requireEnabled().click();
        JOptionPaneFixture option1 = window.optionPane();
        option1.requireInformationMessage();
        option1.okButton().click();
        JOptionPaneFixture option2 = window.optionPane();
        option2.requireInformationMessage();
        option2.okButton().click();

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
