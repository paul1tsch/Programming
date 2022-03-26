package htbla.kaindorf.second_grade.pos.q4.MiniTel.model;

import htbla.kaindorf.second_grade.pos.q4.MiniTel.beans.Entry;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        MiniTelModel.java
 */

public class MiniTelModel extends AbstractListModel {

    private final List<Entry> entries = new ArrayList<>();
    private final List<Entry> filtered = new ArrayList<>();
    private String mode = "all";

    @Override
    public int getSize() {
        return filtered.size();
    }

    @Override
    public Entry getElementAt(int index) {
        return filtered.get(index);
    }

    public void save(Entry entry) {
        entries.add(entry);
        entries.sort(Comparator.comparing(Entry::getName));
        filter(mode);
        fireContentsChanged(entry, 0, entries.size());
    }

    public void delete(int[] indices) {
        for (int i = indices.length - 1; i >= 0; i--) {
            if (entries.isEmpty()) {
                break;
            }
            entries.remove(filtered.get(indices[i]));
        }
        filter(mode);
        fireContentsChanged(filtered, 0, filtered.size());
    }

    public void filter(String mode) {
        this.mode = mode;
        filtered.clear();

        for (Entry entry : entries) {
            if (entry.isPrivate() && mode.equals("private")) {
                filtered.add(entry);
            } else if (!entry.isPrivate() && mode.equals("business")) {
                filtered.add(entry);
            } else{
                if (mode.equals("all")) {
                    filtered.add(entry);
                }
            }
        }
        fireContentsChanged(filtered, 0, filtered.size());
    }
}
