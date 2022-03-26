package htbla.kaindorf.second_grade.loal.recursions;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Prime.java
 */

public class Prime {

    public static void main(String[] args) {
        int n, x;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a random number: ");
        n = scan.nextInt();
        Prime prime = new Prime();
        x = prime.prime(n, 2);
        if (x == 1) {
            System.out.println(n + " is prime number");
        } else {
            System.out.println(n + " is not prime number");
        }
    }

    int prime(int y, int i) {
        if (i < y) {
            if (y % i != 0) {
                return (prime(y, ++i));
            } else {
                return 0;
            }
        }
        return 1;
    }
}
