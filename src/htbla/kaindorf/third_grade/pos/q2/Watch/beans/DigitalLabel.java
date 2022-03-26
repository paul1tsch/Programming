package htbla.kaindorf.third_grade.pos.q2.Watch.beans;

import javax.swing.*;
import java.awt.*;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        DigitalLabel.java
 */

public class DigitalLabel extends JLabel {
    private int value = 10;

    private static final String[][] SEGMENTS_OF_NUMBER = {
            {"1111110--"},
            {"0110000--"},
            {"1101101--"},
            {"1111001--"},
            {"0110011--"},
            {"1011011--"},
            {"1011111--"},
            {"1110000--"},
            {"1111111--"},
            {"1111011--"},
            {"-------11"}
    };

    public DigitalLabel() {
        setBackground(Color.BLACK);
        setOpaque(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DigitalLabel digitalLabel = new DigitalLabel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(200, 400);
        frame.getContentPane().add(digitalLabel);
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);

        for (int i = 0; i <= 10; i++) {
            digitalLabel.setValue(i);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static int[] getXCoordinates(int segment) {
        return switch (segment) {
            case 0, 3, 6 -> new int[]{2, 3, 8, 9, 8, 3};
            case 1, 2 -> new int[]{9, 10, 10, 9, 8, 8};
            case 4, 5 -> new int[]{2, 3, 3, 2, 1, 1};
            case 7, 8 -> new int[]{5, 7, 7, 5};
            default -> new int[]{};
        };
    }

    private static int[] getYCoordinates(int segment) {
        return switch (segment) {
            case 0 -> new int[]{2, 1, 1, 2, 3, 3};
            case 1, 5 -> new int[]{2, 3, 8, 9, 8, 3};
            case 6 -> new int[]{9, 8, 8, 9, 10, 10};
            case 2, 4 -> new int[]{9, 10, 15, 16, 15, 10};
            case 3 -> new int[]{16, 15, 15, 16, 17, 17};
            case 7 -> new int[]{5, 5, 7, 7};
            case 8 -> new int[]{11, 11, 13, 13};
            default -> new int[]{};
        };
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphic = (Graphics2D) g;
        RenderingHints renderingHints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        graphic.setRenderingHints(renderingHints);

        graphic.scale(this.getWidth() / 11.0, this.getHeight() / 18.0);

        char c;
        for (String s : SEGMENTS_OF_NUMBER[value]) {
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                switch (c) {
                    case '0' -> {
                        graphic.setPaint(Color.decode("#2A2A2A"));
                        graphic.fillPolygon(getXCoordinates(i), getYCoordinates(i), getXCoordinates(i).length);
                        graphic.setStroke(new BasicStroke(0.2f));
                        graphic.setPaint(Color.BLACK);
                        graphic.drawPolygon(getXCoordinates(i), getYCoordinates(i), getXCoordinates(i).length);
                    }
                    case '1' -> {
                        graphic.setPaint(Color.RED);
                        graphic.fillPolygon(getXCoordinates(i), getYCoordinates(i), getXCoordinates(i).length);
                        graphic.setStroke(new BasicStroke(0.2f));
                        graphic.setPaint(Color.BLACK);
                        graphic.drawPolygon(getXCoordinates(i), getYCoordinates(i), getXCoordinates(i).length);
                    }
                    case '-' -> {
                        graphic.setPaint(Color.BLACK);
                        graphic.fillPolygon(getXCoordinates(i), getYCoordinates(i), getXCoordinates(i).length);
                    }
                }
            }
        }
    }
}
