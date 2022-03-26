package htbla.kaindorf.third_grade.pos.q1.MapTester.bl;

import htbla.kaindorf.third_grade.pos.q1.MapTester.beans.Student;

import java.time.LocalDate;
import java.util.*;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        MapTester.java
 */

public class MapTester {

    private final Map<Integer, String> studentMap = new HashMap<>();
    private final Map<String, List<Student>> schoolMap = new TreeMap<>();

    public static void main(String[] args) {
        MapTester mapTester = new MapTester();
        mapTester.fillMap();
        mapTester.showMap();

        mapTester.fillStudentMap();
        mapTester.showSchoolMap();
    }

    public void fillMap() {
        studentMap.put(1, "Allwinger");
        studentMap.put(10, "Jamnik");
        studentMap.put(11, "Jamnik");
        studentMap.put(20, "Ranegger");
        studentMap.put(10, "Alaba");
    }

    public void showMap() {
        System.out.println("\n");
        for (Integer key : studentMap.keySet()) {
            System.out.println(studentMap.get(key));
        }
        System.out.println("\n");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.format("Key: %3s - Value %3s \n", entry.getKey(), entry.getValue());
        }
        System.out.println("\n");
    }

    public List<String> getClassnamesOfSchool() {
        List<String> classnames = new ArrayList<>(schoolMap.keySet());
        Collections.sort(classnames);
        return classnames;
    }

    public List<Student> getClassFromSchool(String classname) {
        try {
            List<Student> students = schoolMap.get(classname);
            Collections.sort(students);
            return students;
        } catch (NullPointerException npx) {
            throw new NullPointerException("Classname " + classname + " does not exist");
        }

//        if (schoolMap.containsKey(classname)) {
//            List<Student> students = schoolMap.get(classname);
//            Collections.sort(students);
//            return students;
//        }
//        throw new NoSuchElementException("Classname " + classname + " does not exist");


    }

    public void fillStudentMap() {
        Student s1 = new Student("Allwinger", LocalDate.now());
        Student s2 = new Student("Jamnik", LocalDate.now().minusDays(1000));
        Student s3 = new Student("Ranegger", LocalDate.now().minusDays(2000));

        List<Student> classList3D = new ArrayList<>();
        classList3D.add(s1);
        classList3D.add(s2);

        schoolMap.put("3DHIF", classList3D);

        Student s4 = new Student("Draxler", LocalDate.now().minusDays(3000));
        Student s5 = new Student("Draxler", LocalDate.now().minusDays(3500));

        List<Student> classList3C = new ArrayList<>();
        classList3C.add(s4);
        classList3C.add(s5);
        classList3D.add(0, s3);

        schoolMap.put("3CHIF", classList3C);

        Collections.sort(classList3D);
    }

    public void showSchoolMap() {
        for (String classname : schoolMap.keySet()) {
            System.out.println("Students of " + classname);
            for (Student student : schoolMap.get(classname)) {
                System.out.println("\t" + student);
            }
        }
        System.out.println("\n");

        for (Map.Entry<String, List<Student>> entry : schoolMap.entrySet()) {
            System.out.format("Key: %s - Value: %s \n", entry.getKey(), entry.getValue());
        }
    }
}
