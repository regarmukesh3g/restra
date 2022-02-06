package com.company.stockexchange.repositories;

import com.company.stockexchange.models.AskOffer;
import com.company.stockexchange.models.Order;
import com.company.stockexchange.models.StockInfo;
import com.company.stockexchange.utils.CompareUtil;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StockRepository {

  HashMap<String, StockInfo> stockMap = new HashMap<>();

  public void placeOrder(Order order) {


  }

  public StockInfo findOne(String stock) {
    return stockMap.get(stock);
  }

  public void createNewStock(String stock, StockInfo stockInfo) {
    stockMap.put(stock,stockInfo);
  }

  public void addOfferToStock(String stock, AskOffer askOffer) {

  }

}
