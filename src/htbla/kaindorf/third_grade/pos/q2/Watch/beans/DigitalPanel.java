package htbla.kaindorf.third_grade.pos.q2.Watch.beans;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class DigitalPanel extends JPanel implements Runnable {

    private DigitalLabel[] digitalLabels = new DigitalLabel[8];
    private int timeOffsetInHours = 0;

    public DigitalPanel() {
        initComponents();
    }

    public DigitalPanel(int timeOffset) {
        this.timeOffsetInHours = timeOffset;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(1, 8));

        for (int i = 0; i < digitalLabels.length; i++) {
            digitalLabels[i] = new DigitalLabel();
            add(digitalLabels[i]);
        }
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            LocalTime localTime = LocalTime.now().plusHours(timeOffsetInHours);

            int hour = localTime.getHour();
            int minute = localTime.getMinute();
            int second = localTime.getSecond();

            digitalLabels[0].setValue(hour / 10);
            digitalLabels[1].setValue(hour % 10);
            digitalLabels[3].setValue(minute / 10);
            digitalLabels[4].setValue(minute % 10);
            digitalLabels[6].setValue(second / 10);
            digitalLabels[7].setValue(second % 10);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                break;
            }
        }
    }

    public void setTimeOffsetInHours(int timeOffsetInHours) {
        this.timeOffsetInHours = timeOffsetInHours;
        Thread thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        DigitalPanel digitalPanel = new DigitalPanel();

        frame.add(digitalPanel);

        frame.setSize(800, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Thread thread = new Thread(digitalPanel);
        thread.start();
    }
}
