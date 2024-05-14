package in.nk.tech.reactive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nk.tech.reactive.dao.CustomerDao;
import in.nk.tech.reactive.entity.Customer;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public List<Customer> getAllCustomers() {
		long start = System.currentTimeMillis();

		List<Customer> customers = customerDao.findAll();

		long end = System.currentTimeMillis();

		System.out.println("Time Approach-1 :: " + (end - start));

		return customers;
	}
	
	public Flux<Customer> getCustomersStream() {
		long start = System.currentTimeMillis();

		Flux<Customer> customers = customerDao.getCustomerStream();

		long end = System.currentTimeMillis();

		System.out.println("Time Approach-2 :: " + (end - start));

		return customers;
	}
}
