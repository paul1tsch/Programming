package htbla.kaindorf.second_grade.pos.q4.Training.model;

import htbla.kaindorf.second_grade.pos.q4.Training.beans.Route;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        RouteModel.java
 */

public class RouteModel extends AbstractListModel {

    List<Route> routes = new ArrayList<>();

    @Override
    public int getSize() {
        return routes.size();
    }

    public void add(Route route) {
        routes.add(route);
        fireContentsChanged(this, 0, getSize());
    }

    @Override
    public Object getElementAt(int index) {
        return routes.get(index);
    }

    public void addTrack(String name, double distance) {
        routes.add(new Route(name, distance));
        fireContentsChanged(routes, 0, routes.size());
    }
}
