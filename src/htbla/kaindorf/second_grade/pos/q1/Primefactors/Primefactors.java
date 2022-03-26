package htbla.kaindorf.second_grade.pos.q1.Primefactors;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Primefactors.java
 */

public class Primefactors {

    private int num;

    public static void main(String[] args) {
        Primefactors primefactors = new Primefactors();

        primefactors.input();
        primefactors.compute();
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number: ");
        num = scan.nextInt();
    }

    public void compute() {
        System.out.print("Prime Factors: ");

        for (int i = 2; i < num; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num = num / i;
            }
        }
        if (num > 2) {
            System.out.print(num);
        }
    }
}
