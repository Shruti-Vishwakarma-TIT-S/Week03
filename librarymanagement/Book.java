package com.datastructures.linkedlist.librarymanagement;

// Book class to store book details
class Book {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean isAvailable; // Availability status: true means available, false means checked out

    // Constructor to initialize a book's details
    public Book(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

