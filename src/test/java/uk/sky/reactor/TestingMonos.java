package uk.sky.reactor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class TestingMonos {

    /**
     * We don't want to block our main thread executing our test code when testing publishers
     * We can test synchronous code using the help of methods from StepVerifier class
     */

    @Test
    public void shouldContainData(){
        Mono<Car> mono = Mono.just(new Car("ferrari"));
        StepVerifier.create(mono).
                assertNext(car -> Assertions.assertThat(car.getName()).isEqualTo("ferrari"))
                .verifyComplete();
    }

    @Test
    public void shouldError(){
        Mono<Error> mono = Mono.error(new RuntimeException("problem emitting data"));
        StepVerifier.create(mono).expectError(RuntimeException.class).verify();
    }

    @Test
    public void shouldBeEmpty(){
        Mono<Void> mono = Mono.empty();
        StepVerifier.create(mono).expectNextCount(0).verifyComplete();
    }
}
