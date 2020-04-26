package com.java.YahooFinanceAPI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ResultWindow extends JFrame {

    private JPanel contentPane;
    private JTextPane txtpnMsg;

    /**
     * Create the frame.
     */
    public ResultWindow() {
        setTitle("Real Time API Robo-Advisor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1000, 100, 540, 650);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(ResultWindow.class.getResource("/images/Picture3.jpg")));
        lblNewLabel.setBounds(0, 0, 577, 166);
        contentPane.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 177, 624, 573);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JTextPane txtpnInvestmentRecommendation = new JTextPane();
        txtpnInvestmentRecommendation.setEditable(false);
        txtpnInvestmentRecommendation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        txtpnInvestmentRecommendation.setText("Investment Recommendation for you:");
        txtpnInvestmentRecommendation.setBounds(10, 11, 542, 41);
        panel.add(txtpnInvestmentRecommendation);
        
        txtpnMsg = new JTextPane();
        txtpnMsg.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtpnMsg.setBounds(10, 55, 504, 620);
        panel.add(txtpnMsg);
    }

    public JTextPane getTxtpnMsg() {
        return txtpnMsg;
    }
    
    
}
