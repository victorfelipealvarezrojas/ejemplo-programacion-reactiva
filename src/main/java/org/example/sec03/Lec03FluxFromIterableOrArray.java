package org.example.sec03;

import org.example.common.Util;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Lec03FluxFromIterableOrArray {
    public static void main(String[] args) {

        List<String> myArrayList = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i"));

        Flux<String> myFlux = Flux.fromIterable((myArrayList));

        myFlux.subscribe(Util.subscriber());


    }

}
