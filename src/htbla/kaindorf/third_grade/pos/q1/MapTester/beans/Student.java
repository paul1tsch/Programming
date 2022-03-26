package htbla.kaindorf.third_grade.pos.q1.MapTester.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Student.java
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {

    // @ToString.Exclude
    // @EqualsAndHashCode.Exclude
    // Only lists, collections or maps and so on would be excluded!

    private String name;
    private LocalDate dateOfBirth;
    // private int age;

    @Override
    public int compareTo(Student other) {
        // return this.age - student.age
        // this.something -> current - student.something -> passed object
        // compareTo:
        //              = 0     this = o
        //              < 0     this < o
        //              > 0     this > o
        // o = other

        if (this.getName().equals(other.getName())) {
            return this.dateOfBirth.compareTo(other.getDateOfBirth());
        }
        return this.getName().compareTo(other.getName());
    }
}
