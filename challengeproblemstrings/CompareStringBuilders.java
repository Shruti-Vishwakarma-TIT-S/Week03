package com.java.challengeproblemstrings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;

public class CompareStringBuilders {

    public static void main(String[] args) {
        // Compare StringBuilder and StringBuffer for string concatenation
        compareStringBuilders();

        // Compare FileReader and InputStreamReader for reading a large file and counting words
        try {
            // Path to the large file
            String largeFilePath = "C:\\Users\\HP\\OneDrive\\Attachments\\Hii\\src\\main\\java\\com\\java\\challengeproblemstrings\\Story The Magical Paintbrush.txt";
            // Compare FileReader and InputStreamReader
            compareFileReaders(largeFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to compare StringBuilder and StringBuffer for string concatenation
    public static void compareStringBuilders() {
        String sampleString = "hello";
        int iterations = 1000000;

        // Using StringBuilder
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(sampleString);
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(sampleString);
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        // Print the results
        System.out.println("StringBuilder time (nanoseconds): " + stringBuilderTime);
        System.out.println("StringBuffer time (nanoseconds): " + stringBufferTime);
    }

    // Method to compare FileReader and InputStreamReader for reading a large file and counting words
    public static void compareFileReaders(String filePath) throws IOException {
        // Using FileReader
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            long wordCount = countWords(bufferedReader);
            System.out.println("FileReader word count: " + wordCount);
        }
        long endTime = System.nanoTime();
        long fileReaderTime = endTime - startTime;

        // Using InputStreamReader
        startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            long wordCount = countWords(bufferedReader);
            System.out.println("InputStreamReader word count: " + wordCount);
        }
        endTime = System.nanoTime();
        long inputStreamReaderTime = endTime - startTime;

        // Print the results
        System.out.println("FileReader time (nanoseconds): " + fileReaderTime);
        System.out.println("InputStreamReader time (nanoseconds): " + inputStreamReaderTime);
    }

    // Method to count words in a BufferedReader
    public static long countWords(BufferedReader reader) throws IOException {
        long wordCount = 0;
        String line;

        // Read each line from the buffered reader
        while ((line = reader.readLine()) != null) {

            // Split the line into words
            String[] words = line.split("\\s+");

            // Count the number of words
            wordCount += words.length;
        }
        return wordCount;
    }
}
