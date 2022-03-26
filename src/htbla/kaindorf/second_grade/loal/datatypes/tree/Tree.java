package htbla.kaindorf.second_grade.loal.datatypes.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Tree.java
 */

public class Tree {

    public static void main(String[] args) {
        Node root = buildTree();
        defineHierarchyLevel(root);
        System.out.println("❯❯❯❯❯ Company DHIF19 ❮❮❮❮❮");
        System.out.println("➤ " + calculateSalary(root) + " EUR Salary");
        System.out.println("➤ " + calculateCountDevices(root) + " Devices");
        System.out.println("➤ " + employeesInLevel(root, 1) + " CEO");
        System.out.println("➤ " + employeesInLevel(root, 2) + " Heads of Department");
        System.out.println("➤ " + employeesInLevel(root, 3) + " Team Leaders");
        System.out.println("➤ " + employeesInLevel(root, 4) + " Employees");
    }

    private static int calculateCountDevices(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Node element;
        int device = 0;
        while (!stack.isEmpty()) {
            element = stack.pop();
            device += element.getCountDevices();

            if (element.getRight() != null)
                stack.push(element.getRight());
            if (element.getMiddle() != null)
                stack.push(element.getMiddle());
            if (element.getLeft() != null)
                stack.push(element.getLeft());
        }
        return device;
    }

    private static void defineHierarchyLevel(Node element) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(element);
        element.setLevel(1);

        while (!queue.isEmpty()) {
            Node currentElement = queue.poll();

            if (currentElement.getLeft() != null) {
                currentElement.getLeft().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getLeft());
            }
            if (currentElement.getMiddle() != null) {
                currentElement.getMiddle().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getMiddle());
            }
            if (currentElement.getRight() != null) {
                currentElement.getRight().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getRight());
            }
        }
    }

    private static int employeesInLevel(Node element, int level) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(element);
        element.setLevel(1);
        int counter = 0;

        while (!queue.isEmpty()) {
            Node currentElement = queue.poll();

            if (currentElement.getLevel() == level) {
                counter++;
                continue;
            }
            if (currentElement.getLeft() != null) {
                currentElement.getLeft().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getLeft());
            }
            if (currentElement.getMiddle() != null) {
                currentElement.getMiddle().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getMiddle());
            }
            if (currentElement.getRight() != null) {
                currentElement.getRight().setLevel(currentElement.getLevel() + 1);
                queue.add(currentElement.getRight());
            }
        }
        return counter;
    }

    private static void defineHierarchyLevel2(Node element) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(element);
        while (!queue.isEmpty()) {
            Node currentElement = queue.poll();

            System.out.println(currentElement.getName() + ", ");

            if (currentElement.getLeft() != null) {
                queue.add(currentElement.getLeft());
            }
            if (currentElement.getRight() != null) {
                queue.add(currentElement.getRight());
            }
        }
    }


    private static int calculateSalary(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Node element;
        int salary = 0;
        while (!stack.isEmpty()) {
            element = stack.pop();
            salary += element.getSalary();

            if (element.getRight() != null)
                stack.push(element.getRight());
            if (element.getMiddle() != null)
                stack.push(element.getMiddle());
            if (element.getLeft() != null)
                stack.push(element.getLeft());
        }
        return salary;
    }

    private static Node buildTree() {
        Node n1 = new Node("CEO", 5000, 3);
        Node n2 = new Node("Department Manager Software Development", 4000, 3);
        Node n3 = new Node("Team Leader SWT1", 3900, 2);
        Node n4 = new Node("Senior Developer", 3800, 2);
        Node n5 = new Node("Junior Developer", 2600, 1);
        Node n6 = new Node("Team Leader SWT2", 3200, 2);
        Node n7 = new Node("Junior Developer", 2600, 1);
        Node n8 = new Node("Junior Developer", 2600, 1);
        Node n9 = new Node("Team Leader SWT3", 3900, 3);
        Node n10 = new Node("Senior Developer", 3700, 2);
        Node n11 = new Node("Senior Developer", 3500, 1);
        Node n12 = new Node("Department Manager Sales Development", 4100, 3);
        Node n13 = new Node("Team Leader ST1", 3500, 2);
        Node n14 = new Node("Sales 1", 3000, 2);
        Node n15 = new Node("Sales 2", 2900, 1);
        Node n16 = new Node("Team Leader ST2", 3600, 2);
        Node n17 = new Node("Sales 1", 2800, 1);
        Node n18 = new Node("Sales 2", 2900, 2);

        n1.setLeft(n2);
        n1.setRight(n12);

        n2.setLeft(n3);
        n2.setMiddle(n6);
        n2.setRight(n9);

        n3.setLeft(n4);
        n3.setRight(n5);

        n6.setLeft(n7);
        n6.setRight(n8);

        n9.setLeft(n10);
        n9.setRight(n11);

        n12.setLeft(n13);
        n12.setRight(n16);

        n13.setLeft(n14);
        n13.setRight(n15);

        n16.setLeft(n17);
        n16.setRight(n18);

        return n1;
    }

    public static class Node {
        private final int salary;
        private final int countDevices;
        private String name;
        private Node left;
        private Node middle;
        private Node right;
        private int level;


        public Node(String name, int salary, int countDevices) {
            this.name = name;
            this.salary = salary;
            this.countDevices = countDevices;
            this.level = -1;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }


        public int getCountDevices() {
            return countDevices;
        }


        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getMiddle() {
            return middle;
        }

        public void setMiddle(Node middle) {
            this.middle = middle;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
