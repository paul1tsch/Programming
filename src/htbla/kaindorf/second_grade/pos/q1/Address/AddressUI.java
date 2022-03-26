package htbla.kaindorf.second_grade.pos.q1.Address;

import htbla.kaindorf.second_grade.pos.q1.Address.beans.Address;

import java.util.Scanner;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        AddressUI.java
 */

public class AddressUI {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        AddressUI addressUI = new AddressUI();

        Address address1 = addressUI.createAddress();
        System.out.println(address1.toString());

        addressUI.changeAddress(address1);

        System.out.println(address1);
    }

    public int promptInt(String prompt) {
        System.out.println(prompt + ": ");
        return scan.nextInt();
    }

    public String promptString(String prompt) {
        System.out.println(prompt + ": ");
        return scan.next();
    }

    public Address createAddress() {
        String street = promptString("Enter street");
        int number = promptInt("Enter number");
        String city = promptString("Enter city");
        int zipcode = promptInt("Enter zipcode");

        return new Address(street, number, city, zipcode);
    }

    public void changeAddress(Address address) {
        String street = address.getStreet();
        int number = address.getNumber();
        String city = address.getCity();
        int zipcode = address.getZipcode();

        System.out.println("\nWhat would you like to change?");

        System.out.printf("[A] Street : %8s\n", street);
        System.out.printf("[B] Number : %8d\n", number);
        System.out.printf("[C] City   : %8s\n", city);
        System.out.printf("[D] Zipcode: %8d\n", zipcode);
        System.out.print("[N] If you would like nothing to change\n");

        char ch;
        System.out.print("\n\t Enter, what you would like to change: ");
        ch = scan.next().charAt(0);

        char c = Character.toUpperCase(ch);
        switch (c) {
            case 'A' -> {
                System.out.println("Enter new value: ");
                street = scan.next();
                address.setStreet(street);
            }
            case 'B' -> {
                System.out.println("Enter new value: ");
                number = scan.nextInt();
                address.setNumber(number);
            }
            case 'C' -> {
                System.out.println("Enter new value: ");
                city = scan.next();
                address.setCity(city);
            }
            case 'D' -> {
                System.out.println("Enter new value: ");
                zipcode = scan.nextInt();
                address.setZipCode(zipcode);
            }
            case 'N' -> System.out.println("Nothing will be changed, thanks for using!");
            default -> System.out.println("NOTHING CHANGED");
        }
    }
}
