package com.datastructures.linkedlist.librarymanagement;

// Doubly Linked List to manage the library
class LibraryLinkedList {

    // Head and Tail pointers
    Node head;
    Node tail;

    // Static inner class Node
    static class Node {
        // Book details
        Book book;
        // Points to the next node
        Node next;
        // Points to the previous node
        Node prev;

        // Constructor to create a node with book data
        public Node(Book book) {
            this.book = book;
            this.next = null;
            this.prev = null;
        }
    }

    // Add a new book at the beginning
    public void addAtBeginning(Book book) {
        Node newNode = new Node(book);

        // If the list is empty, make the new node both head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a new book at the end
    public void addAtEnd(Book book) {
        Node newNode = new Node(book);

        // If the list is empty, make the new node both head and tail
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a new book at a specific position
    public void addAtPosition(int position, Book book) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        // If position is 0, add at the beginning
        if (position == 0) {
            addAtBeginning(book);
            return;
        }

        // Traverse to the specified position
        Node temp = head;
        int count = 0;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        // If the position is out of range
        if (temp == null) {
            System.out.println("Position out of range.");
        }
        else {
            Node newNode = new Node(book);
            newNode.next = temp.next;

            // If we are adding at the end
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            else {
                // Update the tail if the new node is at the end
                tail = newNode;
            }

            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Remove a book by Book ID
    public void removeByBookId(int bookId) {
        Node temp = head;

        // Traverse the list to find the book by ID
        while (temp != null) {
            if (temp.book.bookId == bookId) {
                // If the book is found, remove it
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                else {
                    // Update head if the first node is removed
                    head = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                else {
                    // Update tail if the last node is removed
                    tail = temp.prev;
                }

                System.out.println("Book with ID " + bookId + " removed.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by Book Title
    public void searchByBookTitle(String bookTitle) {
        Node temp = head;

        while (temp != null) {
            if (temp.book.bookTitle.equalsIgnoreCase(bookTitle)) {
                System.out.println("Book found: " + temp.book.bookTitle + ", Author: " + temp.book.author +
                        ", Genre: " + temp.book.genre + ", ID: " + temp.book.bookId +
                        ", Availability: " + (temp.book.isAvailable ? "Available" : "Checked Out"));
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book with title '" + bookTitle + "' not found.");
    }

    // Search for a book by Author
    public void searchByAuthor(String author) {
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.book.author.equalsIgnoreCase(author)) {
                System.out.println("Book found: " + temp.book.bookTitle + ", Author: " + temp.book.author +
                        ", Genre: " + temp.book.genre + ", ID: " + temp.book.bookId +
                        ", Availability: " + (temp.book.isAvailable ? "Available" : "Checked Out"));
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No books found by author '" + author + "'.");
        }
    }

    // Update a book's Availability Status by Book ID
    public void updateAvailabilityStatus(int bookId, boolean isAvailable) {
        Node temp = head;

        while (temp != null) {
            if (temp.book.bookId == bookId) {
                temp.book.isAvailable = isAvailable;
                System.out.println("Availability of book with ID " + bookId + " updated to " +
                        (isAvailable ? "Available" : "Checked Out"));
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }

        Node temp = head;
        System.out.println("Books in the library (forward):");
        while (temp != null) {
            System.out.println("Title: " + temp.book.bookTitle + ", Author: " + temp.book.author +
                    ", Genre: " + temp.book.genre + ", ID: " + temp.book.bookId +
                    ", Availability: " + (temp.book.isAvailable ? "Available" : "Checked Out"));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }

        Node temp = tail;
        System.out.println("Books in the library (reverse):");
        while (temp != null) {
            System.out.println("Title: " + temp.book.bookTitle + ", Author: " + temp.book.author +
                    ", Genre: " + temp.book.genre + ", ID: " + temp.book.bookId +
                    ", Availability: " + (temp.book.isAvailable ? "Available" : "Checked Out"));
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Main function to test the Library Management System
    public static void main(String[] args) {

        // Create a Library linked list
        LibraryLinkedList library = new LibraryLinkedList();

        // Add some books to the library
        library.addAtEnd(new Book("The Story Of My Life", "Hellen Keller", "Autobiography", 101, true));
        library.addAtEnd(new Book("Pride and Prejudice", "Jane Austen", "Autobiography", 102, true));
        library.addAtEnd(new Book("Gaban", "Munshi Premchand", "Fiction", 103, false));
        library.addAtEnd(new Book("Three men in a boat", "Unknown", "Humour", 104, true));

        // Display all books in forward and reverse order
        library.displayBooksForward();
        library.displayBooksReverse();

        // Update the availability status of a book
        library.updateAvailabilityStatus(102, false); // Mark 1984 as checked out

        // Search for a book by title
        library.searchByBookTitle("1984");

        // Search for books by author
        library.searchByAuthor("Harper Lee");

        // Remove a book by Book ID
        library.removeByBookId(104);

        // Count and display the total number of books
        int totalBooks = library.countBooks();
        System.out.println("Total number of books in the library: " + totalBooks);

        // Display all books again
        library.displayBooksForward();
    }
}
