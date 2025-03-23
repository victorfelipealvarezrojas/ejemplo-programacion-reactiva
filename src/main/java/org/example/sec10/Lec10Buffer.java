package org.example.sec10;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec10Buffer {
    public static void main(String[] args) {
        demo();
        Util.sleepSeconds(60);
    }

    private static void demo() {
        eventStream()
                .buffer(2)
                .subscribe(Util.subscriber());
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                //.take(10)
                .map(i -> "event" + i);
    }
}
