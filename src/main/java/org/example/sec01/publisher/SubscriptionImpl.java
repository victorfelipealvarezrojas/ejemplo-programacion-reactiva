package org.example.sec01.publisher;

import com.github.javafaker.Faker;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.logging.Logger;

public class SubscriptionImpl implements Subscription {

    private static final Logger log = Logger.getLogger(SubscriptionImpl.class.getName());
    private static final int MAX_EMAILS = 10;
    private Subscriber<? super String> subscriber;
    private final Faker faker;
    private boolean isCancelled;
    private int counter = 0;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = new Faker();
    }

    @Override
    public void request(long request) {
        if (isCancelled) {
            return;
        }
        if(request > MAX_EMAILS){
            this.subscriber.onError(new RuntimeException("Request limit exceeded"));
            this.isCancelled = true;
            return;
        }
        log.info("Request received: " + request);
        for (int i = 0; i < request && counter < MAX_EMAILS; i++) {
            counter++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if (counter == MAX_EMAILS) {
            log.info("All emails were sent");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("Subscription cancelled");
        this.isCancelled = true;
    }
}
