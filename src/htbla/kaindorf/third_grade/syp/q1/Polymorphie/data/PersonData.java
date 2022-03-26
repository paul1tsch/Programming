package htbla.kaindorf.third_grade.syp.q1.Polymorphie.data;

import htbla.kaindorf.third_grade.syp.q1.Polymorphie.Person;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        PersonData.java
 */

public interface PersonData {
    List<Person> personList = Arrays.asList(
            new Person("PAULITSCH", "Dominik", LocalDate.of(2021, Month.DECEMBER, 20)),
            new Person("ZENZ", "Felix", LocalDate.of(2021, Month.OCTOBER, 20)),
            new Person("RANNEGGER", "Arthur", LocalDate.of(2004, Month.DECEMBER, 21)));
}
