package com.customerApi.service;

import java.util.Collections;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.customerApi.dto.CustomerDto;
import com.customerApi.dto.ResetPwdDto;
import com.customerApi.entity.Customer;
import com.customerApi.mapper.CustomerMapper;
import com.customerApi.repo.CustomerRepo;
import com.customerApi.response.AuthResponse;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	@Autowired
	private EmailService emailService;
	
	Random rnd = new Random();
	
	@Override
	public boolean isEmailUnique(String email) {
		Customer cust = customerRepo.findByEmail(email); 
		return cust == null;
	}

	@Override
	public boolean register(CustomerDto customerDto) {
		String orgPwd = getRandomPwd();
		String encodedPwd = pwdEncoder.encode(orgPwd);
		
		Customer entity = CustomerMapper.convertToEntity(customerDto);
		entity.setPassword(encodedPwd);
		Customer savedEntity = customerRepo.save(entity);
		
		if(savedEntity != null) {
			String subject = "Registration success";
			String body = "Your login password is "+orgPwd+". Please reset your password after login.";
			return emailService.sendEmail(customerDto.getEmail(), body, subject);
		}
		return false;
	}

	@Override
	public CustomerDto getCustomerByEmail(String email) {
		Customer cust = customerRepo.findByEmail(email);
		if(cust != null) {
			return CustomerMapper.convertToDto(cust);
		}
		return null;
	}

	@Override
	public boolean resetPwd(ResetPwdDto resetPwdDto) {
		Customer cust = customerRepo.findByEmail(resetPwdDto.getEmail());
		if(cust != null) {
			String newPassword = resetPwdDto.getNewPwd();
			String encodedPwd = pwdEncoder.encode(newPassword);
			cust.setPassword(encodedPwd);
			cust.setPwdUpdated("YES");
			customerRepo.save(cust);
			return true;
		}
		return false;
	}

	@Override
	public AuthResponse login(CustomerDto customerDto) {
		AuthResponse response = new AuthResponse();
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(customerDto.getEmail(), customerDto.getPassword());
		Authentication authenticate = authManager.authenticate(authToken);
		if(authenticate.isAuthenticated()) {
			Customer cust = customerRepo.findByEmail(customerDto.getEmail());
			response.setCustomer(CustomerMapper.convertToDto(cust));
			response.setToken("");
		}
		return response;
	}

	private String getRandomPwd() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder pwd = new StringBuilder();
		
		while(pwd.length()<5) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			pwd.append(SALTCHARS.charAt(index));
		}
		return pwd.toString();
	}

	@Override
	public boolean forgotPassword(String email) {
		Customer cust = customerRepo.findByEmail(email);
		if(cust != null) {
			String subject = "**Password Reset Request**";
			String body = "temp body";
			emailService.sendEmail(email, body, subject);
			return true;
		}
		return false;
	}

}
