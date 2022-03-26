package htbla.kaindorf.second_grade.pos.q3.NumberList;

import htbla.kaindorf.second_grade.pos.q3.NumberList.bl.NumberListBL;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        NumberListGUI.java
 */

public class NumberListGUI extends javax.swing.JFrame {

    NumberListBL bl;

    private javax.swing.JPanel Change;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Init;
    private javax.swing.ButtonGroup bgFirst;
    private javax.swing.ButtonGroup bgSecond;
    private javax.swing.JButton btInit;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbValue;
    private javax.swing.JRadioButton rbIndex;
    private javax.swing.JTextField tfIndexOrValue;
    private javax.swing.JLabel lbElement;
    private javax.swing.JRadioButton rbFixed;
    private javax.swing.JRadioButton rbRandom;
    private javax.swing.JScrollPane spScroll;
    private javax.swing.JSlider srElements;
    private javax.swing.JSlider srRandom;
    private javax.swing.JTextArea taValues;
    private javax.swing.JTextField tfFixed;

    public NumberListGUI() {
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
        setTitle("NumberList Graphical User Interface");
        setResizable(false);
        setSize(620, 550);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new NumberListGUI().setVisible(true));
    }

    private void initComponents() {

        bgFirst = new javax.swing.ButtonGroup();
        bgSecond = new javax.swing.ButtonGroup();
        Init = new javax.swing.JPanel();
        lbElement = new javax.swing.JLabel();
        srElements = new javax.swing.JSlider();
        rbRandom = new javax.swing.JRadioButton();
        srRandom = new javax.swing.JSlider();
        rbFixed = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        btInit = new javax.swing.JButton();
        tfFixed = new javax.swing.JTextField();
        Change = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfIndexOrValue = new javax.swing.JTextField();
        rbIndex = new javax.swing.JRadioButton();
        btDelete = new javax.swing.JButton();
        rbValue = new javax.swing.JRadioButton();
        btInsert = new javax.swing.JButton();
        Content = new javax.swing.JPanel();
        spScroll = new javax.swing.JScrollPane();
        taValues = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Init.setBorder(javax.swing.BorderFactory.createTitledBorder("Init"));
        Init.setLayout(new java.awt.GridLayout(3, 2));

        lbElement.setText("Elements:");
        Init.add(lbElement);

        srElements.setMajorTickSpacing(10);
        srElements.setMinimum(10);
        srElements.setMinorTickSpacing(10);
        srElements.setPaintLabels(true);
        srElements.setPaintTicks(true);
        Init.add(srElements);

        bgFirst.add(rbRandom);
        rbRandom.setText("Random values:");
        Init.add(rbRandom);

        srRandom.setMajorTickSpacing(10);
        srRandom.setMinorTickSpacing(5);
        srRandom.setPaintLabels(true);
        srRandom.setPaintTicks(true);
        Init.add(srRandom);

        bgFirst.add(rbFixed);
        rbFixed.setSelected(true);
        rbFixed.setText("Fixed value:");
        Init.add(rbFixed);

        jPanel1.setLayout(new java.awt.BorderLayout(10, 10));

        btInit.setText("init");
        btInit.addActionListener(evt -> onInit());
        jPanel1.add(btInit, java.awt.BorderLayout.CENTER);

        tfFixed.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.add(tfFixed, java.awt.BorderLayout.LINE_START);

        Init.add(jPanel1);

        getContentPane().add(Init, java.awt.BorderLayout.PAGE_START);

        Change.setBorder(javax.swing.BorderFactory.createTitledBorder("Change"));
        Change.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        jLabel1.setText("Index/Value:");
        Change.add(jLabel1);

        tfIndexOrValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Change.add(tfIndexOrValue);

        bgSecond.add(rbIndex);
        rbIndex.setSelected(true);
        rbIndex.setText("Index");
        Change.add(rbIndex);

        btDelete.setText("Delete");
        btDelete.addActionListener(evt -> onDelete());
        Change.add(btDelete);

        bgSecond.add(rbValue);
        rbValue.setText("Value");
        Change.add(rbValue);

        btInsert.setText("Insert");
        btInsert.addActionListener(evt -> onInsert());
        Change.add(btInsert);

        getContentPane().add(Change, java.awt.BorderLayout.CENTER);

        Content.setBorder(javax.swing.BorderFactory.createTitledBorder("Content"));
        Content.setLayout(new javax.swing.OverlayLayout(Content));

        spScroll.setPreferredSize(new java.awt.Dimension(234, 170));

        taValues.setEditable(false);
        taValues.setColumns(20);
        taValues.setFont(new java.awt.Font("Fira Code", Font.PLAIN, 12));
        taValues.setRows(5);
        spScroll.setViewportView(taValues);

        Content.add(spScroll);

        getContentPane().add(Content, java.awt.BorderLayout.PAGE_END);

        pack();
    }


    private void onInit() {
        int fixedValue = Integer.parseInt(tfFixed.getText());
        bl = new NumberListBL(rbIndex.isSelected(), srElements.getValue(), srRandom.getValue(), fixedValue);
        bl.init();
        taValues.setText(bl.toString());
    }

    private void onDelete() {
        if (bl == null) {
            JOptionPane.showConfirmDialog(this, "[-] The array has not been initialized! Click init first!", "Error", JOptionPane.YES_NO_OPTION);
            return;
        }

        boolean isIndex = rbIndex.isSelected();
        int value = Integer.parseInt(tfIndexOrValue.getText());
        bl.delete(isIndex, value);

        taValues.setText(bl.toString());
        if (isIndex && value < 0 || value > bl.getNumbers().size() - 1) {
            JOptionPane.showMessageDialog(this, "[-] Index must be in the interval"
                    + "[0, " + (bl.getNumbers().size() - 1) + "]", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onInsert() {
        boolean isIndex = rbIndex.isSelected();
        int value = Integer.parseInt(tfIndexOrValue.getText());

        bl.insert(isIndex, value);
        taValues.setText(bl.toString());
    }
}
