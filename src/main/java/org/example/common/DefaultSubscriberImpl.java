package org.example.common;


import org.example.sec02.Lec03MonoSubscribe;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;


/**
 * Clase que implementa la interfaz Subscriber
 * esta clase se encarga de recibir emails desde un publisher, por medio de la interfaz Subscription
 */
public class DefaultSubscriberImpl<T> implements Subscriber<T> {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DefaultSubscriberImpl.class);


    private final String name;
    private Subscription subscription;

    public DefaultSubscriberImpl(String name) {
        this.name = name;
    }

    /**
     * Por medio de este metodo se recibe la subscripcion desde el publisher
     * @param subscription
     */
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(Long.MAX_VALUE);
    }

    /**
     * Por medio de este metodo se obtiene la subscripcion y es posible llamar a los
     * metodos de la interfaz Subscription como request o cancel
     * @return
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * Por medio de este metodo se recibe el email desde el publisher
     * @param item
     */
    @Override
    public void onNext(T item) {
        log.info("{} received: {}", this.name, item);
    }

    /**
     * Por medio de este metodo se recibe un error desde el publisher
     * @param throwable
     */
    @Override
    public void onError(Throwable throwable) {
        log.info("{} error: {}", this.name, throwable.getMessage());
    }

    /**
     * Por medio de este metodo se recibe la notificacion de que se
     * han enviado todos los emails
     */
    @Override
    public void onComplete() {
        log.info("{} completed", this.name);
    }
}