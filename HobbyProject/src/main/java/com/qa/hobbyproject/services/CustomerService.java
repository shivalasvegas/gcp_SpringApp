package com.qa.hobbyproject.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hobbyproject.exceptions.IdNotFoundException;
import com.qa.hobbyproject.model.Customer;
import com.qa.hobbyproject.repositories.CustomerRepository;

@Service
public class CustomerService {

	private final static Logger LOGGER = Logger.getLogger(Logger.class.getName());
	
	
	@Autowired
	CustomerRepository customerRepo;

	// Create
	public String createCustomer(Customer customer) {
		this.customerRepo.save(customer);
		return "Customer record created";
	}

	// Read
	public Customer readCustomer(int id) {
		Customer customer = this.customerRepo.findById(id).orElseThrow(IdNotFoundException::new);
		LOGGER.info("Read Customer with id: " + customer.getCustomerId()); 
		return customer;
	}

	public List<Customer> readAllCustomers() {
		List<Customer> customerRecords = this.customerRepo.findAll();
		LOGGER.info("Read all customer records");
		return customerRecords;

	}
	
	public boolean checkCustomerDetails(String customerEmail, String customerPassword) {
		boolean isCustomer = false;
		LOGGER.info("Checking customer data"); 
		Customer customer = this.customerRepo.findByCustomerEmail(customerEmail);
		if (customer==null) isCustomer = false;
		else isCustomer = true;
		if (customer.getCustomerPassword() == customerPassword && isCustomer) {
			isCustomer = true;
		}
			
		return isCustomer;

	}

	// Update
	public Customer updateCustomer(Customer updatedCustomer, int id) {
		Customer existingCustomer = this.customerRepo.findById(id).orElseThrow(IdNotFoundException::new);

		existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
		existingCustomer.setCustomerAddress(updatedCustomer.getCustomerAddress());
		existingCustomer.setCustomerPhone(updatedCustomer.getCustomerPhone());
		existingCustomer.setCustomerEmail(updatedCustomer.getCustomerEmail());
		existingCustomer.setCustomerPassword(updatedCustomer.getCustomerPassword());
		LOGGER.info("Updated customer with id: " + existingCustomer.getCustomerId());
		Customer saved = this.customerRepo.save(existingCustomer);
		return saved;
	}

	// Delete
	public boolean deleteCustomer(int id) {
		Customer customer = this.customerRepo.findById(id).orElseThrow(IdNotFoundException::new);
		LOGGER.info("Deleting customer with id: " + customer.getCustomerId());
		
		this.customerRepo.deleteById(id);
		boolean deleted = !this.customerRepo.existsById(id);
		LOGGER.info("Customer deleted");
		return deleted;
	}

}
