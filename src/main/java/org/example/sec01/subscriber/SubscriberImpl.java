package org.example.sec01.subscriber;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Subscriber;
import java.util.logging.Logger;

public class SubscriberImpl implements Subscriber<String> {

    private static final Logger log = Logger.getLogger(SubscriberImpl.class.getName());
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public void onNext(String email) {
        log.info("Email received: " + email);
    }

    @Override
    public void onError(Throwable throwable) {
        log.severe("ERROR: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        log.info("completed");
    }
}