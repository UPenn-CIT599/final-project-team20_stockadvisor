package com.java.YahooFinanceAPI;

import static org.junit.Assert.*;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JRadioButtonFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class GetInvestmentTermTest extends AssertJSwingJUnitTestCase {

private FrameFixture window;
    
    /**
     * This test checks the function of radio buttons.
     */
    @Test
    public void getInvestmentTermTest() {
        
        JRadioButtonFixture button1 = window.radioButton("Short Term");
        button1.requireVisible().requireEnabled();

        JRadioButtonFixture button2 = window.radioButton("Long Term");
        button2.requireVisible().requireEnabled();
        
        button1.click();
        String term = ParametersWindow.getInvestTerm();
        assertEquals(term, "S");
        
        button2.click();
        term = ParametersWindow.getInvestTerm();
        assertEquals(term, "L");
        
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
