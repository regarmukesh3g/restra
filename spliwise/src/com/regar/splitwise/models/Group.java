package com.regar.splitwise.models;

import java.util.ArrayList;
import java.util.List;

public class Group {
  private int ID;
  private String name;
  private List<User> memberList;
  private List<Expense> expenseList;

  public Group(int id, String name, List<User> memberList) {
    ID = id;
    this.name = name;
    this.memberList = memberList;
    this.expenseList = new ArrayList<>();
  }

  public List<User> getMemberList() {
    return memberList;
  }

  public void setMemberList(List<User> memberList) {
    this.memberList = memberList;
  }

  public int getID() {
    return ID;
  }

  public void addExpenseReport(Expense expense) {

    this.expenseList.add(expense);

  }

}
