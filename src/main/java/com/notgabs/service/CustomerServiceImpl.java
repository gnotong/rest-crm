package com.notgabs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notgabs.dao.CustomerDAO;
import com.notgabs.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	public List<Customer> getCustomers(int sort) {
		return customerDAO.getCustomers(sort);
	}

	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

	@Transactional
	public List<Customer> searchCustomers(String filter) {
		return customerDAO.searchCustomers(filter);
	}
}
