package com.regar.splitwise.controllers;

import com.regar.splitwise.services.UserService;

public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }



}
