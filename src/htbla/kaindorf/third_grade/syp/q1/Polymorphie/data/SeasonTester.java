package htbla.kaindorf.third_grade.syp.q1.Polymorphie.data;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        SeasonTester.java
 */

public class SeasonTester {
    public static void main(String[] args) {
        Seasons season = Seasons.WINTER;

        for(Seasons s : Seasons.values()){
            System.out.println(s.ordinal() + " - " + s + " has " + s.getNumOfDays() + " days!");
        }

        System.out.println();

        for(Month m : Month.values()){
            System.out.println(m.ordinal() + " - " + m + " is also " + m.getDisplayName(TextStyle.FULL, Locale.FRENCH));
        }
    }
}
