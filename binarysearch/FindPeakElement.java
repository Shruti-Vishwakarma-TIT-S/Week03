package com.java.binarysearch;

public class FindPeakElement {
    // Main method to test the binary search for the peak element
    public static void main(String[] args) {
        // Example of an array
        int[] array = {1, 3, 20, 4, 1, 0};

        // Find the peak element
        int peakIndex = findPeakElement(array);

        // Print the result
        System.out.println("The peak element index is: " + peakIndex);
        System.out.println("The peak element is: " + array[peakIndex]);
    }

    // Method to find a peak element in the array
    public static int findPeakElement(int[] arr) {
        // Initialize left as 0 and right as n - 1
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search
        while (left < right) {
            // Find the middle element
            int mid = (left + right) / 2;

            // If arr[mid] is greater than its neighbors, it is a peak element
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }
            // If arr[mid] is less than arr[mid - 1], search the left half
            else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // If arr[mid] is less than arr[mid + 1], search the right half
            else {
                left = mid + 1;
            }
        }
        // The left index will be the peak element
        return left;
    }
}
