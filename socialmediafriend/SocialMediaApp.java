package com.datastructures.linkedlist.socialmediafriend;

// Main class for testing the social media system
public class SocialMediaApp {

    public static void main(String[] args) {
        // Create a social media system
        SocialMediaLinkedList socialMedia = new SocialMediaLinkedList();

        // Add users to the system (using Indian names)
        socialMedia.addUser(1, "Amit", 25);
        socialMedia.addUser(2, "Priya", 30);
        socialMedia.addUser(3, "Ravi", 22);
        socialMedia.addUser(4, "Sita", 28);

        // Create friend connections (using Indian names)
        // Amit and Priya are friends
        socialMedia.addFriendConnection(1, 2);
        // Priya and Ravi are friends
        socialMedia.addFriendConnection(2, 3);
        // Ravi and Sita are friends
        socialMedia.addFriendConnection(3, 4);
        // Amit and Ravi are friends
        socialMedia.addFriendConnection(1, 3);

        // Display friends of a specific user
        // Amit's friends
        socialMedia.displayFriends(1);
        // Priya's friends
        socialMedia.displayFriends(2);

        // Find mutual friends between two users
        socialMedia.findMutualFriends(1, 3);

        // Count the number of friends for each user
        socialMedia.countFriends();

        // Remove a friend connection
        socialMedia.removeFriendConnection(1, 2);

        // Display friends after removing connection
        socialMedia.displayFriends(1);
        socialMedia.displayFriends(2);
    }
}
