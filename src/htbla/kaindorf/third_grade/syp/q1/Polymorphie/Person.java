package htbla.kaindorf.third_grade.syp.q1.Polymorphie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Person.java
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("E dd.MMM.yyyy");
    // Class-bound not object-bound - do not always generate the date
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd. MMMM yyyy");
    private String lastname;
    private String firstname;
    @EqualsAndHashCode.Exclude
    private LocalDate dateOfBirth;

    // private LocalTime time;
    // private LocalDateTime dateTime;

    // @EqualsAndHashCode.Exclude
    // @ToString.Exclude
    // private Address address;

    public static void main(String[] args) {
        /*
        Person person1 = new Person("PAULITSCH", "Dominik", LocalDate.of(2021, Month.DECEMBER, 20));
        Person person2 = new Person("ZENZ", "Felix", LocalDate.of(2021, Month.DECEMBER, 20));

        System.out.println("Persons:\n");
        List<Person> list = new ArrayList<>();

        System.out.println("== " + (person1 == person2));               // referential equality
        System.out.println(".equals() " + (person1.equals(person2)));   // content-related equality

        list.add(person1);
        list.add(person2);

        // not a variable, just a reference
        Person person3 = person1;

        list.parallelStream().forEach(System.out::println);
        System.out.println("\n");
        person1.changePerson(person3);

        list.parallelStream().forEach(System.out::println);
         */

        Random random = new Random();
        LocalDate localDate = LocalDate.of(1990, 1, 1);
        localDate = localDate.plusDays(random.nextInt(random.nextInt(365 * 2)));
        System.out.println(localDate.format(DATE_TIME_FORMATTER));
        System.out.println(localDate.getDayOfWeek());
    }

    @Override
    public String toString() {
        return String.format("%-15s %-10s has Birthday on %s", firstname, lastname, dateOfBirth.format(DATE_TIME_FORMATTER));
    }

    public void changePerson(Person p) {
        p.setFirstname("Lisa");
    }
}
