// Import custom package
package com.java.stringmanipulation;

// Import HashSet Class from util package
import java.util.HashSet;

// Create a class to remove duplicates
public class RemoveDuplicates {

    // Take method name removeDuplicates
    public static String removeDuplicate(String original){

        // Create StringBuilder Class object sb
        StringBuilder sb = new StringBuilder();

        // Create HashSet of character type
        HashSet<Character> occur = new HashSet<>();

        // Use for each loop to iterate over String and convert String to charArray
        for(char c : original.toCharArray()){

            /* If HashSet does not contains the current element then it
            will get append to new String and get added to Hashset */
            if(!occur.contains(c)){

                // To append char value to stringBuilder
                sb.append(c);

                // To add character c to HashSet
                occur.add(c);
            }
        }

        // Return String
        return sb.toString();
    }

    // Main method to execute the flow of program
    public static void main(String[] args) {

        // Create a user defined String name original
        String original = "Hello Everyone Good Morning";

        // Print the input String
        System.out.println("Original String: " + original);

        // call removeDuplicates method
        String afterRemoveDuplicates = removeDuplicate(original);

        // Now Print the String with unique characters
        System.out.println("Unique Characters String: "+ afterRemoveDuplicates);
    }
}
