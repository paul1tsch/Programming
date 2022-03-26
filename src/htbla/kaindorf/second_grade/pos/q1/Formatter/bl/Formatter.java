package htbla.kaindorf.second_grade.pos.q1.Formatter.bl;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Formatter.java
 */

public class Formatter {

    public String time(String fmt, int... values) {
        StringBuilder str;
        String plus;

        if ((values[1] >= 60) || (values[2] >= 60)) {
            System.out.println("[-] Something went horribly wrong!");
            return "";
        }

        switch (fmt) {
            case "hh:mm:ss" -> {
                if (values[0] > 23) {
                    System.out.println("[-] Something went horribly wrong!");
                    return "";
                }
                str = new StringBuilder(String.format("%02d", values[0]));
                for (int x = 1; x < values.length; x++) {
                    str.append(":").append(String.format("%02d", values[x]));
                }
                return str.toString();
            }
            case "hh:mm" -> {
                if (values[0] > 23) {
                    System.out.println("[-] Something went horribly wrong!");
                    return "";
                }
                str = new StringBuilder(String.format("%02d", values[0]));
                for (int x = 1; x < values.length - 1; x++) {
                    str.append(":").append(String.format("%02d", values[x]));
                }
                return str.toString();
            }
            case "HH:mm:ss" -> {
                if (values[0] > 23) {
                    System.out.println("[-] Something went horribly wrong!");
                    return "";
                }
                if (values[0] > 12) {
                    values[0] -= 12;
                    plus = "PM";
                } else if (values[0] == 0) {
                    values[0] = 12;
                    plus = "AM";
                } else if (values[0] == 12) {
                    plus = "PM";
                } else {
                    plus = "AM";
                }
                str = new StringBuilder(String.format("%02d", values[0]));
                for (int x = 1; x < values.length; x++) {
                    str.append(":").append(String.format("%02d", values[x]));
                }
                str.append(" ").append(plus);
                return str.toString();
            }
            case "HH:mm" -> {
                if (values[0] > 23) {
                    System.out.println("[-] Something went horribly wrong!");
                    return "";
                }
                if (values[0] > 12) {
                    values[0] -= 12;
                    plus = "PM";
                } else if (values[0] == 0) {
                    values[0] = 12;
                    plus = "AM";
                } else if (values[0] == 12) {
                    plus = "PM";
                } else {
                    plus = "AM";
                }
                str = new StringBuilder(String.format("%02d", values[0]));
                for (int x = 1; x < values.length - 1; x++) {
                    str.append(":").append(String.format("%02d", values[x]));
                }
                str.append(" ").append(plus);
                return str.toString();
            }
        }
        System.out.println("[-] Wrong format!");
        return "";
    }
}
