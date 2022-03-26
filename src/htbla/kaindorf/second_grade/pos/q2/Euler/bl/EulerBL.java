package htbla.kaindorf.second_grade.pos.q2.Euler.bl;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        EulerBL.java
 */

public class EulerBL {

    public static int[] getDigitFactorials() {
        int[] retVal = new int[10];
        for (int i = 0; i < retVal.length; i++)
            retVal[i] = (int) getFactorial(i);

        return retVal;
    }

    public static long getFactorial(int num) {
        long retVal = 1;

        for (int i = 2; i <= num; i++)
            retVal *= i;

        return retVal;
    }

    public String calculation(boolean is1, boolean is3, boolean is9, boolean is20, boolean is24) {
        StringBuilder str = new StringBuilder();

        if (is1) {
            int sum = 0;

            for (int i = 1; i < 999; i++) {
                if (0 == (i % 3) || 0 == (i % 5)) {
                    sum += i;
                }
            }
            str.append("Problem 1 (Multiples of 3 and 5): \n").append(sum).append("\n-----------------------------------");
        }

        if (is3) {
            long num = 600851475143L;
            long i;

            for (i = 2L; i < num; i++) {
                while (num % i == 0) {
                    num /= i;
                }
            }
            str.append("\nProblem 3 (Largest prime factor): \n").append(num).append("\n-----------------------------------");
        }

        if (is9) {
            for (int a = 3; a <= 1000; a++) {
                for (int b = a + 1; b < 1000; b++) {
                    double cSquare = Math.pow(a, 2) + Math.pow(b, 2);
                    double c = Math.pow(cSquare, 0.5);

                    if (a + b + c == 1000) {
                        str.append("\nProblem 9 (Pythagorean Triplet): \n").append(a * b * c).append("\n-----------------------------------");
                    }
                }
            }
        }

        if (is20) {
            int product = 10;
            int sumDigits = 0;

            for (int n = 10; n >= 1; n--) {
                product = n * product;
            }
            int length = String.valueOf(product).length();
            for (int i = 1; i <= length; i++) {
                int digit = product % 10;
                sumDigits += digit;
                product /= 10;
            }
            str.append("\nProblem 20 (Factorial Digit Number): \n").append(sumDigits).append("\n-----------------------------------");
        }

        if (is24) {

            int[] factorials = getDigitFactorials();

            long left = 1000000;
            StringBuilder result = new StringBuilder();

            while (result.length() < 10) {
                for (int i = 0; i < 10; i++) {
                    if (!result.toString().contains(Integer.toString(i))) {
                        if (left - factorials[9 - result.length()] > 0) {
                            left = left - factorials[9 - result.length()];
                        } else {
                            result.append(i);
                            break;
                        }
                    }
                }
            }

            str.append("\nProblem 24 (Lexicographic Permutation): \n").append(result).append("\n-----------------------------------");
        }
        return str.toString();
    }
}
