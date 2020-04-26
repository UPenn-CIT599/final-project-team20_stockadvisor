package com.java.YahooFinanceAPI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
//    public static void main (String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    MainWindow frame = new MainWindow();
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
    public MainWindow() {
        
        setTitle("Real Time API Robo-Advisor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 455);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(311, 0, 313, 416);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/Picture1.jpeg")));
        lblNewLabel.setBounds(0, 0, 313, 333);
        panel.add(lblNewLabel);
        
        JButton btnStartButton = new JButton("Start");
        btnStartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ParametersWindow window = new ParametersWindow();
                window.setVisible(true);
                setVisible(false);
            }
        });
        
        btnStartButton.setBackground(new Color(192, 192, 192));
        btnStartButton.setBounds(100, 322, 114, 42);
        contentPane.add(btnStartButton);
        
        JTextPane txtpnAuthors = new JTextPane();
        txtpnAuthors.setEditable(false);
        txtpnAuthors.setText("© Team 20: Boyu Wu, Liangen Hu, Chenming Cao");
        txtpnAuthors.setBounds(10, 245, 287, 33);
        contentPane.add(txtpnAuthors);
        
        JTextPane txtpnTitle = new JTextPane();
        txtpnTitle.setEditable(false);
        txtpnTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        txtpnTitle.setText("A Stock Investment Advisor by Time Series Trend Analysis");
        txtpnTitle.setBounds(10, 43, 287, 224);
        contentPane.add(txtpnTitle);
        
    }

    
}
