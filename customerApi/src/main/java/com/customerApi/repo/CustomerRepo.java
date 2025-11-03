package com.customerApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customerApi.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

	public Customer findByEmail(String email);
}
