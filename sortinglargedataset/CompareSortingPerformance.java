package com.asymptoticnotations.sortinglargedataset;

import java.util.Arrays;
import java.util.Scanner;

public class CompareSortingPerformance {
    private long bubbleSortTime;
    private long mergeSortTime;
    private long quickSortTime;

    public void bubbleSort(long[] array, int length){
        long startTime = System.nanoTime();
        // Outer loop for each pass through the array
        for (int i = 0; i < length - 1; i++) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < length - 1 - i; j++) {
                // If the current element is greater than the next element, swap them
                if (array[j] > array[j + 1]) {
                    // Swap the elements
                    long temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        // Store the time taken for Bubble Sort
        bubbleSortTime = endTime - startTime;
    }

    public void mergeSort(long[] array, int left, int right) {
        long startTime = System.nanoTime();
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
        long endTime = System.nanoTime();
        // Store the time taken for Merge Sort
        mergeSortTime = endTime - startTime;
    }

    public void merge(long[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        long[] leftArray = new long[n1];
        long[] rightArray = new long[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void quickSort(long[] array, int low, int high) {
        long startTime = System.nanoTime();
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
        long endTime = System.nanoTime();
        // Store the time taken for Quick Sort
        quickSortTime = endTime - startTime;
    }

    private int partition(long[] array, int low, int high) {
        long pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                long temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        long temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);
        CompareSortingPerformance perfom = new CompareSortingPerformance();

        // Ask user to input the length of the array
        System.out.println("Enter length more than 1000000: ");
        int length = sc.nextInt();

        long[] array = new long[length];

        // Fill the array with random values
        for (int i = 0; i < length; i++) {
            array[i] = (long) ((Math.random() * 1000000) + 1);
        }

        // For Bubble Sort:
        long[] bubbleSortArray = Arrays.copyOf(array, array.length);
        System.out.println("Bubble Sort: ");
        perfom.bubbleSort(bubbleSortArray, length);

        // For Merge Sort:
        long[] mergeSortArray = Arrays.copyOf(array, array.length);
        System.out.println("Merge Sort: ");
        perfom.mergeSort(mergeSortArray, 0, length - 1);

        // For Quick Sort:
        long[] quickSortArray = Arrays.copyOf(array, array.length);  
        System.out.println("Quick Sort: ");
        perfom.quickSort(quickSortArray, 0, length - 1);

        // Print the time taken for each sorting algorithm after sorting is done:
        System.out.println("Time taken for Bubble Sort in milliseconds: " + perfom.bubbleSortTime / 1e6);
        System.out.println("Time taken for Merge Sort in milliseconds: " + perfom.mergeSortTime / 1e6);
        System.out.println("Time taken for Quick Sort in milliseconds: " + perfom.quickSortTime / 1e6);
    }
}
