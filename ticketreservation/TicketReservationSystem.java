package com.datastructures.linkedlist.ticketreservation;

// TicketReservationSystem class represents the circular linked list for ticket reservations
class TicketReservationSystem {
    // Head of the circular linked list (points to the first ticket reservation)
    Ticket head;

    // Tail of the circular linked list (points to the last ticket reservation)
    Ticket tail;

    // Constructor to initialize the system (empty list)
    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
    }

    // Add a new ticket reservation at the end of the circular linked list
    public void addTicketReservation(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        // If the list is empty, initialize the first ticket
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            // Circular link
            newTicket.next = head;
        } else {
            // Add the new ticket at the end of the circular list
            tail.next = newTicket;
            tail = newTicket;
            // Circular link
            tail.next = head;
        }
        System.out.println("Ticket reserved successfully: " + newTicket.ticketId);
    }

    // Remove a ticket reservation by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets available to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        // Traverse the list to find the ticket to remove
        do {
            if (temp.ticketId == ticketId) {
                // If it's the first ticket
                if (prev == null) {
                    // If there's only one node in the list
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = temp.next;
                        // Circular link
                        tail.next = head;
                    }
                } else {
                    prev.next = temp.next;
                    // If it's the last ticket, update the tail pointer
                    if (temp == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Ticket removed successfully: " + ticketId);
                return;
            }
            prev = temp;
            temp = temp.next;
            // Traverse in a circular way
        } while (temp != head);

        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    // Display all the current tickets in the reservation system
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets to display.");
            return;
        }

        Ticket temp = head;
        System.out.println("Current Tickets in the Reservation System:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName
                    + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
            // Traverse in a circular way
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.contains(searchTerm) || temp.movieName.contains(searchTerm)) {
                System.out.println("Found Ticket: Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName
                        + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for: " + searchTerm);
        }
    }

    // Calculate and display the total number of booked tickets
    public void totalBookedTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total booked tickets: " + count);
    }
}
