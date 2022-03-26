package htbla.kaindorf.second_grade.pos.q1.Lottonumbers.beans;

import htbla.kaindorf.second_grade.pos.q1.Lottonumbers.LottonumbersUI;

import java.util.Arrays;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Lottonumbers.java
 */

public class Lottonumbers {

    public static void main(String[] args) {
        LottonumbersUI lotto = new LottonumbersUI();

        lotto.setRandomNumbers();
        lotto.setAdditionalNumber(5);
        lotto.contains(5);
        lotto.nextNumber();

        Arrays.toString(lotto.getRandomNumbers());

        lotto.getAdditionalNumber();
        lotto.getAdditionalNumber2();
        lotto.sortNumbers();

        lotto.toString();
    }
}
