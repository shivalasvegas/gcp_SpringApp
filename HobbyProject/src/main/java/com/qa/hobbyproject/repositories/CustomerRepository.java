package com.qa.hobbyproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.hobbyproject.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

		Customer findByCustomerEmail (String email);
}
