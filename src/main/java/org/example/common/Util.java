package org.example.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Util {

    private final static Faker  faker = Faker.instance();

    public static <T> Subscriber<T> subscriber() {
        return new DefaultSubscriberImpl<>("");
    }

    public static <T> Subscriber<T> subscriber(String name) {
        return new DefaultSubscriberImpl<>(name);
    }

    public static Faker faker(){
        return faker;
    }

    public static void sleepSeconds(int seconds) {
        try {
            sleep(Duration.ofSeconds(seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}