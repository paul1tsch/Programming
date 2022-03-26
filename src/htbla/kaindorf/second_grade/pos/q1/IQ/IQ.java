package htbla.kaindorf.second_grade.pos.q1.IQ;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        IQ.java
 */

public class IQ {

    public int[] values;
    public double average;
    public int mode;
    public int aboveAvg;
    public int belowAvg;
    public int upperBound;
    public int lowerBound;
    public int valuesInterval;
    String line;

    public IQ(String line) {
        this.line = line;
        String[] numbers = line.split(";");
        values = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            values[i] = Integer.parseInt(numbers[i]);
        }

        System.out.println("Evaluation");
        System.out.println("The following values were entered: ");

        for (int value : values) {
            System.out.printf("%d ", value);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nPlease enter the list of IQs separated by semicolons: ");
        IQ iq = new IQ(scan.next());

        iq.compute();
        iq.output();
        iq.computeInterval();
    }

    public void compute() {
        int sum;
        for (int j : values) {
            sum = j;
            average += sum;
        }
        average = average / values.length;

        int idx = 0;
        int count = 1;
        int count_fn = 0;
        int len = values.length;
        int[] help = values;
        int tmp;

        for (int i = 0; i < len; i++) {
            for (int u = 1; u < (len - i); u++) {
                if (help[u - 1] > help[u]) {
                    tmp = help[u - 1];
                    help[u - 1] = help[u];
                    help[u] = tmp;
                }
            }
        }

        for (int a = 0; a < help.length - 1; ++a) {
            if (help[a] == help[a + 1]) {
                ++count;
            }
            if (count_fn < count) {
                count_fn = count;
                idx = a;
            }
            if (help[a] != help[a + 1]) {
                count = 1;
            }
        }

        mode = help[idx];
        aboveAvg = 0;
        belowAvg = 0;

        for (int value : values) {
            if (value < average) {
                belowAvg++;
            } else if (value > average) {
                aboveAvg++;
            }
        }
    }

    public void computeInterval() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPlease enter the range to determine the number of IQs that lie within the interval: ");
        System.out.println("Lowerbound: ");
        lowerBound = scanner.nextInt();

        System.out.println("Upperbound: ");
        upperBound = scanner.nextInt();

        valuesInterval = 0;
        for (int value : values) {
            if (value <= upperBound && value >= lowerBound) {
                valuesInterval++;
            }
        }
        System.out.printf("In the range [%d,%d] are %d IQ values", lowerBound, upperBound, valuesInterval);
    }

    public void output() {
        System.out.printf("\nArithmetic mean:  %.2f", average);
        System.out.println("\nThe most common value: " + mode);
        System.out.printf("\nNumber of people with IQ < %.2f : %d", average, belowAvg);
        System.out.printf("\nNumber of people with IQ > %.2f : %d", average, aboveAvg);
    }
}
