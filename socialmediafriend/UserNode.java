package com.datastructures.linkedlist.socialmediafriend;
// UserNode class represents a user with their details and a linked list of friends
class UserNode {
    // User's unique ID
    int userId;

    // User's name
    String name;

    // User's age
    int age;

    // Head of the friend linked list
    FriendNode friendHead;

    // Link to the next user node
    UserNode next;

    // Constructor to initialize the user
    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        // Initialize empty friend list
        this.friendHead = null;
        this.next = null;
    }
}

