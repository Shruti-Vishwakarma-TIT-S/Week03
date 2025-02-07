// Import custom package
package com.java.stringmanipulation;
// Create a class to reverse a string
public class ReverseString {
    // Main method to initiate the program
    public static void main(String[] args) {
        // Take String input
        String original = "hello";
        System.out.println("Input String is: " + original);

        // create a StringBuilder class object
        StringBuilder sb = new StringBuilder();

        // Use append() method to add original value to StringBuilder object
        sb.append(original);

        // Reverse the String given
        sb.reverse();

        //Convert it to String from StringBuilder
        String reverse = sb.toString();

        // Print new String that is reversed
        System.out.println("Reversed String is: " + reverse);

    }

}
