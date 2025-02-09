package org.example.sec05;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec01Handle {

    private static final Logger log = LoggerFactory.getLogger(Lec01Handle.class);

    public static void main(String[] args) {
        Flux.range(1, 10)
                .filter(item -> item != 7)
                .handle((item, sink) -> {
                    switch (item) {
                        case 1 -> sink.next(-2);
                        case 4 -> {}
                        case 7 -> sink.error(new RuntimeException("Error occurred at: " + item));
                        default -> sink.next(item);
                    }
                })
                .cast(Integer.class)
                .subscribe(Util.subscriber());


    }
}
