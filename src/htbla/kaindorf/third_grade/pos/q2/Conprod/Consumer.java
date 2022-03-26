package htbla.kaindorf.third_grade.pos.q2.Conprod;

import htbla.kaindorf.third_grade.pos.q2.Conprod.misc.Stack;

import java.util.Random;

public class Consumer implements Runnable {
    private Stack beerStack;
    private int numberIterations;


    public Consumer(Stack beerStack, int numberIterations) {
        this.beerStack = beerStack;
        this.numberIterations = numberIterations;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < numberIterations; i++) {
            synchronized (beerStack) {
                while (beerStack.isEmpty()) {
                    System.out.println("\n[i] Consumer is waiting - Beerstack is empty!\n");
                    try {
                        beerStack.wait(); // gives lock free
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[i] Consumer continues!\n");

                }
                int value = beerStack.pop();
                System.out.println("Consumer takes beercrate: " + value + "\tBeerstack now: " + beerStack);
                beerStack.notify();
            }
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
