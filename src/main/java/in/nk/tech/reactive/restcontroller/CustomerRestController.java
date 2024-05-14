package in.nk.tech.reactive.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nk.tech.reactive.entity.Customer;
import in.nk.tech.reactive.service.CustomerService;
import reactor.core.publisher.Flux;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping(value = "customers-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getStreamOfCustomers() {
		return customerService.getCustomersStream();
	}
}
