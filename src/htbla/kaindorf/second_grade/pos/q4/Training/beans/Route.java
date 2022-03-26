package htbla.kaindorf.second_grade.pos.q4.Training.beans;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Route.java
 */

public class Route {

    private String name;
    private double distance;

    public Route(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    public Route(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
