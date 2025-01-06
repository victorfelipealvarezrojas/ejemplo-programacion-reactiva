package org.example.sec01_02;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;
import java.util.List;


public class StockPricePublisher implements Publisher<Double> {
    private List<Double> prices = Arrays.asList(100.0, 101.5, 102.0);

    @Override
    public void subscribe(Subscriber<? super Double> subscriber) {
        StockPriceSubscription subscription = new StockPriceSubscription(subscriber, prices);
        subscriber.onSubscribe(subscription);
    }
}
