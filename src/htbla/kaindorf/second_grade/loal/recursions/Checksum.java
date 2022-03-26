package htbla.kaindorf.second_grade.loal.recursions;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Checksum.java
 */

public class Checksum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int number;
        number = scan.nextInt();

        System.out.println("Sum of the Digits: " + checksum(number));
    }

    public static int checksum(int number) {
        if (number <= 9) {
            System.out.println(number + " + 0");
            return number;
        } else {
            System.out.printf("%d + ", number % 10);
            return number % 10 + checksum(number / 10);
        }
    }
}
