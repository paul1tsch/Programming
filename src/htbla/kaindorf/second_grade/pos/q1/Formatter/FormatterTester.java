package htbla.kaindorf.second_grade.pos.q1.Formatter;

import htbla.kaindorf.second_grade.pos.q1.Formatter.bl.Formatter;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        FormatterTester.java
 */

public class FormatterTester {

    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        Scanner scan = new Scanner(System.in);

        String format = scan.next();
        int hour = scan.nextInt();
        int min = scan.nextInt();
        int sec = scan.nextInt();

        String string = formatter.time(format, hour, min, sec);
        System.out.printf("" + format + " %s", string);
    }
}
