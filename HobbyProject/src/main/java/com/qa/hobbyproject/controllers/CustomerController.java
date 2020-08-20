package com.qa.hobbyproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.qa.hobbyproject.exceptions.IdNotFoundException;
import com.qa.hobbyproject.model.Customer;
import com.qa.hobbyproject.services.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("/createcustomer")
	public String createCustomerRecord(@RequestBody Customer customer) {
		String message = this.service.createCustomer(customer);

		return message;
	}

	@GetMapping("/readcustomer/{id}")
	public Customer readCustomerRecord(@PathVariable int id) {
		Customer record = this.service.readCustomer(id);
		return record;
	}

	@GetMapping("/readallcustomers")
	public List<Customer> readAllCustomerRecords() {
		List<Customer> record = service.readAllCustomers();

		return record;
	}
	
	@GetMapping("/checkcustomerdetails/{customerEmail}/{customerPassword}")
	public boolean checkCustomerRecords(@PathVariable String customerEmail, @PathVariable String customerPassword) {
		boolean isCustomer = service.checkCustomerDetails(customerEmail, customerPassword);
		
		return isCustomer;
	}

	
	@PostMapping("/updatecustomer/{id}")
	public Customer updateCustomerRecord1(@RequestBody Customer newCustomer, @PathVariable int id) {
		Customer record = service.updateCustomer(newCustomer, id);
		return record;
	}


	@DeleteMapping("/deletecustomer/{id}")
	public String deleteCustomerRecord(@PathVariable int id) throws IdNotFoundException {
		boolean deleted = this.service.deleteCustomer(id);

		String message;
		try {
			if (deleted)
				message = "Customer deleted";
			else
				message = "Id does not exist";
		} catch (IdNotFoundException customerException) {
			message = "Please enter another id";
		}

		return message;
	}
	
	@PostMapping("/deletecustomer/{id}")
	public String deleteCustomerRecord1(@PathVariable int id) throws IdNotFoundException {
		boolean deleted = this.service.deleteCustomer(id);

		String message;
		try {
			if (deleted)
				message = "Customer deleted";
			else
				message = "Id does not exist";
		} catch (IdNotFoundException customerException) {
			message = "Please enter another id";
		}

		return message;
	}
	
	@GetMapping("/deletecustomer/{id}")
	public String deleteCustomerRecord2(@PathVariable int id) throws IdNotFoundException {
		boolean deleted = this.service.deleteCustomer(id);

		String message;
		try {
			if (deleted)
				message = "Customer deleted";
			else
				message = "Id does not exist";
		} catch (IdNotFoundException customerException) {
			message = "Please enter another id";
		}
		
		return message;
		
	}

}
