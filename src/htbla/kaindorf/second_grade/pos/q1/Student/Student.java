package htbla.kaindorf.second_grade.pos.q1.Student;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Student.java
 */

public class Student {

    public String name = "";
    public String surname = "";

    public static void main(String[] args) {
        Student firstStudent = new Student();
        Student secondStudent = new Student();
        Student thirdStudent = new Student();

        firstStudent.input();
        firstStudent.output();

        secondStudent.input();
        secondStudent.output();

        thirdStudent.input();
        thirdStudent.output();
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        name = scan.next();

        System.out.print("Please enter your surname: ");
        surname = scan.next();
    }

    public void output() {
        System.out.println("\tThe name is " + name);
        System.out.print("\tThe surname is " + surname);
    }
}
