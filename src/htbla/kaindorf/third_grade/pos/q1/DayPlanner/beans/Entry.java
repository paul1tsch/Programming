package htbla.kaindorf.third_grade.pos.q1.DayPlanner.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH & Felix ZENZ
 * Initials:    DP & FZ
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Entry.java
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry implements Comparable<Entry> {

    @EqualsAndHashCode.Exclude
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");
    private LocalTime time;
    private String text;

    @Override
    public String toString() {
        return String.format("\t\t\t%5s %s", time.format(DATE_TIME_FORMATTER), text);
    }

    @Override
    public int compareTo(Entry o) {
        return this.getTime().compareTo(o.getTime());
    }
}
