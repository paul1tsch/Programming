package htbla.kaindorf.third_grade.pos.q2.Threads;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     Threads
 * File:        ThreadTest.java
 */

public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(ThreadTest::work);
//        thread.setDaemon(true);                         // (Daemon)-Thread is no longer going on, when main-Thread has finished
        thread.start();
        try {
            thread.sleep(500);                      // Trotz Thread-Instance anderen Thread schlafen schicken geht nicht (statisch, nur in dem, in den ich mich gerade befinde)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());   // Main-Thread
    }

    public static void work() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
