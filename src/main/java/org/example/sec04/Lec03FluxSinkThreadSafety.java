package org.example.sec04;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class Lec03FluxSinkThreadSafety {

    private static final Logger log = LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);

    public static void main(String[] args) throws InterruptedException {
        demo2();
    }

    private static void demo() {
        var myList = new ArrayList<>();
        Runnable runable = () -> {
            for (int i = 0; i < 1000; i++) {
                myList.add(i);
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runable).start();
        }
        Util.sleepSeconds(3);
        log.info("demo Size: {}", myList.size());
    }

    private static void demo2() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(10);

        var myList = new ArrayList<String>();
        var flux = Flux.create(generator);
        flux.subscribe(myList::add);

        Runnable runable = () -> {
            for (int i = 0; i < 1000; i++) {
                generator.generate();
            }
            latch.countDown();
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runable).start();
        }
        latch.await();
        log.info("demo2 Size: {}", myList.size());
    }

    static GeneratorConsumer<String> generator = new GeneratorConsumer<>(() ->
            new Faker().pokemon().name()
    );

    static class GeneratorConsumer<T> implements Consumer<FluxSink<T>> {
        private FluxSink<T> sink;
        private final Supplier<T> supplier;

        public GeneratorConsumer(Supplier<T> supplier) {
            this.supplier = supplier;
        }

        @Override
        public void accept(FluxSink<T> sink) {
            this.sink = sink;
        }

        public void generate() {
            if (sink != null) {
                sink.next(supplier.get());
            }
        }
    }
}
