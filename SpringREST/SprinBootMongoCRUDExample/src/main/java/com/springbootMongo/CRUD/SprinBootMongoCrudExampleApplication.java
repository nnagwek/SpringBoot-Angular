package com.springbootMongo.CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprinBootMongoCrudExampleApplication  implements CommandLineRunner{

	@Autowired
	private CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SprinBootMongoCrudExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer c1 = new Customer("1", "Larry", "page");
		Customer c2 = new Customer("2", "Barreck", "Merkel");
		Customer c3 = new Customer("3", "Sammy", "Tan");
		Customer c4 = new Customer("4", "Harry", "keel");
		
		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);
		customerRepository.save(c4);
		
		System.out.println("**************************************************************");
		
		List<Customer> customers = customerRepository.findAll();
		
		for(Customer customer : customers) {
			System.out.println(customer);
		}
	}
	

}
