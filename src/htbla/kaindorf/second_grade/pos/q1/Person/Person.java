package htbla.kaindorf.second_grade.pos.q1.Person;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Person.java
 */

public class Person {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your name:\t\t");
        String name = scan.next();

        System.out.print("Please enter your surname:\t");
        String surname = scan.next();

        System.out.println("\nYour name is: " + name + " " + surname + "");
    }
}
