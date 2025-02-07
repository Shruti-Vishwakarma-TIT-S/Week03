package com.java.inputstreamreader;
// Import necessary packages
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInput {
    public static void main(String[] args) {
        // Create an InputStreamReader to read bytes from the console
        try (InputStreamReader isr = new InputStreamReader(System.in);

             // Wrap the InputStreamReader in a BufferedReader for efficient reading
             BufferedReader reader = new BufferedReader(isr)) {

            // Enter the file path
            System.out.println("Please enter the file path where you want to save the input:");

            // Read the file path from the console
            String filePath = reader.readLine();

            // Create a FileWriter to write to the specified file
            try (FileWriter writer = new FileWriter(filePath)) {
                String userInput;
                System.out.println("Enter text (type 'exit' to quit):");

                // Read user input and write to the file until "exit" is entered
                while (!(userInput = reader.readLine()).equalsIgnoreCase("exit")) {

                    // Write the input to the file with a new line
                    writer.write(userInput + System.lineSeparator());
                }

                // Inform the user that the input has been saved
                System.out.println("Input has been saved to '" + filePath + "'.");
            }

        } catch (IOException e) {
            // Handle any IO exceptions
            e.printStackTrace();
        }
    }
}
