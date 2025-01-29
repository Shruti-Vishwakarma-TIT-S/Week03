package com.datastructures.linkedlist.inventorymanagement;

// Define the Singly Linked List class to manage inventory
class InventoryLinkedList {

    // Head of the linked list
    Node head;

    // Static inner Node class
    static class Node {

        // Item details
        Item item;

        // Points to the next node
        Node next;

        // Constructor to create a new node
        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    // Add an item at the beginning
    public void addAtBeginning(Item item) {

        // Create a new node with the item
        Node newNode = new Node(item);

        // Point the new node to the current head
        newNode.next = head;

        // Update the head to point to the new node
        head = newNode;
    }

    // Add an item at the end
    public void addAtEnd(Item item) {

        // Create a new node with the item
        Node newNode = new Node(item);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse the list to find the last node
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            // Append the new node to the end of the list
            temp.next = newNode;
        }
    }

    // Add an item at a specific position
    public void addAtPosition(int position, Item item) {

        // If the position is 0, add at the beginning
        if (position == 0) {
            addAtBeginning(item);
            return;
        }

        // Create a new node with the item
        Node newNode = new Node(item);

        // Traverse the list to find the correct position
        Node temp = head;
        int count = 0;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        // If the position is out of range
        if (temp == null) {
            System.out.println("Position out of range");
        } else {
            // Insert the new node at the specified position
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Remove an item based on Item ID
    public void removeByItemId(int itemId) {

        // If the list is empty, print a message and return
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        // If the item to be removed is the first item
        if (head.item.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }

        // Traverse the list to find the item with the given ID
        Node temp = head;
        Node prev = null;

        while (temp != null && temp.item.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }

        // If the item was not found
        if (temp == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            // Remove the item by updating the previous node's next pointer
            prev.next = temp.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityById(int itemId, int newQuantity) {

        // Traverse the list to find the item
        Node temp = head;
        while (temp != null) {
            if (temp.item.itemId == itemId) {
                // Update the item's quantity
                temp.item.quantity = newQuantity;
                System.out.println("Quantity of item with ID " + itemId + " updated to " + newQuantity);
                return;
            }
            temp = temp.next;
        }

        // If the item is not found
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchByItemId(int itemId) {

        // Traverse the list to find the item by ID
        Node temp = head;
        while (temp != null) {
            if (temp.item.itemId == itemId) {
                // Print the item details
                System.out.println("Item found: " + temp.item.itemName + ", ID: " + itemId + ", Quantity: " + temp.item.quantity + ", Price: " + temp.item.price);
                return;
            }
            temp = temp.next;
        }

        // If the item is not found
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchByItemName(String itemName) {

        // Traverse the list to find the item by name
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.item.itemName.equalsIgnoreCase(itemName)) {
                // Print the item details
                System.out.println("Item found: " + temp.item.itemName + ", ID: " + temp.item.itemId + ", Quantity: " + temp.item.quantity + ", Price: " + temp.item.price);
                found = true;
            }
            temp = temp.next;
        }

        // If no items were found with the given name
        if (!found) {
            System.out.println("Item with name " + itemName + " not found.");
        }
    }

    // Calculate and display the total value of the inventory (Quantity * Price)
    public void calculateTotalValue() {

        // Initialize the total value
        double totalValue = 0;

        // Traverse the list and calculate the total value
        Node temp = head;
        while (temp != null) {
            totalValue += temp.item.quantity * temp.item.price;
            temp = temp.next;
        }

        // Print the total value
        System.out.println("Total value of inventory: Rs " + totalValue);
    }

    // Sort the inventory based on Item Name in ascending or descending order
    public void sortByItemName(boolean ascending) {

        // If the list is empty or has only one item, no sorting is needed
        if (head == null || head.next == null) {
            return;
        }

        // Convert the linked list to an array for sorting
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Create an array of items from the linked list
        Item[] itemsArray = new Item[size];
        temp = head;
        int index = 0;
        while (temp != null) {
            itemsArray[index++] = temp.item;
            temp = temp.next;
        }

        // Sort the array based on Item Name
        for (int i = 0; i < itemsArray.length - 1; i++) {
            for (int j = i + 1; j < itemsArray.length; j++) {
                if ((ascending && itemsArray[i].itemName.compareToIgnoreCase(itemsArray[j].itemName) > 0) ||
                        (!ascending && itemsArray[i].itemName.compareToIgnoreCase(itemsArray[j].itemName) < 0)) {
                    // Swap items in the array
                    Item tempItem = itemsArray[i];
                    itemsArray[i] = itemsArray[j];
                    itemsArray[j] = tempItem;
                }
            }
        }

        // Rebuild the linked list with the sorted items
        head = null;
        for (int i = 0; i < itemsArray.length; i++) {
            addAtEnd(itemsArray[i]);
        }

        // Print the sorting status
        System.out.println("Inventory sorted by Item Name " + (ascending ? "ascending" : "descending") + ".");
    }

    // Sort the inventory based on Price in ascending or descending order
    public void sortByPrice(boolean ascending) {

        // If the list is empty or has only one item, no sorting is needed
        if (head == null || head.next == null) {
            return;
        }

        // Convert the linked list to an array for sorting
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Create an array of items from the linked list
        Item[] itemsArray = new Item[size];
        temp = head;
        int index = 0;
        while (temp != null) {
            itemsArray[index++] = temp.item;
            temp = temp.next;
        }

        // Sort the array based on Price
        for (int i = 0; i < itemsArray.length - 1; i++) {
            for (int j = i + 1; j < itemsArray.length; j++) {
                if ((ascending && itemsArray[i].price > itemsArray[j].price) ||
                        (!ascending && itemsArray[i].price < itemsArray[j].price)) {
                    // Swap items in the array
                    Item tempItem = itemsArray[i];
                    itemsArray[i] = itemsArray[j];
                    itemsArray[j] = tempItem;
                }
            }
        }

        // Rebuild the linked list with the sorted items
        head = null;
        for (int i = 0; i < itemsArray.length; i++) {
            addAtEnd(itemsArray[i]);
        }

        // Print the sorting status
        System.out.println("Inventory sorted by Price " + (ascending ? "ascending" : "descending") + ".");
    }

    // Display all items in the inventory
    public void displayInventory() {

        // If the list is empty, print a message and return
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        // Traverse and print all items
        Node temp = head;
        System.out.println("Inventory:");
        while (temp != null) {
            System.out.println("Item Name: " + temp.item.itemName + ", ID: " + temp.item.itemId + ", Quantity: " + temp.item.quantity + ", Price: Rs " + temp.item.price);
            temp = temp.next;
        }
    }

    // Main function to test the inventory management system
    public static void main(String[] args) {

        // Create an inventory linked list
        InventoryLinkedList inventory = new InventoryLinkedList();

        // Add some items to the inventory
        inventory.addAtEnd(new Item("Laptop", 101, 10, 800.00));
        inventory.addAtEnd(new Item("Smartphone", 102, 15, 500.00));
        inventory.addAtEnd(new Item("Tablet", 103, 20, 300.00));
        inventory.addAtEnd(new Item("Headphones", 104, 30, 50.00));

        // Display the inventory
        inventory.displayInventory();

        // Update the quantity of an item by ID
        inventory.updateQuantityById(102, 18);

        // Remove an item based on Item ID
        inventory.removeByItemId(104);

        // Search for an item by Item ID
        inventory.searchByItemId(103);

        // Search for an item by Item Name
        inventory.searchByItemName("Laptop");

        // Calculate and display the total value of the inventory
        inventory.calculateTotalValue();

        // Sort the inventory by Item Name (ascending)
        inventory.sortByItemName(true);

        // Display the sorted inventory
        inventory.displayInventory();

        // Sort the inventory by Price (descending)
        inventory.sortByPrice(false);

        // Display the sorted inventory
        inventory.displayInventory();
    }
}


