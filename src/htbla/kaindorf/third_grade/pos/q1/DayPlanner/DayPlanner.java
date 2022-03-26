package htbla.kaindorf.third_grade.pos.q1.DayPlanner;

import htbla.kaindorf.third_grade.pos.q1.DayPlanner.beans.Entry;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH & Felix ZENZ
 * Initials:    DP & FZ
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        DayPlanner.java
 */

public class DayPlanner {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final Map<LocalDate, List<Entry>> fullMap = new TreeMap<>();

    public static void main(String[] args) {
        Entry d2 = new Entry(LocalTime.of(8, 0), "Pair Programming POS");
        Entry d3 = new Entry(LocalTime.of(17, 0), "POS Homework");
        Entry d1 = new Entry(LocalTime.of(6, 30), "Breakfast");
        Entry d4 = new Entry(LocalTime.of(10, 30), "Football");
        Entry d5 = new Entry(LocalTime.of(17, 0), "Party");

        List<Entry> entries1 = new ArrayList<>();
        entries1.add(d1);
        entries1.add(d2);
        entries1.add(d3);

        List<Entry> entries2 = new ArrayList<>();
        entries2.add(d4);
        entries2.add(d5);

        fullMap.put(LocalDate.of(2019, Month.OCTOBER, 18), entries1);
        fullMap.put(LocalDate.of(2019, Month.OCTOBER, 19), entries2);

        DayPlanner dayPlanner = new DayPlanner();
        dayPlanner.showAllDays();
        dayPlanner.addEntry(LocalDate.of(2020, Month.DECEMBER, 21), new Entry(LocalTime.of(9, 20), "Learning React"));
        System.out.println();
        dayPlanner.showAllDays();
        System.out.println();
        dayPlanner.showEntriesOfDay(LocalDate.of(2019, Month.OCTOBER, 18));

    }

    public void addEntry(LocalDate localDate, Entry entry) {
        if (!fullMap.containsKey(localDate)) {
            fullMap.put(localDate, new ArrayList<>());
        }
        List<Entry> entryList = fullMap.get(localDate);
        entryList.add(entry);
        Collections.sort(entryList);
    }

    public void showAllDays() {
        String dateOutput = "Date";
        String entryOutput = "Entries";
        System.out.format("%12s %10s", dateOutput, entryOutput);
        System.out.print("\n");
        System.out.println("--------------------------------");

        for (LocalDate date : fullMap.keySet()) {
            System.out.println("<" + date.format(DATE_TIME_FORMATTER) + ">");
            for (Entry entry : fullMap.get(date)) {
                System.out.println(entry.toString());
            }
        }
    }

    public void showEntriesOfDay(LocalDate date) {
        String dateOutput = "Date";
        String entryOutput = "Entries";
        System.out.format("%12s %10s", dateOutput, entryOutput);
        System.out.print("\n");
        System.out.println("--------------------------------");

        System.out.println("<" + date.format(DATE_TIME_FORMATTER) + ">");
        for (Entry entry : fullMap.get(date)) {
            System.out.println(entry.toString());
        }
    }
}
