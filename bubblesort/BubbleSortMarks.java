package com.sortingalgorithms.bubblesort;

public class BubbleSortMarks {

    // This method performs the sorting
    public static void sort(int length, int[] studentMarks){

        // Outer loop that runs through the entire array
        for(int i = 0; i < length-1; i++){

            // Inner loop that compares adjacent elements
            for(int j = 0; j < length-1-i ; j++){
                // If the current element is greater than the next element, swap them
                if(studentMarks[j] > studentMarks[j+1]){

                    // Store the current element in a temporary variable
                    int temp = studentMarks[j];

                    // Swap the current element with the next element
                    studentMarks[j] = studentMarks[j+1];
                    studentMarks[j+1] = temp;
                }
            }
        }

        // Print a new line for clarity
        System.out.println();

        // Print the sorted student marks
        System.out.println("Sorted array is ");
        for (int i = 0; i < length-1 ; i++){

            // Print each sorted mark followed by a space
            System.out.print(studentMarks[i] + " ");
        }
    }

    // Main method where the program execution begins
    public static void main(String[] args) {

        // Define the length of the array
        int length = 10;

        // Initialize the array with student marks
        int[] studentMarks = {56, 23, 71, 36, 90, 11, 86, 48, 27, 33};

        // Print the given unsorted array
        System.out.println("Unsorted Array is ");
        for (int i = 0; i < length-1 ; i++){

            // Print each unsorted mark followed by a space
            System.out.print(studentMarks[i] + " ");
        }

        // Call the sort method to sort the student marks
        sort(length, studentMarks);
    }
}
