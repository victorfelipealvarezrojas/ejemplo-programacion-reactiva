package org.example.optional.threadingandscheduler;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec01DefaultBehaviorDemo {

    private static final Logger log = LoggerFactory.getLogger(Lec01DefaultBehaviorDemo.class);

    public static void main(String[] args) {

        var flux = Flux.create(sync -> {
                    for (int i = 0; i < 10; i++) {
                        log.info("generation {}", i);
                        sync.next(i);
                    }
                    sync.complete();
                })
                .doOnNext(value -> log.info("value {}", value));

        Runnable runnable = () -> flux.subscribe(Util.subscriber("subs1"));

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
