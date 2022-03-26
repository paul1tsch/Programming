package htbla.kaindorf.third_grade.syp.q1.Polymorphie.bl;

import htbla.kaindorf.third_grade.syp.q1.Polymorphie.Person;
import htbla.kaindorf.third_grade.syp.q1.Polymorphie.data.PersonData;

import java.util.Comparator;
import java.util.List;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        PersonBL.java
 */

public class PersonBL implements PersonData {

    public static void main(String[] args) {
        PersonBL bl = new PersonBL();

        bl.sort("date", true);

        bl.filter("SAILER");
        System.out.println("--------");
        bl.printList();
    }

    public void sort(String criterium, boolean ascending) {
        Comparator<Person> comperator = switch (criterium) {
//          case "firstname"    ->  (p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname());
            case "firstname" -> Comparator.comparing(Person::getFirstname);
            case "lastname" -> Comparator.comparing(Person::getLastname);
            case "date" -> Comparator.comparing(Person::getDateOfBirth).thenComparing(Person::getLastname);
            default -> null;
        };
        comperator = ascending ? comperator : comperator.reversed();
        personList.sort(comperator);
    }

    public void printList() {
//        for (Person p : personList) {
//            System.out.println(p);
//        }

//        personList.parallelStream().forEach(p -> System.out.println(p));

        personList.forEach(System.out::println);
    }

    public void filter(String lastname) {
//        personList.removeIf(person -> person.getLastname().equals(lastname));

        List<Person> filteredList = personList.stream()
                .filter(person -> person.getLastname().equals(lastname))
                .toList();

        filteredList.stream().forEach(System.out::println);
    }

}
