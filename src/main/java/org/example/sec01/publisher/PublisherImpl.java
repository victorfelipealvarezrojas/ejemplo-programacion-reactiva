package org.example.sec01.publisher;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/** El Publisher::
 * Simplemente, va a conectar la suscripción y el Subscriber, nada más.
 */
public class PublisherImpl implements Publisher<String> {
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        // Se crea una nueva instancia de SubscriptionImpl
        var subscription = new SubscriptionImpl(subscriber); // necesita tener una referencia al subscriber
        // Se envia la subscripcion al subscriber
        subscriber.onSubscribe(subscription);
    }
}