package htbla.kaindorf.second_grade.pos.q4.MiniTel;

import htbla.kaindorf.second_grade.pos.q4.MiniTel.beans.Entry;
import htbla.kaindorf.second_grade.pos.q4.MiniTel.model.MiniTelModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        MiniTelGUI.java
 */

public class MiniTelGUI extends javax.swing.JFrame {

    private final MiniTelModel model = new MiniTelModel();
    private final String mode = "all";

    private javax.swing.ButtonGroup bgGroup;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btSave;
    private javax.swing.JList<String> lList;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNumber;
    private javax.swing.JMenuItem mAll;
    private javax.swing.JMenuItem mBusiness;
    private javax.swing.JMenuItem mPrivate;
    private javax.swing.JPanel pInput;
    private javax.swing.JPanel pNumbers;
    private javax.swing.JPopupMenu popMenu;
    private javax.swing.JRadioButton rbBusiness;
    private javax.swing.JRadioButton rbPrivate;
    private javax.swing.JScrollPane spScroll;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfNumber;

    public MiniTelGUI() {
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

        setSize(391, 489);
        setLocationRelativeTo(null);
        setTitle("GUI MiniTelGUI");
        lList.setModel(model);

        // Test
        model.save(new Entry("Patrik", "+43-660-2870713", true));
        model.save(new Entry("Poelzi", "+43-676-3004330", false));
        model.save(new Entry("Dominik", "+43-664-1370022", true));
        model.save(new Entry("Patrik2", "+43-660-2870713", true));
        model.save(new Entry("Poelzi2", "+43-676-3004330", false));
        model.save(new Entry("Dominik2", "+43-664-1370022", true));

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MiniTelGUI().setVisible(true));
    }

    private void initComponents() {
        bgGroup = new javax.swing.ButtonGroup();
        popMenu = new javax.swing.JPopupMenu();
        mAll = new javax.swing.JMenuItem();
        mPrivate = new javax.swing.JMenuItem();
        mBusiness = new javax.swing.JMenuItem();
        pNumbers = new javax.swing.JPanel();
        spScroll = new javax.swing.JScrollPane();
        lList = new javax.swing.JList<>();
        pInput = new javax.swing.JPanel();
        btSave = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbNumber = new javax.swing.JLabel();
        tfNumber = new javax.swing.JTextField();
        rbPrivate = new javax.swing.JRadioButton();
        rbBusiness = new javax.swing.JRadioButton();

        mAll.setFont(new java.awt.Font("JetBrains Mono NL", Font.PLAIN, 12));
        mAll.setText("all");
        mAll.addActionListener(this::onMenuItem);
        popMenu.add(mAll);

        mPrivate.setFont(new java.awt.Font("JetBrains Mono NL", Font.PLAIN, 12));
        mPrivate.setText("private");
        mPrivate.addActionListener(this::onMenuItem);
        popMenu.add(mPrivate);

        mBusiness.setFont(new java.awt.Font("JetBrains Mono NL", Font.PLAIN, 12));
        mBusiness.setText("business");
        mBusiness.addActionListener(this::onMenuItem);
        popMenu.add(mBusiness);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pNumbers.setBorder(javax.swing.BorderFactory.createTitledBorder("All phone-numbers"));
        pNumbers.setLayout(new javax.swing.OverlayLayout(pNumbers));

        lList.setFont(new java.awt.Font("JetBrains Mono NL", Font.PLAIN, 14));
        lList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onMouseClicked(evt);
            }
        });
        spScroll.setViewportView(lList);

        pNumbers.add(spScroll);

        getContentPane().add(pNumbers, java.awt.BorderLayout.CENTER);

        pInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        pInput.setLayout(new java.awt.GridLayout(4, 2));

        btSave.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12));
        btSave.setText("Save");
        btSave.addActionListener(evt -> onSave());
        pInput.add(btSave);

        btDelete.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12));
        btDelete.setText("Delete");
        btDelete.addActionListener(evt -> onDelete());
        pInput.add(btDelete);

        lbName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbName.setText("Name: ");
        pInput.add(lbName);

        tfName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pInput.add(tfName);

        lbNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNumber.setText("Number: ");
        pInput.add(lbNumber);

        tfNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pInput.add(tfNumber);

        bgGroup.add(rbPrivate);
        rbPrivate.setSelected(true);
        rbPrivate.setText("Private");
        pInput.add(rbPrivate);

        bgGroup.add(rbBusiness);
        rbBusiness.setText("Business");
        pInput.add(rbBusiness);

        getContentPane().add(pInput, java.awt.BorderLayout.SOUTH);

        pack();
    }

    private void onMouseClicked(java.awt.event.MouseEvent evt) {
        System.out.println("onMouseClicked");
        if (evt.getButton() == MouseEvent.BUTTON3) {
            popMenu.show(lList, evt.getX(), evt.getY());
        }
    }

    private void onMenuItem(java.awt.event.ActionEvent evt) {
        System.out.println(evt.getActionCommand());
        String mode = evt.getActionCommand();

        TitledBorder border = (TitledBorder) pNumbers.getBorder();
        border.setTitle(mode + " numbers");
        pNumbers.repaint();

        model.filter(mode);
    }

    private void onSave() {
        String name = tfName.getText();
        String num = tfNumber.getText();
        boolean isPrivate = rbPrivate.isSelected();

        Entry entry = new Entry(name, num, isPrivate);
        model.save(entry);
    }

    private void onDelete() {
        int[] indices = lList.getSelectedIndices();
        model.delete(indices);
    }
}
