package com.regar.splitwise.services;

import com.regar.splitwise.models.User;
import com.regar.splitwise.repositories.UserRepository;
import java.util.logging.Logger;

public class UserService {
  private UserRepository userRepository;
  private Logger logger=Logger.getLogger("UserService");

  public UserService() {
    this.userRepository = new UserRepository();
  }

  public User createUser(int s, String name) {
    if (this.userRepository.findOne(s) == null) {
      User newUser = createNewUser(s, name);
      return this.userRepository.addUser(newUser);
    } else {
      logger.warning("User already exists");
      return this.userRepository.findOne(s);
    }
  }

  private User createNewUser(int s, String name) {
    return new User(s, name);
  }

}
