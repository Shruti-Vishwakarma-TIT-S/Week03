package com.datastructures.linkedlist.ticketreservation;

// Main class to test the Online Ticket Reservation System
public class TicketReservationApp {
    public static void main(String[] args) {
        // Initialize the ticket reservation system
        TicketReservationSystem system = new TicketReservationSystem();

        // Add some ticket reservations
        system.addTicketReservation(101, "Amit Sharma", "Avengers", "A1", "2025-01-28 10:00");
        system.addTicketReservation(102, "Priya Singh", "Titanic", "B3", "2025-01-28 11:00");
        system.addTicketReservation(103, "Ravi Kumar", "Avengers", "C5", "2025-01-28 12:00");

        // Display all current tickets
        system.displayTickets();

        // Search for tickets by Customer Name or Movie Name
        system.searchTicket("Avengers");

        // Remove a ticket by Ticket ID
        system.removeTicket(102);

        // Display all current tickets after removal
        system.displayTickets();

        // Calculate the total number of booked tickets
        system.totalBookedTickets();
    }
}
