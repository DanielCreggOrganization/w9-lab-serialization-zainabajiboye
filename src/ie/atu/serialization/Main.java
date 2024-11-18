package ie.atu.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {
    
        public static void main(String[] args) {
  
                    Movie movie = new Movie(" Shrek ", "Eddie Murphy", 2013,  8.5);
                    System.out.println("Original Book: " + movie);
                    
                    // Serialize
                    try (FileOutputStream fileOut = new FileOutputStream("resources/movie.ser");
                         ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                        out.writeObject(movie);
                        System.out.println("Movie has been serialized");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                    // Deserialize
                    try (FileInputStream fileIn = new FileInputStream("resources/movie.ser");
                         ObjectInputStream in = new ObjectInputStream(fileIn)) {
                        Movie deserializedBook = (Movie) in.readObject();
                        System.out.println("Movie has been deserialized");
                        System.out.println("Deserialized Movie: " + deserializedBook);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                     List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Shrek", "Eddie Murphy", 2013, 7.5));
        movies.add(new Movie("Parasite", "Bong Joon-Ho", 2019, 10));
        movies.add(new Movie("Us", "Jordan Peele", 2019, 8.5));
        
        System.out.println("Original catalog:");
        movies.forEach(System.out::println);
        
        // Serialize list
        serializeMovies(movies, "resources/movie.ser");
        
        // Deserialize list
        List<Movie> loadedBooks = deserializeMovies("resources/movie.ser");
        
        System.out.println("\nDeserialized catalog:");
        loadedBooks.forEach(System.out::println);
    }
    
    private static void serializeMovies(List<Movie> movies, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(movies);
            System.out.println("\nCatalog has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static List<Movie> deserializeMovies(String filename) {
        List<Movie> movie = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            movie = (List<Movie>) in.readObject();
            System.out.println("Catalog has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return movie;
    }
    }

            
        

