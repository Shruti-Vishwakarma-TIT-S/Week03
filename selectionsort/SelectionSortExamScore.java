package com.sortingalgorithms.selectionsort;

public class SelectionSortExamScore {

    // This method performs selection sort on the given examScores array
    public static void selectionSort(int length, int[] examScores) {

        // Outer loop to iterate through the entire array
        for (int i = 0; i < length - 1; i++) {

            // Assume the minimum element is the first element of the unsorted part
            int min = i;

            // Inner loop to find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < length; j++) {

                // If the current element is smaller than the current minimum, update min
                if (examScores[min] > examScores[j]) {
                    // Update the index of the minimum element
                    min = j;
                }
            }

            // Swap the found minimum element with the element at index 'i'
            int temp = examScores[min];
            examScores[min] = examScores[i];
            examScores[i] = temp;
        }

        // Print the sorted array
        System.out.println("\nSorted array is ");
        for (int i = 0; i < length; i++) {

            // Print each sorted score followed by a space
            System.out.print(examScores[i] + " ");
        }
    }

    // Main method where the program execution begins
    public static void main(String[] args) {

        // Define the length of the array
        int length = 10;

        // Initialize the array with exam scores
        int[] examScores = {65, 78, 91, 36, 43, 57, 14, 51, 96, 24};

        // Print the given unsorted array
        System.out.println("Unsorted array is ");
        for (int i = 0; i < length; i++) {

            // Print each unsorted score followed by a space
            System.out.print(examScores[i] + " ");
        }

        // Call the selectionSort method to sort the examScores array
        selectionSort(length, examScores);
    }
}
