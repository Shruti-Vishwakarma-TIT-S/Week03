package hashmap;

import java.util.HashSet;

public class PairWithGivenSum {

    // Function to check if a pair with the given sum exists in the array
    public static boolean hasPairWithSum(int[] arr, int target) {
        // HashSet to store the numbers we've seen so far
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Traverse the array
        for (int num : arr) {
            // Check if the difference between the target and the current number exists in the set
            if (seenNumbers.contains(target - num)) {
                return true; // Pair found
            }
            // Add the current number to the set
            seenNumbers.add(num);
        }

        // If no pair is found
        return false;
    }

    public static void main(String[] args) {
        // Example input
        int[] arr = {1, 4, 6, 3, 2};
        int target = 10;

        // Call the function and print the result
        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair with the given sum exists.");
        } else {
            System.out.println("No pair with the given sum found.");
        }
    }
}
