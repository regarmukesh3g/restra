package com.regar.splitwise.models;

import com.regar.splitwise.util.ExpenseSequence;
import java.util.List;

public class Expense {
  private final int ID;
  private User user;
  private int amount;
  private List<User> memberList;
  private final int groupId;

  public Expense(User user, int amount, List<User> memberList, int id) {
    this.user = user;
    this.amount = amount;
    this.memberList = memberList;
    this.groupId = id;
    this.ID = ExpenseSequence.getNextExpenseId();
  }

}
