package htbla.kaindorf.third_grade.pos.q2.Threads.gui;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     Threads
 * File:        TimeLabel.java
 */

public class TimeLabel extends JLabel implements Runnable {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public TimeLabel() {
        super("00:00:00", JLabel.CENTER);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            LocalTime localTime = LocalTime.now();
            setText(localTime.format(DATE_TIME_FORMATTER));
            try {

                Thread.sleep(150);
            } catch (InterruptedException e) {
                break;
            }
        }
        setText("00:00:00");
    }
}
