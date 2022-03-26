package htbla.kaindorf.second_grade.loal.datatypes.lists;

import java.io.Serial;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        DoubleLinkedList.java
 */

public class DoubleLinkedList {

    private Node first;
    private Node last;
    private Node current;

    public void add(Excuse a) {
        Node n = new Node(a);
        if (last == null) {
            first = n;
        } else {
            last.setNext(n);
            n.setPrevious(last);
        }
        last = n;
    }

    public void reset() {
        current = first;
    }

    public void resetToLast() {
        current = last;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public Excuse next() {
        if (current == null) {
            return null;
        }
        Excuse a = current.getExcuse();
        current = current.getNext();
        return a;
    }

    public Excuse previous() {
        if (current == null) {
            return null;
        }
        Excuse a = current.getExcuse();
        current = current.getPrevious();
        return a;
    }

    public void moveNext() {
        if (current != null)
            current = current.getNext();
    }

    public void movePrevious() {
        if (current != null)
            current = current.getPrevious();
    }

    public Excuse getCurrent() throws CurrentNotSetException {
        if (current == null) {
            throw new CurrentNotSetException();
        }
        return current.getExcuse();
    }

    public Excuse get(int pos) {
        Node n = first;
        int cnt = 1;
        while (cnt != pos && n != null) {
            n = n.getNext();
            cnt++;
        }
        return (n != null) ? n.getExcuse() : null;
    }

    public void remove(int pos) {
        Node n = first;
        int cnt = 1;
        while (cnt != pos && n != null) {
            n = n.getNext();
            cnt++;
        }
        if (n == null) {
            return;
        }
        removeNode(n);
        if (current == n) {
            current = null;
        }
    }

    public void removeCurrent() throws CurrentNotSetException {
        if (current == null) {
            throw new CurrentNotSetException();
        }
        removeNode(current);
        if (current.getNext() != null) {
            current = current.getNext();
        } else {
            current = current.getPrevious();
        }
    }

    private void removeNode(Node n) {
        if (n == first) {
            first = n.getNext();
            if (first != null) {
                first.setPrevious(null);
            }
        } else if (n == last) {
            last = n.getPrevious();
            if (last != null) {
                last.setNext(null);
            }
        } else {
            n.getPrevious().setNext(n.getNext());
            n.getNext().setPrevious(n.getPrevious());
        }
    }

    public void insertAfterCurrentAndMove(Excuse a) throws CurrentNotSetException {
        Node n = new Node(a);
        if (current == null) {
            throw new CurrentNotSetException();
        } else if (current == last) {
            last.setNext(n);
            n.setPrevious(last);
            last = n;
        } else {
            n.setNext(current.getNext());
            n.setPrevious(current);
            current.getNext().setPrevious(n);
            current.setNext(n);
        }
        current = n;
    }

    public static class CurrentNotSetException extends Exception {

        @Serial
        private static final long serialVersionUID = 251858618L;

    }

    public static class Excuse {
        private final String excuse;

        public Excuse(String excuse) {
            this.excuse = excuse;
        }

        public String getExcuse() {
            return excuse;
        }
    }

    public static class Node {
        private final Excuse excuse;

        private Node next;

        private Node previous;


        public Node(Excuse excuse) {
            this.excuse = excuse;
        }

        public Excuse getExcuse() {
            return excuse;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

}
