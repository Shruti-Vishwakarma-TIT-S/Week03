package com.datastructures.linkedlist.roundrobin;

public class RoundRobinScheduler {

    public static void main(String[] args) {

        CircularLinkedList scheduler = new CircularLinkedList();

        // Add processes to the scheduler (Process ID, Burst Time)
        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.addProcess(3, 8);
        scheduler.addProcess(4, 6);

        // Display initial process list
        System.out.println("Initial Process List:");
        scheduler.displayProcesses();

        // Simulate the round-robin scheduling with a time quantum of 4 units
        int timeQuantum = 4;
        scheduler.roundRobinScheduling(timeQuantum);
    }
}
