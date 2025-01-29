package com.datastructures.linkedlist.moviemanagement;

// Movie class to store information about a movie
class Movie {
    String title;
    String director;
    int yearOfRelease;
    double rating;

    // Constructor to initialize movie details
    public Movie(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
    }
}

