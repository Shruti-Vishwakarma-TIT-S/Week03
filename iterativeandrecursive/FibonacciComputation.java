package com.asymptoticnotations.iterativeandrecursive;

public class FibonacciComputation {

    // Method to calculate Fibonacci using recursion (inefficient for large n)
    public long fibonacciRecursive(int n) {
        // Base case: If n is 0 or 1, return n directly
        if (n <= 1) return n;

        // Recursive call: Sum of previous two Fibonacci numbers
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Method to calculate Fibonacci using iteration (efficient for large n)
    public long fibonacciIterative(int n) {
        // Declare variables to store the previous two Fibonacci numbers
        int a = 0, b = 1, sum;

        // Loop starts from 2 because the first two Fibonacci numbers are already defined
        for (int i = 2; i <= n; i++) {
            // Calculate the next Fibonacci number
            sum = a + b;

            // Update previous values for next iteration
            a = b;
            b = sum;
        }

        // Return the nth Fibonacci number
        return b;
    }

    public static void main(String[] args) {
        // Create an object of FibonacciComputation class
        FibonacciComputation fibonacci = new FibonacciComputation();

        // Define the Fibonacci number to compute
        int number = 100;

        // Measure execution time for the iterative approach
        long startTime = System.nanoTime();
        fibonacci.fibonacciIterative(number);
        long endTime = System.nanoTime();

        // Print execution time for iterative approach
        System.out.println("Iterative approach takes " + (endTime - startTime) / 1e6 + " ms ");

        // Measure execution time for the recursive approach
        startTime = System.nanoTime();
        fibonacci.fibonacciRecursive(number);
        endTime = System.nanoTime();

        // Print execution time for recursive approach
        System.out.println("Recursive approach takes " + (endTime - startTime) / 1e6 + " ms ");
    }
}
