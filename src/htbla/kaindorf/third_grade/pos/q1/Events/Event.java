package htbla.kaindorf.third_grade.pos.q1.Events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Event.java
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("E dd.MM.yyyy", Locale.GERMAN);
    private String text;
    private LocalDate date;

    @Override
    public String toString() {
        return String.format("%-15s - %10s", text, date.format(DTF));
    }
}
