package com.qa.hobbyproject.servicetests;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.hobbyproject.model.Customer;
import com.qa.hobbyproject.repositories.CustomerRepository;
import com.qa.hobbyproject.services.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceUnitTest {
	@MockBean
	private CustomerRepository repo;

	@Autowired
	private CustomerService service;
	//private final static Logger LOGGER = Logger.getLogger(Logger.class.getName());
	

	private Optional<Customer> testOpCustomer;
	private Customer testCustomer;
	private Customer testNewCustomer;
	private Customer testNewCustomerWithId;

	private int id;
	private String customerEmail;
	private String customerPassword;
	
	private List<Customer> listCustomer = new ArrayList<>();

	@Before
	public void init() {

		this.testCustomer = new Customer("Arthur Dent", "155 Cottinghom Lane", "01273567456", "adent@earth.com",
				"123345");
		this.testCustomer.setCustomerId(1);
		this.id = this.testCustomer.getCustomerId();
		this.customerEmail = this.testCustomer.getCustomerEmail();
		this.customerPassword = this.testCustomer.getCustomerPassword();

		this.testOpCustomer = Optional.ofNullable(this.testCustomer);
		

		
		this.testNewCustomer = new Customer("Ford Prefect", "The Universe", "0000111", "perfect@universe.com",
			"towelsrus");
		this.testNewCustomerWithId = new Customer("Ford Prefect", "The Universe", "0000111", "perfect@universe.com",
				"towelsrus"); ;
		this.testNewCustomerWithId.setCustomerId(1);
	}

	@Test
	public void testCreate_createCustomer() {
		when(this.repo.save(testCustomer)).thenReturn(new Customer());

		String message = this.service.createCustomer(this.testCustomer);
		assertEquals("Customer record created", message);
	}

	@Test
	public void testRead_readCustomer() {
		when(this.repo.findById(id)).thenReturn(this.testOpCustomer);
		Optional<Customer> optCustomer = Optional.ofNullable(this.service.readCustomer(this.id));
		assertEquals(this.testOpCustomer, optCustomer);
	}

	@Test
	public void testReadAll_readAllCustomers() {
		when(this.repo.findAll()).thenReturn(this.listCustomer);
		List<Customer> newListCustomer = this.service.readAllCustomers();
		assertEquals(this.listCustomer, newListCustomer);
	}

	@Test
	public void testReadDetails_checkCustomerDetails() {
		when(this.repo.findByCustomerEmail(this.customerEmail)).thenReturn(this.testCustomer);
		boolean isCustomer = this.service.checkCustomerDetails(this.customerEmail, this.customerPassword);
		
		assertTrue(isCustomer);
		
	}

	
	@Test
	public void testUpdate_updateCustomer() {
		when(this.repo.findById(this.id)).thenReturn(this.testOpCustomer);
		
		when(this.repo.save(this.testCustomer)).thenReturn(this.testNewCustomerWithId);

		Customer updated = this.service.updateCustomer(this.testNewCustomer, this.id);
		assertEquals(this.testNewCustomerWithId, updated);
	}

	@Test
	public void testDelete_deleteCustomer() {
		when(this.repo.findById(this.id)).thenReturn(this.testOpCustomer);
		boolean deletedRepo = !this.repo.existsById(this.id);
		boolean deleted = this.service.deleteCustomer(this.id);

		assertEquals(deletedRepo, deleted);

	}

}
