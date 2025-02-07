package com.java.inputstreamreader;

// Import necessary classes for file reading
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

// Create a class ConvertByteToChar
public class ConvertByteToChar {

    // Main method to start the flow of program
    public static void main(String[] args) {

        // Path to the text file
        String filePath = "C:\\Users\\HP\\OneDrive\\Attachments\\Hii\\src\\main\\java\\com\\java\\inputstreamreader\\BinaryFile.txt";

        // Create a FileInputStream, InputStreamReader and BufferedReader to read the file
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;

            // Read and print each line until the end of the file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        // Catch and print any IOException that occurs
        catch (IOException e) {
            e.printStackTrace();
        }
        // The file is automatically closed after reading all the lines
    }
}
