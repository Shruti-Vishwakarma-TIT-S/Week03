package com.sortingalgorithms.mergesort;

public class MergeSortBookPrices {

    // This method performs the merge sort on the bookPrices array
    public static void mergeSort(double[] bookPrices) {

        // Base case: If the array has one or zero elements, it's already sorted
        if (bookPrices.length < 2) {
            return;
        }

        // Find the middle index to divide the array
        int mid = bookPrices.length / 2;

        // Create left subarray
        double[] left = new double[mid];

        // Create right subarray
        double[] right = new double[bookPrices.length - mid];

        // Fill the left subarray with the first half of the original array
        for (int i = 0; i < mid; i++) {
            left[i] = bookPrices[i];
        }

        // Fill the right subarray with the second half of the original array
        for (int i = mid; i < bookPrices.length; i++) {
            right[i - mid] = bookPrices[i];
        }

        // Recursively sort both subarrays
        mergeSort(left);
        mergeSort(right);

        // Merge the two sorted subarrays into the original array
        merge(bookPrices, left, right);
    }

    // This method merges two sorted arrays (left and right) into the bookPrices array
    private static void merge(double[] bookPrices, double[] left, double[] right) {

        // Initialize indices for the left, right, and main arrays
        // Index for the left subarray
        int i = 0;
        // Index for the right subarray
        int j = 0;
        // Index for the main array
        int k = 0;

        // Merge the left and right subarrays until one of them is fully traversed
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                // If the left element is smaller, add it to the main array
                bookPrices[k++] = left[i++];
            }
            else {
                // If the right element is smaller, add it to the main array
                bookPrices[k++] = right[j++];
            }
        }

        // If there are remaining elements in the left subarray, add them to the main array
        while (i < left.length) {
            bookPrices[k++] = left[i++];
        }

        // If there are remaining elements in the right subarray, add them to the main array
        while (j < right.length) {
            bookPrices[k++] = right[j++];
        }
    }

    // Main method to test the merge sort
    public static void main(String[] args) {

        // Define the length of the array
        int length = 8;

        // Initialize the array with example book prices
        double[] bookPrices = {308.6, 273.9, 43.5, 113.56, 917.25, 812.6, 100.49, 249.57};

        // Print the given unsorted array
        System.out.println("\nUnsorted array is ");
        for (int i = 0; i < length; i++) {
            // Print each unsorted book price followed by a space
            System.out.print(bookPrices[i] + " ");
        }

        // Call the mergeSort method to sort the bookPrices array
        mergeSort(bookPrices);

        // Print the sorted array
        System.out.println("\nSorted Array");
        for (int i = 0; i < length; i++) {
            // Print each sorted book price followed by a space
            System.out.print(bookPrices[i] + " ");
        }
    }
}
