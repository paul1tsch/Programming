package htbla.kaindorf.second_grade.pos.q1.NumberConverter;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        NumberConverter.java
 */

public class NumberConverter {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        NumberConverter hex2dec = new NumberConverter();
        hex2dec.getInput();
    }

    public void getInput() {
        Scanner scan = new Scanner(System.in);
        char ch;

        System.out.print("Enter, what would you like to convert! ([x] for Hex to Dec, [d] for Dec to Hex):\t\t");
        ch = scan.next().charAt(0);

        switch (ch) {
            case 'x' -> hex();
            case 'd' -> dec();
            default -> System.out.print("[-] Something went horribly wrong!");
        }
    }

    public void hex() {
        System.out.print("\nEnter hex number:\t");

        String string = scan.next();
        string = string.toUpperCase();

        int val = 0;
        String digits = "0123456789ABCDEF";

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            int d = digits.indexOf(c);
            val = 16 * val + d;
        }
        System.out.print("Hex in Dec: " + val);
    }

    public void dec() {
        System.out.print("\nEnter dec number:\t");
        int num = scan.nextInt();

        String str = Integer.toHexString(num);
        System.out.print("Dec in Hex: " + str);
    }
}
