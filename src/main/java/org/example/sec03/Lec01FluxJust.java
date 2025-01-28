package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Lec01FluxJust {

    public static void main(String[] args) {
        List<Integer> myArrayList = new ArrayList<>(List.of(1, 2, 3, 8, 12, 4, 5, 20, 11));

        Flux.just(myArrayList)
                .subscribe(Util.subscriber());

    }

}
