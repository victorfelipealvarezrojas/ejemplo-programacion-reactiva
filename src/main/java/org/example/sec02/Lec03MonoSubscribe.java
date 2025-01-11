package org.example.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    private static final Logger log = LoggerFactory.getLogger(Lec03MonoSubscribe.class);

    public static void main(String[] args) {
        // publisher
        var mono = Mono.just(1)
                .map( i -> i / 0);

        // subscriber
        mono.subscribe(
                i -> log.info("onNext: {}", i),
                err -> log.error("onError: {}", err.getMessage()),
                () -> log.info("onComplete"),
                subscription -> {
                    subscription.request(1);
                    subscription.cancel();
                }
        );
    }
}
