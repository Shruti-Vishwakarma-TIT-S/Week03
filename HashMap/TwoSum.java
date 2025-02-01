package hashmap;

import java.util.HashMap;

public class TwoSum {

    // Function to find two indices that sum up to the target
    public static int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the value and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the complement

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices
                return new int[] { map.get(complement), i };
            }

            // If complement is not found, add the current element to the map
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array (or throw an exception)
        return new int[] {};
    }

    public static void main(String[] args) {
        // Example input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Call the function and print the result
        int[] result = twoSum(nums, target);

        if (result.length > 0) {
            System.out.println("Indices of the two numbers that sum up to " + target + ": " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}
