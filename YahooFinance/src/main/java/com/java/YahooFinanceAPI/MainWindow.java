package com.java.YahooFinanceAPI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * This class builds the Main Window, the first window of our GUI.
 */
public class MainWindow extends JFrame implements Window {

    private JPanel contentPane;
    private JButton btnStartButton;

    /**
     * Constructor, create the frame for Main Window, show our project information.
     */
    public MainWindow() {

        initComponents();
        clickStartEvent();

    }

    /**
     * This method creates the initial look for the main window
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

        // Create Panel for image, set the background color.
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.GRAY);
        imagePanel.setBounds(311, 0, 313, 416);
        contentPane.add(imagePanel);
        imagePanel.setLayout(null);

        // Put in image as a label.
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/Picture1.jpeg")));
        lblNewLabel.setBounds(0, 0, 313, 333);
        imagePanel.add(lblNewLabel);

        // Create start button
        btnStartButton = new JButton("Start");
        btnStartButton.setName("Start");
        btnStartButton.setBackground(new Color(192, 192, 192));
        btnStartButton.setBounds(100, 322, 114, 42);
        contentPane.add(btnStartButton);
        
        // Show team members
        JTextPane txtpnAuthors = new JTextPane();
        txtpnAuthors.setName("Authors");
        txtpnAuthors.setEditable(false);
        txtpnAuthors.setText("© Team 20: Boyu Wu, Liangen Hu, Chenming Cao");
        txtpnAuthors.setBounds(10, 245, 287, 33);
        contentPane.add(txtpnAuthors);
        
        // Show project title
        JTextPane txtpnTitle = new JTextPane();
        txtpnTitle.setName("Title");
        txtpnTitle.setEditable(false);
        txtpnTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        txtpnTitle.setText("A Stock Investment Advisor by Time Series Trend Analysis");
        txtpnTitle.setBounds(10, 43, 287, 224);
        contentPane.add(txtpnTitle);

    }

    /**
     * This method creates an event for clicking the "Start" Button. After click
     * "Start", it will go to our next Parameter Window.
     */
    public void clickStartEvent() {

        btnStartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ParametersWindow parameters = new ParametersWindow();
                parameters.setVisible(true);
                setVisible(false);
            }
        });
    }

}
