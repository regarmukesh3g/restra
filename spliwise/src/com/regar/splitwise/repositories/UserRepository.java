package com.regar.splitwise.repositories;

import com.regar.splitwise.models.User;
import java.util.HashMap;

public class UserRepository {

  private HashMap<Integer, User> userMap;

  public UserRepository() {
    HashMap<Integer, User> userMap = new HashMap<>();
    this.userMap = userMap;
  }

  public User findOne(int s) {
    return this.userMap.get(s);
  }

  public User addUser(User newUser) {
    this.userMap.put(newUser.getPhoneNumber(),newUser);
    return newUser;
  }

}

