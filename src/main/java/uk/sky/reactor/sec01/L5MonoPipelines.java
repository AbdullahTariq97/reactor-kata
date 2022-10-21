package uk.sky.reactor.sec01;

import reactor.core.publisher.Mono;
import uk.sky.reactor.util.Util;

public class L5MonoPipelines {
    public static void main(String[] args) {

        Mono<Integer> monoMap = Mono.just("ball")
                .map(String::length) // you return an object and the .map method wraps it inside a publisher
                .map(l -> l/1);

        monoMap.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

//      The usefulness of flatmap will become more clearer when we get to fluxes
        Mono<String> monoFlatMap = Mono.just("ball")
                .flatMap(str -> Mono.just("bat")); // you have to wrap the object inside a publisher yourself

        monoFlatMap.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
