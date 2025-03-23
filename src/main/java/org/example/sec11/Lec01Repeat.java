package org.example.sec11;

import org.example.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Lec01Repeat {
    public static void main(String[] args) {

        var mono = Mono.fromSupplier(() -> Util.faker().name().fullName());

        mono.repeat(3).subscribe(Util.subscriber());

    }
}
