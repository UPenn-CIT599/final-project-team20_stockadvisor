package com.java.YahooFinanceAPI;

import java.awt.EventQueue;

/**
 * This class runs the App
 */
public class AppRunner {

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
