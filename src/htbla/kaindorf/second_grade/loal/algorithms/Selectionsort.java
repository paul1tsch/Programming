package htbla.kaindorf.second_grade.loal.algorithms;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Selectionsort.java
 */

public class Selectionsort {

    public static void main(String[] args) {
        Selectionsort selection = new Selectionsort();
        int[] arr = {64, 25, 12, 22, 11, 31, 166, 133, 155, 99, 27, 0, 22, 11};

        System.out.println("Unsorted Array:");
        printArray(arr);

        selection.sort(arr);
        System.out.println("Sorted Array:");
        printArray(arr);
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + " * ");
        }
        System.out.println(arr[n - 1]);
    }

    void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
