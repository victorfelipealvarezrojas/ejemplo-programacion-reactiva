package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Lec01MultipleSubscribe {

    public static void main(String[] args) {

        var flux = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9);

        flux.subscribe(Util.subscriber());
        flux.subscribe(Util.subscriber());
        flux.subscribe(Util.subscriber());

    }

}
