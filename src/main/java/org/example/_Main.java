package org.example;

import org.example.sec01.publisher.PublisherImpl;
import org.example.sec01.subscriber.SubscriberImpl;

import java.time.Duration;


public class _Main {
    public static void main(String[] args) throws InterruptedException {
        demo4();
    }

    private static void demo1(){
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    private static void demo2() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2L).toMillis());
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
    }

    private static void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().cancel();
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2L).toMillis());
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
    }

    private static void demo4() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(55);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(5);
        Thread.sleep(Duration.ofSeconds(2L).toMillis());
        subscriber.getSubscription().request(11);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
    }
}