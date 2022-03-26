package htbla.kaindorf.second_grade.pos.q1.Car;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Car.java
 */

public class Car {

    public String brand = null;
    public String model = null;
    public int speed;
    public int calcSpeed;

    public static void main(String[] args) {
        Car car = new Car();

        car.input();
        car.accelerate();
        car.output();
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the brand of the car: ");
        brand = scan.next();

        System.out.print("Enter model of the car: ");
        model = scan.next();

        System.out.println("" + brand + " " + model + " runs with 0 Km/h");

        System.out.print("Desired velocity: ");
        speed = scan.nextInt();
    }

    public void accelerate() {
        for (int i = 0; i < speed; i++) {
            calcSpeed++;
        }
    }

    public void output() {
        if (speed < 0 || speed > 130) {
            System.out.println("[-]Please try again, your speed must be above 0 and under 130 km/h");
        } else {
            System.out.println("" + brand + " " + model + " runs with " + calcSpeed + " Km/h");
        }
    }
}
