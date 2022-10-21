package uk.sky.reactor.sec02;

import reactor.core.publisher.Flux;
import uk.sky.reactor.util.Util;

public class L2FluxSink {
    public static void main(String[] args) {
        Flux.create((fluxSink ->
        {
            String countryName =  Util.faker().country().name();

            while(!countryName.equalsIgnoreCase("canada")) {
                fluxSink.next(countryName);
                countryName = Util.faker().country().name();
            }
            fluxSink.next(countryName);
            fluxSink.complete();

        })).subscribe(Util.subscriber());
    }
}
