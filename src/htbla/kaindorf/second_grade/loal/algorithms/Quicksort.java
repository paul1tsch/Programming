package htbla.kaindorf.second_grade.loal.algorithms;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Quicksort.java
 */

public class Quicksort {

    public static int[] Array = {5, 4, 1, 7, 2, 9, 8, 6, 3, 0};

    public static void main(String[] args) {
        Quicksort qs = new Quicksort();

        System.out.println("Array [unsorted]:");
        printArray(Array);

        int[] arr = qs.sort(0, Array.length - 1);

        System.out.println("Array [sorted]:");
        printArray(arr);
    }

    public static void printArray(int[] array) {
        for (int j : array) System.out.print(j + " ");
        System.out.println();
    }

    public int[] sort(int left, int right) {
        int q;
        if (left < right) {
            q = divide(left, right);
            sort(left, q);
            sort(q + 1, right);
        }
        return Array;
    }

    int divide(int left, int right) {

        int i, j, pivot = Array[(left + right) / 2];
        i = left - 1;
        j = right + 1;
        while (true) {
            do {
                i++;
            } while (Array[i] < pivot);

            do {
                j--;
            } while (Array[j] > pivot);

            if (i < j) {
                int k = Array[i];
                Array[i] = Array[j];
                Array[j] = k;
            } else {
                return j;
            }
        }
    }
}
