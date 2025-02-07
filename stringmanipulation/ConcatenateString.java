package com.java.stringmanipulation;

// create a class ConcatenateString
public class ConcatenateString {

    // Method to concatenate all strings in the array using StringBuffer
    public static String concatenateString(String[] strArray, StringBuffer sb){

        // Use for each loop
        for (String str : strArray){

            // Append each string to StringBuffer
            sb.append(str);
        }
        // Return the concatenated string
        return sb.toString();
    }

    // Method to print all elements in the array

    public static void printArray(String[] strArray){

        // Use for loop
        for(int i = 0; i < strArray.length; i++){
            // Print each element followed by a space
            System.out.print(strArray[i] + " ");
        }

        // Move to the next line after printing all elements
        System.out.println();
    }

    public static void main(String[] args) {

        // Array of strings to be concatenated
        String[] strArray = {"Hello", "Mam", "Nice", "To", "Meet", "You"};

        // Print the original array
        System.out.print("Original array : ");
        printArray(strArray);

        // Create a new StringBuffer object
        StringBuffer sb = new StringBuffer();

        // Concatenate all strings in the array
        String concatenate = concatenateString(strArray, sb);

        // Print the concatenated string
        System.out.println("Concatenated String : " + concatenate);
    }
}
