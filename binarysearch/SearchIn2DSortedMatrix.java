package com.java.binarysearch;

public class SearchIn2DSortedMatrix {
    // Main method to test the binary search in a 2D sorted matrix
    public static void main(String[] args) {
        // Example of a 2D sorted matrix
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        // Target value to search for
        int target = 3;

        // Perform binary search for the target value
        boolean found = searchMatrix(matrix, target);

        // Print the result
        if (found) {
            System.out.println("Target value " + target + " found in the matrix.");
        } else {
            System.out.println("Target value " + target + " not found in the matrix.");
        }
    }

    // Method to perform binary search in a 2D sorted matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows and columns in the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Initialize left as 0 and right as rows * columns - 1
        int left = 0;
        int right = rows * cols - 1;

        // Perform binary search
        while (left <= right) {
            // Find the middle element index
            int mid = (left + right) / 2;
            // Convert mid to row and column indices
            int midRow = mid / cols;
            int midCol = mid % cols;

            // Get the middle element value
            int midValue = matrix[midRow][midCol];

            // Compare the middle element with the target
            if (midValue == target) {
                // Target value found
                return true;
            }
            else if (midValue < target) {
                // Search the right half
                left = mid + 1;
            }
            else {
                // Search the left half
                right = mid - 1;
            }
        }
        return false;
    }
}

