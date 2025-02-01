package hashmap;

import java.util.LinkedList;

// Define the custom HashMap class
class CustomHashMap {

    // Define the HashMap structure
    private static final int INITIAL_CAPACITY = 16; // Initial size of the array
    private LinkedList<Entry>[] table; // Array of linked lists (buckets)

    // Constructor to initialize the table
    public CustomHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>(); // Initialize each bucket as an empty linked list
        }
    }

    // Hash function to calculate the index for a key
    private int hash(String key) {
        return key.hashCode() % table.length;
    }

    // Inner class to represent a key-value pair
    private static class Entry {
        String key;
        String value;

        // Constructor for Entry
        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Put method to insert key-value pair into the map
    public void put(String key, String value) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        // Check if key already exists, if so update the value
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key is found
                return;
            }
        }

        // If key doesn't exist, add a new entry
        bucket.add(new Entry(key, value));
    }

    // Get method to retrieve the value for a given key
    public String get(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        // Search for the key in the corresponding bucket
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        // Return null if the key is not found
        return null;
    }

    // Remove method to delete the key-value pair from the map
    public void remove(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        // Iterate through the linked list to find and remove the entry
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry); // Remove the entry from the list
                return;
            }
        }
    }

    // Method to display the contents of the map for testing
    public void display() {
        for (int i = 0; i < table.length; i++) {
            LinkedList<Entry> bucket = table[i];
            if (!bucket.isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry entry : bucket) {
                    System.out.print("[" + entry.key + " = " + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    // Main method for testing the custom HashMap implementation
    public static void main(String[] args) {
        // Create an instance of CustomHashMap
        CustomHashMap map = new CustomHashMap();

        // Insert some key-value pairs
        map.put("name", "Anjali");
        map.put("age", "25");
        map.put("city", "New Delhi");

        // Retrieve values
        System.out.println("Name: " + map.get("name")); // Output: Alice
        System.out.println("Age: " + map.get("age"));   // Output: 25

        // Display all elements in the map
        map.display();

        // Remove an entry
        map.remove("age");

        // Display all elements after removal
        map.display();
    }
}
