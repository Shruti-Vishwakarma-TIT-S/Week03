package com.java.filereader;

// Import necessary classes for file reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {

        // Path to the text file
        String filePath = "C:\\Users\\HP\\OneDrive\\Attachments\\Hii\\src\\main\\java\\com\\java\\filereader\\Story The Boy and the Starfish.txt";

        // Create a FileReader and BufferedReader to read the file
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;

            // Read and print each line until the end of the file
            while ((line = br.readLine()) != null) {
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
