package htbla.kaindorf.second_grade.loal.datatypes.stack;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Stack.java
 */

public class Stack {

    Node first;

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop() + " removed!");
        System.out.println("Top element: " + stack.peek());
    }

    public void push(int i) {
        Node node = new Node(i);

        if (first == null) {
            first = node;
        } else {
            Node temp = first;
            first = node;
            node.getNext = temp;
        }
        System.out.println(i + " inserted!");
    }

    public int pop() {
        int pop = 0;
        if (first == null) {
            System.out.println("[-] Stack Empty!");
        } else {
            pop = first.value;
            first = first.getNext;
        }
        return pop;
    }

    public Object peek() {
        if (first == null) {
            System.out.println("[-] Stack Empty!");
        } else {
            return first.value;
        }
        return "No Value!";
    }

    public static class Node {
        int value;
        Node getNext;

        Node(int value) {
            this.value = value;
        }
    }
}
