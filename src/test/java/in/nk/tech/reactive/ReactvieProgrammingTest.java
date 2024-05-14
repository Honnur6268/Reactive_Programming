package in.nk.tech.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
public class ReactvieProgrammingTest {

	@Test
	public void testMonoReactive() {
		Mono<String> mono = Mono.just("Reactive Programming").log();

		mono.subscribe(System.out::println);
	}

	@Test
	public void testFluxReactive() {
		Flux<String> flux = Flux.just("Hello, ", "Reactive Programming").log()	;
		
		flux.subscribe(System.out::println);
	}
}
