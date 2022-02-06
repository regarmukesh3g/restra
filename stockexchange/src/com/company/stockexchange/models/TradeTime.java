package com.company.stockexchange.models;

public class TradeTime implements Comparable<TradeTime> {
  int hour;
  int minute;

  public TradeTime(String arg) {
    String[] split = arg.split(":");
    hour = Integer.parseInt(split[0]);
    minute = Integer.parseInt(split[1]);
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  public int compareTo(TradeTime time) {

    if (this.getHour() < time.getHour()) {
      return -1;
    }
    if (this.getHour() > time.getHour()) {
      return 1;
    }
    if (this.getMinute() < time.getMinute()) {
      return -1;
    }
    if (this.getMinute() > time.getMinute()) {
      return 1;
    }
    return 0;
  }

}
