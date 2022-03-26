package htbla.kaindorf.second_grade.pos.q4.Training.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Training.java
 */

public class Training {

    private String name;
    private double distance;
    private LocalDate date;
    private String time;
    private final String sDate;

    private final DateTimeFormatter dtfOutput = DateTimeFormatter.ofPattern("MMM.yyyy");

    public Training(String name, double distance, String sDate, String time) {
        this.name = name;
        this.distance = distance;
        this.sDate = sDate;
        this.time = time;

        try {
            DateTimeFormatter dtfInput = DateTimeFormatter.ofPattern("dd.MMM.yyyy");
            date = LocalDate.parse(sDate, dtfInput);
        } catch (Exception e) {
            System.out.println("Student.constructor: BAD DATE FORMAT in " + sDate);
        }
    }

    public static void main(String[] args) {
        Training training = new Training("Schoolrun", 12.3, "17.Dec.2018", "01:15:25");

        System.out.println(training);
    }

    public double getDistance() {
        return distance;
    }

    public String getTime() {
        return time;
    }

    public String getsDate() {
        return sDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String sDistance = Double.toString(distance);
        return String.format("%-15s %s km  %s - %s", name, sDistance, date.format(dtfOutput), time);
    }
}
