package htbla.kaindorf.second_grade.loal.recursions;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Pow.java
 */

public class Pow {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int base;
        int exponent;
        System.out.println("Please enter the base and the exponent");
        System.out.print("\tBase: ");
        base = scan.nextInt();
        System.out.print("\tExponent: ");
        exponent = scan.nextInt();

        int result = base;

        System.out.println("\nInterim invoices: ");
        System.out.print("\t\nResult: " + base + "^" + exponent + " = " + Pow.power(base, exponent, result));
    }

    public static int power(int base, int exponent, int result) {
        if (exponent > 1) {
            System.out.printf("%d * %d", result, base);
            result = result * base;
            System.out.printf(" = %d\n", result);
            return power(base, --exponent, result);
        } else {
            return result;
        }
    }
}
