package com.datastructures.linkedlist.inventorymanagement;

// Item class to store information about an inventory item
class Item {

    // Item Name
    String itemName;

    // Item ID
    int itemId;

    // Item Quantity
    int quantity;

    // Item Price
    double price;

    // Constructor to initialize item details
    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
}

