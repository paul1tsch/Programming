package htbla.kaindorf.second_grade.pos.q2.Calendar;

import htbla.kaindorf.second_grade.pos.q2.Calendar.bl.CalendarBL;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        CalendarGUI.java
 */

public class CalendarGUI extends javax.swing.JFrame {

    CalendarBL bl = new CalendarBL();

    private javax.swing.JButton btApointment;
    private javax.swing.JButton btCreate;
    private javax.swing.JButton btDelete;
    private javax.swing.JEditorPane epMonths;
    private javax.swing.JLabel lbMonth;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JScrollPane spScroll;
    private javax.swing.JTextField tfMonth;

    public CalendarGUI() {
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
        java.awt.EventQueue.invokeLater(() -> new CalendarGUI().setVisible(true));
    }

    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        lbMonth = new javax.swing.JLabel();
        tfMonth = new javax.swing.JTextField();
        btCreate = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        btApointment = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        spScroll = new javax.swing.JScrollPane();
        epMonths = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(new java.awt.BorderLayout());

        panel3.setLayout(new java.awt.GridLayout(1, 3));

        lbMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMonth.setText("Month:");
        panel3.add(lbMonth);
        panel3.add(tfMonth);

        btCreate.setText("Create");
        btCreate.addActionListener(evt -> onGenerateDaysOfMonth());
        panel3.add(btCreate);

        panel1.add(panel3, java.awt.BorderLayout.NORTH);

        panel2.setLayout(new java.awt.GridLayout(1, 2));

        btApointment.setText("Create");
        btApointment.addActionListener(evt -> onGenerateEvents());
        panel2.add(btApointment);

        btDelete.setText("Delete");
        btDelete.addActionListener(evt -> onRemoveEvents());
        panel2.add(btDelete);

        panel1.add(panel2, java.awt.BorderLayout.SOUTH);

        epMonths.setContentType("text/html");
        epMonths.setFont(new java.awt.Font("Courier New", Font.PLAIN, 12));
        spScroll.setViewportView(epMonths);

        panel1.add(spScroll, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void onGenerateDaysOfMonth() {
        String month = tfMonth.getText();
        String dates_string = bl.generateDaysOfMonth(month);

        epMonths.setText(dates_string);
    }

    private void onGenerateEvents() {
        epMonths.setText(bl.generateEvents());
    }

    private void onRemoveEvents() {
        String str = JOptionPane.showInputDialog("Which appointment would you like to delete? [Enter the Day]");
        epMonths.setText(bl.delEvent(str));
    }
}
