package htbla.kaindorf.third_grade.pos.q2.Threads.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     Threads
 * File:        TimeFrame.java
 */

public class TimeFrame extends JFrame {
    private final Font monospaceFont = new Font("MonoLisa", Font.BOLD, 36);
    private final Font plainFont = new Font("Inter", Font.PLAIN, 20);
    private JButton btStart;
    private JButton btStop;
    private TimeLabel lbTime;
    private Thread timeThread;


    public TimeFrame() {
        initComponents();
    }

    public static void main(String[] args) {
        new TimeFrame().setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 300);

        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 1, 5, 5));

        lbTime = new TimeLabel();                       // Create Component
        lbTime.setFont(monospaceFont);                  // Configure Component
        container.add(lbTime);
//        timeThread = new Thread(lbTime);              not allowed, when Thread should be started more than one time!

        JPanel paSouth = new JPanel();
        paSouth.setLayout(new GridLayout(1, 2));
        container.add(paSouth);

        btStart = new JButton("Start");
        btStart.setFont(plainFont);
        btStart.setBackground(Color.LIGHT_GRAY);
        btStart.addActionListener(this::onStart);

        btStop = new JButton("Stop");
        btStop.setFont(plainFont);
        btStop.setBackground(Color.LIGHT_GRAY);
        btStop.addActionListener(this::onStop);

        paSouth.add(btStart);
        paSouth.add(btStop);

        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void onStart(ActionEvent actionEvent) {
        if (timeThread == null || timeThread.isAlive()) {
            timeThread = new Thread(lbTime);
            timeThread.start();                             // Starting a new thread
        }
    }

    private void onStop(ActionEvent actionEvent) {
        if (timeThread != null && timeThread.isAlive()) {
            timeThread.interrupt();
        }
    }
}
