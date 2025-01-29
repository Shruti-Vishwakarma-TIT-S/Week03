package com.datastructures.linkedlist.moviemanagement;

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        // Create a movie doubly linked list
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();

        // Add movies to the list
        movieList.addAtBeginning(new Movie("3 Idiots", "Raj Kumar Hirani", 2009, 8.8));
        movieList.addAtEnd(new Movie("Dangal", "Nitesh Tiwari", 2016, 9.0));
        movieList.addAtEnd(new Movie("Taare Zameen Par", "AAmir Khan", 2007, 8.6));

        // Display all movies forward and reverse
        movieList.displayForward();
        movieList.displayReverse();

        // Search for a movie by Director
        movieList.searchByDirector("Christopher Nolan");

        // Search for a movie by Rating
        movieList.searchByRating(8.8);

        // Update the rating of a movie
        movieList.updateRating("Inception", 9.0);

        // Remove a movie by Title
        movieList.removeByTitle("Interstellar");

        // Display all movies after removal
        movieList.displayForward();
    }
}
