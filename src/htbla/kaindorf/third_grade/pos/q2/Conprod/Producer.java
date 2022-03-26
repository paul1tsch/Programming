package htbla.kaindorf.third_grade.pos.q2.Conprod;

import htbla.kaindorf.third_grade.pos.q2.Conprod.misc.Stack;

import java.util.Random;

public class Producer implements Runnable {
    private Stack beerStack;
    private int numberIterations;

    public Producer(Stack beerStack, int numberIterations) {
        this.beerStack = beerStack;
        this.numberIterations = numberIterations;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < numberIterations; i++) {
            synchronized (beerStack) {
                while (beerStack.isFull()) {
                    System.out.println("\n[i] Producer is waiting - Beerstack is full!\n");
                    try {
                        beerStack.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[i] Producer continues!\n");
                }
                beerStack.push(random.nextInt(90) + 10);
                System.out.println("Producer produces beercrate:\t" + beerStack);
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
