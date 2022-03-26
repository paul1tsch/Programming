package htbla.kaindorf.second_grade.loal.algorithms;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Standardsearch.java
 */

public class Standardsearch {

    public static void main(String[] args) {
        System.out.println("[+] Starting Standard\n");

        Searcharray searchArray = new Searcharray(1, 10_000_000);
        searchArray.load();

        System.out.println("\n[+] Searching ...\n");

        searchFor(searchArray, 314699018);
        searchFor(searchArray, 816387057);
        searchFor(searchArray, 1317297914);
        searchFor(searchArray, 1651147229);
        searchFor(searchArray, 1651147228);
    }

    public static int search(Searcharray array, int value, int left, int right) {
        int cnt = left;
        while (cnt <= right && array.get(cnt) != value) {
            cnt++;
            if (cnt > right) {
                System.out.println("Array out of bound");
                break;
            }
        }
        return cnt;
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
