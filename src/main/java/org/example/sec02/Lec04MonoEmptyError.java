package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {
    public static void main(String[] args) {
        getUserName(3)
                .subscribe(Util.subscriber());

    }

    private static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("user1");  //Just indica el elemento a emitir
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Not found"));
        };
    }


}
