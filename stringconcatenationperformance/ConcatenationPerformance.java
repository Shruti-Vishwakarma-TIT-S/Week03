package com.asymptoticnotations.stringconcatenationperformance;
// Import Scanner for user input
import java.util.Scanner;

public class ConcatenationPerformance {

    public double stringPerformance(int length) {
        // Start time
        long startTime = System.nanoTime();

        // Start with an empty string
        String str = "";

        // Append "a" multiple times (inefficient due to immutability)
        for (int i = 0; i < length; i++) {
            // Creates a new object each time (very slow)
            str += "a";
        }

        // End time
        long endTime = System.nanoTime();

        // Convert to milliseconds
        return (endTime - startTime) / 1e6;
    }

    public double stringBuilderPerformance(int length) {
        // Start time
        long startTime = System.nanoTime();

        // Use StringBuilder (efficient)
        StringBuilder sb = new StringBuilder();

        // Append "a" multiple times (fast and optimized)
        for (int i = 0; i < length; i++) {
            sb.append("a");
        }

        // End time
        long endTime = System.nanoTime();

        // Convert to milliseconds
        return (endTime - startTime) / 1e6;
    }

    public double stringBufferPerformance(int length) {
        // Start time
        long startTime = System.nanoTime();

        // Use StringBuffer (thread-safe)
        StringBuffer sbr = new StringBuffer();

        // Append "a" multiple times
        for (int i = 0; i < length; i++) {
            sbr.append("a");
        }

        // End time
        long endTime = System.nanoTime();

        // Convert to milliseconds
        return (endTime - startTime) / 1e6;
    }

    public static void main(String[] args) {
        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Ask user for string length
        System.out.println("Enter the length of the string:");

        // Read user input
        int length = sc.nextInt();

        // Close Scanner
        sc.close();

        // Create object
        ConcatenationPerformance perform = new ConcatenationPerformance();

        // Measure and print time for String concatenation
        double aString = perform.stringPerformance(length);
        System.out.println("Time for String: " + aString + " ms");

        // Measure and print time for StringBuilder concatenation
        double aStringBuilder = perform.stringBuilderPerformance(length);
        System.out.println("Time for StringBuilder: " + aStringBuilder + " ms");

        // Measure and print time for StringBuffer concatenation
        double aStringBuffer = perform.stringBufferPerformance(length);
        System.out.println("Time for StringBuffer: " + aStringBuffer + " ms");
    }
}
