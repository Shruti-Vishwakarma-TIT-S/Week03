package com.sortingalgorithms.countingsort;

public class CountingSortStudentAges {

    // This method performs Counting Sort on the array of student ages
    public static void countingSort(int[] ages) {
        int maxAge = 18;  // Maximum possible age (18)
        int minAge = 10;  // Minimum possible age (10)

        // Step 1: Create a count array to store frequency of each age
        int[] count = new int[maxAge - minAge + 1];

        // Step 2: Fill the count array with frequency of each age in the input array
        for (int age : ages) {
            count[age - minAge]++; // Increment the count for the corresponding age
        }

        // Step 3: Modify the count array by adding the cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];  // Add the count of previous ages to get the cumulative count
        }

        // Step 4: Create the output array to store the sorted ages
        int[] sortedAges = new int[ages.length];

        // Step 5: Place each element in its correct position in the output array
        // Traverse the input array from right to left to maintain stability
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            int position = count[age - minAge] - 1;  // Find the position using the cumulative count
            sortedAges[position] = age;  // Place the element in the sorted array
            count[age - minAge]--;  // Decrease the count to place the next occurrence
        }

        // Step 6: Copy the sorted array back to the original array
        System.arraycopy(sortedAges, 0, ages, 0, ages.length);
    }

    // Main method to test the Counting Sort
    public static void main(String[] args) {

        // Define the array of student ages
        int[] ages = {12, 15, 10, 13, 17, 16, 18, 15, 12, 14};

        // Print the unsorted array
        System.out.println("Unsorted Student Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        // Call the countingSort method to sort the student ages
        countingSort(ages);

        // Print the sorted array
        System.out.println("\nSorted Student Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}
