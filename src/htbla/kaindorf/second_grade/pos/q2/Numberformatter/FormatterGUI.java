package htbla.kaindorf.second_grade.pos.q2.Numberformatter;

import htbla.kaindorf.second_grade.pos.q2.Numberformatter.bl.NumberFormatter;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        FormatterGUI.java
 */

public class FormatterGUI extends javax.swing.JFrame {

    NumberFormatter numberFormatter = new NumberFormatter();

    private javax.swing.JPanel Button;
    private javax.swing.JPanel Format;
    private javax.swing.JPanel textInput;
    private javax.swing.JButton btFormat;
    private javax.swing.JCheckBox cbRight;
    private javax.swing.JCheckBox cbDelimiter;
    private javax.swing.JScrollPane spScroll;
    private javax.swing.JLabel lbInput;
    private javax.swing.JLabel lbFormat;
    private javax.swing.JLabel lbFiller;
    private javax.swing.JTextArea taOutput;
    private javax.swing.JTextField tfInput;
    private javax.swing.JTextField tfFormat;
    private javax.swing.JTextField tfFiller;
    private boolean isCheckedDelimiter = false;
    private boolean isCheckedRight = false;
    private double num;
    private String format;
    private String fillChar;

    public FormatterGUI() {
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
        java.awt.EventQueue.invokeLater(() -> new FormatterGUI().setVisible(true));
    }

    private void initComponents() {

        Format = new javax.swing.JPanel();
        lbInput = new javax.swing.JLabel();
        tfInput = new javax.swing.JTextField();
        cbDelimiter = new javax.swing.JCheckBox();
        lbFormat = new javax.swing.JLabel();
        tfFormat = new javax.swing.JTextField();
        cbRight = new javax.swing.JCheckBox();
        lbFiller = new javax.swing.JLabel();
        tfFiller = new javax.swing.JTextField();
        textInput = new javax.swing.JPanel();
        spScroll = new javax.swing.JScrollPane();
        taOutput = new javax.swing.JTextArea();
        Button = new javax.swing.JPanel();
        btFormat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Format.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Format", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", Font.PLAIN, 14), new java.awt.Color(127, 0, 128)));
        Format.setLayout(new java.awt.GridLayout(3, 0, 3, 0));

        lbInput.setText("Eingabezahl");
        Format.add(lbInput);

        tfInput.addActionListener(evt -> tfInputActionPerformed());
        Format.add(tfInput);

        cbDelimiter.setText("Trennzeichen");
        cbDelimiter.addActionListener(evt -> isCheckedDelimiter());
        Format.add(cbDelimiter);

        lbFormat.setText("Format");
        Format.add(lbFormat);

        tfFormat.addActionListener(evt -> tfFormatActionPerformed());
        Format.add(tfFormat);

        cbRight.setText("rechtsbündig");
        cbRight.addActionListener(evt -> isCheckedRight());
        Format.add(cbRight);

        lbFiller.setText("Füllzeichen");
        Format.add(lbFiller);

        tfFiller.addActionListener(evt -> tfFillerActionPerformed());
        Format.add(tfFiller);

        getContentPane().add(Format, java.awt.BorderLayout.PAGE_START);

        textInput.setLayout(new java.awt.BorderLayout());

        taOutput.setColumns(20);
        taOutput.setRows(5);
        spScroll.setViewportView(taOutput);

        textInput.add(spScroll, java.awt.BorderLayout.CENTER);

        getContentPane().add(textInput, java.awt.BorderLayout.CENTER);

        Button.setLayout(new java.awt.BorderLayout());

        btFormat.setText("Formatieren");
        btFormat.addActionListener(evt -> onClick());
        Button.add(btFormat, java.awt.BorderLayout.CENTER);

        getContentPane().add(Button, java.awt.BorderLayout.PAGE_END);

        pack();
    }

    private void tfInputActionPerformed() {
    }

    private void tfFillerActionPerformed() {
    }

    private void isCheckedDelimiter() {
        isCheckedDelimiter = !isCheckedDelimiter;
    }

    private void isCheckedRight() {
        isCheckedRight = !isCheckedRight;
    }

    private void tfFormatActionPerformed() {
    }

    private void onClick() {
        num = Double.parseDouble(tfInput.getText());
        fillChar = tfFiller.getText();
        format = tfFormat.getText();
        taOutput.setText(numberFormatter.format(num, format, fillChar, isCheckedDelimiter, isCheckedRight));
    }
}
