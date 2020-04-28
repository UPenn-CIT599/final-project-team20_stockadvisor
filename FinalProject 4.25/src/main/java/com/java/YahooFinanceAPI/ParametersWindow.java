package com.java.YahooFinanceAPI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import yahoofinance.Stock;

/**
 * This class builds the Parameters Window, the second window of our GUI.
 */
public class ParametersWindow extends JFrame implements Window {

    private JPanel contentPane;
    private static JTextField tickerField;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private static JRadioButton rdbtnShortTerm;
    private static JRadioButton rdbtnLongTerm;
    private JButton btnCheckButton;
    private JButton btnContinue;
    private JOptionPane tickerOption;

    /**
     * Constructor, create the frame for Parameters Window, collect user input
     * information for time series trend analysis.
     */
    public ParametersWindow() {

        initComponents();
        clickCheckEvent();
        clickContinueEvent();
    }

    /**
     * This method creates the initial look for the parameters window.
     */
    @Override
    public void initComponents() {
        // Create a window and set the size, location, title, color, etc. for the
        // window.
        setTitle("Real Time API Robo-Advisor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 455);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Put in image as a label.
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(SystemColor.menu);
        lblNewLabel.setBounds(0, 0, 624, 120);
        contentPane.add(lblNewLabel);
        lblNewLabel
                .setIcon(new ImageIcon(ParametersWindow.class.getResource("/images/Picture2.jpg")));

        // Show information of User greetings
        JTextPane txtpnGreeting = new JTextPane();
        txtpnGreeting.setEditable(false);
        txtpnGreeting.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
        txtpnGreeting.setText(
                "Welcome to Stock Investment Advisor!\nPlease follow the steps and fill out the information below.");
        txtpnGreeting.setBounds(10, 121, 604, 60);
        contentPane.add(txtpnGreeting);

        // Create panel for Step 1.
        JPanel panelStep1 = new JPanel();
        panelStep1.setBackground(Color.WHITE);
        panelStep1.setBounds(10, 192, 604, 68);
        contentPane.add(panelStep1);
        panelStep1.setLayout(null);

        // Show the instruction for Step 1
        JLabel lblStep1 = new JLabel(
                "Step 1: Please write down the ticker of the stock/ETF, click the \"Check\" button, and confirm your entry.");
        lblStep1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStep1.setBounds(0, 11, 604, 24);
        lblStep1.setVerticalAlignment(SwingConstants.TOP);
        panelStep1.add(lblStep1);

        // Create a text field for user to put in stock/ETF ticker
        JLabel lblStockTicker = new JLabel("Stock/ETF Ticker");
        lblStockTicker.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStockTicker.setBounds(0, 39, 116, 24);
        panelStep1.add(lblStockTicker);

        tickerField = new JTextField();
        tickerField.setName("Ticker Field");
        tickerField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tickerField.setBounds(126, 41, 86, 20);
        panelStep1.add(tickerField);
        tickerField.setColumns(10);

        // Create button for checking ticker information
        btnCheckButton = new JButton("Check");
        btnCheckButton.setName("Check");
        tickerOption = new JOptionPane();
        btnCheckButton.setBackground(Color.LIGHT_GRAY);
        btnCheckButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnCheckButton.setBounds(246, 40, 89, 23);
        panelStep1.add(btnCheckButton);

        // Create panel for Step 2
        JPanel panelStep2 = new JPanel();
        panelStep2.setBackground(Color.WHITE);
        panelStep2.setBounds(10, 271, 604, 60);
        contentPane.add(panelStep2);
        panelStep2.setLayout(null);

        // Show the instruction for Step 2
        JLabel lblStep2 = new JLabel("Step 2: Please select the investment horizon.");
        lblStep2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStep2.setBounds(0, 0, 594, 23);
        panelStep2.add(lblStep2);

        // Create a botton group made of two radio buttons for user to select investment
        // horizon
        JLabel lblTerm = new JLabel("Investment Horizon");
        lblTerm.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTerm.setBounds(0, 35, 119, 14);
        panelStep2.add(lblTerm);

        rdbtnShortTerm = new JRadioButton("Short Term");
        rdbtnShortTerm.setName("Short Term");
        rdbtnShortTerm.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonGroup.add(rdbtnShortTerm);
        rdbtnShortTerm.setBounds(125, 30, 109, 23);
        panelStep2.add(rdbtnShortTerm);

        rdbtnLongTerm = new JRadioButton("Long Term");
        rdbtnLongTerm.setName("Long Term");
        rdbtnLongTerm.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonGroup.add(rdbtnLongTerm);
        rdbtnLongTerm.setBounds(236, 30, 109, 23);
        panelStep2.add(rdbtnLongTerm);

        // Create panel for Step 3
        JPanel panelStep3 = new JPanel();
        panelStep3.setBackground(Color.WHITE);
        panelStep3.setBounds(10, 340, 604, 65);
        contentPane.add(panelStep3);
        panelStep3.setLayout(null);

        // Show the instruction for Step 3
        JLabel lblStep3 = new JLabel(
                "Step 3: Click \"Continue\" to start analysis and get recommendation.");
        lblStep3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStep3.setBounds(0, 0, 604, 28);
        panelStep3.add(lblStep3);

        // Create button for continue to get the investment recommendation
        btnContinue = new JButton("Continue");
        btnContinue.setName("Continue");
        btnContinue.setBackground(Color.LIGHT_GRAY);
        btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnContinue.setBounds(245, 31, 89, 23);
        panelStep3.add(btnContinue);

    }

    /**
     * This method creates an event for clicking the "Check" Button. After click
     * "Check", it will check the ticker information and compare with that on
     * YahooFinance. It will bring the Message Dialog or Option Dialog for user to
     * proceed.
     */
    public void clickCheckEvent() {

        btnCheckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stockTicker = tickerField.getText();
                YahooFinanceDataReader reader = new YahooFinanceDataReader();
                Stock stock;
                try {
                    stock = reader.getStock(stockTicker);
                    // This handles NullPointerException. If user input ticker is invalid, it will
                    // bring a Message Dialog.
                    if (stock == null) {
                        JOptionPane.showMessageDialog(tickerOption,
                                "Stock/ETF Ticker is invalid. Please try again! You can go to https://finance.yahoo.com/ to search the ticker.",
                                "Error", 0);
                        tickerField.setText("");
                    }
                    // If user input ticker is valid, it will ask user to confirm the ticker input.
                    else if (stock.isValid()) {
                        String name = stock.getName();
                        int answer = JOptionPane.showConfirmDialog(tickerOption,
                                "You have entered the ticker for \"" + name
                                        + "\". Is that correct?",
                                "Please confirm your selection", JOptionPane.YES_NO_OPTION);
                        if (answer == 0) {
                            tickerField.setEditable(false);
                        }
                        else {
                            tickerField.setText("");
                            JOptionPane.showMessageDialog(tickerOption,
                                    "Please try again! You can go to https://finance.yahoo.com/ to search the ticker.",
                                    "Reminder", 1);
                        }
                    }
                    // This handles FileNotFoundException. If user input ticker is invalid, it will
                    // bring a Message Dialog.
                    else {
                        JOptionPane.showMessageDialog(tickerOption,
                                "Stock/ETF Ticker is invalid. Please try again! You can go to https://finance.yahoo.com/ to search the ticker.",
                                "Error", 0);
                        tickerField.setText("");
                    }

                }
                // This handles IOException.
                catch (IOException e1) {
                    JOptionPane.showMessageDialog(tickerOption,
                            "Stock/ETF Ticker is invalid. Please try again! You can go to https://finance.yahoo.com/ to search the ticker.",
                            "Error", 0);
                    tickerField.setText("");
                }
            }
        });
    }

    /**
     * This method creates an event for clicking the "Continue" Button. After click
     * "Continue", it will first check whether the user has completed the first two
     * steps. If yes, it will proceed to the Result Window. If not, it will point
     * out the step that the user has not completed.
     */
    public void clickContinueEvent() {
        btnContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if ((tickerField.isEditable() == false)
                        && (rdbtnLongTerm.isSelected() || rdbtnShortTerm.isSelected())) {
                    ResultWindow result = new ResultWindow();
                    result.setVisible(true);
                    setVisible(false);
                }
                else {
                    JOptionPane continueOption = new JOptionPane();

                    if (tickerField.isEditable() == true) {
                        JOptionPane.showMessageDialog(continueOption,
                                "Please complete Step 1: Enter and confirm the Ticker information.",
                                "Reminder", 1);
                    }
                    if (!rdbtnLongTerm.isSelected() && !rdbtnShortTerm.isSelected()) {
                        JOptionPane.showMessageDialog(continueOption,
                                "Please complete Step 2: Select the investment horizon.",
                                "Reminder", 1);
                    }
                }

            }
        });
    }

    /**
     * This method gets the user input of the stock/ETF symbol. It will be used in
     * result generation. It is set static so that we don't need to declare an
     * object when using it and this will avoid showing a new window.
     * 
     * @return String for stock/ETF symbol
     */
    public static String getStockSymbol() {
        return tickerField.getText();
    }

    /**
     * This method gets the user selection of the investment horizon. It will be
     * used in result generation. It is set static so that we don't need to declare
     * an object when using it and this will avoid showing a new window.
     * 
     * @return String for investment horizon
     */
    public static String getInvestTerm() {
        String term = "";
        if (rdbtnShortTerm.isSelected()) {
            term = "S";
        }
        else {
            term = "L";
        }
        return term;
    }

}
