package com.java.YahooFinanceAPI;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JRadioButtonFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * This class tests the function of radio buttons.
 */
public class ParametersWindowStepTwoTest extends AssertJSwingJUnitTestCase {

private FrameFixture window;
    
    /**
     * This test checks the function of radio buttons.
     */
    @Test
    public void verifyRadioButtons() {
        
        JRadioButtonFixture button1 = window.radioButton("Short Term");
        button1.requireVisible().requireEnabled();

        JRadioButtonFixture button2 = window.radioButton("Long Term");
        button2.requireVisible().requireEnabled();
        
        button1.click();
        button1.requireSelected();
        button2.requireSelected(false);
        
        button2.click();
        button1.requireSelected(false);
        button2.requireSelected();
        
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
