package com.java.YahooFinanceAPI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This class builds the Parameter Window, the third window of our GUI.
 */
public class ResultWindow extends JFrame implements Window {

    private JPanel contentPane;
    private JTextPane txtpnResultStatement;

    /**
     * Constructor, create the frame for Result Window, show the investment
     * recommendation to the user.
     */
    public ResultWindow() {
        initComponents();
        generateStatement();
    }
    
    /**
     * This method creates the initial look for the result window
     */
    @Override
    public void initComponents() {
        // Create a window and set the size, location, title, color, etc. for the
        // window.
        setTitle("Real Time API Robo-Advisor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1000, 100, 540, 650);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Put in image as a label.
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(ResultWindow.class.getResource("/images/Picture3.jpg")));
        lblNewLabel.setBounds(0, 0, 577, 166);
        contentPane.add(lblNewLabel);

        // Create panel for investment recommendation.
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 177, 624, 573);
        contentPane.add(panel);
        panel.setLayout(null);

        // Create title for investment recommendation.
        JTextPane txtpntitle = new JTextPane();
        txtpntitle.setName("Title");
        txtpntitle.setEditable(false);
        txtpntitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        txtpntitle.setText("Investment Recommendation for you:");
        txtpntitle.setBounds(10, 11, 542, 41);
        panel.add(txtpntitle);

        // Create text panel for the investment statement
        txtpnResultStatement = new JTextPane();
        txtpnResultStatement.setName("Statement");
        txtpnResultStatement.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtpnResultStatement.setBounds(10, 55, 504, 480);
        panel.add(txtpnResultStatement);

    }

    /**
     * This method processes user input data, generates time series trend analysis
     * visualization results and generates the final investment statement
     */
    public void generateStatement() {
        String symbol = ParametersWindow.getStockSymbol();
        String term = ParametersWindow.getInvestTerm();
        ResultGenerator generator = new ResultGenerator();
        String recommedation = generator.process(symbol, term);
        txtpnResultStatement.setText(recommedation);
    }

}
