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

import com.qa.hobbyproject.controllers.AdminController;
import com.qa.hobbyproject.model.Admin;
import com.qa.hobbyproject.services.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerUnitTest {
	
	@MockBean
	private AdminService service;

	@Autowired
	private AdminController controller;

	private Admin testAdmin;
	private Admin testNewAdmin;
	private int id;
	private String email;
	private String password;
	
	private List<Admin> listAdmin = new ArrayList<>();

	@Before
	public void init() {

		this.testAdmin = new Admin("Arthur Dent", "adent@earth.com","123345");
		this.testAdmin.setAdminId(1);
		this.id = this.testAdmin.getAdminId();
		this.email = this.testAdmin.getAdminEmail();
		this.password = this.testAdmin.getAdminPassword();

		this.testNewAdmin = new Admin("Ford Prefect","perfect@universe.com","towelsrus");
		

	}

	@Test
	public void testCreate_createAdminRecord() {
		when(this.service.createAdmin(this.testAdmin)).thenReturn("Admin record created");
		String result = this.controller.createAdminRecord(this.testAdmin);
		assertEquals("Admin record created", result);
	}

	@Test
	public void testRead_readAdmin() {
		when(this.service.readAdmin(this.id)).thenReturn(this.testAdmin);
		Admin record = this.controller.readAdminRecord(this.id);
		assertEquals(this.testAdmin, record);
	}

	@Test
	public void testReadAll_readAllAdminRecords() {
		when(this.service.readAllAdmins()).thenReturn(this.listAdmin);
		List<Admin> record = this.controller.readAllAdminRecords();
		assertEquals(this.listAdmin, record);
	}

	@Test
	public void testCheck_checkAdminRecords() {
		when(this.service.checkAdminDetails(this.email, this.password)).thenReturn(true);
		
		boolean isCustomer = this.controller.checkAdminRecords(this.email, this.password);
		assertTrue(isCustomer);
	}
	
	@Test
	public void testUpdate_updateAdminRecord() {
		when(this.service.updateAdmin(this.testNewAdmin, this.id)).thenReturn(this.testNewAdmin);
		Admin record = this.controller.updateAdminRecord(this.testNewAdmin, this.id);
		assertEquals(this.testNewAdmin, record);
	}

	
	@Test
	public void testUpdate_updateAdminRecord2() {
		when(this.service.updateAdmin(this.testNewAdmin, this.id)).thenReturn(this.testNewAdmin);
		Admin record = this.controller.updateAdminRecord2(this.testNewAdmin, this.id);
		assertEquals(this.testNewAdmin, record);
	}

	
	@Test
	public void testDelete_deleteAdminRecord() {
		when(this.service.deleteAdmin(this.id)).thenReturn(true);
		
		String message1 = this.controller.deleteAdminRecord(this.id);
		String message2 = this.controller.deleteAdminRecord(12);
		boolean deleted = message1.equals("Admin deleted");
		boolean idNotExist = message2.equals("Id does not exist");
		assertEquals(true, deleted);
		assertEquals(true, idNotExist);
	}

}
