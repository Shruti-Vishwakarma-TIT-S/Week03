package com.java.challengeproblemsearching;
import java.util.Arrays;

public class SearchProblems{

    // Method to find the first missing positive integer using linear search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Mark numbers that are out of range or negative

        for (int i = 0; i < n; i++) {

            // If the number is less than or equal to zero or greater than the length of the array,
            if (nums[i] <= 0 || nums[i] > n) {

                // mark it as out of range by assigning it a value greater than the maximum index
                nums[i] = n + 1;
            }
        }

        // Use the array index as a hash to record the presence of numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {

                // If the number is within the range, mark the index corresponding to the number as visited
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // Find the first index which has a positive value, that index + 1 is the missing number
        for (int i = 0; i < n; i++) {

            if (nums[i] > 0) {
                // If the value at the current index is positive, it means the index + 1 is the missing positive integer
                return i + 1;
            }
        }

        // If all indices are visited, the first missing positive integer is n + 1
        return n + 1;
    }

    // Method to perform binary search and find the index of the target number
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is the target
            if (arr[mid] == target) {

                // If the middle element is equal to the target, return the index
                return mid;
            }
            else if (arr[mid] < target) {

                // If the middle element is less than the target, search in the right half
                left = mid + 1;
            }
            else {

                // If the middle element is greater than the target, search in the left half
                right = mid - 1;
            }
        }

        // If the target is not found in the array, return -1
        return -1;
    }

    // Main method to test the program
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        // Find the first missing positive integer
        int firstMissingPositive = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + firstMissingPositive);

        // Sort the array for binary search
        Arrays.sort(nums);

        // Find the index of the target number
        int targetIndex = binarySearch(nums, target);
        System.out.println("Index of target number " + target + ": " + targetIndex);
    }
}
