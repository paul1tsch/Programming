package htbla.kaindorf.second_grade.pos.q4.Student.model;

import htbla.kaindorf.second_grade.pos.q4.Student.beans.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        StudentListModel.java
 */

public class StudentListModel extends AbstractListModel {

    private final List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
        fireContentsChanged(this, 0, getSize());
    }

    public void delete(int[] indices) {
        for (int i = indices.length - 1; i >= 0; i--) {
            if (students.isEmpty()) {
                break;
            }
            students.remove(indices[i]);
        }
        fireContentsChanged(this, 0, getSize());
    }

    public void modify(int index, Student student) {
        students.set(index, student);
        fireContentsChanged(student, index, index);
    }

    @Override
    public int getSize() {
        return students.size();
    }

    @Override
    public Object getElementAt(int index) {
        return students.get(index);
    }

    public Student getStudent(int index) {
        return students.get(index);
    }
}
