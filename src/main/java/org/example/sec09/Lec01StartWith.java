package org.example.sec09;

import org.example.common.Util;
import org.example.sec05.Lec01Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01StartWith {

    private static final Logger log = LoggerFactory.getLogger(Lec01StartWith.class);

    public static void main(String[] args) {
            producer1()
                    .startWith(producer2()) // es una forma de agregar elementos al inicio del flujo existente pero no es otro productor
                    //.take(2) // take(2) solo toma los primeros 2 elementos
                    .subscribe(Util.subscriber());

            Util.sleepSeconds(3);
    }

    private static Flux<Integer> producer1(){
        return Flux.just(1,2,3,4)
                .doOnSubscribe(s -> log.info("Subscribing to producer 1"))
                .delayElements(Duration.ofMillis(10));

    }

    private static Flux<Integer> producer2(){
        return Flux.just(1,2,3,4)
                .doOnSubscribe(s -> log.info("Subscribing to producer 2"))
                .delayElements(Duration.ofMillis(10));

    }


}
