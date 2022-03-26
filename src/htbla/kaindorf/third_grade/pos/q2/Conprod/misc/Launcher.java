package htbla.kaindorf.third_grade.pos.q2.Conprod.misc;

import htbla.kaindorf.third_grade.pos.q2.Conprod.Consumer;
import htbla.kaindorf.third_grade.pos.q2.Conprod.Producer;
import htbla.kaindorf.third_grade.pos.q2.Conprod.misc.Stack;

public class Launcher {

    public static void main(String[] args) {
        Stack beerStack = new Stack(5);
        int numberIterations = 100;

        // --- Initialize Consumer and Producer
        Producer producer = new Producer(beerStack, numberIterations);
        Consumer consumer = new Consumer(beerStack, numberIterations);

        // --- Creating both threads
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        // --- Starting both threads
        producerThread.start();
        consumerThread.start();

    }
}
