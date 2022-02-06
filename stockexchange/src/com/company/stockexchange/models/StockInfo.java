package com.company.stockexchange.models;

import java.util.PriorityQueue;

public class StockInfo {


  public PriorityQueue<AskOffer> getAskOfferList() {
    return askOfferList;
  }

  PriorityQueue<AskOffer> askOfferList = new PriorityQueue<>();

  public void addAsk(AskOffer askOffer) {
    askOfferList.add(askOffer);
  }

}
