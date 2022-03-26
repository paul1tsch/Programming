package htbla.kaindorf.second_grade.pos.q1.Address.beans;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Address.java
 */

public class Address {

    private String street;
    private int number;
    private String city;
    private int zipcode;

    public Address(String street, int number, String city, int zipcode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipcode = zipcode;
    }

    public void setZipCode(int zipCode) {
        this.zipcode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    //Here we are OVERRIDING a method
    //This @ sign is called an Annotation
    @Override
    public String toString() {
        return "Address Information: " + street + " " + number + " - " + zipcode + " " + city;
    }
    //Remember: overloading a constructor
}
