package com.datastructures.linkedlist.undoredo;

// Main class to test the TextEditor functionality
public class TextEditorApp {

    public static void main(String[] args) {
        // Initialize the text editor with a history size limit of 10
        TextEditor editor = new TextEditor(10);

        // Add some text states
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, Java!");
        editor.addTextState("Java is awesome!");

        // Display the current text
        editor.displayCurrentState();

        // Perform undo operations
        editor.undo();
        editor.undo();

        // Perform redo operations
        editor.redo();

        // Add more text states
        editor.addTextState("Undo/Redo functionality is working.");
        editor.addTextState("Last added text.");

        // Display the current text
        editor.displayCurrentState();

        // Perform undo operations again
        editor.undo();
        editor.undo();
        editor.undo();

        // Display the final current text
        editor.displayCurrentState();
    }
}
