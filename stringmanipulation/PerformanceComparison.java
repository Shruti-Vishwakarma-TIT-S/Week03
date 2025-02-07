// Create a package
package com.java.stringmanipulation;
// Create a class PerformanceComparison
public class PerformanceComparison {

    // Main method to start the program
    public static void main(String[] args) {

        // Local variables to keep track of time
        long startTime, endTime;

        // Testing StringBuilder Performance
        startTime = System.nanoTime();

        // Create object of StringBuilder
        StringBuilder sb = new StringBuilder("Java");

        // Run loop till 1 million times
        for (int i = 0; i < 1000000; i++) {
            // Append string to StringBuilder
            sb.append(" Performance Test");
        }
        endTime = System.nanoTime();

        // Print the time taken by StringBuilder
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");

        // Testing StringBuffer Performance
        startTime = System.nanoTime();

        // Create a sbf object of StringBuffer class
        StringBuffer sbf = new StringBuffer("Java");

        // For loop run till 1 million times
        for (int i = 0; i < 1000000; i++) {

            // Append string to StringBuffer
            sbf.append(" Performance Test");
        }
        endTime = System.nanoTime();

        // Print the time taken by StringBuffer
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");
    }
}
