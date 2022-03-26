package htbla.kaindorf.second_grade.pos.q2.Fraction;

import htbla.kaindorf.second_grade.pos.q2.Fraction.bl.Fraction;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        FractionGUI.java
 */

public class FractionGUI extends javax.swing.JFrame {

    private javax.swing.JButton btSimplify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tfDenominator1;
    private javax.swing.JTextField tfDenominator2;
    private javax.swing.JTextField tfNumerator1;
    private javax.swing.JTextField tfNumerator2;

    public FractionGUI() {
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
        java.awt.EventQueue.invokeLater(() -> new FractionGUI().setVisible(true));
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNumerator1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDenominator1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btSimplify = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfNumerator2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfDenominator2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", Font.PLAIN, 12), new java.awt.Color(93, 93, 93)));
        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 20, 20));
        jPanel2.add(jLabel1);

        tfNumerator1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNumerator1.setText("1");
        jPanel2.add(tfNumerator1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fraction     ");
        jPanel2.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("--------------");
        jPanel2.add(jLabel3);
        jPanel2.add(jLabel4);

        tfDenominator1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDenominator1.setText("1");
        jPanel2.add(tfDenominator1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel4.setMaximumSize(new java.awt.Dimension(72, 35));
        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                onResize();
            }
        });
        jPanel4.setLayout(new java.awt.CardLayout(5, 5));

        btSimplify.setText("simplify");
        btSimplify.setHideActionText(true);
        btSimplify.setMaximumSize(new java.awt.Dimension(72, 40));
        btSimplify.setMinimumSize(new java.awt.Dimension(72, 40));
        btSimplify.setPreferredSize(new java.awt.Dimension(72, 20));
        btSimplify.addActionListener(evt -> onSimplify());
        jPanel4.add(btSimplify, "card2");

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Simplified", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", Font.PLAIN, 12), new java.awt.Color(93, 93, 93))); // NOI18N
        jPanel3.setLayout(new java.awt.GridLayout(3, 2, 20, 20));
        jPanel3.add(jLabel5);

        tfNumerator2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNumerator2.setText("1");
        jPanel3.add(tfNumerator2);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Fraction     ");
        jPanel3.add(jLabel6);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("--------------");
        jPanel3.add(jLabel7);
        jPanel3.add(jLabel8);

        tfDenominator2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDenominator2.setText("1");
        jPanel3.add(tfDenominator2);

        jPanel1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void onSimplify() {
        int a = Integer.parseInt(tfNumerator1.getText());
        int b = Integer.parseInt(tfDenominator1.getText());
        Fraction fraction = new Fraction(a, b);
        fraction.cancel();

        tfNumerator2.setText("" + fraction.getNumerator());
        tfDenominator2.setText("" + fraction.getDenominator());

    }

    private void onResize() {
        System.out.println(new Date() + "onResize");

        System.out.println("jPanel4 height=" + jPanel4.getSize().height);
        System.out.println("btSimplify height=" + btSimplify.getSize().height);

        CardLayout cl = (CardLayout) jPanel4.getLayout();
        System.out.println("CardLayout Vgap = " + cl.getVgap());

        int gap = (jPanel4.getSize().height - 40) / 2;
        cl.setVgap(gap);

        int width = btSimplify.getSize().width;
        btSimplify.setSize(width, 40);
        System.out.println("btSimplify height=" + btSimplify.getSize().height);

    }
}
