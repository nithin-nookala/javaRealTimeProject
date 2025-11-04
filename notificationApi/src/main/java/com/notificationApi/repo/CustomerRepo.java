package com.notificationApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificationApi.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

	public Customer findByEmail(String email);
}
