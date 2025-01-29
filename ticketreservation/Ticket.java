package com.datastructures.linkedlist.ticketreservation;

// Ticket class represents a ticket reservation
class Ticket {
    // Unique ID for the ticket
    int ticketId;

    // Customer's name
    String customerName;

    // Movie name for which the ticket is booked
    String movieName;

    // Seat number assigned to the customer
    String seatNumber;

    // Booking time (just a simple string representation)
    String bookingTime;

    // Pointer to the next ticket (circular linked list)
    Ticket next;

    // Constructor to initialize the ticket
    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        // Initially next pointer is null
        this.next = null;
    }
}


