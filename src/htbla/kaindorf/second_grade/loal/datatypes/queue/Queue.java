package htbla.kaindorf.second_grade.loal.datatypes.queue;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Queue.java
 */

public class Queue {

    Node front;
    Node rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();

        System.out.println("Queue Front: " + queue.front.value);
        System.out.println("Queue Rear: " + queue.rear.value);
    }

    public void dequeue() {
        if (this.front == null) {
            return;
        }

        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }
    }

    public void enqueue(int data) {
        Node temp = new Node(data);

        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        this.rear.next = temp;
        this.rear = temp;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
