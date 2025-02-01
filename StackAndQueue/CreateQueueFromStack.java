package com.datastructure.stackandqueue;

import java.util.Stack;

public class CreateQueueFromStack {
    // First stack to hold elements
    private Stack<Integer> stack1;

    // Second stack to reverse the elements
    private Stack<Integer> stack2;

    // Static variable to track number of elements
    static int i = 4;

    // Constructor to initialize the stacks
    CreateQueueFromStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Method to insert element into the queue
    public void enqueue(int data) {
        stack1.push(data);
        // Print the element inserted
        System.out.println("Element inserted is " + i-- + " " + data);
    }

    // Method to remove element from the queue
    public int dequeue() {
        // Transfer all elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Pop the element from stack2 (which is the front of the queue)
        int popElement = stack2.pop();

        // Transfer elements back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        // Return the element removed from the queue
        return popElement;
    }
}

class Main {
    public static void main(String[] args) {
        // Create an instance of CreateQueueFromStack
        CreateQueueFromStack queue = new CreateQueueFromStack();

        // Enqueue elements into the queue
        queue.enqueue(12);
        queue.enqueue(96);
        queue.enqueue(85);
        queue.enqueue(63);

        // Dequeue elements from the queue and print them
        System.out.println("Elements in queue are 1 " + queue.dequeue());
        System.out.println("Elements in queue are 2 " + queue.dequeue());
        System.out.println("Elements in queue are 3 " + queue.dequeue());
        System.out.println("Elements in queue are 4 " + queue.dequeue());
    }
}

