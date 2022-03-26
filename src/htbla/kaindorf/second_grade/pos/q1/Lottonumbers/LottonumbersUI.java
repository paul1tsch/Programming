package htbla.kaindorf.second_grade.pos.q1.Lottonumbers;

import java.util.Random;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        LottonumbersUI.java
 */

public class LottonumbersUI {

    private int[] numbers = {0, 0, 0, 0, 0};
    private int additionalNumber;
    private int additionalNumber2;

    public void setRandomNumbers() {
        this.numbers = numbers;
    }

    public int[] getRandomNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = nextNumber();
        }
        return numbers;
    }

    public boolean contains(int n) {
        for (int number : numbers) {
            if (number == n) {
                return true;
            }
        }
        return false;
    }

    public int nextNumber() {
        int number;
        Random random = new Random();

        do {
            number = random.nextInt(50 - 1 + 1) + 1;
        } while (contains(number));

        return number;
    }

    public void getAdditionalNumber() {
        Random random = new Random();
        nextNumber();

        additionalNumber = random.nextInt(12 - 1 + 1) + 1;
        do {
            additionalNumber = random.nextInt(12 - 1 + 1) + 1;
        } while (contains(nextNumber()));
    }

    public void setAdditionalNumber(int additionalNumber) {
        this.additionalNumber = additionalNumber;
    }

    public void getAdditionalNumber2() {
        Random random = new Random();
        nextNumber();

        additionalNumber2 = random.nextInt(12 - 1 + 1) + 1;
        do {
            additionalNumber2 = random.nextInt(12 - 1 + 1) + 1;
        } while (contains(nextNumber()));
    }

    public void sortNumbers() {
        int n = numbers.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (numbers[j - 1] > numbers[j]) {
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        System.out.print("Lotto-Numbers: ");
        for (long j : numbers) System.out.print(j + " ");
        System.out.println(", Supplementary Number: " + additionalNumber + " and " + additionalNumber2 + " ");
        return null;
    }
}
