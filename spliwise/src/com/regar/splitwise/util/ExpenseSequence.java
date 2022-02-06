package com.regar.splitwise.util;

public class ExpenseSequence {
  static int seq = 0;

  public static int getNextExpenseId() {
    return seq++;
  }

}
