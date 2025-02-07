package com.java.binarysearch;

public class BinarySearchOcurrences {

    // Method to find the first occurrence of the target
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int firstOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found, record it and continue searching on the left side
            if (arr[mid] == target) {
                firstOccurrence = mid;
                right = mid - 1;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return firstOccurrence;
    }

    // Method to find the last occurrence of the target
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found, record it and continue searching on the right side
            if (arr[mid] == target) {
                lastOccurrence = mid;
                left = mid + 1;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return lastOccurrence;
    }

    // Main method to test the program
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        // Find the first and last occurrence of the target
        int firstOccurrence = findFirstOccurrence(arr, target);
        int lastOccurrence = findLastOccurrence(arr, target);

        // Print the results
        if (firstOccurrence == -1) {
            System.out.println("Element not found in the array.");
        }

        else {
            System.out.println("First occurrence of element " + target + " is at index: " + firstOccurrence);
            System.out.println("Last occurrence of element " + target + " is at index: " + lastOccurrence);
        }
    }
}
