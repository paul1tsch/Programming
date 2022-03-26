package htbla.kaindorf.third_grade.pos.q2.Euler_52.beans;

import htbla.kaindorf.third_grade.pos.q2.Euler_39.TriangleWorker;
import htbla.kaindorf.third_grade.pos.q2.Euler_39.beans.Triangle;
import htbla.kaindorf.third_grade.pos.q2.Euler_52.PermutedMultiplesWorker;

import java.util.Set;
import java.util.concurrent.*;

public class Launcher {
    private void runWorkers() {
        ExecutorService pool = Executors.newFixedThreadPool(12);
        CompletionService<Integer> service = new ExecutorCompletionService<>(pool);

        Integer result = null;
        int maxFactor = 6;
        for (int i = 1; i < 10_000_000; i++) {
            service.submit(new PermutedMultiplesWorker(i, maxFactor));
        }
        pool.shutdown();
        do {
            try {
                result = service.take().get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        } while (result == null);
        System.out.println("Smallest: " + result);
    }

    public static void main(String[] args) {
        new Launcher().runWorkers();
    }

}
