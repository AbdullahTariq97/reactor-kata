package uk.sky.reactor.sec02;

import reactor.core.publisher.Flux;

public class L4MapAndFlatMapOperators {
    public static void main(String[] args) {

        /**
         * The .map operation maps one stream to another
         */
        Flux.just("hello", "world").
                map(String::toUpperCase)
                .subscribe(System.out::println);

        /**
         * The .flatMap operation maps one stream to many streams and then combines those streams back into one
         * hello gets its own stream and world gets its own stream/publisher
         * The two streams are then "flattened" into a single stream/publisher
        */
        Flux.just("hello", "world")
                .flatMap(str -> Flux.just(str.split("")))
                .subscribe(System.out::println);
    }
}
