package htbla.kaindorf.second_grade.loal.datatypes.tree;

import java.lang.reflect.Type;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        InsertDeleteTree.java
 */

public abstract class InsertDeleteTree {

    protected Node<Type> root;

    protected abstract int compare(Type a, Type b);

    public void add(Type elem) {
        Node<Type> newElement = new Node<>(elem);

        if (root == null) {
            root = newElement;
            return;
        }

        Node<Type> node = root;
        while (true) {
            int vgl = compare(elem, node.getValue());
            if (vgl < 0) {
                if (node.getLeft() == null) {
                    node.setLeft(newElement);
                    newElement.setParent(node);
                    return;
                }
                node = node.getLeft();
            } else if (vgl > 0) {
                if (node.getRight() == null) {
                    node.setRight(newElement);
                    newElement.setParent(node);
                    return;
                }
                node = node.getRight();
            } else {
                return;
            }
        }
    }

    public Node<Type> find(Type needle) {
        return find(root, needle);
    }

    public Node<Type> find(Node<Type> current, Type needle) {
        if (current == null) {
            return null;
        }
        int vgl = compare(needle, current.getValue());
        if (vgl == 0) {
            return current;
        } else if (vgl < 0) {
            return find(current.getLeft(), needle);
        } else {
            return find(current.getRight(), needle);
        }
    }

    public void printTree() {
        printTree(root, "");
    }

    public void printTree(Node<Type> current, String prefix) {
        if (current == null) {
            return;
        }
        System.out.println(prefix + current.getValue());
        printTree(current.getLeft(), prefix + " L ");
        printTree(current.getRight(), prefix + " R ");
    }

    public class Node<Type> {

        protected final Type value;
        protected Node<Type> left;
        protected Node<Type> right;
        protected Node<Type> parent;

        public Node(Type value) {
            this.value = value;
        }

        public Node<Type> getLeft() {
            return left;
        }

        public void setLeft(Node<Type> left) {
            this.left = left;
        }

        public Node<Type> getRight() {
            return right;
        }

        public void setRight(Node<Type> right) {
            this.right = right;
        }

        public Node<Type> getParent() {
            return parent;
        }

        public void setParent(Node<Type> parent) {
            this.parent = parent;
        }

        public Type getValue() {
            return value;
        }
    }
}
