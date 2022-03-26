package htbla.kaindorf.second_grade.pos.q2.Fraction.bl;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Fraction.java
 */

public class Fraction {

    private int denominator;
    private int numerator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static void main(String[] args) {
        Fraction fraction = new Fraction(15, 10);
        fraction.cancel();
    }

    public void cancel() {
        int a = numerator;
        int b = denominator;
        do {
            while (a > b) {
                a = a - b;
            }
            while (b > a) {
                b = b - a;
            }
        } while (a != b);

        System.out.println("ggt = " + a);
        denominator = denominator / a;
        numerator = numerator / a;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }
}
