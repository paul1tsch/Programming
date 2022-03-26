package htbla.kaindorf.second_grade.pos.q4.Training.model;

import htbla.kaindorf.second_grade.pos.q4.Training.beans.Training;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        TrainingModel.java
 */

public class TrainingModel extends AbstractListModel {

    List<Training> trainings = new ArrayList<>();

    @Override
    public int getSize() {
        return trainings.size();
    }

    public void add(Training training) {
        trainings.add(training);
        fireContentsChanged(this, 0, getSize());
    }

    @Override
    public Object getElementAt(int index) {
        return trainings.get(index);
    }

    public void addTraining(String name, double distance, String sDate, String time) {
        trainings.add(new Training(name, distance, sDate, time));
        fireContentsChanged(trainings, 0, trainings.size());
    }
}
