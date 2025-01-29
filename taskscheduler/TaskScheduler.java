package com.datastructures.linkedlist.taskscheduler;

// Main class to run the task scheduler
public class TaskScheduler {
    public static void main(String[] args) {
        // Create a task circular linked list
        TaskCircularLinkedList taskList = new TaskCircularLinkedList();

        // Add tasks to the list
        taskList.addAtBeginning(new Task(1, "Task 1", 5, "2025-02-01"));
        taskList.addAtEnd(new Task(2, "Task 2", 3, "2025-02-02"));
        taskList.addAtEnd(new Task(3, "Task 3", 4, "2025-02-03"));
        taskList.addAtPosition(1, new Task(4, "Task 4", 1, "2025-02-04"));

        // Display all tasks
        System.out.println("All tasks in the list:");
        taskList.displayAllTasks();

        // Search for tasks by Priority
        System.out.println("\nSearching for tasks with priority 3:");
        taskList.searchByPriority(3);

        // View tasks and move to the next task
        System.out.println("\nViewing tasks and moving to the next task:");
        taskList.viewNextTask();

        // Remove a task by Task ID
        taskList.removeByTaskId(2);

        // Display all tasks after removal
        System.out.println("\nTasks after removal:");
        taskList.displayAllTasks();
    }
}
