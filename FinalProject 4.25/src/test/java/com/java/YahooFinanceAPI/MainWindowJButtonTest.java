package com.java.YahooFinanceAPI;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

public class MainWindowJButtonTest extends AssertJSwingJUnitTestCase {

private FrameFixture window;
    
    /**
     * This test checks the setting of JTextPanel, it should be visible, enabled and not editable.
     */
    @Test
    public void buttonMatcher() {

        JButtonFixture button = window.button("Start");
        button.requireVisible().requireEnabled();
        button.click();
        window.requireNotVisible();
        
    }
    

    @Override
    protected void onSetUp() {
        MainWindow frame = GuiActionRunner.execute(() -> new MainWindow());
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
