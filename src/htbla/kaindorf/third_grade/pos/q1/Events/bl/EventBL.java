package htbla.kaindorf.third_grade.pos.q1.Events.bl;

import htbla.kaindorf.third_grade.pos.q1.Events.Event;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        EventBL.java
 */

public class EventBL {
    private static final String[] subjects = {"POS", "DBI", "NVS", "TINF"};
    private static final String[] activities = {"PLF", "Uebung", "Aufgabe"};
    private final List<Event> EVENTS = new ArrayList<>();

    public static void main(String[] args) {
        EventBL bl = new EventBL();

        bl.initEvents();
        bl.printEvents();
        System.out.println("--------------------------------");
        bl.sortEvents(true);
        bl.printEvents();
        System.out.println("--------------------------------");
        bl.filterEvents();
        bl.printEvents();
    }

    public void initEvents() {
        Random random = new Random();
        String subject;
        String activity;
        String text;

        for (int i = 0; i < 25; i++) {
            int randomActivity = random.nextInt(3);
            activity = activities[randomActivity];

            int randomSubject = random.nextInt(4);
            subject = subjects[randomSubject];

            int plusRandomDays = random.nextInt((int) DAYS.between(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 2, 28)) - 1);
            LocalDate startDate = LocalDate.of(2021, Month.JANUARY, 1);
            LocalDate randomDate = startDate.plusDays(plusRandomDays);
            DayOfWeek dayOfWeek = randomDate.getDayOfWeek();

            if (dayOfWeek.equals(DayOfWeek.SUNDAY)) {
                randomDate = randomDate.plusDays(1);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                randomDate = randomDate.plusDays(2);
            }

            text = String.format("%s-%s ", subject, activity);
            EVENTS.add(new Event(text, randomDate));
        }
    }

    public void sortEvents(boolean ascending) {
        // Comparator<Event> comparator = (e1, e2) -> e1.getDate().compareTo(e2.getDate());
        // comparator = comparator.thenComparing((e1, e2) -> e1.getText().compareTo(e2.getText()));
        Comparator<Event> comparator = Comparator.comparing(Event::getDate).thenComparing(Event::getText);

        comparator = ascending ? comparator : comparator.reversed();
        EVENTS.sort(comparator);
    }

    public void printEvents() {
        // EVENTS.forEach(event -> System.out.println(event));
        EVENTS.forEach(System.out::println);
    }

    public void filterEvents() {
        EVENTS.removeIf(e -> e.getText().contains("PLF"));
    }
}
