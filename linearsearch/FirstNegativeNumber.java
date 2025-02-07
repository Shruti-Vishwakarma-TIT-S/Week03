package com.java.linearsearch;

public class FirstNegativeNumber {
    // Main method to test the linear search
    public static void main(String[] args) {
        // Example array to search
        int[] array = {3, 7, 1, -4, 2, -9, 6};

        // Perform linear search for the first negative number
        int index = findFirstNegative(array);

        // Print the result
        if (index > 0) {
            System.out.println("The first negative number is at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }

    // Method to find the first negative number in the array
    public static int findFirstNegative(int[] array) {
        // Iterate through the array from the start

        for (int i = 0; i < array.length; i++) {
            // Check if the current element is negative
            if (array[i] < 0) {
                // If a negative number is found, return its index
                return i;
            }
        }
        // If the loop completes without finding a negative number, return -1
        return -1;
    }
}
