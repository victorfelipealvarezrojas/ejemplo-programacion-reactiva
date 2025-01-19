package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5);
        Mono.fromSupplier(() -> sum(list))
                .subscribe(Util.subscriber());
    }

    private static int sum(List<Integer> list){
        System.out.println("list = " + list);
        return list.stream().mapToInt(i -> i).sum();
    }


}
