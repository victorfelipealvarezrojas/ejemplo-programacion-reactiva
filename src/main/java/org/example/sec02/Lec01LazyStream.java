package org.example.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Stream;


public class Lec01LazyStream {
    private static final Logger log = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {


        List<Integer> result = Stream.of(1)
                .peek(i -> log.info("received: {}", i))
                .toList(); // los steam son lazy, no se ejecutan hasta que se les pide un resultado (operador terminal)


        System.out.println("result = " + result.get(0));

    }

}
