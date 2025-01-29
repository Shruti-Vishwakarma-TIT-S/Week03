package com.datastructures.linkedlist.studentrecord;

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        // Create a student linked list
        StudentLinkedList studentList = new StudentLinkedList();

        // Add some students to the list
        studentList.addAtBeginning(new Student(1, "Vandna", 20, "A"));
        studentList.addAtEnd(new Student(2, "Jasmine", 21, "B"));
        studentList.addAtEnd(new Student(3, "Misti", 22, "A"));

        // Display all student records
        System.out.println("All student records:");
        studentList.displayAllRecords();

        // Search for a student by Roll Number
        int searchRollNumber = 2;
        StudentLinkedList.Node foundStudent = studentList.searchByRollNumber(searchRollNumber);
        if (foundStudent != null) {
            System.out.println("\nStudent found: " + foundStudent.student.name);
        } else {
            System.out.println("\nStudent with roll number " + searchRollNumber + " not found");
        }

        // Update a student's grade
        studentList.updateGrade(2, "A+");

        // Display updated records
        System.out.println("\nUpdated student records:");
        studentList.displayAllRecords();

        // Delete a student by Roll Number
        studentList.deleteByRollNumber(1);

        // Display records after deletion
        System.out.println("\nRecords after deletion:");
        studentList.displayAllRecords();
    }
}
