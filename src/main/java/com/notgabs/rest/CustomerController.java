package com.notgabs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notgabs.entity.Customer;
import com.notgabs.exception.CustomerNotFoundException;
import com.notgabs.exception.StudentNotFoundException;
import com.notgabs.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> list() {
		return customerService.getCustomers(1);
	}

	@PostMapping("/customers")
	public Customer create(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		
		return customer;
	}

	@GetMapping("/customers/{id}")
	public Customer one(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		if (null == customer) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		return customer;
	}

	@PutMapping("/customers")
	public Customer update(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		
		return customer;
	}

	@DeleteMapping("/customers/{id}")
	public void delete(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		if (null == customer) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		customerService.deleteCustomer(id);
	}
}
