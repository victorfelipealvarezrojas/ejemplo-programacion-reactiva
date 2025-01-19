package org.example.sec02;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Clase que muestra como crear un Mono Defer y como se comporta.
 * <p>
 *     - Mono.defer() es una fábrica que permite crear un Mono a partir de un supplier.
 *     - El supplier se ejecuta cada vez que se suscribe un subscriber.
 *     - Se puede usar para crear un Mono a partir de un recurso que no se puede reutilizar.
 *     - además de retrazar la creación del Mono hasta que se suscriba un subscriber.
 */
public class Lec10MonoDefer {
    private static final Logger log = LoggerFactory.getLogger(Lec10MonoDefer.class);

    public static void main(String[] args) {
        Mono.defer(Lec10MonoDefer::createPublisher) // defer se ejecuta cada vez que se suscribe un subscriber
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> createPublisher(){
        log.info("createPublisher");
        var list = List.of(1, 2, 3, 4, 5);
        Util.sleepSeconds(3);
        return Mono.fromSupplier(() -> sum(list));
    }

    private static int sum(List<Integer> list){
        log.info("list = {}", list);
        Util.sleepSeconds(3);
        return list.stream().mapToInt(i -> i).sum();
    }



}
