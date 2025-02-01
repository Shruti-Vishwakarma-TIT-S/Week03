package hashmap;

import java.util.*;

public class SubArrayWithZeroSum {

    // Function to find and print all subarrays with zero sum
    public static void findZeroSumSubarrays(int[] arr) {
        // HashMap to store the cumulative sum and its list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        int cumulativeSum = 0;

        // Initialize the map with 0 sum occurring at index -1 (helps in case subarray starts from index 0)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum
            cumulativeSum += arr[i];

            // If the cumulative sum is already present in the map, we found zero sum subarrays
            if (map.containsKey(cumulativeSum)) {
                // Retrieve the list of previous indices where this cumulative sum occurred
                List<Integer> indices = map.get(cumulativeSum);

                // For each occurrence of the same sum, it indicates a zero sum subarray
                for (int index : indices) {
                    // Subarray from (index+1) to i has a zero sum
                    System.out.println("Subarray with zero sum: [" + (index + 1) + ", " + i + "]");
                }
            }

            // Add the current index to the list of indices for the current cumulative sum
            map.putIfAbsent(cumulativeSum, new ArrayList<>());
            map.get(cumulativeSum).add(i);
        }
    }

    public static void main(String[] args) {
        // Example input
        int[] arr = {6, -3, 1, 3, -2, 2, 4, -4};

        // Call the function to find zero sum subarrays
        findZeroSumSubarrays(arr);
    }
}
