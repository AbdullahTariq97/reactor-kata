package uk.sky.reactor.sec02;

import reactor.core.publisher.Flux;
import uk.sky.reactor.util.NameGenerator;

public class L3FluxVersusList {

    public static void main(String[] args) {
        /**
         * we have to wait for 5 secs before the list is given to us
         * You have to wait for the collection to get completely populated with items before response is returned
         */
//        List<String> listOfNames = NameGenerator.getNamesAsList(5);
//        System.out.println(listOfNames);

        /**
         * You don't have to wait five seconds, you get the value as its emitted
         */
//        Flux<String> flux = NameGenerator.getNames(5);
//        flux.subscribe(data -> System.out.println("The item received by subscriber is : " + data));
    }
}
