package com.asymptoticnotations.readingdirectory;

// Import necessary classes for file reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class FilereaderInputstream {

    // Method to read a file using InputStreamReader (Byte Stream)
    public void inputstreamreader(String filepath) {

        // Record the start time for performance measurement
        long startTime = System.nanoTime();

        try (FileInputStream fileInputStream = new FileInputStream(filepath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 32 * 1024)) {

            // Variable to store each line while reading
            String line;

            // Read file line by line until the end
            while ((line = bufferedReader.readLine()) != null) {
                // Do just reading the file to measure performance
            }

        }
        // Catch any IOException if file reading fails
        catch (IOException e) {
            e.printStackTrace();
        }

        // Record the end time for performance measurement
        long endTime = System.nanoTime();

        // Print the total time taken to read the file using InputStreamReader
        System.out.println("\nUsing InputStreamReader it takes " + (endTime - startTime) / 1e6 + " ms ");
    }

    // Method to read a file using FileReader (Character Stream)
    public void filereader(String filepath) {

        // Record the start time for performance measurement
        long startTime = System.nanoTime();

        try (FileReader fr = new FileReader(filepath);
             BufferedReader br = new BufferedReader(fr, 32 * 1024)) {

            // Variable to store each line while reading
            String line;

            // Read file line by line until the end
            while ((line = br.readLine()) != null) {
                // Do just reading the file to measure performance
            }

        }
        // Catch any IOException if file reading fails
        catch (IOException e) {
            e.printStackTrace();
        }

        // Record the end time for performance measurement
        long endTime = System.nanoTime();

        // Print the total time taken to read the file using FileReader
        System.out.println("\nUsing FileReader it takes " + (endTime - startTime) / 1e6 + " ms ");
    }

    // Main method to execute the file reading tests
    public static void main(String[] args) {

        // Create an instance of FilereaderInputstream class
        FilereaderInputstream file = new FilereaderInputstream();

        // Define the file path (Make sure this file exists)
        String filepath = "C:\\Users\\HP\\OneDrive\\Attachments\\Day06\\src\\main\\java\\com\\asymptoticnotations\\readingdirectory\\Story The Boy and the Starfish.txt";

        // Call the method to read the file using FileReader
        file.filereader(filepath);

        // Call the method to read the file using InputStreamReader
        file.inputstreamreader(filepath);
    }
}
