package com.company.stockexchange.services;

import com.company.stockexchange.models.AskOffer;
import com.company.stockexchange.models.Order;
import com.company.stockexchange.models.StockInfo;
import com.company.stockexchange.models.TradeTime;
import com.company.stockexchange.repositories.StockRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderService {

  private StockRepository stockRepository;

  public OrderService(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  public void placeOrder(String s) {

    Order order = new Order(s);
    String stock = order.getStock();
    StockInfo existingStockInfo = stockRepository.findOne(stock);

    if (order.getOrderType().equals("Sell")) {
      sellStock(order, existingStockInfo);
    } else {
      buyStock(order, existingStockInfo);
    }
  }

  private void buyStock(Order order, StockInfo existingStockInfo) {
    if (existingStockInfo == null) {
      System.out.println("No offers yet");
    } else {
      // TODO: buy from stock;
      int buyQuantity = order.getQuantity();
      int boughtQuantity = 0;
      PriorityQueue<AskOffer> askQueue = existingStockInfo.getAskOfferList();
      while (boughtQuantity < buyQuantity) {
        AskOffer poll = askQueue.poll();
        float price = poll.getPrice();
        if (price > order.getPrice()) {
          askQueue.add(poll);
          break;
        }
        TradeTime offerTime = poll.getTime();
        List<AskOffer> offerList = new ArrayList<>();
        while (poll != null && poll.getPrice() == price && poll.getTime() == offerTime) {
          offerList.add(poll);
          poll = askQueue.poll();
        }

        if (poll != null && (poll.getPrice() != price
            || Objects.requireNonNull(poll).getTime() != offerTime)) {
          askQueue.add(poll);
        }
        Integer total = 0;
        Set<Integer> collect = offerList.stream().map(AskOffer::getQuantity)
            .collect(Collectors.toSet());
        for (Integer offer : collect) {
          total += offer;
        }
        if (total < buyQuantity) {
          // BuyAll
          boughtQuantity = buyAllFromOffer(offerList, order, boughtQuantity);
        } else {
          boughtQuantity = buyInProportion(offerList, order, boughtQuantity, buyQuantity, total,
              askQueue);
        }
      }
    }
  }

  private int buyAllFromOffer(List<AskOffer> offerList, Order order, int boughtQuantity) {
    for (AskOffer offer : offerList) {
      boughtQuantity = buyFromOffer(offer, offer.getQuantity(), boughtQuantity, order);
    }
    return boughtQuantity;
  }

  private int buyInProportion(List<AskOffer> offerList, Order order, int boughtQuantity,
      int buyQuantity, Integer total,
      PriorityQueue<AskOffer> askQueue) {
    for (AskOffer offer : offerList) {

      float proportion = offer.getQuantity() / total;
      int buyFromThis = (int) (proportion * (buyQuantity - boughtQuantity));
      if (buyFromThis < offer.getQuantity()) {
        boughtQuantity = buyFromOffer(offer, buyFromThis, boughtQuantity, order);
      } else {
        boughtQuantity = buyFromOffer(offer, offer.getQuantity(), boughtQuantity, order);
      }
      total -= boughtQuantity;
      if (offer.getQuantity() > 0) {
        askQueue.add(offer);
      }
    }
    return boughtQuantity;
  }

  private int buyFromOffer(AskOffer offer, int buyFromThis, int boughtQuantity, Order order) {
    System.out.println(offer.getOrderId() + " " + order.getId() + " " + buyFromThis + " " + offer
        .getPrice());
    boughtQuantity += buyFromThis;
    offer.setQuantity(offer.getQuantity() - buyFromThis);
    return boughtQuantity;
  }

  private void sellStock(Order order, StockInfo existingStockInfo) {
    AskOffer askOffer = new AskOffer(order.getPrice(), order.getTime(), order.getQuantity(),
        order.getId());
    if (existingStockInfo == null) {
      StockInfo stockInfo = new StockInfo();
      stockInfo.addAsk(askOffer);
      stockRepository.createNewStock(order.getStock(), stockInfo);
    } else {
      existingStockInfo.addAsk(askOffer);
    }
  }

}
