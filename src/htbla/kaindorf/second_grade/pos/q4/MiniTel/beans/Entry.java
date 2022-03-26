package htbla.kaindorf.second_grade.pos.q4.MiniTel.beans;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Entry.java
 */

public class Entry {

    private final String name;
    private final String number;

    private final boolean isPrivate;

    public Entry(String name, String number, boolean isPrivate) {
        this.name = name;
        this.number = number;
        this.isPrivate = isPrivate;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public String toString() {
        String privat = isPrivate ? "p" : "b";
        return String.format("%-10s - %s (%s)", name, number, privat);
    }

    public String getName() {
        return name;
    }
}
