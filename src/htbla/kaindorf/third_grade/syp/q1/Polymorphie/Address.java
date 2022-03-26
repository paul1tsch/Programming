package htbla.kaindorf.third_grade.syp.q1.Polymorphie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Address.java
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String country;
    private String city;
    private String zipCode;
    private String street;
    private int number;
    private List<Person> persons = new LinkedList<>();

    public Address(String country, String city, String zipCode, String street, int number) {
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.number = number;
    }

    public void addPerson(Person person) {
        if (!persons.contains(person)) {
            persons.add(person);
        }
    }

    @Override
    public String toString() {
        return country + " " + city + " " + zipCode + " " + street + " " + number;
    }
}
