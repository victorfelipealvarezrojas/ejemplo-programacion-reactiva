package org.example.sec12;

import org.example.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SyncOne {
    public static void main(String[] args) {

        Sinks.One<Object> oneSink =  Sinks.one();
        oneSink.asMono().subscribe(Util.subscriber());
        oneSink.tryEmitValue("Hello");

    }
}
