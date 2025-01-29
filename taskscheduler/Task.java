package com.datastructures.linkedlist.taskscheduler;

// Task class to store information about a task
class Task {
    // Take instance variable
    int taskId;
    String taskName;
    int priority;
    String dueDate;

    // Constructor to initialize task details
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

