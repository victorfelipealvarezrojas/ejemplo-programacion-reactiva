package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec07MonoFromRunable {
    public static void main(String[] args) {
        getProductName(2).subscribe(Util.subscriber());
    }

    private static Mono<String> getProductName(int productId) {
        if (productId == 1) {
            return Mono.fromSupplier(() -> Util.faker().commerce().productName());
        }
        return Mono.fromRunnable(() -> notifyBusiness(productId)); // a diferencia de fromSupplier, no retorna nada
    }

    private static void notifyBusiness(int productId){
        System.out.println("Notifying the business");
    }
}
