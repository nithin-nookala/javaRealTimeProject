package com.customerApi.service;

import com.customerApi.dto.CustomerDto;
import com.customerApi.dto.ResetPwdDto;
import com.customerApi.response.AuthResponse;

public interface CustomerService {

	public boolean isEmailUnique(String email);
	public boolean register(CustomerDto customerDto);
	public CustomerDto getCustomerByEmail(String email);
	public boolean resetPwd(ResetPwdDto resetPwdDto);
	public AuthResponse login(CustomerDto customerDto);
	public boolean forgotPassword(String email);
}
