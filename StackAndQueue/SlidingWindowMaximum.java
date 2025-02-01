package com.datastructure.slidingwindow;

import java.util.*;

class SlidingWindowMaximum {

    // Function to find the maximum in each sliding window of size k using queue
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        // List to store the result
        List<Integer> result = new ArrayList<>();

        // Queue to store indices of useful elements for the current window
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            // Remove elements that are out of the current window
            if (!queue.isEmpty() && queue.peek() < i - k + 1) {
                // Remove from front of the queue
                queue.poll();
            }

            // Remove elements from the queue that are smaller than the current element
            while (!queue.isEmpty() && nums[queue.peek()] <= nums[i]) {
                // Remove from front
                queue.poll();
            }

            // Add the current element's index to the back of the queue
            queue.offer(i);

            // Once we have processed at least k elements, add the max of the window (front of the queue) to the result
            if (i >= k - 1) {
                // The element at the front of the queue is the max in the current window
                result.add(nums[queue.peek()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example input
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 5;

        // Call the function and print the result
        List<Integer> result = maxSlidingWindow(nums, k);
        System.out.println("Sliding window maximums: " + result);
    }
}
