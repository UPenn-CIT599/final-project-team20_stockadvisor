package com.java.YahooFinanceAPI;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * This test checks the setting of JTextPanel in MainWindow
 */
public class MainWindowJTextPanelTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    /**
     * This test checks the setting of JTextPanel, it should be visible, enabled and
     * not editable.
     */
    @Test
    public void textPanelMatcher() {

        JTextComponentFixture textbox1 = window.textBox("Authors");
        textbox1.requireVisible().requireEnabled().requireNotEditable();

        JTextComponentFixture textbox2 = window.textBox("Title");
        textbox2.requireVisible().requireEnabled().requireNotEditable();

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
