package com.company.stockexchange.models;

public class Order {
  int id;
  TradeTime time;
  String stock;
  String orderType;
  int quantity;
  float price;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Order(String s) {
    String[] args = s.split(" ");
    id = Integer.parseInt(args[0]);
    time = new TradeTime(args[1]);
    stock = args[2];
    orderType = args[3];
    quantity = Integer.parseInt(args[4]);
    price = Float.parseFloat(args[5]);
  }

  public TradeTime getTime() {
    return time;
  }

  public void setTime(TradeTime time) {
    this.time = time;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getStock() {
    return stock;
  }

  public void setStock(String stock) {
    this.stock = stock;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

}
