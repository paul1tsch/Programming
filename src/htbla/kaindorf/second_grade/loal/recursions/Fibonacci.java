package htbla.kaindorf.second_grade.loal.recursions;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Fibonacci.java
 */

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num;
        System.out.print("Enter Fibonacci Index: ");
        num = scan.nextDouble();

        System.out.println("The " + num + "th Fibonacci number is: " + fib(num));
    }

    public static double fib(double num) {
        if (num <= 1) {
            return num;
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }

}
