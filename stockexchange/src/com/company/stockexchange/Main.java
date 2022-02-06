package com.company.stockexchange;

import com.company.stockexchange.repositories.StockRepository;
import com.company.stockexchange.services.OrderService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StockRepository stockRepository = new StockRepository();
        OrderService orderService = new OrderService(stockRepository);

        orderService.placeOrder("1 09:45 FK Sell 100 240.10");
        orderService.placeOrder("2 09:45 FK Sell 90 237.45");
        orderService.placeOrder("3 09:47 FK Buy 80 238.10");
        orderService.placeOrder("5 09:48 FK Sell 220 241.50");
        orderService.placeOrder("6 09:49 FK Buy 50 238.50");
        orderService.placeOrder("7 09:52 AZ Buy 10 100.10");
        orderService.placeOrder("8 10:01 FK Sell 20 240.10");
        orderService.placeOrder("9 10:02 FK Buy 150 242.70");




    }
}
