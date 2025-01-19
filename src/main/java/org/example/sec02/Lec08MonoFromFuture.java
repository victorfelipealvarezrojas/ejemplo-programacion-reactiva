package org.example.sec02;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/**
 * Clase que muestra como crear un Mono a partir de un Future
 * utiliza un grupo de hilos(separados) para generar el nombre
 * es eager(ansioso) por defecto y no perezoza
 */
public class Lec08MonoFromFuture {
    private static final Logger log = LoggerFactory.getLogger(Lec08MonoFromFuture.class);

    public static void main(String[] args) {
        Mono.fromFuture(() -> getName()) // () -> la vuelve lazy
                .subscribe(Util.subscriber());

        Util.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> {
            log.info("generating the name...");
            return Util.faker().name().fullName();
        });
    }


}
