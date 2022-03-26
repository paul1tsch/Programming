package htbla.kaindorf.second_grade.pos.q3.NameList.bl;

import java.util.LinkedList;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        NameListBL.java
 */

public class NameListBL {

    private final LinkedList<String> names = new LinkedList<>();
    private int position = 0;

    public void insert(String name) {
        if (!names.contains(name)) {
            names.add(name);
        } else {
            System.out.println("Failure: Name is already existing! ///ERROR/// ");
        }
    }

    public String getNameOfList() {
        try {
            return names.get(position);
        } catch (Exception e) {
            System.out.println("///NO ERROR/// DO NOT MIND! THE ERROR BELOW IS NOT AN ERROR! ///NO ERROR///");
        }
        return names.get(position);
    }

    public int[] getIndex() {
        return new int[]{position + 1, names.size()};
    }

    public void delete(String name) {
        if (!names.contains(name)) {
            System.out.println("NO NAME IS LIKE THAT ///ERROR///");
        }
        while (names.contains(name)) {
            names.remove(name);
            if (position == names.size()) {
                position--;
            }
        }
    }

    public void up() {
        if (position > 0) {
            position--;
        } else {
            System.out.println("BEGINNING ///ERROR///");
        }
    }

    public void down() {
        if (position < names.size() - 1) {
            position++;
        } else {
            System.out.println("ENDING ///ERROR///");
        }
    }
}
