package htbla.kaindorf.third_grade.pos.q1.Songs;

import htbla.kaindorf.third_grade.pos.q1.Songs.beans.Artist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Song.java
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    private int length;
    private String genre;
    private String name;
    private LocalDate creationDate;

    private Map<Artist, Set<Song>> songMap = new TreeMap<>();

    public Song(int length, String genre, String name, LocalDate creationDate) {
        this.length = length;
        this.genre = genre;
        this.name = name;
        this.creationDate = creationDate;
    }

    public static void main(String[] args) {
        Song maptest = new Song();
        maptest.fillMap();
        maptest.showMap();
    }

    public void fillMap() {
        Song song = new Song();
        Artist artist1 = new Artist("Amigos", LocalDate.of(1956, Month.NOVEMBER, 3), 122);
        Artist artist2 = new Artist("Katy Pery", LocalDate.of(1997, Month.APRIL, 1), 212);
        Artist artist3 = new Artist("Manskin", LocalDate.of(2000, Month.SEPTEMBER, 7), 3);

        Song song1 = new Song(3, "Pop", "Roar", LocalDate.of(2003, Month.AUGUST, 12));
        Song song2 = new Song(4, "Techno", "Pokerface", LocalDate.of(2007, Month.FEBRUARY, 25));
        Song song3 = new Song(2, "Schlager", "Baby Blue", LocalDate.of(2013, Month.DECEMBER, 31));
        Song song4 = new Song(6, "Pop", "Beggin", LocalDate.of(2020, Month.AUGUST, 12));
        Song song5 = new Song(2, "Pop", "Emo-Kid", LocalDate.of(2017, Month.AUGUST, 12));

        Set<Song> songsOfArtist1 = new HashSet<>();
        songsOfArtist1.add(song3);

        Set<Song> songsOfArtist2 = new HashSet<>();
        songsOfArtist2.add(song2);
        songsOfArtist2.add(song1);

        Set<Song> songsOfArtist3 = new HashSet<>();
        songsOfArtist3.add(song4);
        songsOfArtist3.add(song5);

        songMap.put(artist1, songsOfArtist1);
        songMap.put(artist2, songsOfArtist2);
        songMap.put(artist3, songsOfArtist3);
    }

    public void showMap() {
        for (Artist artist : songMap.keySet()) {
            System.out.println("Artist: " + artist);
            for (Song song : songMap.get(artist)) {
                System.out.println("\tSong: " + song);
            }
        }
    }

    @Override
    public String toString() {
        return name + ", with a length of " + length + " minutes " + "with the genre " + genre + " created on " + creationDate;
    }
}
