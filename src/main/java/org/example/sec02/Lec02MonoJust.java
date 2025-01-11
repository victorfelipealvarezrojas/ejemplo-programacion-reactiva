package org.example.sec02;

import org.example.common.Util.*;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import static org.example.common.Util.subscriber;

public class Lec02MonoJust {
    public static void main(String[] args) {
        Publisher<String> mono = Mono.just("valvarez stream"); // elemento a emitir

        // Los Publishers en programación reactiva son "fríos" (cold publishers),
        // lo que significa que no emiten datos hasta que alguien se suscribe a ellos.
        System.out.println("mono = " + mono);


        mono.subscribe(subscriber("subs1"));




    }
}