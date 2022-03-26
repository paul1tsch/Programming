package htbla.kaindorf.third_grade.pos.q2.Watch;

import htbla.kaindorf.third_grade.pos.q2.Watch.beans.DigitalPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DigitalWatch extends JFrame {

    private final Font plainFont = new Font("Inter", Font.PLAIN, 32);

    private void initComponents() {
        setTitle("Thread Watch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);
        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2));
        container.setBackground(Color.black);

//      ==================== BUTTONS & TEXT ================

        JLabel textField = new JLabel();
        textField.setText("Current Time:");
        textField.setFont(plainFont);
        textField.setForeground(Color.white);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel button1 = new JLabel();
        button1.setText("New Location");
        button1.setFont(plainFont);
        button1.setForeground(Color.white);
        button1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel button2 = new JLabel();
        button2.setText("New Location");
        button2.setFont(plainFont);
        button2.setForeground(Color.white);
        button2.setHorizontalAlignment(SwingConstants.CENTER);


//      ==================== PANEL WEST ====================

        JPanel paWest = new JPanel();
        paWest.setLayout(new GridLayout(3, 1));
        paWest.setBackground(Color.black);
        paWest.add(textField);
        paWest.add(button1);
        paWest.add(button2);

//      ====================  TIMEPANEL ====================

        DigitalPanel panel1 = new DigitalPanel(0);
        Thread localeThread = new Thread(panel1);
        localeThread.setDaemon(true);
        localeThread.start();

        DigitalPanel panel2 = new DigitalPanel();
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addTime(button1, panel2);
            }
        });

        DigitalPanel panel3 = new DigitalPanel();
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addTime(button2, panel3);
            }
        });


//      ==================== PANEL EAST ====================

        JPanel paEast = new JPanel();
        paEast.setLayout(new GridLayout(3, 1));
        paEast.setBackground(Color.black);
        paEast.add(panel1);
        paEast.add(panel2);
        paEast.add(panel3);


//      ==================== PANEL ADD =====================
        container.add(paWest, LEFT_ALIGNMENT);
        container.add(paEast, RIGHT_ALIGNMENT);

    }

    public DigitalWatch() {
        initComponents();
    }

    public void addTime(JLabel button, DigitalPanel panel) {
        JFrame error = new JFrame();
        int offset = 0;

        JFrame frameLocation = new JFrame();
        String location = JOptionPane.showInputDialog(frameLocation, "Please enter location: ");

        JFrame frameOffset = new JFrame();
        try {
            offset = Integer.parseInt(JOptionPane.showInputDialog(frameOffset, "Please enter time offset in hours: "));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(error, "Please enter an Integer number");
        }


        Thread panelThread = new Thread(panel);
        panel.setTimeOffsetInHours(offset);
        button.setText(String.format("%s:", location));
        panelThread.setDaemon(true);
        panelThread.start();
    }

    public static void main(String[] args) {
        new DigitalWatch().setVisible(true);
    }
}
