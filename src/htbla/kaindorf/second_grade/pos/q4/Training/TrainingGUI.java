package htbla.kaindorf.second_grade.pos.q4.Training;

import htbla.kaindorf.second_grade.pos.q4.Training.beans.Route;
import htbla.kaindorf.second_grade.pos.q4.Training.model.RouteModel;
import htbla.kaindorf.second_grade.pos.q4.Training.model.TrainingModel;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        TrainingGUI.java
 */

public class TrainingGUI extends javax.swing.JFrame{

    RouteModel routeModel = new RouteModel();
    TrainingModel trainingModel = new TrainingModel();

    private JSeparator SPR1;
    private JSeparator SPR2;
    private JButton btAdd;
    private JButton btInsert;
    private JButton btSorting;
    private JPanel btnPanel;
    private JLabel lbDate;
    private JLabel lbLength;
    private JLabel lbName;
    private JLabel lbRuntime;
    private JList<String> listTracks;
    private JList<String> listTraining;
    private JPanel mainPanel1;
    private JPanel mainPanel2;
    private JScrollPane spScroll;
    private JScrollPane spScroll2;
    private JPanel subPanel;
    private JPanel subPanel1;
    private JPanel subPanel2;
    private JPanel subPanel3;
    private JTextField tfDate;
    private JTextField tfLength;
    private JTextField tfName;
    private JTextField tfRuntime;

    public TrainingGUI() {
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

        setSize(1090, 500);

        setTitle("❯❯❯ Training - TRAIN4LIFE");
        setResizable(false);
        setLocationRelativeTo(null);

        listTracks.setModel(routeModel);
        routeModel.addTrack("Forest run", 5.2);
        routeModel.addTrack("Marathon", 45.2);
        routeModel.addTrack("School arena", 0.5);

        listTraining.setModel(trainingModel);
        trainingModel.addTraining("School", 12.2, "17.Dec.2018", "03:11:22");
        trainingModel.addTraining("School2", 14.2, "17.Dec.2018", "03:15:22");

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TrainingGUI().setVisible(true));
    }

    private void initComponents() {

        mainPanel1 = new javax.swing.JPanel();
        subPanel1 = new javax.swing.JPanel();
        spScroll2 = new javax.swing.JScrollPane();
        listTracks = new javax.swing.JList<>();
        subPanel2 = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbLength = new javax.swing.JLabel();
        tfLength = new javax.swing.JTextField();
        SPR2 = new javax.swing.JSeparator();
        btAdd = new javax.swing.JButton();
        subPanel3 = new javax.swing.JPanel();
        lbDate = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        lbRuntime = new javax.swing.JLabel();
        tfRuntime = new javax.swing.JTextField();
        SPR1 = new javax.swing.JSeparator();
        btInsert = new javax.swing.JButton();
        mainPanel2 = new javax.swing.JPanel();
        subPanel = new javax.swing.JPanel();
        spScroll = new javax.swing.JScrollPane();
        listTraining = new javax.swing.JList<>();
        btnPanel = new javax.swing.JPanel();
        btSorting = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        mainPanel1.setLayout(new java.awt.GridLayout(3, 1));

        subPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Running tracks"));
        subPanel1.setLayout(new javax.swing.OverlayLayout(subPanel1));

        listTracks.setFont(new java.awt.Font("JetBrains Mono NL", Font.PLAIN, 10));
        listTracks.setModel(new javax.swing.AbstractListModel<>() {
            final String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        spScroll2.setViewportView(listTracks);

        subPanel1.add(spScroll2);

        mainPanel1.add(subPanel1);

        subPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Track"));
        subPanel2.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        lbName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbName.setText("Name:");
        subPanel2.add(lbName);
        subPanel2.add(tfName);

        lbLength.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLength.setText("Length of the track [km]:");
        subPanel2.add(lbLength);
        subPanel2.add(tfLength);
        subPanel2.add(SPR2);

        btAdd.setText("add");
        btAdd.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btAdd.addActionListener(evt -> onAdd());
        subPanel2.add(btAdd);

        mainPanel1.add(subPanel2);

        subPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Training"));
        subPanel3.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        lbDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDate.setText("Date:");
        subPanel3.add(lbDate);
        subPanel3.add(tfDate);

        lbRuntime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbRuntime.setText("Runtime:");
        subPanel3.add(lbRuntime);
        subPanel3.add(tfRuntime);

        SPR1.setPreferredSize(new java.awt.Dimension(0, 0));
        subPanel3.add(SPR1);

        btInsert.setText("insert");
        btInsert.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btInsert.addActionListener(evt -> onInsert());
        subPanel3.add(btInsert);

        mainPanel1.add(subPanel3);

        getContentPane().add(mainPanel1);

        mainPanel2.setLayout(new java.awt.BorderLayout());

        subPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Traininglist"));
        subPanel.setLayout(new javax.swing.OverlayLayout(subPanel));

        listTraining.setFont(new java.awt.Font("JetBrains Mono NL", Font.PLAIN, 10));
        listTraining.setModel(new javax.swing.AbstractListModel<>() {
            final String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        spScroll.setViewportView(listTraining);

        subPanel.add(spScroll);

        mainPanel2.add(subPanel, java.awt.BorderLayout.CENTER);

        btnPanel.setLayout(new java.awt.BorderLayout());

        btSorting.setText("Sorting by the training time");
        btSorting.addActionListener(evt -> onSort());
        btnPanel.add(btSorting, java.awt.BorderLayout.CENTER);

        mainPanel2.add(btnPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(mainPanel2);

        pack();
    }

    private void onAdd() {
        Route route = new Route(tfName.getText());
        routeModel.add(route);
    }

    private void onInsert() {
        // TODO: Get Track & Distance per selectedIndex

        String length = tfLength.getText();
        double distance = Double.parseDouble(length);
        trainingModel.addTraining(tfName.getText(), distance, tfDate.getText(), tfRuntime.getText());
    }

    private void onSort() {
        //TODO: Substring 2 characters before the first ":"
        //TODO: and 2 characters after the last ":"
        //TODO: Remove the ":" and write String as double value
        //TODO: Sort by size and insert old associated String again
        //TODO: Perfecto! Now sorting is done!
    }
}
