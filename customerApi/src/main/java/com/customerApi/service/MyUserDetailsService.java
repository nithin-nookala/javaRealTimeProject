package com.customerApi.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.customerApi.entity.Customer;
import com.customerApi.repo.CustomerRepo;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepo customerRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer cust = customerRepo.findByEmail(email);
		return new User(cust.getEmail(), cust.getPassword(), Collections.emptyList());
	}

	
}
