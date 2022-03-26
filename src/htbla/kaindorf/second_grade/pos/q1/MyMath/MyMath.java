package htbla.kaindorf.second_grade.pos.q1.MyMath;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        MyMath.java
 */

public class MyMath {

    public static final double PI = 3.141592653589793;
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        MyMath math = new MyMath();

        System.out.println("[1] Get Pi\n[2] Get Abs\n[3] Get Min\n[4] Get Max\n[5] Get Power\n[6] Get Rounded Number\n[7] Get Faculty\n[8] Get Sinus\n[9] Get Cosine");
        math.get_input();
    }

    public void get_input() {
        int num;
        num = scan.nextInt();

        switch (num) {
            case 1 -> System.out.println("π is: " + PI);
            case 2 -> {
                System.out.print("Please enter a number: ");

                int a;
                a = scan.nextInt();

                System.out.println("Absolut of " + a + " is: " + abs(a));
            }
            case 3 -> {
                System.out.println("Please enter 3 numbers: ");

                int num1, num2, num3;
                num1 = scan.nextInt();
                num2 = scan.nextInt();
                num3 = scan.nextInt();

                System.out.println("The minimum of these 3 numbers is: " + min(num1, num2, num3));
            }
            case 4 -> {
                System.out.println("Please enter 3 numbers: ");

                int az, bz, cz;
                az = scan.nextInt();
                bz = scan.nextInt();
                cz = scan.nextInt();

                System.out.println("The maximum of these 3 numbers is: " + max(az, bz, cz));
            }
            case 5 -> {
                System.out.println("Please enter base and exponent: ");

                double base;
                int exponent;
                base = scan.nextDouble();
                exponent = scan.nextInt();

                System.out.println("The result is: " + power(base, exponent));
            }
            case 6 -> {
                System.out.println("Please enter a number, you would like to round: ");

                double value;
                int digits;
                value = scan.nextDouble();
                digits = scan.nextInt();

                System.out.println("The rounded number is: " + round(value, digits));
            }
            case 7 -> {
                System.out.println("Enter a number from which you would like to calculate the factorial: ");

                int number;
                number = scan.nextInt();

                System.out.println("The result of the factorial is: " + factorial(number));
            }
            case 8 -> {
                System.out.println("Please enter a number, you would like to get the sine of: ");

                double sineNumber;
                sineNumber = scan.nextDouble();

                System.out.println("The result of the sine calculation is: " + sin(sineNumber));
            }
            case 9 -> {
                System.out.println("Please enter a number, you would like to get the cosine of: ");

                double cosineNumber;
                cosineNumber = scan.nextDouble();

                System.out.println("The result of the cosine calculation is: " + cos(cosineNumber));
            }

            default -> throw new IllegalStateException("[-] ERROR");
        }
    }

    public int abs(int a) {
        if (a >= 0) {
            return a;
        } else {
            return (-a);
        }
    }

    public int min(int a, int b, int c) {
        int min = a;

        if (min > b) {
            min = b;
        }
        if (min > c) {
            min = c;
        }
        return min;
    }

    public int max(int a, int b, int c) {
        int max = 0;
        if ((a > b) & (a > c)) {
            max = a;
        } else if ((a > b) & (a < c)) {
            max = c;

        } else if ((a < b) & (b < c)) {
            max = c;
        } else if ((a < b) & (b > c)) {
            max = b;
        }
        return max;
    }

    public double power(double base, int exponent) {
        if (exponent != 0) {
            return (base * power(base, exponent - 1));
        } else {
            return 1;
        }
    }

    public double round(double value, int digits) {
        value = (int) (value * (int) power(10, digits + 1));
        if (value > 0) {
            value += 5;
        }
        if (value < 0) {
            value -= 5;
        }
        value = (int) (value / 10);
        value /= power(10, digits);
        return value;
    }

    public long factorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return factorial(num - 1) * num;
        }
    }

    public double sin(double x) {
        double sign = 1;

        if (x < 0) {
            sign = -1.0;
            x = -x;
        }
        if (x > 360) {
            x -= (int) (x / 360) * 360;
        }
        x *= PI / 180.0;

        double res = 0;
        double term = x;
        int k = 1;

        while (res + term != res) {
            res += term;
            k += 2;
            term *= -x * x / k / (k - 1);
        }
        return sign * res;
    }

    public double cos(double x) {
        double cos = 0;
        double temp = 1;
        int cnt = 0;

        if (x < 0) {
            x = -x;
        }
        if (x > 360) {
            x -= (int) (x / 360) * 360;
        }
        x *= PI / 180.0;

        while (cos + temp != cos) {
            cos += temp;
            cnt += 2;
            temp *= -x * x / cnt / (cnt - 1);
        }
        return cos;
    }
}
