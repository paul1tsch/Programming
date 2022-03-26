package htbla.kaindorf.second_grade.pos.q1.Trainingscalculation;

import java.util.Random;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        TrainingsCalculation.java
 */

public class TrainingsCalculation {

    private final char operator;
    private final char[] operators = {'+', '-', '*', '/'};
    Random random = new Random();
    private int number1;
    private int number2;
    private int result;

    public TrainingsCalculation(byte difficulty) {
        operator = operators[random.nextInt(4 - 1) + 1];

        switch (difficulty) {
            case 1 -> {
                number1 = random.nextInt(10 - 1) + 1;
                number2 = random.nextInt(10 - 1) + 1;
            }
            case 2 -> {
                number1 = random.nextInt(100 - 1) + 1;
                number2 = random.nextInt(100 - 1) + 1;
            }
        }

        switch (operator) {
            case '+' -> result = number1 + number2;
            case '-' -> result = number1 - number2;
            case '*' -> result = number1 * number2;
            case '/' -> result = number1 / number2;
            default -> System.out.println("[-] Something went horribly wrong!");
        }
    }

    public int getNum1() {
        return number1;
    }

    public int getNum2() {
        return number2;
    }

    public char getOperator() {
        return operator;
    }

    public int getResult() {
        return result;
    }
}
