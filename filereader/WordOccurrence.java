package com.java.filereader;

// Import necessary classes for file reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Create a class WordOccurence
public class WordOccurrence {

    // Main method to start the program
    public static void main(String[] args) {

        // Path to the text file
        String filePath = "C:\\Users\\HP\\OneDrive\\Attachments\\Hii\\src\\main\\java\\com\\java\\filereader\\Story The Curious Kitten.txt";

        // Word to be counted
        String target = "Kitty";

        // Initialize a counter variable to keep track of word occurrences
        int count = 0;

        // Create a FileReader and BufferedReader to read the file
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;

            // Read and print each line until the end of the file
            while ((line = br.readLine()) != null) {

                // Split the line into words
                String[] words = line.split("\\s+");

                // Check if the target word exists in the array of words
                for (String word : words) {
                    if (word.equalsIgnoreCase(target)) {
                        // Increment the counter each time the word is found
                        count++;
                    }
                }
            }
        }
        // Catch and print any IOException that occurs
        catch (IOException e) {
            e.printStackTrace();
        }

        // The file is automatically closed after reading all the lines
        System.out.println("The word '" + target + "' has occurred " + count + " times.");
    }
}
