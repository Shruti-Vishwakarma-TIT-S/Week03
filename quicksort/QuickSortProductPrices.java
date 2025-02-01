package com.sortingalgorithms.quicksort;

public class QuickSortProductPrices {

    // This method performs the QuickSort algorithm
    public static void quickSort(double[] productPrices, int low, int high) {

        // Base case: If the low index is greater than or equal to the high index, return
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(productPrices, low, high);

            // Recursively apply QuickSort to the left partition (elements smaller than pivot)
            quickSort(productPrices, low, pivotIndex - 1);

            // Recursively apply QuickSort to the right partition (elements larger than pivot)
            quickSort(productPrices, pivotIndex + 1, high);
        }
    }

    // This method partitions the array based on the pivot
    private static int partition(double[] productPrices, int low, int high) {

        // Pivot element: In this case, we use the last element of the array
        double pivot = productPrices[high];

        // Index of the smaller element
        int i = (low - 1);

        // Loop through the array and place elements smaller than the pivot on the left side
        // and elements larger than the pivot on the right side
        for (int j = low; j < high; j++) {
            if (productPrices[j] <= pivot) {
                i++;  // Increment the smaller element index
                // Swap the current element with the element at index i
                double temp = productPrices[i];
                productPrices[i] = productPrices[j];
                productPrices[j] = temp;
            }
        }

        // After the loop, place the pivot element at the correct position
        double temp = productPrices[i + 1];
        productPrices[i + 1] = productPrices[high];
        productPrices[high] = temp;

        // Return the index where the pivot is placed
        return i + 1;
    }

    // Main method to test the QuickSort algorithm
    public static void main(String[] args) {

        // Initialize the array with product prices
        double[] productPrices = {299.99, 149.49, 59.99, 199.99, 499.99, 89.99, 129.49, 349.99};

        // Print the unsorted array
        System.out.println("Unsorted Product Prices:");
        for (double price : productPrices) {
            System.out.print(price + " ");
        }

        // Call the quickSort method to sort the array
        quickSort(productPrices, 0, productPrices.length - 1);

        // Print the sorted array
        System.out.println("\nSorted Product Prices:");
        for (double price : productPrices) {
            System.out.print(price + " ");
        }
    }
}
