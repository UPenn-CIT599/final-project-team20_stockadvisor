package com.java.YahooFinanceAPI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import yahoofinance.Stock;

public class ParametersWindow extends JFrame {

    private JPanel contentPane;
    private static JTextField textField;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private static JRadioButton rdbtnShortTerm;
    private static JRadioButton rdbtnLongTerm;

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ParametersWindow frame = new ParametersWindow();
//                    frame.setVisible(true);
//                }
//                catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public ParametersWindow() {
        
        setTitle("Real Time API Robo-Advisor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 455);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(SystemColor.menu);
        lblNewLabel.setBounds(0, 0, 624, 120);
        contentPane.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon(ParametersWindow.class.getResource("/images/Picture2.jpg")));
        
        JTextPane txtpnGreeting = new JTextPane();
        txtpnGreeting.setEditable(false);
        txtpnGreeting.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
        txtpnGreeting.setText("Welcome to Stock Investment Advisor! \r\nPlease follow the steps and fill out the information below.");
        txtpnGreeting.setBounds(10, 121, 604, 60);
        contentPane.add(txtpnGreeting);
        
        JPanel panelStep1 = new JPanel();
        panelStep1.setBackground(Color.WHITE);
        panelStep1.setBounds(10, 192, 604, 68);
        contentPane.add(panelStep1);
        panelStep1.setLayout(null);
        
        JLabel lblStep1 = new JLabel("Step 1: Please write down the ticker of the stock/ETF, click the \"Check\" button, and confirm your entry.");
        lblStep1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStep1.setBounds(0, 11, 604, 24);
        lblStep1.setVerticalAlignment(SwingConstants.TOP);
        panelStep1.add(lblStep1);
        
        JLabel lblStockTicker = new JLabel("Stock/ETF Ticker");
        lblStockTicker.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStockTicker.setBounds(0, 39, 116, 24);
        panelStep1.add(lblStockTicker);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textField.setBounds(126, 41, 86, 20);
        panelStep1.add(textField);
        textField.setColumns(10);
        
        JButton btnCheckButton = new JButton("Check");
        JOptionPane tickerOption = new JOptionPane();
        btnCheckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stockTicker = textField.getText();
                YahooFinanceDataReader reader = new YahooFinanceDataReader();
                Stock stock;
                try {
                    stock = reader.getStock(stockTicker);
                    if (stock == null) {
                        JOptionPane.showMessageDialog(tickerOption,
                                "Stock/ETF Ticker is invalid. Please try again! You can go to https://finance.yahoo.com/ to search the ticker.", "Error", 0);
                    }
                    else if (stock.isValid()) {
                        String name = stock.getName();
                        int answer = JOptionPane.showConfirmDialog(tickerOption,
                                "You have entered the ticker for \"" + name
                                        + "\". Is that correct?",
                                "Please confirm your selection", JOptionPane.YES_NO_OPTION);
                        if (answer == 0) {
                            textField.setEditable(false);
//                            boolean tickerField = false;
                        }
                        else {
                            textField.setText("");
                            JOptionPane.showMessageDialog(tickerOption,
                                    "Please try again! You can go to https://finance.yahoo.com/ to search the ticker.", "Reminder", 1);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(tickerOption,
                                "Stock/ETF Ticker is invalid. Please try again! You can go to https://finance.yahoo.com/ to search the ticker.", "Error", 0);
                    }

                }
                catch (IOException e1) {
                    JOptionPane.showMessageDialog(tickerOption,
                            "Stock/ETF Ticker is invalid. Please try again! You can go to https://finance.yahoo.com/ to search the ticker.", "Error", 0);
                }
            }
        });
        btnCheckButton.setBackground(Color.LIGHT_GRAY);
        btnCheckButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnCheckButton.setBounds(246, 40, 89, 23);
        panelStep1.add(btnCheckButton);
        
        JPanel panelStep2 = new JPanel();
        panelStep2.setBackground(Color.WHITE);
        panelStep2.setBounds(10, 271, 604, 60);
        contentPane.add(panelStep2);
        panelStep2.setLayout(null);
        
        JLabel lblStep2 = new JLabel("Step 2: Please select the investment horizon.");
        lblStep2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStep2.setBounds(0, 0, 594, 23);
        panelStep2.add(lblStep2);
        
        JLabel lblTerm = new JLabel("Investment Horizon");
        lblTerm.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTerm.setBounds(0, 35, 119, 14);
        panelStep2.add(lblTerm);
        
        rdbtnShortTerm = new JRadioButton("Short Term");
        rdbtnShortTerm.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonGroup.add(rdbtnShortTerm);
        rdbtnShortTerm.setBounds(125, 30, 109, 23);
        panelStep2.add(rdbtnShortTerm);
        
        rdbtnLongTerm = new JRadioButton("Long Term");
        rdbtnLongTerm.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonGroup.add(rdbtnLongTerm);
        rdbtnLongTerm.setBounds(236, 30, 109, 23);
        panelStep2.add(rdbtnLongTerm);
        
        JPanel panelStep3 = new JPanel();
        panelStep3.setBackground(Color.WHITE);
        panelStep3.setBounds(10, 340, 604, 65);
        contentPane.add(panelStep3);
        panelStep3.setLayout(null);
        
        JLabel lblStep3 = new JLabel("Step 3: Click \"Continue\" to start analysis and get recommendation.");
        lblStep3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStep3.setBounds(0, 0, 604, 28);
        panelStep3.add(lblStep3);
        
        JButton btnContinue = new JButton("Continue");
        
        btnContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if ((textField.isEditable() == false) && (rdbtnLongTerm.isSelected() || rdbtnShortTerm.isSelected())) {
                    ResultWindow result = new ResultWindow();
                    result.setVisible(true);
                    setVisible(false);
                    String symbol = getStockSymbol();
                    String term = getInvestTerm();
//                    System.out.println(getStockSymbol());
//                    System.out.println(getInvestTerm());
                    ResultGenerator generator = new ResultGenerator();
                    String recommedation = generator.process(symbol, term);
                    result.getTxtpnMsg().setText(recommedation);
                }
                else {
                    JOptionPane continueOption = new JOptionPane();
                    
                    if (textField.isEditable() == true) {
                        JOptionPane.showMessageDialog(continueOption, "Please complete Step 1: Enter and confirm the Ticker information.", "Reminder", 1);
                    }
                    if (!rdbtnLongTerm.isSelected() && !rdbtnShortTerm.isSelected()) {
                        JOptionPane.showMessageDialog(continueOption, "Please complete Step 2: Select the investment horizon.", "Reminder", 1);
                    }
                }

            }
        });
        
        btnContinue.setBackground(Color.LIGHT_GRAY);
        btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnContinue.setBounds(245, 31, 89, 23);
        panelStep3.add(btnContinue);
        
    }

    public static String getStockSymbol() {
        return textField.getText();
    }
    
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
