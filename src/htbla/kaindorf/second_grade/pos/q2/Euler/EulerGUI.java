package htbla.kaindorf.second_grade.pos.q2.Euler;

import htbla.kaindorf.second_grade.pos.q2.Euler.bl.EulerBL;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        EulerGUI.java
 */

public class EulerGUI extends javax.swing.JFrame {

    EulerBL euler = new EulerBL();

    private boolean isCheckedMultiplesOf3And5 = false;
    private boolean isCheckedSpecialPythagoreanTriplet = false;
    private boolean isCheckedFactorialDigitSum = false;
    private boolean isCheckedLexicographicPermutations = false;
    private boolean isCheckedLargestPrimeFactor = false;
    private javax.swing.JButton btCalculate;
    private javax.swing.JCheckBox cbfact;
    private javax.swing.JCheckBox cbprime;
    private javax.swing.JCheckBox cblex;
    private javax.swing.JCheckBox cbmult;
    private javax.swing.JCheckBox cbpytha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taResult;

    public EulerGUI() {
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
        setLocationRelativeTo(null);
        setSize(400, 400);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new EulerGUI().setVisible(true));
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbmult = new javax.swing.JCheckBox();
        cbprime = new javax.swing.JCheckBox();
        cbpytha = new javax.swing.JCheckBox();
        cbfact = new javax.swing.JCheckBox();
        cblex = new javax.swing.JCheckBox();
        btCalculate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taResult = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Euler Problems"));
        jPanel1.setLayout(new java.awt.GridLayout(6, 1));

        cbmult.setFont(new java.awt.Font("Poppins", Font.BOLD, 11));
        cbmult.setText("1 - Multiples of 3 and 5 till 1000");
        cbmult.addActionListener(evt -> isCheckedMultiplesOf3And5());
        jPanel1.add(cbmult);

        cbprime.setFont(new java.awt.Font("Poppins", Font.BOLD, 11));
        cbprime.setText("3 - Largest prime factor of 600851475142");
        cbprime.addActionListener(evt -> isCheckedLargestPrimeFactor());
        jPanel1.add(cbprime);

        cbpytha.setFont(new java.awt.Font("Poppins", Font.BOLD, 11));
        cbpytha.setText("9 - Special Pythagorean Triplet");
        cbpytha.addActionListener(evt -> isCheckedSpecialPythagoreanTriplet());
        jPanel1.add(cbpytha);

        cbfact.setFont(new java.awt.Font("Poppins", Font.BOLD, 11));
        cbfact.setText("20 - Factorial Digit Sum");
        cbfact.addActionListener(evt -> isCheckedFactorialDigitSum());
        jPanel1.add(cbfact);

        cblex.setFont(new java.awt.Font("Poppins", Font.BOLD, 11));
        cblex.setText("24 - Lexicographic Permutations");
        cblex.addActionListener(evt -> isCheckedLexicographicPermutations());
        jPanel1.add(cblex);

        btCalculate.setText("Calculate");
        btCalculate.addActionListener(evt -> onCalculate());
        jPanel1.add(btCalculate);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Result"));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        taResult.setColumns(20);
        taResult.setRows(5);
        jScrollPane1.setViewportView(taResult);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void isCheckedMultiplesOf3And5() {
        isCheckedMultiplesOf3And5 = !isCheckedMultiplesOf3And5;
    }

    private void isCheckedLargestPrimeFactor() {
        isCheckedLargestPrimeFactor = !isCheckedLargestPrimeFactor;
    }

    private void isCheckedSpecialPythagoreanTriplet() {
        isCheckedSpecialPythagoreanTriplet = !isCheckedSpecialPythagoreanTriplet;
    }

    private void isCheckedFactorialDigitSum() {
        isCheckedFactorialDigitSum = !isCheckedFactorialDigitSum;
    }

    private void isCheckedLexicographicPermutations() {
        isCheckedLexicographicPermutations = !isCheckedLexicographicPermutations;
    }

    private void onCalculate() {
        taResult.setText(euler.calculation(isCheckedMultiplesOf3And5, isCheckedLargestPrimeFactor, isCheckedSpecialPythagoreanTriplet, isCheckedFactorialDigitSum, isCheckedLexicographicPermutations));
    }
}
