package htbla.kaindorf.second_grade.pos.q4.Student.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Student.java
 */

public class Student {

    private final String surname;
    private final String sDateOfBirth;
    private final DateTimeFormatter dtfOutput = DateTimeFormatter.ofPattern("dd. MMM yyyy");
    private String name;
    private LocalDate dateOfBirth;

    public Student(String name, String surname, String sDateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.sDateOfBirth = sDateOfBirth;
        try {
            DateTimeFormatter dtfInput = DateTimeFormatter.ofPattern("d.M.yyyy");
            dateOfBirth = LocalDate.parse(sDateOfBirth, dtfInput);
        } catch (Exception e) {
            System.out.println("Student.constructor: BAD DATE FORMAT in " + sDateOfBirth);
        }

    }

    public static void main(String[] args) {
        Student student = new Student("Franz", "KOINIGG", "04.03.2005");

        System.out.println(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsDateOfBirth() {
        return sDateOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return (surname + ", " + name + " - " + dateOfBirth.format(dtfOutput));
    }
}
