package com.asymptoticnotations.datastructuresearch;

import java.util.*;
public class DataStructureSearchComparison {

    // Method to search an element in an array (Linear Search - O(N))
    public static boolean searchInArray(int[] array, int key) {
        // Iterate through the array to find the key
        for (int num : array) {
            if (num == key) {

                // Element found
                return true;
            }
        }
        return false;
    }

    // Method to search an element in a HashSet (O(1) on average)
    public static boolean searchInHashSet(HashSet<Integer> set, int key) {
        // HashSet allows quick lookup with constant time complexity
        return set.contains(key);
    }

    // Method to search an element in a TreeSet (O(log N))
    public static boolean searchInTreeSet(TreeSet<Integer> set, int key) {
        // TreeSet is implemented using a balanced binary search tree
        return set.contains(key);
    }

    public static void main(String[] args) {
        // Define dataset size
        int number = 1000000;

        // Create an array, HashSet, and TreeSet
        int[] array = new int[number];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Populate the data structures with random numbers
        Random random = new Random();
        for (int i = 0; i < number; i++) {

            // Generate a random number
            int num = random.nextInt(number * 10);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Choose a random element from the array to search
        int searchKey = array[random.nextInt(number)];

        // Measure search time in Array (O(N))
        long startTime = System.nanoTime();
        searchInArray(array, searchKey);
        long endTime = System.nanoTime();
        System.out.println("Array search time: " + (endTime - startTime) / 1e6 + " ms");

        // Measure search time in HashSet (O(1))
        startTime = System.nanoTime();
        searchInHashSet(hashSet, searchKey);
        endTime = System.nanoTime();
        System.out.println("HashSet search time: " + (endTime - startTime) / 1e6 + " ms");

        // Measure search time in TreeSet (O(log N))
        startTime = System.nanoTime();
        searchInTreeSet(treeSet, searchKey);
        endTime = System.nanoTime();
        System.out.println("TreeSet search time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
