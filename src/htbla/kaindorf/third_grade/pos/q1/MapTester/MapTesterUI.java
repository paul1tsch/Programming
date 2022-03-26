package htbla.kaindorf.third_grade.pos.q1.MapTester;

import htbla.kaindorf.third_grade.pos.q1.MapTester.beans.Student;
import htbla.kaindorf.third_grade.pos.q1.MapTester.bl.MapTester;

import java.util.List;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        MapTesterUI.java
 */

public class MapTesterUI {

    private final MapTester bl = new MapTester();

    public MapTesterUI() {
        bl.fillStudentMap();
    }

    public static void main(String[] args) {
        MapTesterUI ui = new MapTesterUI();
        ui.printClassname();
    }

    public void printClassname() {
        for (String classnames : bl.getClassnamesOfSchool()) {
            System.out.println(classnames);
            for (Student student : bl.getClassFromSchool(classnames)) {
                System.out.println(" - " + student);
            }
        }
        try {
            List<Student> student = bl.getClassFromSchool("3BHIF");
        } catch (NullPointerException npx) {
            System.out.println("\nWarning: " + npx);
        }
    }
}
