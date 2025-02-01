package org.example.sec04;

import org.example.common.Util;
import org.example.sec01.publisher.SubscriptionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateDownStreamDemand {

    private static final Logger log = LoggerFactory.getLogger(Lec04FluxCreateDownStreamDemand.class);

    public static void main(String[] args) {
        var subscriber = new SubscriptionImpl(null);
        Flux.create(fluxSink -> {
            for(int i = 0; i < 10; i++) {
                var name = Util.faker().name().fullName();
                log.info("Emitting: {}", name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(Util.subscriber());

    }
}
