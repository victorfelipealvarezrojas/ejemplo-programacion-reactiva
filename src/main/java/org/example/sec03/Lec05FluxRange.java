package org.example.sec03;

import com.github.javafaker.Faker;
import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {

        Faker faker = new Faker();

        Flux.range(1, 10)
                .map(i -> faker.name().fullName())
                .subscribe(Util.subscriber());
    }
}