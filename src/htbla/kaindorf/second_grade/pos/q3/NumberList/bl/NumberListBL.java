package htbla.kaindorf.second_grade.pos.q3.NumberList.bl;

import java.util.LinkedList;
import java.util.Random;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        NumberListBL.java
 */

public class NumberListBL {

    private final LinkedList<Integer> numbers = new LinkedList<>();
    private final boolean isRandom;
    private final int nElements;
    private final int OG;
    private final int fixedValue;

    Random random = new Random();

    public NumberListBL(boolean isRandom, int nElements, int OG, int fixedValue) {
        this.isRandom = isRandom;
        this.nElements = nElements;
        this.OG = OG;
        this.fixedValue = fixedValue;
    }

    public void init() {
        if (isRandom) {
            generateRandomNumbers();
        } else {
            generateFixedNumbers();
        }

    }

    public void delete(boolean isIndex, int value) {
        System.out.printf("delete: isIndex=%b value=%d\n", isIndex, value);
        dumpList();
        if (isIndex) {
            System.out.printf("delete: deleting at Index=%d\n", value);
            numbers.remove(value);
        } else {
            System.out.printf("delete: deleting all values %d\n", value);
            while (numbers.remove((Integer) value)) ;
        }
        dumpList();
    }

    public void dumpList() {
        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        if (numbers.size() == 0) {
            return "numbers is empty";
        }
        for (int i = 0; i < numbers.size(); i++) {
            str.append(String.format("%3d", numbers.get(i))).append(", ");
            if ((i + 1) % 10 == 0) {
                str.append("\n");
            }
        }
        str = new StringBuilder(str.substring(0, str.length() - 2));
        return str.toString();
    }

    public void insert(boolean isIndex, int value) {
        int index = value;
        if (isIndex) {
            if (isRandom) {
                value = random.nextInt(OG) + 1;
                numbers.add(index, value);
            } else
                numbers.add(index, fixedValue);
        } else
            numbers.add(value);
    }

    private void generateRandomNumbers() {
        for (int i = 0; i < nElements; i++) {
            numbers.add(random.nextInt(OG) + 1);
        }
    }

    private void generateFixedNumbers() {
        for (int i = 0; i < nElements; i++) {
            numbers.add(fixedValue);
        }

    }

    public LinkedList<Integer> getNumbers() {
        return numbers;
    }
}
