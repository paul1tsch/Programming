package htbla.kaindorf.second_grade.pos.q2.Equationsolver.controller;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        EquationController.java
 */

public class EquationController {

    public static void main(String[] args) {
        EquationController ctrl = new EquationController();

        String negative = "x²+6x+29=0";

        int a = ctrl.findA(negative);
        int b = ctrl.findB(negative);
        int c = ctrl.findC(negative);

        ctrl.getResult(a, b, c);
    }

    public int findA(String str) {
        int a;
        int index1 = str.indexOf("x²");

        String strA = str.substring(0, index1);

        a = switch (strA) {
            case "-" -> -1;
            case "+", "" -> 1;
            default -> Integer.parseInt(strA);
        };

        return a;
    }

    public int findB(String str) {
        int b;
        int index1 = str.indexOf("x²");

        index1 = index1 + 2;

        int index2 = str.lastIndexOf("x");
        String strB = str.substring(index1, index2);

        b = switch (strB) {
            case "-" -> -1;
            case "+", "" -> 1;
            default -> Integer.parseInt(strB);
        };

        return b;
    }

    public int findC(String str) {
        int c;
        int index2 = str.lastIndexOf("x");

        index2 = index2 + 1;

        int index3 = str.indexOf("=");
        String strC = str.substring(index2, index3);

        c = switch (strC) {
            case "-", "+", "" -> 0;
            default -> Integer.parseInt(strC);
        };

        return c;
    }

    public double getResult(int a, int b, int c) {
        double result = b * b - 4.0 * a * c;
        double x1 = (-b + Math.pow(result, 0.5)) / (2.0 * a);
        double x2 = (-b - Math.pow(result, 0.5)) / (2.0 * a);

        if (result > 0.0) {
            System.out.println("x1: " + x1 + ", x2: " + x2);
        } else if (result == 0.0) {
            double x = -b / (2.0 * a);
            System.out.println("x: " + x);
        } else {
            String solution1 = Double.toString(x1);
            String solution2 = Double.toString(x2);
            System.out.println("x1: " + solution1 + ", x2: " + solution2);
        }
        return result;
    }
}
