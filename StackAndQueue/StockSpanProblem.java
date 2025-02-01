package com.datastructure.stockspanproblem;

import java.util.Stack;

public class StockSpanProblem {

    // Method to calculate the stock span
    public static int[] calculateStockSpan(int[] prices) {
        int n = prices.length;
        // Array to store the span for each price
        int[] span = new int[n];
        // Stack to store the indices of prices
        Stack<Integer> stack = new Stack<>();

        // Iterate through the prices array
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack until you find a price that is greater than the current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                // Pop the index from the stack
                stack.pop();
            }

            // Calculate the span for the current price
            if (stack.isEmpty()) {
                // If the stack is empty, the span is the current index plus one
                span[i] = i + 1;
            }
            else {
                /* The span is the difference between the current index and the index of
                 the price that was popped from the stack
                 */
                span[i] = i - stack.peek();
            }

            // Push the current index onto the stack
            stack.push(i);
        }
        // Return the span array
        return span;
    }

    // Main method to test the stock span calculation
    public static void main(String[] args) {
        int[] prices = {10, 4, 5, 90, 120, 80};
        int[] span = calculateStockSpan(prices);

        System.out.println("Stock Span: ");
        for (int i = 0; i < span.length; i++) {
            System.out.println("Day " + (i + 1) + ": Price = " + prices[i] + ", Span = " + span[i]);
        }
    }
}
