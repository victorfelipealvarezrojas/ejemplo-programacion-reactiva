package org.example.sec04;

import com.github.javafaker.Faker;
import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int x = 0; x < 10; x++) {
                fluxSink.next(new Faker().pokemon().name());
            }
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
