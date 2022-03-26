package htbla.kaindorf.third_grade.pos.q1.Songs.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Artist.java
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist implements Comparable<Artist> {

    private String name;
    private LocalDate birthday;
    private int songs;

    @Override
    public String toString() {
        return name + " born on " + birthday + " has made totally " + songs + " songs";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return songs == artist.songs && Objects.equals(name, artist.name) && Objects.equals(birthday, artist.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, songs);
    }

    @Override
    public int compareTo(Artist o) {
        return this.birthday.compareTo(o.getBirthday());
    }
}
