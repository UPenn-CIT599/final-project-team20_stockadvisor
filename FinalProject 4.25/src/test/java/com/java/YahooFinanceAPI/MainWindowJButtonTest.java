package com.java.YahooFinanceAPI;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * This class tests the Main Window of our GUI
 */
public class MainWindowJButtonTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    /**
     * This test checks the setting of JButton "Start". After press it, the current
     * window will be invisible, and a new window will show up.
     */
    @Test
    public void buttonTest() {

        JButtonFixture button = window.button("Start");
        button.requireVisible().requireEnabled();
        button.click();
        window.requireNotVisible();

    }

    /**
     * This default method sets up the window for JUnit testing.
     */
    @Override
    protected void onSetUp() {
        MainWindow frame = GuiActionRunner.execute(() -> new MainWindow());
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
