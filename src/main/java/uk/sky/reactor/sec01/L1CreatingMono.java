package uk.sky.reactor.sec01;

import reactor.core.publisher.Mono;
import uk.sky.reactor.util.Util;

public class L1CreatingMono {
    public static void main(String[] args) {

//        Take them through util subscriber and util package classes

        /**
         * How to create a Mono source?
         * Use this method only if you are sure data is available Otherwise it will through null pointer exception
         * Mono wraps the string object
         * The Mono may be empty initially and the data may arrive sometime in the future.
         * In this case it will arrive instantly as there is nothing delaying it
         */
//        Mono<String> mono = Mono.just("some data");

        /**
         * No data will be emitted by the Mono as we are not subscribed to this publisher using .subscribe() method
         * Nothing happens if we don't subscribe !
         * Using the subscribe method we pass a default implementation of a subscriber down to the publisher
         * We can also pass a custom implementation of a subscriber using subscribe(Subscriber subs)
         */
//        Mono.just("some data").subscribe();

        /**
         * How do we unwrap the data inside a Mono?
         */

        /**
         *  Wrong way - The blocking way.
         *  Using block() method.
         *  blocks the main thread until data is ready to be emitted by the Mono. The method passes down a custom subscriber
         */
//        String blockingData = Mono.just("some data").block();
//        System.out.println("Data received using blocking way: " + blockingData);



        /** Correct way - non-blocking way
         *  Using .subscribe(Consumer con)
         *  You have access to the data emitted by the mono inside the consumer
         *  The main thread is not blocked this way
         *  If you execute the main method will see it's actually still blocking the main thread.
         *  This will be clarified further in Lesson 3
         */
//        Mono.just("some data").subscribe(data -> {
//            Util.sleepSeconds(4);
//            System.out.println("Data received using non-blocking way: " + data);
//        });
//        System.out.println("next line");

        /**
         * A mono source can also be created using .fromSupplier() method. There are many, feel free to experiment with them
         * If no data is present in the mono source, nothing will be emitted the consumer callback inside .subscribe() will not be invoked
         * and an onComplete signal will be sent to the subscriber
         **/
//        Mono<String> monoFromSupplier = Mono.fromSupplier(() -> "Abdullah");
//        monoFromSupplier.subscribe(data -> System.out.println("Data from mono supplier: " + data));

//      The callback inside this mono's subscribe is never invoked because no data is ever emitted
//        Mono<String> emptyMono = Mono.fromSupplier(() -> null);
//        emptyMono.subscribe(data -> System.out.println("Data from empty mono supplier: " + data));
    }

}
