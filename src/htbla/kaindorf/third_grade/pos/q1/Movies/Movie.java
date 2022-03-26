package htbla.kaindorf.third_grade.pos.q1.Movies;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Movie.java
 */

public class Movie implements Comparable<Movie> {

    private String title;
    private String genre;
    private int length;


    public Movie(String title, String genre, int length) {
        this.title = title;
        this.genre = genre;
        this.length = length;

    }

    public static void main(String[] args) {
        Movie movie1 = new Movie("ScaryMovie", "Horror", 123);
        System.out.println(movie1.hashCode());

        Movie movie2 = new Movie("ScaryMovie 2", "Horror", 187);
        System.out.println(movie2.hashCode());

        Movie movie3 = new Movie("ScaryMovie 3", "Comedy", 158);
        System.out.println(movie3.hashCode());

        Set<Movie> movies = new TreeSet<>();

        // Add method calls hashcode and equals method
        System.out.println(movies.add(movie1));
        System.out.println("Number of movies: " + movies.size() + "\n");

        System.out.println(movies.add(movie2));
        System.out.println("Number of movies: " + movies.size() + "\n");

        System.out.println(movies.add(movie3));
        System.out.println("Number of movies: " + movies.size() + "\n");

        // Same instance variables are also the same, even if they have different names

        if (movies.contains(new Movie("ScaryMovie 2", "Horror", 187))) {
            System.out.println("ScaryMovie2 found \n");
        }
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", length=" + length +
                ", genre='" + genre + '\'' +
                '}';
    }

    // always implement, otherwise we will not find our objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //das aktuelle Objekt ist das 'this'
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return length == movie.length && Objects.equals(title, movie.title) && Objects.equals(genre, movie.genre);
    }


    // Implement for set collections and for the key of map collections
    // No lists are compared when exclude: @EqualsAndHashCode.Exclude

    @Override
    public int hashCode() {
        return Objects.hash(title, length, genre); //   Search for Set-Collections, first HashCode, then Equals [Collections, Maps].
        // return title.hashCode();                     We are looking for packets
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int compareTo(Movie movie) {
        // by length    -> return this.length - movie.getLength();
        // by title     -> return this.title.compareTo(movie.getTitle());
        if (this.getGenre().equals(movie.getGenre())) {
            return this.length - movie.getLength();
        }

        return this.getGenre().compareTo(movie.getGenre());
        // or return genre.compareTo(movie.getGenre());
    }
}
