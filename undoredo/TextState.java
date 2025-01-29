package com.datastructures.linkedlist.undoredo;

// TextState class represents a state of the text content
class TextState {
    // The content of the text at a specific point
    String textContent;

    // Pointer to the previous state (for undo)
    TextState prev;

    // Pointer to the next state (for redo)
    TextState next;

    // Constructor to initialize the text content
    public TextState(String textContent) {
        this.textContent = textContent;
        this.prev = null;
        this.next = null;
    }
}

