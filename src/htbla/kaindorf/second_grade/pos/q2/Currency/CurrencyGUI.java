package htbla.kaindorf.second_grade.pos.q2.Currency;

import htbla.kaindorf.second_grade.pos.q2.Currency.beans.Rate;

import javax.swing.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        CurrencyGUI.java
 */

public class CurrencyGUI extends javax.swing.JFrame {

    private double rate = 0.0;
    private javax.swing.JButton btDOLLARtoEURO;
    private javax.swing.JButton btEUROtoDOLLAR;
    private javax.swing.JLabel lbEuro;
    private javax.swing.JLabel lbDollar;
    private javax.swing.JPanel panel1;
    private javax.swing.JTextField tfDOLLAR;
    private javax.swing.JTextField tfEURO;

    public CurrencyGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                System.out.println(laf);
            }
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
        }
        String strRate = new Rate().downloadRate();
        rate = Double.parseDouble(strRate);

        initComponents();
        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new CurrencyGUI().setVisible(true));
    }

    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        lbEuro = new javax.swing.JLabel();
        tfEURO = new javax.swing.JTextField();
        lbDollar = new javax.swing.JLabel();
        tfDOLLAR = new javax.swing.JTextField();
        btEUROtoDOLLAR = new javax.swing.JButton();
        btDOLLARtoEURO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Currency Converter");

        panel1.setLayout(new java.awt.GridLayout(3, 2));

        lbEuro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEuro.setText("Euro (€)");
        lbEuro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panel1.add(lbEuro);

        tfEURO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfEURO.setText("0.0");
        tfEURO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onEUROtoDOLLAR_clicked();
            }
        });
        panel1.add(tfEURO);

        lbDollar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDollar.setText("Dollar ($)");
        panel1.add(lbDollar);

        tfDOLLAR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDOLLAR.setText("0.0");
        tfDOLLAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onDOLLARtoEURO_clicked();
            }
        });

        panel1.add(tfDOLLAR);

        btEUROtoDOLLAR.setText("€ --> $");
        btEUROtoDOLLAR.addActionListener(evt -> onEUROtoDOLLAR());
        panel1.add(btEUROtoDOLLAR);

        btDOLLARtoEURO.setText("$ --> €");
        btDOLLARtoEURO.addActionListener(this::onDOLLARtoEURO);
        panel1.add(btDOLLARtoEURO);

        getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }


    private void onEUROtoDOLLAR() {

        Locale.setDefault(Locale.US);
        System.out.println("onEUROtoDOLLAR has been clicked!");
        String strEURO = tfEURO.getText();
        double euros = Double.parseDouble(strEURO);
        double dollars = euros * rate;

        String strDOLLAR = String.format("%.2f", dollars);
        strEURO = String.format("%.2f", euros);

        tfDOLLAR.setText(strDOLLAR);
        tfEURO.setText(strEURO);
    }

    private void onDOLLARtoEURO(java.awt.event.ActionEvent evt) {
        Locale.setDefault(Locale.US);
        System.out.println("onDOLLARtoEURO has been clicked!");
        String strDOLLAR = tfDOLLAR.getText();
        double dollars = Double.parseDouble(strDOLLAR);
        double euros = dollars / rate;

        String strEURO = String.format("%.2f", euros);
        strDOLLAR = String.format("%.2f", dollars);

        tfEURO.setText(strEURO);
        tfDOLLAR.setText(strDOLLAR);

    }

    private void onEUROtoDOLLAR_clicked() {
        System.out.println("onEUROtoDOLLAR_clicked has been clicked!");
        tfEURO.selectAll();
    }

    private void onDOLLARtoEURO_clicked() {
        System.out.println("onDOLLARtoEURO_clicked has been clicked!");
        tfDOLLAR.selectAll();
    }
}
