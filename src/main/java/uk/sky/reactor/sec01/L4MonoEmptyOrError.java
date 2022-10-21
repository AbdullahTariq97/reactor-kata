package uk.sky.reactor.sec01;

import reactor.core.publisher.Mono;
import uk.sky.reactor.util.Util;

public class L4MonoEmptyOrError {
    public static void main(String[] args) {
        /**
         * Different flavours of mono available depending on the situation.
         * If there has been a problem emitting data for a mono return Mono<Error>
         * If there is no data to be emitted return Mono<Void>
         * .subscribe() is method is overloaded. You can pass set of consumers. Each controls how subscriber will react
         * when onComplete, onNext or onError signals are sent
         */

        userRepository(1).subscribe(Util.onNext(),
                                            Util.onError(),
                                         Util.onComplete());

        System.out.println("\n");

        userRepository(2).subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        System.out.println("\n");

        userRepository(3).subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());


    }

    // This is acting like a publisher
    public static Mono<String> userRepository(int userId){
        Mono<String> user;

           switch(userId){
            case 1 :
            // .just method wrapper value
            user = Mono.just(Util.faker().name().firstName());
            break;
            case 2 :
            // handles situation when no data is available for user with id 2
            user = Mono.empty();
            break;
           default:
           // handles situation when user id not acceptable. Throws error
            user = Mono.error(new RuntimeException("Not in the allowed range"));
            break;
        };
       return user;
    }

}
