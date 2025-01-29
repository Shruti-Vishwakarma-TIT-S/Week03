package com.datastructures.linkedlist.socialmediafriend;

// FriendNode class represents a friend connection between two users
class FriendNode {
    // Friend's unique ID
    int friendId;

    // Link to the next friend in the list
    FriendNode next;

    // Constructor to initialize a friend's ID
    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}
