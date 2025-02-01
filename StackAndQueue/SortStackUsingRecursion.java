package com.datastructure.stackusingrecursion;

import java.util.Stack;

public class SortStackUsingRecursion {

    // Main method to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case: If the stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int topElement = stack.pop();

        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the popped element back into the sorted stack
        insertInSortedOrder(stack, topElement);
    }

    // Helper method to insert an element into the sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: If the stack is empty or the top element is less than or equal to the element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element); // Push the element onto the stack
            return;
        }

        // If the top element is greater than the element, pop the top element
        int top = stack.pop();

        // Recursively call to insert the element
        insertInSortedOrder(stack, element);

        // Push the popped element back onto the stack
        stack.push(top);
    }

    // Main method to test the sorting
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);

        System.out.println("Original Stack: " + stack);
        // Sort the stack
        sortStack(stack);
        // Print the sorted stack
        System.out.println("Sorted Stack: " + stack);
    }
}