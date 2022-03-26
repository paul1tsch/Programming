package htbla.kaindorf.second_grade.pos.q3.StationList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        StationListGUI.java
 */

public class StationListGUI extends javax.swing.JFrame {

    private final DefaultListModel<String> dlm = new DefaultListModel<>();

    private javax.swing.JButton btClear;
    private javax.swing.JButton btInit;
    private javax.swing.JButton btInsert;
    private javax.swing.JButton btRemove;
    private javax.swing.JButton btShuffle;
    private javax.swing.JList<String> lList;
    private javax.swing.JPanel panelMiddle;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JScrollPane spScroll;
    private javax.swing.JTextField tfText;

    public StationListGUI() {
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

        setTitle("Station List Graphical User Interface");
        setSize(350, 550);
        setLocationRelativeTo(null);

        setResizable(false);

        lList.setModel(dlm);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new StationListGUI().setVisible(true));
    }

    private void initComponents() {

        panelNorth = new javax.swing.JPanel();
        btInit = new javax.swing.JButton();
        panelMiddle = new javax.swing.JPanel();
        spScroll = new javax.swing.JScrollPane();
        lList = new javax.swing.JList<>();
        panelSouth = new javax.swing.JPanel();
        tfText = new javax.swing.JTextField();
        btInsert = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        btShuffle = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelNorth.setLayout(new java.awt.GridLayout());

        btInit.setText("Init");
        btInit.addActionListener(evt -> onInit());
        panelNorth.add(btInit);

        add(panelNorth, java.awt.BorderLayout.PAGE_START);

        panelMiddle.setBorder(javax.swing.BorderFactory.createTitledBorder("List of stations"));
        panelMiddle.setLayout(new javax.swing.OverlayLayout(panelMiddle));

        lList.setModel(new javax.swing.AbstractListModel<>() {
            final String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        spScroll.setViewportView(lList);

        panelMiddle.add(spScroll);

        add(panelMiddle, java.awt.BorderLayout.CENTER);

        panelSouth.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));
        panelSouth.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        tfText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelSouth.add(tfText);

        btInsert.setText("+ Insert");
        btInsert.addActionListener(evt -> onInsert());
        panelSouth.add(btInsert);

        btRemove.setText("- Remove");
        btRemove.addActionListener(evt -> onRemove());
        panelSouth.add(btRemove);

        btClear.setText("🗑 Clear");
        btClear.addActionListener(evt -> onClear());
        panelSouth.add(btClear);

        btShuffle.setText("🔀 Shuffle");
        btShuffle.addActionListener(evt -> onShuffle());
        panelSouth.add(btShuffle);

        add(panelSouth, java.awt.BorderLayout.PAGE_END);
    }

    private void onInit() {
        dlm.clear();
        dlm.addElement("ORF1");
        dlm.addElement("ORF2");
        dlm.addElement("ATV");
        dlm.addElement("ARD");
        dlm.addElement("PULS4");
    }

    private void onInsert() {
        int selectedIndex = lList.getSelectedIndex();
        String newText = tfText.getText();

        System.out.println("[+] onInsert: Index[" + selectedIndex + "]");

        if (dlm.contains(newText)) {
            JOptionPane.showMessageDialog(this, "[-] " + newText + " is already in the list!");
            return;
        }
        if (selectedIndex < 0) {
            dlm.add(selectedIndex, tfText.getText());

        } else {
            dlm.add(selectedIndex, newText);
        }

    }

    private void onRemove() {
        int[] selectedIndices = lList.getSelectedIndices();

        for (int i = selectedIndices.length - 1; i > -1; i--) {
            dlm.remove(selectedIndices[i]);
        }
    }

    private void onClear() {
        dlm.clear();
    }

    private void onShuffle() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < dlm.getSize(); i++) {
            list.add(dlm.get(i));
        }
        Collections.shuffle(list);

        dlm.clear();
        dlm.addAll(list);
    }
}
