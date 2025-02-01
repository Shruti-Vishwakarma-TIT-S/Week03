package com.sortingalgorithms.heapsort;

public class HeapSortJobApplicants {

    // This method performs the heap sort
    public static void heapSort(double[] salaries) {

        // Step 1: Build a Max Heap from the given array
        int n = salaries.length;

        // Building the max heap by calling heapify for each non-leaf node (from n/2-1 to 0)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements one by one from the heap and place them at the end
        for (int i = n - 1; i >= 1; i--) {
            // Swap the root (maximum element) with the last element
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call heapify on the reduced heap to maintain the max heap property
            heapify(salaries, i, 0);
        }
    }

    // This method ensures the Max Heap property is maintained
    private static void heapify(double[] salaries, int n, int i) {
        int largest = i; // Initialize the largest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If the left child is larger than the root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If the right child is larger than the largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If the largest element is not the root, swap them
        if (largest != i) {
            double swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(salaries, n, largest);
        }
    }

    // Main method to test the heap sort
    public static void main(String[] args) {

        // Array of salaries representing job applicants' expected salary demands
        double[] salaries = {50000, 70000, 60000, 40000, 80000, 55000, 75000};

        // Print the unsorted array
        System.out.println("Unsorted Job Applicants' Salaries:");
        for (double salary : salaries) {
            System.out.print(salary + " ");
        }

        // Call the heapSort method to sort the salaries
        heapSort(salaries);

        // Print the sorted array
        System.out.println("\nSorted Job Applicants' Salaries (Ascending Order):");
        for (double salary : salaries) {
            System.out.print(salary + " ");
        }
    }
}
