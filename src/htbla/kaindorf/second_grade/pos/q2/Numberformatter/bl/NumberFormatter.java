package htbla.kaindorf.second_grade.pos.q2.Numberformatter.bl;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        NumberFormatter.java
 */

public class NumberFormatter {

    public String getDigitLine(int length) {
        StringBuilder str = new StringBuilder();
        int cnt = 1;

        for (int i = 0; i < length; i++) {
            if (cnt == 10) {
                cnt = 1;
                str.append(" ");
            } else {
                str.append(cnt);
                cnt++;
            }
        }

        return str.toString();
    }

    public String format(double num, String format, String fillChar, boolean isCheckedDelimiter, boolean isCheckedRight) {
        String str = "";
        String text = String.valueOf(fillChar);

        if (isCheckedRight && isCheckedDelimiter) {
            str += String.format("%," + format + "f", num);
            str = str.replace(' ', text.charAt(0));
        } else if (isCheckedRight) {
            str += String.format("%" + format + "f", num);
            str = str.replace(' ', text.charAt(0));
        } else if (isCheckedDelimiter) {
            str += String.format("%-," + format + "f", num);
        }

        return getDigitLine(str.length()) + "\n" + str;
    }
}
