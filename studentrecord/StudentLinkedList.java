package com.datastructures.linkedlist.studentrecord;

// Define the LinkedList class to manage the list of students
class StudentLinkedList {
    Node head; // Head of the linked list

    // Static inner Node class
    static class Node {
        Student student;
        Node next; // Points to the next node

        // Constructor to create a new node
        public Node(Student student) {
            this.student = student;
            // Initially, the next node is null
            this.next = null;
        }
    }

    // Constructor to initialize the list
    public StudentLinkedList() {
        head = null;
    }

    // Add a student record at the beginning of the list
    public void addAtBeginning(Student student) {
        // Create a new node
        Node newNode = new Node(student);
        // Link the new node to the current head
        newNode.next = head;
        // Update head to the new node
        head = newNode;
    }

    // Add a student record at the end of the list
    public void addAtEnd(Student student) {
        // Create a new node
        Node newNode = new Node(student);
        if (head == null) {
            // If the list is empty, new node becomes the head
            head = newNode;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                // Traverse to the last node
                temp = temp.next;
            }
            // Add the new node at the end
            temp.next = newNode;
        }
    }

    // Add a student record at a specific position
    public void addAtPosition(int position, Student student) {
        Node newNode = new Node(student);
        if (position == 0) {
            // Add at the beginning if position is 0
            addAtBeginning(student);
            return;
        }

        Node temp = head;
        int count = 0;
        while (temp != null && count < position - 1) {
            // Traverse until the desired position
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range");
        }
        else {
            // Link the new node to the next node
            newNode.next = temp.next;
            // Link the previous node to the new node
            temp.next = newNode;
        }
    }

    // Delete a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If the student to be deleted is at the head
        if (head.student.rollNumber == rollNumber) {
            head = head.next; // Move head to the next node
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.student.rollNumber != rollNumber) {
            temp = temp.next; // Traverse to find the student
        }

        if (temp.next == null) {
            System.out.println("Student with roll number " + rollNumber + " not found");
        }
        else {
            // Delete the student by changing the next pointer
            temp.next = temp.next.next;
        }
    }

    // Search for a student record by Roll Number
    public Node searchByRollNumber(int rollNumber) {
        Node temp = head;
        while (temp != null) {
            if (temp.student.rollNumber == rollNumber) {
                // Return the node if student is found
                return temp;
            }
            // Move to the next node
            temp = temp.next;
        }
        // Return null if student is not found
        return null;
    }

    // Display all student records
    public void displayAllRecords() {
        if (head == null) {
            System.out.println("No students in the list");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.student.rollNumber + ", Name: " + temp.student.name + ", Age: " + temp.student.age + ", Grade: " + temp.student.grade);
            // Move to the next node
            temp = temp.next;
        }
    }

    // Update a student's grade based on Roll Number
    public void updateGrade(int rollNumber, String newGrade) {
        Node studentNode = searchByRollNumber(rollNumber);
        if (studentNode != null) {
            // Update the grade of the found student
            studentNode.student.grade = newGrade;
            System.out.println("Grade updated successfully for roll number " + rollNumber);
        }
        else {
            System.out.println("Student with roll number " + rollNumber + " not found");
        }
    }
}
