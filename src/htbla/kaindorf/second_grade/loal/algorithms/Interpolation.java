package htbla.kaindorf.second_grade.loal.algorithms;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Interpolation.java
 */

public class Interpolation {

    public static void main(String[] args) {
        System.out.println("[+] Starting Interpolation\n");

        Searcharray searchArray = new Searcharray(1, 10_000_000);
        searchArray.load();

        System.out.println("\nGet 10: " + searchArray.get(10));
        System.out.println("\n[+] Searching ...\n");

        searchFor(searchArray, 314699018);
        searchFor(searchArray, 816387057);
        searchFor(searchArray, 1317297914);
        searchFor(searchArray, 1651147229);
        searchFor(searchArray, 1651147228);
    }

    public static int search(Searcharray array, int value, int left, int right) {
        if (right < left) {
            return -1;
        }

        int valueLeft = array.get(left);
        int valueRight = array.get(right);
        int mid = left + (int) (((value - valueLeft) / (double) (valueRight - valueLeft)) * (right - left));
        int valueMid = array.get(mid);

        if (value == valueMid) {
            return mid;
        } else if (value < valueMid) {
            return search(array, value, left, mid - 1);
        } else {
            return search(array, value, mid + 1, right);
        }
    }

    private static void searchFor(Searcharray array, int value) {
        System.out.print("Looking for " + value + " ");
        array.resetGetCounter();

        long startTime = System.currentTimeMillis();
        int index = search(array, value, 0, array.length() - 1);
        long stopTime = System.currentTimeMillis();

        System.out.println("At position " + index + ", took " + array.getGetCounter() + " calls, and took " + (stopTime - startTime) + "ms");
    }
}
