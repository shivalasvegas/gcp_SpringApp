package com.qa.hobbyproject.servicetests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.hobbyproject.model.Admin;
import com.qa.hobbyproject.repositories.AdminRepository;
import com.qa.hobbyproject.services.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceUnitTest {
	
	@MockBean
	private AdminRepository repo;

	@Autowired
	private AdminService service;

	private Optional<Admin> testOpAdmin;
	private Admin testAdmin;
	private Admin testNewAdmin;
	private Admin testNewAdminWithId;

	private int id;
	private String adminEmail;
	private String adminPassword;
	
	private List<Admin> listAdmin = new ArrayList<>();

	@Before
	public void init() {

		this.testAdmin = new Admin("Arthur Dent", "adent@earth.com","123345");
		this.testAdmin.setAdminId(1);
		this.id = this.testAdmin.getAdminId();
		this.adminEmail = this.testAdmin.getAdminEmail();
		this.adminPassword = this.testAdmin.getAdminPassword();

		this.testOpAdmin = Optional.ofNullable(this.testAdmin);
		this.testNewAdmin = new Admin("Ford Prefect", "perfect@universe.com","towelsrus");
		this.testNewAdminWithId = new Admin("Ford Prefect","perfect@universe.com","towelsrus"); ;
		this.testNewAdminWithId.setAdminId(1);
	}

	@Test
	public void testCreate_createAdmin() {
		when(this.repo.save(testAdmin)).thenReturn(new Admin());

		String message = this.service.createAdmin(this.testAdmin);
		assertEquals("Admin record created", message);
	}

	@Test
	public void testRead_readAdmin() {
		when(this.repo.findById(id)).thenReturn(this.testOpAdmin);
		Optional<Admin> optAdmin = Optional.ofNullable(this.service.readAdmin(this.id));
		assertEquals(this.testOpAdmin, optAdmin);
	}

	@Test
	public void testReadAll_readAllAdmins() {
		when(this.repo.findAll()).thenReturn(this.listAdmin);
		List<Admin> newListAdmin = this.service.readAllAdmins();
		assertEquals(this.listAdmin, newListAdmin);
	}
	
	@Test
	public void testReadDetails_checkAdminDetails() {
		when(this.repo.findByAdminEmail(this.adminEmail)).thenReturn(this.testAdmin);
		boolean isAdmin = this.service.checkAdminDetails(this.adminEmail, this.adminPassword);
		
		assertTrue(isAdmin);
		
	}

	@Test
	public void testUpdate_updateAdmin() {
		when(this.repo.findById(this.id)).thenReturn(this.testOpAdmin);
		
		when(this.repo.save(this.testAdmin)).thenReturn(this.testNewAdminWithId);

		Admin updated = this.service.updateAdmin(this.testNewAdmin, this.id);
		assertEquals(this.testNewAdminWithId, updated);
	}

	@Test
	public void testDelete_deleteAdmin() {
		when(this.repo.findById(this.id)).thenReturn(this.testOpAdmin).thenReturn(null);
		boolean deletedRepo = !this.repo.existsById(this.id);
		boolean deleted = this.service.deleteAdmin(this.id);

		assertEquals(deletedRepo, deleted);

	}


}
