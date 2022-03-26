package htbla.kaindorf.second_grade.pos.q4.Student;

import htbla.kaindorf.second_grade.pos.q4.Student.beans.Student;
import htbla.kaindorf.second_grade.pos.q4.Student.model.StudentListModel;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        StudentListGUI.java
 */

public class StudentListGUI extends javax.swing.JFrame {

    private final StudentListModel model = new StudentListModel();

    private javax.swing.JButton btDelete;
    private javax.swing.JButton btInsert;
    private javax.swing.JButton btModify;
    private javax.swing.JList<String> lList;
    private javax.swing.JLabel lbBirthday;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbSurname;
    private javax.swing.JPanel panelMiddle;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JPanel panelWhole;
    private javax.swing.JScrollPane spScroll;
    private javax.swing.JTextField tfBirthday;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSurname;

    public StudentListGUI() {
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

        setTitle("Student List Graphical User Interface");

        setSize(350, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        lList.setModel(model);

        model.add(new Student("Dominik", "Paulitsch1", "20.12.2004"));
        model.add(new Student("Dominik", "Paulitsch2", "20.12.2004"));
        model.add(new Student("Dominik", "Paulitsch3", "20.12.2004"));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new StudentListGUI().setVisible(true));
    }

    private void initComponents() {

        panelSouth = new javax.swing.JPanel();
        spScroll = new javax.swing.JScrollPane();
        lList = new javax.swing.JList<>();
        panelWhole = new javax.swing.JPanel();
        panelNorth = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbSurname = new javax.swing.JLabel();
        tfSurname = new javax.swing.JTextField();
        lbBirthday = new javax.swing.JLabel();
        tfBirthday = new javax.swing.JTextField();
        panelMiddle = new javax.swing.JPanel();
        btInsert = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btModify = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelSouth.setBorder(javax.swing.BorderFactory.createTitledBorder("Students"));
        panelSouth.setLayout(new javax.swing.OverlayLayout(panelSouth));

        lList.setFont(new java.awt.Font("Fira Code", Font.PLAIN, 12));
        lList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onDisplayStudent();
            }
        });
        spScroll.setViewportView(lList);

        panelSouth.add(spScroll);

        add(panelSouth, java.awt.BorderLayout.CENTER);

        panelWhole.setPreferredSize(null);
        panelWhole.setLayout(new java.awt.BorderLayout());

        panelNorth.setMinimumSize(new java.awt.Dimension(150, 76));
        panelNorth.setLayout(new java.awt.GridLayout(3, 0, 5, 5));

        lbName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbName.setText("Name:");
        panelNorth.add(lbName);

        tfName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        panelNorth.add(tfName);

        lbSurname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSurname.setText("Surname:");
        panelNorth.add(lbSurname);

        tfSurname.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        panelNorth.add(tfSurname);

        lbBirthday.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbBirthday.setText("Birthday:");
        panelNorth.add(lbBirthday);

        tfBirthday.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        panelNorth.add(tfBirthday);

        panelWhole.add(panelNorth, java.awt.BorderLayout.NORTH);

        panelMiddle.setMaximumSize(new java.awt.Dimension(250, 22));
        panelMiddle.setLayout(new java.awt.GridLayout(1, 0, 20, 10));

        btInsert.setText("insert");
        btInsert.addActionListener(evt -> onInsert());
        panelMiddle.add(btInsert);

        btDelete.setText("delete");
        btDelete.addActionListener(evt -> onDelete());
        panelMiddle.add(btDelete);

        btModify.setText("modify");
        btModify.addActionListener(evt -> onModify());
        panelMiddle.add(btModify);

        panelWhole.add(panelMiddle, java.awt.BorderLayout.SOUTH);

        add(panelWhole, java.awt.BorderLayout.NORTH);
    }

    private void onInsert() {
        if (tfName.getText().isEmpty() || tfSurname.getText().isEmpty() || tfBirthday.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "[-] BAD DATA");
            return;
        }
        try {
            Student student = new Student(tfName.getText(), tfSurname.getText(), tfBirthday.getText());
            model.add(student);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "[-] BAD DATA");
        }
    }

    private void onDelete() {
        int[] indices = lList.getSelectedIndices();
        model.delete(indices);
    }

    private void onModify() {
        Student student = new Student(tfName.getText(), tfSurname.getText(), tfBirthday.getText());
        int index = lList.getSelectedIndex();
        model.modify(index, student);
    }

    private void onDisplayStudent() {
        int index = lList.getSelectedIndex();
        Student student = model.getStudent(index);

        tfName.setText(student.getName());
        tfSurname.setText(student.getSurname());
        tfBirthday.setText(student.getsDateOfBirth());
    }
}
