package htbla.kaindorf.second_grade.pos.q1.Trainingscalculation;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        CalcTrainerUI.java
 */

public class CalcTrainerUI {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        CalcTrainerUI calc = new CalcTrainerUI();
        calc.performTrainingsUnit();
    }

    public int promptInt(Scanner scan) {
        return scan.nextInt();
    }

    public byte promptByte(Scanner scan) {
        return scan.nextByte();
    }

    public void performTrainingsUnit() {

        int round;
        byte difficulty;
        int points = 0;
        int Result;

        System.out.print("Please enter the number of rounds you would like to play: ");
        round = promptInt(scan);

        System.out.print("Please enter the difficulty [1 or 2]: ");
        difficulty = promptByte(scan);

        int cnt = 1;
        while (cnt <= round) {
            TrainingsCalculation calc = new TrainingsCalculation(difficulty);

            System.out.println("\tRound -" + cnt + "-\n");

            System.out.println("\t\t" + calc.getNum1() + " " + calc.getOperator() + " " + calc.getNum2() + " = ?\n");

            System.out.print("Enter Result: ");
            Result = promptInt(scan);

            if (Result == calc.getResult()) {
                System.out.println("\t[+] Perfecto!\n");
                points++;
            } else {
                System.out.println("[-] Wrong! The correct result is " + calc.getResult());
            }
            cnt++;
        }
        System.out.println("You achieved " + points + " out of " + round + " Points, congratulations!");
    }
}
