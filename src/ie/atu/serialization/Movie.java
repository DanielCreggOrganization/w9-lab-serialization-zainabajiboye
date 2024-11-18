package ie.atu.serialization;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String director;
    private int year;
    private double rating;
    
    public Movie (String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
    
    @Override
    public String toString() {
        return "Movie{title='" + title + "', director='" + 
               director + "'year=" + year + "', rating =" + rating + "}";
    }
}
