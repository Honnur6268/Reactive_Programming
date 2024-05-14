package in.nk.tech.reactive.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import in.nk.tech.reactive.entity.Customer;
import reactor.core.publisher.Flux;

@Repository
public class CustomerDao {

	public static void sleepExecution(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public List<Customer> findAll(){
		return IntStream.rangeClosed(1, 10)
					.peek(CustomerDao::sleepExecution)
					.peek(i -> System.out.println("Processing Count : " + i))
					.mapToObj(i -> new Customer(i, "Customer-"+i))
					.collect(Collectors.toList());
	}
	
	public Flux<Customer> getCustomerStream(){
		return Flux.range(1, 10)
					.delayElements(Duration.ofSeconds(1))
					.doOnNext(i -> System.out.println("Processing Count : " + i))
					.map(i -> new Customer(i, "Customer-"+i));
	}
}
