package htbla.kaindorf.second_grade.loal.recursions;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Multiplication.java
 */

public class Multiplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a;
        int b;
        System.out.println("Please enter a & b");
        System.out.print("\tA: ");
        a = scan.nextInt();
        System.out.print("\tB: ");
        b = scan.nextInt();

        int res = a;

        System.out.println("\nInterim invoices: ");
        System.out.printf("\t\nResult: %d * %d = %d", a, b, Multiplication.mul(a, b, res));
    }

    public static int mul(int a, int b, int res) {
        if (b > 1) {
            System.out.printf("%3d + %2d", res, a);
            res = res + a;
            System.out.printf(" = %d\n", res);
            return mul(a, --b, res);
        } else {
            return res;
        }
    }
}
