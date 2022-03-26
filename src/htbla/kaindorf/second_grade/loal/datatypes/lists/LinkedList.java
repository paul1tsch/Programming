package htbla.kaindorf.second_grade.loal.datatypes.lists;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        LinkedList.java
 */

public class LinkedList {

    public static LIST list;

    public static void main(String[] args) {
        list = new LIST();

        list.insert("ALLWINGER");
        list.insert("BANDION");
        list.insert("EHMANN");
        list.insert("FEURER");
        list.insert("FILZMAIER");
        list.insert("FROMM");
        list.insert("GHERGHELES");
        list.insert("HEIN");
        list.insert("HÜTL");
        list.insert("JAMNIK");
        list.insert("KERN");
        list.insert("KOCHAUF");
        list.insert("KOINIGG");
        list.insert("LACKNER");
        list.insert("LACKNER");
        list.insert("LEITNER");
        list.insert("LEVOUNIGG");
        list.insert("MORITZ");
        list.insert("NEUKIRCHNER");
        list.insert("OKORN");
        list.insert("PAULITSCH");
        list.insert("RANEGGER");
        list.insert("RANNEGGER");
        list.insert("SAILER");
        list.insert("SCHARAWEGER");
        list.insert("SCHWEIGHOFER");
        list.insert("STEINBAUER");
        list.insert("VOLLMANN-OSWALD");
        list.insert("WEISS");
        list.insert("WELSER");
        list.insert("WETL");
        list.insert("ZENZ");
        list.insert("ZIVKOVIC");

        System.out.println("Output List:             " + list);
        System.out.println("Output size of List:     " + list.size());
        System.out.println("Adding a element:        KOHLWEG");
        list.add("KOHLWEG", 12);
        System.out.println("Output List:             " + list);
        System.out.println("Output size of List:     " + list.size());
        System.out.println("Removing a element:      KOHLWEG");
        list.remove(12);
        System.out.println("Output List:             " + list);
        System.out.println("Output size of List:     " + list.size());
    }
}

class LIST {

    private static int cnt;
    private Node first;

    private static int getcnt() {
        return cnt;
    }

    public void insert(Object Person) {
        if (first == null) {
            first = new Node(Person);
        }

        Node temp = new Node(Person);
        Node current = first;

        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        cnt++;
    }

    public void add(Object Person, int index) {
        Node temp = new Node(Person);
        Node current = first;

        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }
        assert current != null;
        temp.setNext(current.getNext());
        current.setNext(temp);
        cnt++;
    }

    public void remove(int index) {
        if (index < 1 || index > size()) {
            return;
        }
        Node current = first;
        if (first != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) {
                    return;
                }
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            cnt--;
            return;
        }
        cnt--;
    }

    public int size() {
        return getcnt();
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        if (first != null) {
            Node current = first.getNext();
            while (current != null) {
                output.append("[").append(current.getPerson().toString()).append("]");
                current = current.getNext();
            }
        }
        return output.toString();
    }

    private static class Node {
        Node next;
        Object Person;

        public Node(Object PersonValue) {
            next = null;
            Person = PersonValue;
        }

        public Node(Object PersonValue, Node nextValue) {
            next = nextValue;
            Person = PersonValue;
        }

        public Object getPerson() {
            return Person;
        }

        public void setPerson(Object PersonValue) {
            Person = PersonValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }

}
