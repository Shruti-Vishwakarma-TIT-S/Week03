package com.datastructures.linkedlist.roundrobin;

class CircularLinkedList {

    Node head = null;
    Node tail = null;

    // Node class to store the process and links
    static class Node {

        Process process;
        Node next;

        // Constructor to initialize a node with process
        public Node(Process process) {
            this.process = process;
            this.next = null;
        }
    }

    // Add a process at the end of the circular linked list
    public void addProcess(int processId, int burstTime) {

        Process process = new Process(processId, burstTime);
        Node newNode = new Node(process);

        if (head == null) {

            head = newNode;
            tail = newNode;
            // Circular link to the head
            newNode.next = head;
        } else {

            tail.next = newNode;
            tail = newNode;
            // Circular link to the head
            tail.next = head;
        }
    }

    // Remove a process by Process ID
    public void removeProcessById(int processId) {

        Node temp = head;
        Node prev = null;

        // Check if the list is empty
        if (head == null) {

            System.out.println("Process not found.");
            return;
        }

        // If the process to remove is the head node
        if (head.process.processId == processId) {

            if (head == tail) {  // Only one node
                head = null;
                tail = null;
            } else {
                head = head.next;
                // Maintain the circular link
                tail.next = head;
            }
            System.out.println("Process with ID " + processId + " removed.");
            return;
        }

        // Traverse the list to find the process by ID
        do {
            prev = temp;
            temp = temp.next;
            if (temp.process.processId == processId) {
                prev.next = temp.next;
                if (temp == tail) {
                    // Update tail if the removed process was the last
                    tail = prev;
                }
                System.out.println("Process with ID " + processId + " removed.");
                return;
            }
        } while (temp != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate the Round Robin Scheduling
    public void roundRobinScheduling(int timeQuantum) {

        if (head == null) {

            System.out.println("No processes in the queue.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completedProcesses = 0;
        Node current = head;

        while (completedProcesses < countProcesses()) {

            // Execute the current process for the time quantum or until it finishes
            if (current.process.remainingTime > 0) {

                int executionTime = Math.min(current.process.remainingTime, timeQuantum);
                current.process.remainingTime -= executionTime;
                totalWaitingTime += current.process.waitingTime;
                totalTurnaroundTime += (current.process.turnaroundTime + executionTime);

                System.out.println("Executing Process ID: " + current.process.processId +
                        ", Burst Time: " + current.process.burstTime +
                        ", Remaining Time: " + current.process.remainingTime);

                // If the process is finished, remove it from the list
                if (current.process.remainingTime == 0) {
                    completedProcesses++;
                    current.process.turnaroundTime = current.process.burstTime + current.process.waitingTime;
                    removeProcessById(current.process.processId); // Remove completed process
                }

                // Move to the next process in the circular list
                current = current.next;
            }
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) countProcesses()));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / (double) countProcesses()));
    }

    // Count the total number of processes
    public int countProcesses() {

        int count = 0;
        Node temp = head;

        if (temp == null) return 0;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    // Display all processes in the list
    public void displayProcesses() {

        if (head == null) {

            System.out.println("No processes in the queue.");
            return;
        }

        Node temp = head;
        do {
            System.out.println("Process ID: " + temp.process.processId +
                    ", Burst Time: " + temp.process.burstTime +
                    ", Remaining Time: " + temp.process.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }
}
