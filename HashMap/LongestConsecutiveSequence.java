package hashmap;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Function to find the length of the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        // Edge case: if the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // HashSet to store the elements of the array
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // Iterate through the array
        for (int num : nums) {
            // Only start a sequence if `num - 1` is not in the set
            // This ensures that `num` is the first number in the sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Check for the next numbers in the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the longest streak found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        // Example input
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Call the function and print the result
        int result = longestConsecutive(nums);
        System.out.println("The length of the longest consecutive sequence is: " + result);
    }
}
