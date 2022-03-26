package htbla.kaindorf.second_grade.loal.algorithms;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Insertionsort.java
 */

public class Insertionsort {

    public static void main(String[] args) {
        int[] arr = {12, 15, 25, 911, 20, 69, 13, 0};

        System.out.println("Unsorted Array:");
        printArray(arr);
        System.out.println("Sorted Array:");
        sort(arr);
        printArray(arr);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int tmp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = tmp;
        }
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " * ");
        }
        System.out.println();
    }
}
