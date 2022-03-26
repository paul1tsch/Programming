package htbla.kaindorf.second_grade.pos.q1.Calculator;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Calculator.java
 */

public class Calculator {

    public char operator;
    public double num1;
    public double num2;
    public double result;

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.input();
        calc.calculate();
        calc.output();
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter first Operator [double]: ");
        num1 = scan.nextDouble();

        System.out.print("Enter Operator [+, -, /, *, %]: ");
        operator = scan.next().charAt(0);

        System.out.print("Enter second Operator [double]: ");
        num2 = scan.nextDouble();
    }

    public void calculate() {
        switch (operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            case '%' -> result = num1 % num2;
            default -> System.out.println("[-] Operator is not correct. ");
        }
    }

    public void output() {
        if (operator == '+') {
            System.out.println("The result of the addition is [+]: " + result);
        } else if (operator == '-') {
            System.out.println("The result of the subtraction is [-]: " + result);
        } else if (operator == '*') {
            System.out.println("The result of the multiplication is [*]: " + result);
        } else if (operator == '/') {
            System.out.println("The result of the division is [/]: " + result);
        } else if (operator == '%') {
            System.out.println("The remainder of the division is [%]: " + result);
        }
    }
}
