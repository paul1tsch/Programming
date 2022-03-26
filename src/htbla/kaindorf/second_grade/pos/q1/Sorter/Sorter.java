package htbla.kaindorf.second_grade.pos.q1.Sorter;

import java.util.Random;
import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Sorter.java
 */

public class Sorter {

    public int length;
    public int input;
    public int[] nums;

    public static void main(String[] args) {
        Sorter sorter = new Sorter();

        sorter.input();
        sorter.getArray();
        sorter.output();
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the amount of the Elements: ");
        length = scan.nextInt();

        nums = new int[length];

        System.out.println("[1] Selection-Sort");
        System.out.println("[2] Insertion-Sort");
        System.out.println("[3] Bubble-Sort");
        System.out.print("Choose the following sort: ");

        input = scan.nextInt();

        if (input != 1 && input != 2 && input != 3) {
            error();
        }
    }

    public void getArray() {
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt(length + 1);
        }
    }

    public void selectionSort() {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = nums[min_idx];
            nums[min_idx] = nums[i];
            nums[i] = temp;
        }
    }

    public void insertionSort() {
        int n = nums.length;

        for (int i = 1; i < n; ++i) {
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = tmp;
        }
    }

    public void bubbleSort() {
        int n = nums.length;
        int temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (nums[j - 1] > nums[j]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void error() {
        System.out.println("\n[-] Something went horribly wrong!");
    }

    public void output() {
        if (input == 1) {
            selectionSort();
            for (int j : nums) System.out.print(j + " ");
            System.out.println();
        } else if (input == 2) {
            insertionSort();
            for (int j : nums) System.out.print(j + " ");
            System.out.println();
        } else if (input == 3) {
            bubbleSort();
            for (int j : nums) System.out.print(j + " ");
            System.out.println();
        }
    }
}
