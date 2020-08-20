package com.qa.hobbyproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin {
	
	@Id
	@GeneratedValue
	@Column(name="admin_id")
	private int adminId;
	
	@Column(length=50, name="admin_name")
	private String adminName;
	@Column(length=100, name="admin_email")
	private String adminEmail;
	@Column(length=15, name="admin_password")
	private String adminPassword;
	
	public Admin() {
		
	}
	
	public Admin(String adminName, String adminEmail, String adminPassword) {
		
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		
	}
	
	public Admin(int adminId, String adminEmail, String adminPassword) {
		
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	
	


	
}
	