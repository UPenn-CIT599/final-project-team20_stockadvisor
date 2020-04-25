package com.java.YahooFinanceAPI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ResultWindow extends JFrame {

    private JPanel contentPane;
    private JTextPane txtpnMsg;

    /**
     * Create the frame.
     */
    public ResultWindow() {
        setTitle("Stock Advisor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 455);
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
        panel.setBounds(0, 177, 624, 228);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JTextPane txtpnInvestmentRecommendation = new JTextPane();
        txtpnInvestmentRecommendation.setEditable(false);
        txtpnInvestmentRecommendation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        txtpnInvestmentRecommendation.setText("Investment Recommendation for you:");
        txtpnInvestmentRecommendation.setBounds(79, 11, 473, 41);
        panel.add(txtpnInvestmentRecommendation);
        
        txtpnMsg = new JTextPane();
        txtpnMsg.setFont(new Font("Tahoma", Font.BOLD, 18));
        txtpnMsg.setBounds(79, 84, 468, 102);
        panel.add(txtpnMsg);
    }

    public JTextPane getTxtpnMsg() {
        return txtpnMsg;
    }
    
    
}
