package uk.sky.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import uk.sky.reactor.util.Util;

import java.time.Duration;

public class TestingFluxes {
    @Test
    public void shouldReturnCorrectFlux(){
        Flux<Integer> just = Flux.just(1, 2, 3).delayElements(Duration.ofSeconds(1));

        // step verifier will internally subscriber to the flux and help you test
        StepVerifier.create(just)
                .expectNext(3,2,1)
                .expectComplete() // Please don't forget to add this as part of assertions !
                .verify();
    }

    @Test
    public void shouldThrowErrorOn4Element(){
        Flux<Integer> just = Flux.just(1, 2, 3).delayElements(Duration.ofSeconds(1));

        Flux<Integer> error = Flux.error(() -> new RuntimeException("oops"));

        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1,2,3)
                .verifyError(RuntimeException.class);

        StepVerifier.create(concat)
                .expectNext(1,2,3)
                .verifyErrorMessage("oops");
    }

    @Test
    public void shouldBeEmpty(){
        Flux<Integer> just = Flux.empty();
        StepVerifier.create(just).expectNextCount(0).verifyComplete();
    }


}
