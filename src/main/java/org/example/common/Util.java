package org.example.common;

import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Util {
    public static <T> Subscriber<T> subscriber() {
        return new DefaultSubscriberImpl<>("");
    }

    public static <T> Subscriber<T> subscriber(String name) {
        return new DefaultSubscriberImpl<>(name);
    }

    public static void main(String[] args) {
        var mono = Mono.just(1);
        mono.subscribe(subscriber("subs1"));
        mono.subscribe(subscriber("subs2"));
    }
}