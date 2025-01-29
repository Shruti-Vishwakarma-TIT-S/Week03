package com.datastructures.linkedlist.taskscheduler;

// Define the Circular Linked List class to manage tasks
class TaskCircularLinkedList {
    // Head of the list
    Node head = null;
    // Tail of the list
    Node tail = null;

    // Static inner Node class
    static class Node {
        Task task;
        // Points to the next node
        Node next;

        // Constructor to create a new node
        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Add a task at the beginning
    public void addAtBeginning(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = tail = newNode;
            // Circular reference
            newNode.next = head;
        }
        else {
            newNode.next = head;
            head = newNode;
            // Maintain the circular structure
            tail.next = head;
        }
    }

    // Add a task at the end
    public void addAtEnd(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = tail = newNode;
            // Circular reference
            newNode.next = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            // Maintain the circular structure
            tail.next = head;
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int position, Task task) {
        if (position == 0) {
            addAtBeginning(task);
            return;
        }
        // Take new Node
        Node newNode = new Node(task);
        Node temp = head;
        int count = 0;
        // While loop
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range");
        }
        else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Node temp = head;
        Node prev = null;

        // If the task to be removed is the head
        if (head.task.taskId == taskId) {
            if (head == tail) {
                // If there's only one task
                head = tail = null;
            }
            else {
                head = head.next;
                // Maintain circular structure
            }
                tail.next = head;
            System.out.println("Task with ID " + taskId + " removed.");
            return;
        }

        // Traverse to find the task
        while (temp != null) {
            if (temp.task.taskId == taskId) {
                prev.next = temp.next;
                if (temp == tail) {
                    // Update the tail if the last task is removed
                    tail = prev;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
            // Avoid infinite loop
            if (temp == head) break;
        }

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewNextTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node temp = head;
        do {
            System.out.println("Task ID: " + temp.task.taskId + ", Name: " + temp.task.taskName + ", Priority: " + temp.task.priority + ", Due Date: " + temp.task.dueDate);
            temp = temp.next;
            // Continue until we loop back to the head
        } while (temp != head);
    }

    // Display all tasks in the list starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Node temp = head;
        do {
            System.out.println("Task ID: " + temp.task.taskId + ", Name: " + temp.task.taskName + ", Priority: " + temp.task.priority + ", Due Date: " + temp.task.dueDate);
            temp = temp.next;
            // Loop through the circular list
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Node temp = head;
        boolean found = false;
        do {
            if (temp.task.priority == priority) {
                System.out.println("Task ID: " + temp.task.taskId + ", Name: " + temp.task.taskName + ", Due Date: " + temp.task.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}
