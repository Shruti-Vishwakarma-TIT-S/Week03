package com.datastructures.linkedlist.moviemanagement;

// Define the Doubly Linked List class to manage movie records
class MovieDoublyLinkedList {
    Node head; // Head of the linked list
    Node tail; // Tail of the linked list

    // Static inner Node class
    static class Node {
        Movie movie;
        Node next; // Points to the next node
        Node prev; // Points to the previous node

        // Constructor to create a new node
        public Node(Movie movie) {
            this.movie = movie;
            this.next = null;
            this.prev = null;
        }
    }

    // Constructor to initialize the list
    public MovieDoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add a movie at the beginning
    public void addAtBeginning(Movie movie) {
        Node newNode = new Node(movie);
        // If the list is empty, new node becomes head and tail
        if (head == null) {
            head = tail = newNode;
        } else {
            // Link new node to the current head
            newNode.next = head;
            // Link head's previous pointer to the new node
            head.prev = newNode;
            // Update head to the new node
            head = newNode;
        }
    }

    // Add a movie at the end
    public void addAtEnd(Movie movie) {
        Node newNode = new Node(movie);
        // If the list is empty, new node becomes head and tail
        if (tail == null) {
            head = tail = newNode;
        } else {
            // Link the current tail to the new node
            tail.next = newNode;
            // Link the new node's previous pointer to the current tail
            newNode.prev = tail;
            // Update tail to the new node
            tail = newNode;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(int position, Movie movie) {
        // Add at the beginning if position is 0
        if (position == 0) {
            addAtBeginning(movie);
            return;
        }

        Node newNode = new Node(movie);
        Node temp = head;
        int count = 0;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range");
        } else {
            // Link new node to the next node
            newNode.next = temp.next;
            if (temp.next != null) {
                // Update next node's prev pointer
                temp.next.prev = newNode;
            }
            // Link the previous node to the new node
            temp.next = newNode;
            // Link the new node's prev pointer to the current node
            newNode.prev = temp;
        }
    }

    // Remove a movie by Movie Title
    public void removeByTitle(String title) {
        Node temp = head;
        while (temp != null) {
            if (temp.movie.title.equals(title)) {
                if (temp.prev != null) {
                    // Link previous node to next node
                    temp.prev.next = temp.next;
                }
                else {
                    // If deleting the head, move head to the next node
                    head = temp.next;
                }
                if (temp.next != null) {
                    // Link next node to previous node
                    temp.next.prev = temp.prev;
                }
                else {
                    // If deleting the tail, move tail to the previous node
                    tail = temp.prev;
                }
                System.out.println("Movie \"" + title + "\" removed successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie with title \"" + title + "\" not found.");
    }

    // Search for a movie by Director
    public void searchByDirector(String director) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.movie.director.equalsIgnoreCase(director)) {
                System.out.println("Movie found: " + temp.movie.title + ", Rating: " + temp.movie.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }

    // Search for movies by Rating
    public void searchByRating(double rating) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.movie.rating == rating) {
                System.out.println("Movie found: " + temp.movie.title + ", Director: " + temp.movie.director);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Display all movies in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Node temp = head;
        System.out.println("Movies in forward order:");
        while (temp != null) {
            System.out.println("Title: " + temp.movie.title + ", Director: " + temp.movie.director + ", Year: " + temp.movie.yearOfRelease + ", Rating: " + temp.movie.rating);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Node temp = tail;
        System.out.println("Movies in reverse order:");
        while (temp != null) {
            System.out.println("Title: " + temp.movie.title + ", Director: " + temp.movie.director + ", Year: " + temp.movie.yearOfRelease + ", Rating: " + temp.movie.rating);
            temp = temp.prev;
        }
    }

    // Update the rating of a movie by Movie Title
    public void updateRating(String title, double newRating) {
        Node temp = head;
        while (temp != null) {
            if (temp.movie.title.equals(title)) {
                temp.movie.rating = newRating;
                System.out.println("Rating for \"" + title + "\" updated to: " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie with title \"" + title + "\" not found.");
    }
}