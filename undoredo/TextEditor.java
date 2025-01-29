package com.datastructures.linkedlist.undoredo;

// TextEditor class implements the Undo/Redo functionality
class TextEditor {
    // Head of the doubly linked list (points to the first state)
    TextState head;

    // Tail of the doubly linked list (points to the latest state)
    TextState tail;

    // Current pointer to the latest state
    TextState current;

    // Counter for limiting the history size (maximum of 10 states in history)
    int historySize;

    // Constructor to initialize the editor with history size limit
    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    // Add a new text state to the editor (after an action like typing)
    public void addTextState(String text) {
        // Create a new text state with the given text
        TextState newState = new TextState(text);

        // If the editor has no text history yet
        if (head == null) {
            head = newState;
            tail = newState;
            current = newState;
        } else {
            // If we are in the middle of the history (i.e., after undo, redo)
            if (current.next != null) {
                // Remove all future states (for redo)
                current.next = null;
                tail = current;
            }
            // Link the new state to the current state
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = current;
        }

        // Limit the history size to the last 'historySize' states
        limitHistorySize();
    }

    // Limit the history size to the last 'historySize' states
    private void limitHistorySize() {
        int count = 0;
        TextState temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // If the history exceeds the limit, remove the oldest state
        if (count > historySize) {
            head = head.next;
            head.prev = null;
        }
    }

    // Undo functionality - go back to the previous text state
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.textContent);
        } else {
            System.out.println("No more undo actions.");
        }
    }

    // Redo functionality - go forward to the next text state
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.textContent);
        } else {
            System.out.println("No more redo actions.");
        }
    }

    // Display the current text content
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.textContent);
        } else {
            System.out.println("No text available.");
        }
    }
}
