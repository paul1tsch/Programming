package htbla.kaindorf.third_grade.pos.q2.Euler_39;

import htbla.kaindorf.third_grade.pos.q2.Euler_39.beans.Triangle;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;

public class TriangleWorker implements Callable<Set<Triangle>> {
    private int perimeter;

    public TriangleWorker(int perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public Set<Triangle> call() throws Exception {
        Set<Triangle> trianglesFound = new HashSet<>();
        for (int a = 1; a < perimeter / 2; a++) {
            for (int b = 1; b < perimeter / 2; b++) {
                for (int c = 1; c < perimeter / 2; c++) {
                    if ((Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) && (a + b + c == perimeter)) {
                        trianglesFound.add(new Triangle(a, b, c));
                    }
                }
            }
        }

        return trianglesFound;
    }
}
