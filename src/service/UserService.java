package service;

import java.util.HashMap;

import models.User;

public class UserService {

    // HashMap<String, User> allUsers = new HashMap<>();

    public void addUserToHashmap(User user, HashMap<String, User> allUsers) {
        allUsers.put(user.getUserName(), user);
    }

    public User addUser(String username, HashMap<String, User> allUsers){
        User user = new User(username);
        addUserToHashmap(user, allUsers);
        return user;
    }

    public User wantUser(String username, HashMap<String, User> allUsers){
        return allUsers.get(username);
    }




}
