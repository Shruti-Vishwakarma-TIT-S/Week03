package com.asymptoticnotations.searchtarget;
import java.util.Arrays;
import java.util.Scanner;

public class SearchTarget {

    // Method for linear search
    public int linearSearch(int[] array, int length, int targetElement){

        // Loop through the entire array
        for(int i = 0; i < length; i++){

            // Check if the current element matches the target
            if(array[i] == targetElement)

                // If found, return the index
                return i;
        }

        // If not found, return -1
        return -1;
    }

    // Method for binary search
    public int binarySearch(int[] array, int length, int targetElement){

        // Initialize the left and right pointers for binary search
        int left = 0;
        int right = length - 1;

        // Perform binary search until the left pointer crosses the right pointer
        while(left <= right){

            // Calculate the middle index of the current search range
            int mid = left + (right - left) / 2;

            // Check if the middle element is the target
            if(array[mid] == targetElement)

                // If found, return the middle index
                return mid;

                // If the target is greater, discard the left half
            else if (array[mid] < targetElement)
                left = mid + 1;

                // If the target is smaller, discard the right half
            else
                right = mid - 1;
        }

        // If the target was not found in the array, return -1
        return -1;
    }

    // Main method to run the program
    public static void main(String[] args) {

        // Create a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Create an instance of the SearchTarget class
        SearchTarget search = new SearchTarget();

        // Ask user to input the length of the array (choices: 1000, 10000, 1000000)
        System.out.println("Enter length first 1000, 10000, 1000000: ");
        int length = sc.nextInt();

        // Create an array of integers of the given length
        int[] array = new int[length];

        // Fill the array with consecutive integers starting from 1
        for(int i = 0; i < length; i++){

            // Assign the value (i + 1) to each index
            array[i] = (int)(Math.random()*length)+1;
        }

        // Ask the user to input the target element to search for
        System.out.println("Enter target element between 1 to " + length + ": ");
        int targetElement = sc.nextInt();

        // Record the start time for the linear search
        long startMilliSecond = System.nanoTime();

        // Perform linear search
        int indexLinear = search.linearSearch(array, length, targetElement);

        // Record the end time for the linear search
        long endMilliSecond = System.nanoTime();

        // Output the time taken for linear search in milliseconds
        System.out.println("Time for linear search is " + (endMilliSecond - startMilliSecond) / 1000000.0 );

        // Sort the array before performing binary search (though it's already sorted here)
        Arrays.sort(array);

        // Record the start time for the binary search
        startMilliSecond = System.nanoTime();

        // Perform binary search
        int indexBinary = search.binarySearch(array, length, targetElement);

        // Record the end time for the binary search
        endMilliSecond = System.nanoTime();

        // Output the time taken for binary search in milliseconds
        System.out.println("Time for binary search is " + (endMilliSecond - startMilliSecond) / 1000000.0 );
    }
}
