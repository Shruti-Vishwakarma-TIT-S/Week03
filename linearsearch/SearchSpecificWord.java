package com.java.linearsearch;

public class SearchSpecificWord {
    // Main method to test the linear search
    public static void main(String[] args) {

        // Example array of sentences
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog",
                "Java programming is fun",
                "Linear search is simple and intuitive",
                "The sun sets in the west",
                "Practice makes perfect"
        };

        // Word to search for
        String word = "Linear";

        // Perform linear search for the specific word
        String result = findSentenceWithWord(sentences, word);

        // Print the result
        System.out.println(result);
    }

    // Method to find the first sentence containing the specific word
    public static String findSentenceWithWord(String[] sentences, String word) {

        // Iterate through the array of sentences
        for (String sentence : sentences) {

            // Check if the current sentence contains the specific word
            if (sentence.contains(word)) {
                // If the word is found, return the current sentence
                return sentence;
            }
        }
        // If no sentence contains the word, return "Not Found"
        return "Not Found";
    }
}
