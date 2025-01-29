package com.datastructures.linkedlist.socialmediafriend;

// SocialMediaLinkedList class to manage all users and their friend connections
class SocialMediaLinkedList {
    // Head of the user linked list
    UserNode head = null;

    // Add a new user to the list
    public void addUser(int userId, String name, int age) {
        // Create new user node
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            // If list is empty, set the new user as the head
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                // Traverse to the last user node
                temp = temp.next;
            }
            // Append new user node at the end
            temp.next = newUser;
        }
    }

    // Find a user by their ID
    public UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        // Return null if user not found
        return null;
    }

    // Find a user by their name
    public UserNode findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                // Return user node if name matches
                return temp;
            }
            temp = temp.next;
        }
        // Return null if user not found
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        // Ensure both users exist and are different
        if (user1 != null && user2 != null && userId1 != userId2) {
            // Add each user as a friend to the other if not already a friend
            if (!isFriend(user1, userId2)) {
                addFriend(user1, userId2);
            }
            if (!isFriend(user2, userId1)) {
                addFriend(user2, userId1);
            }
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("Invalid user IDs or they are the same.");
        }
    }

    // Helper method to check if a user is already a friend
    private boolean isFriend(UserNode user, int friendId) {
        FriendNode friend = user.friendHead;
        while (friend != null) {
            if (friend.friendId == friendId) {
                return true; // Friend exists
            }
            friend = friend.next;
        }
        return false;
    }

    // Helper method to add a friend to a user's friend list
    private void addFriend(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        // Add new friend at the beginning of the list
        newFriend.next = user.friendHead;
        // Update the head to the new friend node
        user.friendHead = newFriend;
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            // Remove friendId2 from user1's friend list
            removeFriend(user1, userId2);
            // Remove friendId1 from user2's friend list
            removeFriend(user2, userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("Invalid user IDs.");
        }
    }

    // Helper method to remove a friend from a user's friend list
    private void removeFriend(UserNode user, int friendId) {
        FriendNode temp = user.friendHead;
        FriendNode prev = null;

        // Traverse the friend list to find the friendId
        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }

        // If friendId is found
        if (temp != null) {
            if (prev == null) {
                user.friendHead = temp.next;
            } else {
                prev.next = temp.next;
            }
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": ");
            FriendNode friend1 = user1.friendHead;
            while (friend1 != null) {
                FriendNode friend2 = user2.friendHead;
                while (friend2 != null) {
                    if (friend1.friendId == friend2.friendId) {
                        // Print mutual friend ID
                        System.out.println(friend1.friendId);
                    }
                    friend2 = friend2.next;
                }
                friend1 = friend1.next;
            }
        } else {
            System.out.println("Invalid user IDs.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            System.out.print("Friends of " + user.name + ": ");
            FriendNode friend = user.friendHead;
            while (friend != null) {
                // Print each friend's ID
                System.out.print(friend.friendId + " ");
                friend = friend.next;
            }
            System.out.println();
        } else {
            System.out.println("User not found.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode friend = temp.friendHead;
            while (friend != null) {
                // Count the number of friends
                count++;
                friend = friend.next;
            }
            System.out.println(temp.name + " has " + count + " friends.");
            temp = temp.next;
        }
    }
}
