package htbla.kaindorf.third_grade.pos.q2.Euler_39.beans;

import htbla.kaindorf.third_grade.pos.q2.Euler_39.TriangleWorker;

import java.util.Set;
import java.util.concurrent.*;

public class Launcher {
    public void runWorkers() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CompletionService<Set<Triangle>> service = new ExecutorCompletionService<>(pool);

        for (int perimeter = 10; perimeter <= 1000; perimeter++) {
            service.submit(new TriangleWorker(perimeter));
        }

        pool.shutdown();

        Set<Triangle> largestTriangleSet = null;
        for (int i = 10; i <= 1000; i++) {
            try {
                Future<Set<Triangle>> future = service.take();
                Set<Triangle> triangleSet = future.get();
                if(largestTriangleSet == null || largestTriangleSet.size() < triangleSet.size()) {
                    largestTriangleSet = triangleSet;
                }
//                System.out.println(triangleSet);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(largestTriangleSet);
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.runWorkers();
    }
}
