package com.qa.hobbyproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name="customer_id")
	private int customerId;
	@Column(length=50, name="customer_name")
	private String customerName;
	@Column(length=100, name="customer_address")
	private String customerAddress;
	@Column(length=20, name="customer_phone")
	private String customerPhone;
	@Column(length=100, name="customer_email", unique=true, nullable = false)
	private String customerEmail;
	@Column(length=15, name="customer_password")
	private String customerPassword;
	
	public Customer() {
		super();
	}
	
	public Customer(String customerName, String customerAddress, String customerPhone, String customerEmail, String customerPassword) {
		
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}
	
	public Customer(int customerId, String customerName, String customerAddress, String customerPhone, String customerEmail, String customerPassword) {
		
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	public String getCustomerAddress() {
		return this.customerAddress;
	}
	
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	
	public String getCustomerPhone() {
		return this.customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	
	public String getCustomerName() {
	
		return this.customerName;
	}

	
	public void setCustomerName(String name) {
	 this.customerName = name;
		
	}

	
	public String getCustomerEmail() {
		
		return this.customerEmail;
	}


	public void setCustomerEmail(String email) {
		this.customerEmail = email;
		
	}

	
	public String getCustomerPassword() {
		
		return this.customerPassword;
	}


	public void setCustomerPassword(String password) {
		
		this.customerPassword = password;
	}

	
	
	
}
