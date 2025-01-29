package com.datastructures.linkedlist.roundrobin;

class Process {

    // Process ID
    int processId;

    // Total burst time of the process
    int burstTime;

    // Remaining burst time
    int remainingTime;

    // Waiting time for the process
    int waitingTime;

    // Turnaround time for the process
    int turnaroundTime;

    // Constructor to initialize process details
    public Process(int processId, int burstTime) {

        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;  // Initially, remaining time is the same as burst time
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }
}

