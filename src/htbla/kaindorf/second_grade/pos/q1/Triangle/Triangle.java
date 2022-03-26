package htbla.kaindorf.second_grade.pos.q1.Triangle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Triangle.java
 */

public class Triangle {

    private final int[] arr = {0, 0, 0};
    public String type;
    private int sideA;
    private int sideB;
    private int sideC;

    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        triangle.input();
        triangle.sortSides();
        triangle.determineType();
        triangle.output();
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter side A: ");
        sideA = scan.nextInt();

        System.out.print("Enter side B: ");
        sideB = scan.nextInt();

        System.out.print("Enter side C: ");
        sideC = scan.nextInt();
    }

    public void sortSides() {
        arr[0] = sideA;
        arr[1] = sideB;
        arr[2] = sideC;
        Arrays.sort(arr);
    }

    public void determineType() {
        if (sideA == sideB && sideB == sideC) {
            type = "Equilateral Triangle";
        } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
            type = "Isosceles Triangle";
        } else if (Math.pow(sideA, 2) + Math.pow(sideB, 2) == Math.pow(sideC, 2)) {
            type = "Rectangular Triangle";
        } else if (sideA + sideB > sideC) {
            type = "Common Triangle";
        } else {
            type = "Not an Triangle";
        }
    }

    public void output() {
        System.out.print("Triangle (");

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[n - 1]);
        System.out.print(") → " + type + "");
    }
}
