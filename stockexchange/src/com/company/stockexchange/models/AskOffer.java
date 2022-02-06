package com.company.stockexchange.models;

public class AskOffer implements Comparable<AskOffer> {
  private final float price;
  private final TradeTime time;
  private int quantity;

  public float getPrice() {
    return price;
  }

  public TradeTime getTime() {
    return time;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getOrderId() {
    return orderId;
  }

  private final int orderId;

  public AskOffer(float price, TradeTime time, int quantity, int id) {
    this.price=price;
    this.time = time;
    this.quantity=quantity;
    this.orderId = id;
  }


  @Override
  public int compareTo(AskOffer o) {
    if(this.getPrice()<o.getPrice())
      return -1;
    if(this.getPrice()>o.getPrice())
      return 1;

    return this.getTime().compareTo(o.getTime());

  }

}
