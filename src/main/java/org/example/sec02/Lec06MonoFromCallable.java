package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec06MonoFromCallable {
    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5);
        Mono.fromCallable(() -> sum(list)) // a diferencia de fromSupplier, puede lanzar excepciones
                .subscribe(Util.subscriber());
    }

    private static int sum(List<Integer> list) throws Exception {
        System.out.println("list = " + list);
        return list.stream().mapToInt(i -> i).sum();
    }
}
