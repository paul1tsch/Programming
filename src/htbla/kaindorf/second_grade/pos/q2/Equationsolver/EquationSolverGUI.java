package htbla.kaindorf.second_grade.pos.q2.Equationsolver;

import htbla.kaindorf.second_grade.pos.q2.Equationsolver.controller.EquationController;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        EquationSolverGUI.java
 */

public class EquationSolverGUI extends javax.swing.JFrame {

    private javax.swing.JButton btAcht;
    private javax.swing.JButton btCLR;
    private javax.swing.JButton btDrei;
    private javax.swing.JButton btEins;
    private javax.swing.JButton btFünf;
    private javax.swing.JButton btIstNull;
    private javax.swing.JButton btMinus;
    private javax.swing.JButton btNeun;
    private javax.swing.JButton btNull;
    private javax.swing.JButton btPlus;
    private javax.swing.JButton btSechs;
    private javax.swing.JButton btSieben;
    private javax.swing.JButton btVier;
    private javax.swing.JButton btX;
    private javax.swing.JButton btXqua;
    private javax.swing.JButton btZwei;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane taAusgabe;
    private javax.swing.JTextArea taDisplay;
    private int a;
    private int b;
    private int c;

    public EquationSolverGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                System.out.println(laf);
            }
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
        }

        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new EquationSolverGUI().setVisible(true));
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        taAusgabe = new javax.swing.JScrollPane();
        taDisplay = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btSieben = new javax.swing.JButton();
        btAcht = new javax.swing.JButton();
        btNeun = new javax.swing.JButton();
        btXqua = new javax.swing.JButton();
        btVier = new javax.swing.JButton();
        btFünf = new javax.swing.JButton();
        btSechs = new javax.swing.JButton();
        btX = new javax.swing.JButton();
        btEins = new javax.swing.JButton();
        btZwei = new javax.swing.JButton();
        btDrei = new javax.swing.JButton();
        btPlus = new javax.swing.JButton();
        btNull = new javax.swing.JButton();
        btIstNull = new javax.swing.JButton();
        btCLR = new javax.swing.JButton();
        btMinus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        taDisplay.setEditable(false);
        taDisplay.setColumns(20);
        taDisplay.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        taDisplay.setRows(5);
        taAusgabe.setViewportView(taDisplay);

        jPanel1.add(taAusgabe, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(4, 4));

        btSieben.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btSieben.setText("7");
        btSieben.addActionListener(this::onDigit);
        jPanel2.add(btSieben);

        btAcht.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btAcht.setText("8");
        btAcht.addActionListener(this::onDigit);
        jPanel2.add(btAcht);

        btNeun.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btNeun.setText("9");
        btNeun.addActionListener(this::onDigit);
        jPanel2.add(btNeun);

        btXqua.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btXqua.setText("x²");
        btXqua.addActionListener(this::onDigit);
        jPanel2.add(btXqua);

        btVier.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btVier.setText("4");
        btVier.addActionListener(this::onDigit);
        jPanel2.add(btVier);

        btFünf.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btFünf.setText("5");
        btFünf.addActionListener(this::onDigit);
        jPanel2.add(btFünf);

        btSechs.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btSechs.setText("6");
        btSechs.addActionListener(this::onDigit);
        jPanel2.add(btSechs);

        btX.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btX.setText("x");
        btX.addActionListener(this::onDigit);
        jPanel2.add(btX);

        btEins.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btEins.setText("1");
        btEins.addActionListener(this::onDigit);
        jPanel2.add(btEins);

        btZwei.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btZwei.setText("2");
        btZwei.addActionListener(this::onDigit);
        jPanel2.add(btZwei);

        btDrei.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btDrei.setText("3");
        btDrei.addActionListener(this::onDigit);
        jPanel2.add(btDrei);

        btPlus.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btPlus.setText("+");
        btPlus.addActionListener(this::onDigit);
        jPanel2.add(btPlus);

        btNull.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btNull.setText("0");
        btNull.addActionListener(this::onDigit);
        jPanel2.add(btNull);

        btIstNull.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btIstNull.setText("=0");
        btIstNull.addActionListener(this::onDigit);
        jPanel2.add(btIstNull);

        btCLR.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btCLR.setText("CLR");
        btCLR.addActionListener(evt -> onClear());
        jPanel2.add(btCLR);

        btMinus.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        btMinus.setText("-");
        btMinus.addActionListener(this::onDigit);
        jPanel2.add(btMinus);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void onDigit(java.awt.event.ActionEvent evt) {
        EquationController ctrl = new EquationController();

        JButton button = (JButton) evt.getSource();
        System.out.println(button.getText());
        String text = taDisplay.getText();
        text += button.getText();
        taDisplay.setText(text);
        if (button.getText().equals("=0")) {
            //compute a, b, c and display them
            a = ctrl.findA(taDisplay.getText());
            b = ctrl.findB(taDisplay.getText());
            c = ctrl.findC(taDisplay.getText());
        }
    }

    private void onClear() {
        taDisplay.setText(" ");
    }
}
