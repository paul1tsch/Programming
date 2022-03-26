package htbla.kaindorf.second_grade.pos.q3.NameList;

import htbla.kaindorf.second_grade.pos.q3.NameList.bl.NameListBL;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        NameListGUI.java
 */

public class NameListGUI extends javax.swing.JFrame {

    NameListBL bl = new NameListBL();

    private javax.swing.JTextField tfName_of_List;
    private javax.swing.JTextField tfPosition_of_List;
    private javax.swing.JTextField tfName;

    public NameListGUI() {
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

        setResizable(false);
        setSize(801, 240);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new NameListGUI().setVisible(true));
    }

    private void initComponents() {

        JPanel panel_1 = new JPanel();
        tfName = new javax.swing.JTextField();
        JButton btInsert = new JButton();
        JButton btDelete = new JButton();
        JPanel panel_2 = new JPanel();
        JLabel lbPosition = new JLabel();
        JLabel lbName = new JLabel();
        tfName_of_List = new javax.swing.JTextField();
        tfPosition_of_List = new javax.swing.JTextField();
        JButton btArrowDown = new JButton();
        JButton btArrowUp = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(0, 2));

        panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Fira Code", Font.PLAIN, 12))); // NOI18N
        panel_1.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        tfName.setFont(new java.awt.Font("Fira Code", Font.PLAIN, 14)); // NOI18N
        tfName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        panel_1.add(tfName);

        btInsert.setFont(new java.awt.Font("Fira Code", Font.PLAIN, 14)); // NOI18N
        btInsert.setText("Insert");
        btInsert.addActionListener(evt -> onInsert());
        panel_1.add(btInsert);

        btDelete.setFont(new java.awt.Font("Fira Code", Font.PLAIN, 14)); // NOI18N
        btDelete.setText("Delete");
        btDelete.addActionListener(evt -> onDelete());
        panel_1.add(btDelete);

        getContentPane().add(panel_1);

        panel_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Content", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Fira Code", Font.PLAIN, 12))); // NOI18N

        lbPosition.setFont(new java.awt.Font("Fira Code", Font.BOLD, 18)); // NOI18N
        lbPosition.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPosition.setText("Position:");

        lbName.setFont(new java.awt.Font("Fira Code", Font.BOLD, 18)); // NOI18N
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbName.setText("Name:");

        tfName_of_List.setEditable(false);
        tfName_of_List.setBackground(new java.awt.Color(204, 204, 204));
        tfName_of_List.setFont(new java.awt.Font("Fira Code", Font.PLAIN, 18)); // NOI18N
        tfName_of_List.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tfPosition_of_List.setEditable(false);
        tfPosition_of_List.setBackground(new java.awt.Color(204, 204, 204));
        tfPosition_of_List.setFont(new java.awt.Font("Fira Code", Font.PLAIN, 18)); // NOI18N
        tfPosition_of_List.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btArrowDown.setText("▼");
        btArrowDown.addActionListener(evt -> onDown());

        btArrowUp.setText("▲");
        btArrowUp.addActionListener(evt -> onUp());

        javax.swing.GroupLayout Panel_2Layout = new javax.swing.GroupLayout(panel_2);
        panel_2.setLayout(Panel_2Layout);
        Panel_2Layout.setHorizontalGroup(
                Panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Panel_2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(Panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(Panel_2Layout.createSequentialGroup()
                                                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tfName_of_List, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Panel_2Layout.createSequentialGroup()
                                                .addComponent(lbPosition)
                                                .addGap(18, 18, 18)
                                                .addComponent(tfPosition_of_List)))
                                .addGap(18, 18, 18)
                                .addGroup(Panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btArrowUp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btArrowDown, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        Panel_2Layout.setVerticalGroup(
                Panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_2Layout.createSequentialGroup()
                                .addContainerGap(59, Short.MAX_VALUE)
                                .addGroup(Panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbName)
                                        .addComponent(tfName_of_List, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btArrowUp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(Panel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbPosition)
                                        .addComponent(tfPosition_of_List, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btArrowDown, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
        );

        getContentPane().add(panel_2);

        pack();
    }

    private void onInsert() {
        if (!tfName.getText().equals("")) {

            bl.insert(tfName.getText());
            int[] index = bl.getIndex();

            tfName_of_List.setText(bl.getNameOfList());

            tfPosition_of_List.setText(index[0] + " out of " + index[1]);

        }
    }

    private void onDelete() {
        bl.delete(tfName.getText());
        int[] index = bl.getIndex();

        tfName_of_List.setText(bl.getNameOfList());

        tfPosition_of_List.setText(index[0] + " out of " + index[1]);
    }

    private void onUp() {
        bl.up();
        int[] index = bl.getIndex();

        tfName_of_List.setText(bl.getNameOfList());

        tfPosition_of_List.setText(index[0] + " out of " + index[1]);
    }

    private void onDown() {
        bl.down();
        int[] index = bl.getIndex();

        tfName_of_List.setText(bl.getNameOfList());

        tfPosition_of_List.setText(index[0] + " out of " + index[1]);
    }
}
