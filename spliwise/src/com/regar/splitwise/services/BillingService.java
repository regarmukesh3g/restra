package com.regar.splitwise.services;

import com.regar.splitwise.models.Expense;
import com.regar.splitwise.models.Group;
import com.regar.splitwise.models.User;

public class BillingService {
  public int addExpense(User user, int amount, Group group) {
    Expense expense = new Expense(user,amount,group.getMemberList(),group.getID());
    group.addExpenseReport(expense);
    return expense.getID();
  }

}
