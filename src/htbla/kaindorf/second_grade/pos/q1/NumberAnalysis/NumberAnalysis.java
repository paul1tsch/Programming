package htbla.kaindorf.second_grade.pos.q1.NumberAnalysis;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        NumberAnalysis.java
 */

public class NumberAnalysis {

    public int num;
    public boolean even;
    public boolean prime;
    public int sum;

    public static void main(String[] args) {
        NumberAnalysis number = new NumberAnalysis();

        number.input();
        number.calculate();
        number.output();
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        num = scan.nextInt();

        System.out.print(num);
    }

    public void calculate() {
        even = isEven(num);
        prime = isPrime(num);
        sum = digitSum(num);
    }

    public Boolean isEven(int num) {
        even = num % 2 == 0;
        return even;
    }

    public Boolean isPrime(int num) {
        int i;
        for (i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }
        if (i == num / 2 + 1) {
            prime = true;
        }
        return prime;
    }

    public int digitSum(int num) {
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    public void output() {
        if (even && prime) {
            System.out.print(" is even, a prime number and the sum of the digits is " + sum + "!");
        } else if (even) {
            System.out.println(" is even, not a prime number and the sum of the digits is " + sum + "!");
        } else if (prime) {
            System.out.println(" is odd, a prime number and the sum of the digits is " + sum + "!");
        } else {
            System.out.println(" is odd, not a prime number and the sum of the digits is " + sum + "!");
        }
    }
}
