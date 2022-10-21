package uk.sky.reactor.sec01;

import reactor.core.publisher.Mono;

public class L3MonoHooks {
    public static void main(String[] args) {
        /**
         * Corresponding to different stages of data/information getting passed between publisher and subscriber
         * you methods available to peek at the state of the wrapped data during that stage
         * As you can see a large long and therefore all the data is requested by the default subscriber
         *
         */
        Mono<String> surname = Mono.fromSupplier(() -> "tariq");
        surname.
                doOnSubscribe(subscriptionObject -> System.out.println("The subscription object is " + subscriptionObject))
                .doOnRequest(noRequestedData -> System.out.println("The number of requested data " + noRequestedData))
                .doOnNext(data -> System.out.println("Data from empty mono supplier: " + data))
                .doOnSuccess(data -> System.out.println("Finished emitting data")) // This would be invoked even if mono contains null
                .subscribe();

        /**
         * There are also some hooks available
         */
        Mono<String> city = Mono.fromSupplier(() -> "london");
        surname.doFirst(() -> System.out.println("executed before anything happens"))
                .doOnNext(data -> System.out.println("Data from empty mono supplier: " + data))
                .doFinally(signalType -> System.out.println("executed after everything happened. The stream ended with " + signalType.toString()))
                .subscribe();

    }
}
