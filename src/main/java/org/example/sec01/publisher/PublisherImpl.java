package org.example.sec01.publisher;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;


/**
 * Clase que implementa la interfaz Publisher
 * esta clase se encarga de enviar emails a un subscriber
 * implementa el editor de flujo de datos
 */
public class PublisherImpl implements Publisher<String> {
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        // Se crea una nueva instancia de SubscriptionImpl
        var subscription = new SubscriptionImpl(subscriber);
        // Se envia la subscripcion al subscriber
        subscriber.onSubscribe(subscription);
    }
}