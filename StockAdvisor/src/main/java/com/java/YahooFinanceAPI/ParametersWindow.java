package com.java.YahooFinanceAPI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParametersWindow extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ParametersWindow frame = new ParametersWindow();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ParametersWindow() {
        setTitle("Stock Advisor");
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
        
        JLabel lblStep1 = new JLabel("Step 1: Please write down the ticker of the stock/ETF, then click the \"Check\" button.");
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
        
        JRadioButton rdbtnShortTerm = new JRadioButton("Short Term");
        rdbtnShortTerm.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonGroup.add(rdbtnShortTerm);
        rdbtnShortTerm.setBounds(125, 30, 109, 23);
        panelStep2.add(rdbtnShortTerm);
        
        JRadioButton rdbtnLongTerm = new JRadioButton("Long Term");
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
                ResultWindow result = new ResultWindow();
                result.setVisible(true);
                setVisible(false);
            }
        });
        btnContinue.setBackground(Color.LIGHT_GRAY);
        btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnContinue.setBounds(245, 31, 89, 23);
        panelStep3.add(btnContinue);
    }
}
