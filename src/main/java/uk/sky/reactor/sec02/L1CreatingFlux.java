package uk.sky.reactor.sec02;

import reactor.core.publisher.Flux;
import uk.sky.reactor.util.Util;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

public class L1CreatingFlux {
    public static void main(String[] args) {
        /**
         * Flux emits zero or n items, at the end of which onComplete or onError is called
         */
//        Flux<Integer> flux = Flux.just(1,2,3,4);

        /**
         * The consumer interface implementation will be invoked for each piece of data emitted from flux
         * After all the data has been emitted, the consumer for onComplete is executed
         */
//        flux.subscribe(data -> System.out.println("The item received by subscriber is : " + data));

        /**
         * Fluxes can also be created using iterables like lists and arrays
         */
//        List<String> strings = List.of("a", "b", "c");
//
//        Flux<String> stringFlux = Flux.fromIterable(strings);
//        stringFlux.subscribe(data -> System.out.println("The item received by subscriber is : " + data));
//
//        Integer[] arr = {2,5,7,8};
//
//        Flux<Integer> integerFlux = Flux.fromArray(arr);
//        integerFlux.subscribe(data -> System.out.println("The item received by subscriber is : " + data));


        /**
         * Fluxes can also be created from streams
         */

//        List<Integer> list = List.of(1,2,3,4,5);
//        Stream<Integer> stream = list.stream();
//        Flux<Integer> fluxFromStream = Flux.fromStream(stream);
//        fluxFromStream.subscribe(data -> System.out.println("The item received by subscriber is : " + data));

        /**
         * Fluxes can be created using a range.
         *  emit integers between start (included) and start + count (excluded) then complete
         */
//        Flux<Integer> fluxFromRange = Flux.range(0,12);
//        fluxFromRange.subscribe(data -> System.out.println("The item received by subscriber is : " + data));

        /**
         * Flux can be created so that they emmit an item periodically at set intervals
         */
//        Flux.interval(Duration.ofSeconds(1)).subscribe(data -> System.out.println("The item received by subscriber is : " + data));
//        Util.sleepSeconds(5); // makes main thread wait for 4 seconds until processing inside flux is completed

    }
}
