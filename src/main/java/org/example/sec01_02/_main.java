package org.example.sec01_02;

public class _main {
    public static void main(String[] args) {
        StockPricePublisher stockPricePublisher = new StockPricePublisher();
        StockPriceSubscriber stockPriceSubscriber = new StockPriceSubscriber();

        stockPricePublisher.subscribe(stockPriceSubscriber);
    }
}
