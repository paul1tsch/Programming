package htbla.kaindorf.third_grade.pos.q2.Euler_39.beans;

import java.util.Arrays;

public class Triangle {
    private int[] sides;

    public Triangle(int sideA, int sideB, int sideC) {
        sides = new int[]{sideA, sideB, sideC};
        Arrays.sort(sides);
    }

    public int[] getSides() {
        return sides;
    }

    @Override
    public String toString() {
        int perimeter = sides[0] + sides[1] + sides[2];
        return  "Perimeter: " + perimeter + Arrays.toString(sides);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(sides, triangle.sides);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(sides);
    }
}
