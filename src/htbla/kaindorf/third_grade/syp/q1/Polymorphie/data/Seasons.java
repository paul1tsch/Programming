package htbla.kaindorf.third_grade.syp.q1.Polymorphie.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Seasons.java
 */

public enum Seasons {
    SPRING(92), SUMMER(96), AUTUMN(94), WINTER(91);

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    Seasons(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    private int numOfDays;

}
