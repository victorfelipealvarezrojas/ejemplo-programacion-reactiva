package org.example.sec01_02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.concurrent.Flow;

public class StockPriceSubscription implements Subscription {

    private final Subscriber<? super Double> subscriber;
    private final List<Double> prices;
    private int currentIndex = 0;
    private boolean cancelled = false;

    public StockPriceSubscription(Subscriber<? super Double> subscriber, List<Double> prices) {
        this.subscriber = subscriber;
        this.prices = prices;
    }

    @Override
    public void request(long n) {
        if (cancelled) return;

        // Emitimos n precios o hasta acabar la lista
        for (int i = 0; i < n && currentIndex < prices.size(); i++) {
            subscriber.onNext(prices.get(currentIndex));
            currentIndex++;
        }

        // Si llegamos al final, notificamos completado
        if (currentIndex >= prices.size()) {
            subscriber.onComplete();
        }
    }

    @Override
    public void cancel() {
        this.cancelled = true;
    }
}
