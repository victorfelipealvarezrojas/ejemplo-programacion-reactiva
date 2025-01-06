package org.example.sec01.subscriber;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Subscriber;
import java.util.logging.Logger;


/**
 * Clase que implementa la interfaz Subscriber
 * esta clase se encarga de recibir emails desde un publisher, por medio de la interfaz Subscription
 */
public class SubscriberImpl implements Subscriber<String> {
    private static final Logger log = Logger.getLogger(SubscriberImpl.class.getName());

    private Subscription subscription;

    /**
     * Por medio de este metodo se recibe la subscripcion desde el publisher
     * @param subscription
     */
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
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
     * @param email
     */
    @Override
    public void onNext(String email) {
        log.info("Email received: " + email);
    }

    /**
     * Por medio de este metodo se recibe un error desde el publisher
     * @param throwable
     */
    @Override
    public void onError(Throwable throwable) {
        log.severe("ERROR: " + throwable.getMessage());
    }

    /**
     * Por medio de este metodo se recibe la notificacion de que se
     * han enviado todos los emails
     */
    @Override
    public void onComplete() {
        log.info("completed");
    }
}