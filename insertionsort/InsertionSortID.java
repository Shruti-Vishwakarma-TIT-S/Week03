package com.sortingalgorithms.insertionsort;

public class InsertionSortID {

    // This method performs the sorting
    public static void sort(int length, int[] employeeID) {

        // Outer loop that starts from index 1 and runs through the entire array
        for (int i = 1 ; i < length ; i++) {
            // Store the current element (employeeID[i]) in a variable "key"
            int key = employeeID[i];

            // Set "j" as the index of the element just before "i"
            int j = i - 1;

            /*  While loop to move elements of employeeID greater than "key"
             to one position ahead of their current position */
            while (j >= 0 && employeeID[j] > key){
                employeeID[j + 1] = employeeID[j]; // Shift element one position to the right
                j--; // Move to the next element to the left
            }

            // Insert the "key" in the correct position (after shifting larger elements)
            employeeID[j + 1] = key;
        }

        // Print a new line for clarity after sorting
        System.out.println();

        // Print the sorted employee IDs
        System.out.println("Sorted array is ");
        for (int i = 0; i < length; i++){

            // Print each sorted employee ID followed by a space
            System.out.print(employeeID[i] + " ");
        }

    }

    // Main method where the program execution begins
    public static void main(String[] args) {

        // Define the length of the array
        int length = 10;

        // Initialize the array with employee IDs
        int[] employeeID = {723, 156, 171, 306, 909, 411, 186, 448, 327, 393};

        // Print the given unsorted array
        System.out.println("Unsorted Array is ");
        for (int i = 0; i < length; i++){

            // Print each unsorted employee ID followed by a space
            System.out.print(employeeID[i] + " ");
        }

        // Call the sort method to sort the employee IDs
        sort(length, employeeID);
    }
}
