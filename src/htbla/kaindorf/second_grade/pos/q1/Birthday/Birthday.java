package htbla.kaindorf.second_grade.pos.q1.Birthday;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Birthday.java
 */

public class Birthday {

    public int day;
    public int month;
    public int year;
    public String monthName;
    public int dayOfYear = 365;
    public int h = 5;

    public static void main(String[] args) {
        Birthday birthday = new Birthday();

        birthday.input();
        birthday.compute();
        birthday.output();
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter day: ");
        day = scan.nextInt();

        System.out.print("Please enter month: ");
        month = scan.nextInt();

        System.out.print("Please enter year: ");
        year = scan.nextInt();
    }

    public void compute() {
        switch (month) {
            case 1 -> monthName = "January";
            case 2 -> monthName = "February";
            case 3 -> monthName = "March";
            case 4 -> monthName = "April";
            case 5 -> monthName = "May";
            case 6 -> monthName = "June";
            case 7 -> monthName = "July";
            case 8 -> monthName = "August";
            case 9 -> monthName = "September";
            case 10 -> monthName = "October";
            case 11 -> monthName = "November";
            case 12 -> monthName = "December";
            default -> System.out.print("[-] Something went horribly wrong!");
        }
        switch (month) {
            case 1 -> dayOfYear = 31 - (31 - day);
            case 2 -> dayOfYear = 59 - (28 - day);
            case 3 -> dayOfYear = 90 - (31 - day);
            case 4 -> dayOfYear = 120 - (30 - day);
            case 5 -> dayOfYear = 151 - (31 - day);
            case 6 -> dayOfYear = 181 - (30 - day);
            case 7 -> dayOfYear = 212 - (31 - day);
            case 8 -> dayOfYear = 243 - (31 - day);
            case 9 -> dayOfYear = 273 - (30 - day);
            case 10 -> dayOfYear = 304 - (31 - day);
            case 11 -> dayOfYear = 334 - (30 - day);
            case 12 -> dayOfYear = 365 - (31 - day);
            default -> System.out.println("[-] Something went horribly wrong!");
        }

        int q = day;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        h = q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;

        if (month == 1) {
            month = 13;
            year--;
        }
        if (month == 2) {
            month = 14;
            year--;
        }
    }

    public void output() {
        if (month <= 12) {
            System.out.print("\tYour Birthday is: " + day + "." + monthName + "." + year + "\n");
            System.out.print("\tYour Birthday is the " + dayOfYear + ". day of the year\n");
        } else {
            System.out.println(monthName);
        }
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            System.out.println("\tThe year you are born in is a leap-year!\n");
        } else {
            System.out.println("\tYou aren't born in a leap-year");
        }
        switch (h) {
            case 0 -> System.out.println("\tYou were born on a Saturday");
            case 1 -> System.out.println("\tYou were born on a Sunday");
            case 2 -> System.out.println("\tYou were born on a Monday");
            case 3 -> System.out.println("\tYou were born on a Tuesday");
            case 4 -> System.out.println("\tYou were born on a Wednesday");
            case 5 -> System.out.println("\tYou were born on a Thursday");
            case 6 -> System.out.println("\tYou were born on a Friday");
        }
    }
}
