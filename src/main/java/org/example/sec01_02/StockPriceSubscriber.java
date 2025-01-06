package org.example.sec01_02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


public class StockPriceSubscriber implements Subscriber<Double> {

    @Override
    public void onSubscribe(Subscription subscription) {
        // Pedimos 2 precios inicialmente
        subscription.request(2);
    }

    @Override
    public void onNext(Double price) {
        if(price > 101.0) {
            System.out.println("Alerta: Precio alto! " + price);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("Error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Completado el streaming de precios");
    }
}