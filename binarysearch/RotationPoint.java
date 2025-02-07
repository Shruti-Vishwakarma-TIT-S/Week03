package com.java.binarysearch;

public class RotationPoint {
    // Main method to test the binary search for the rotation point
    public static void main(String[] args) {
        // Example of a rotated sorted array
        int[] array = {15, 18, 43, 92, 3, 6, 12};

        // Find the rotation point
        int rotationPointIndex = findRotationPoint(array);

        // Print the result
        System.out.println("The rotation point index is: " + rotationPointIndex);
    }

    // Method to find the rotation point in the rotated sorted array
    public static int findRotationPoint(int[] arr) {
        // Initialize left as 0 and right as n - 1
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search
        while (left < right) {
            // Find the middle element
            int mid = (left + right) / 2;

            // If arr[mid] is greater than arr[right], the smallest element is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // If arr[mid] is less than arr[right], the smallest element is in the left half
            else {
                right = mid;
            }
        }
        // The left index will be the rotation point
        return left;
    }
}
