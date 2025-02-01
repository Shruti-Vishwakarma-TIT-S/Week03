package com.datastructure.circulartourproblem;

public class CircularTour {

    // Function to find the starting point of the circular tour
    public static int findStartPoint(int[] petrol, int[] distance) {
        // Total surplus petrol at all pumps
        int totalSurplus = 0;
        // Surplus petrol at current pump
        int currentSurplus = 0;
        // Initial starting point
        int startPoint = 0;

        // Traverse the petrol pumps
        for (int i = 0; i < petrol.length; i++) {
            // Calculate the surplus petrol for the current pump
            int surplus = petrol[i] - distance[i];

            // Update total surplus and current surplus
            totalSurplus += surplus;
            currentSurplus += surplus;

            // If currentSurplus goes negative, reset the start point
            if (currentSurplus < 0) {
                // Move the starting point to the next pump
                startPoint = i + 1;
                // Reset current surplus
                currentSurplus = 0;
            }
        }

        // If total surplus is negative, return -1 indicating it's not possible to complete the tour
        return totalSurplus >= 0 ? startPoint : -1;
    }

    public static void main(String[] args) {
        // Example input
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        // Call the function and print the result
        int startPoint = findStartPoint(petrol, distance);
        if (startPoint == -1) {
            System.out.println("No valid starting point found. It is not possible to complete the circular tour.");
        } else {
            System.out.println("The tour can start from pump index: " + startPoint);
        }
    }
}
