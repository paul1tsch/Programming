package htbla.kaindorf.second_grade.pos.q1.Fibonacci;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Fibonacci.java
 */

public class Fibonacci {

    private int fiboSum, lastFibo, upperbound, i2 = 1, i1 = 1;

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        fibonacci.input();
        fibonacci.compute();
        fibonacci.output();
    }

    public int nextNumber() {
        int next = i1 + i2;
        i1 = i2;
        i2 = next;
        return next;
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter upperbound: ");
        upperbound = scan.nextInt();
    }

    public void compute() {
        int next = nextNumber();

        while (fiboSum < upperbound) {
            if ((next % 2) == 0) {
                fiboSum += next;
            }
            lastFibo = next;
            next = nextNumber();
        }
    }

    public void output() {
        System.out.println("Fibonacci-Sum till " + upperbound + ": " + fiboSum);
        System.out.println("The last Fibonacci-Number before the upperbound is " + lastFibo);
    }
}
