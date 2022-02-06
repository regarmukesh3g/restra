package com.regar.splitwise.models;

public class User {
  int phoneNumber;
  String name;

  public User(int s, String name) {
    this.phoneNumber=s;
    this.name=name;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}
