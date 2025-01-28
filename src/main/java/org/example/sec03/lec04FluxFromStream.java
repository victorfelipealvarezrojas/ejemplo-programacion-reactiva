package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class lec04FluxFromStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i"));

        Stream<String> stream = list.stream();

        // se procesa una vez y se cierra porque el stream no es reutilizable
    var flux = Flux.fromStream(stream); // si uso un suplier, puedo reutilizar el stream y el flujo " () -> list.stream()"

        flux.subscribe(Util.subscriber());

        flux.subscribe(Util.subscriber()); // no se puede reutilizar el stream

        flux.subscribe(Util.subscriber()); // no se puede reutilizar el stream


    }
}
