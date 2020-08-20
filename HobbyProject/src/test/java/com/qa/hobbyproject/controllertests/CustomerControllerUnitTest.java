package com.qa.hobbyproject.controllertests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import com.qa.hobbyproject.controllers.CustomerController;
import com.qa.hobbyproject.model.Customer;
import com.qa.hobbyproject.services.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerUnitTest {

	@MockBean
	private CustomerService service;

	@Autowired
	private CustomerController controller;

	private Customer testCustomer;
	private Customer testNewCustomer;
	private int id;
	private String email;
	private String password;
	private List<Customer> listCustomer = new ArrayList<>();

	@Before
	public void init() {

		this.testCustomer = new Customer("Arthur Dent", "155 Cottinghom Lane", "01273567456", "adent@earth.com",
				"123345");

		this.testNewCustomer = new Customer("Ford Prefect", "The Universe", "0000111", "perfect@universe.com",
				"towelsrus");
		this.id = this.testCustomer.getCustomerId();
		this.email = this.testCustomer.getCustomerEmail();
		this.password = this.testCustomer.getCustomerPassword();

	}

	@Test
	public void testCreate_createCustomerRecord() {
		when(this.service.createCustomer(testCustomer)).thenReturn("Customer record created");
		String result = this.controller.createCustomerRecord(testCustomer);
		assertEquals("Customer record created", result);
	}

	@Test
	public void testRead_readCustomer() {
		when(this.service.readCustomer(this.id)).thenReturn(this.testCustomer);
		Customer record = this.controller.readCustomerRecord(this.id);
		assertEquals(this.testCustomer, record);
	}

	@Test
	public void testCheck_checkCustomerRecords() {
		when(this.service.checkCustomerDetails(this.email, this.password)).thenReturn(true);
		
		boolean isCustomer = this.controller.checkCustomerRecords(this.email, this.password);
		assertTrue(isCustomer);
	}

	@Test
	public void testReadAll_readAllCustomerRecords() {
		when(this.service.readAllCustomers()).thenReturn(this.listCustomer);
		List<Customer> record = this.controller.readAllCustomerRecords();
		assertEquals(this.listCustomer, record);
	}

	
	@Test
	public void testUpdate_updateCustomerRecord1() {
		when(this.service.updateCustomer(this.testNewCustomer, this.id)).thenReturn(this.testNewCustomer);
		Customer record = this.controller.updateCustomerRecord1(this.testNewCustomer, this.id);
		assertEquals(this.testNewCustomer, record);
	}
	
	@Test
	public void testDelete_deleteCustomerRecord() {
		when(this.service.deleteCustomer(this.id)).thenReturn(true);
		
		String message1 = this.controller.deleteCustomerRecord(this.id);
		String message2 = this.controller.deleteCustomerRecord(12);
		
		boolean deleted = message1.equals("Customer deleted");
		boolean idNotExist = message2.equals("Id does not exist");
		assertEquals(true, deleted);
		assertEquals(true, idNotExist);
	}
	
	
	
	@Test
	public void testDelete_deleteCustomerRecord1() {
		when(this.service.deleteCustomer(this.id)).thenReturn(true);
		
		String message1 = this.controller.deleteCustomerRecord(this.id);
		String message2 = this.controller.deleteCustomerRecord(12);
		
		boolean deleted = message1.equals("Customer deleted");
		boolean idNotExist = message2.equals("Id does not exist");
		assertEquals(true, deleted);
		assertEquals(true, idNotExist);
	}
	
	

}
