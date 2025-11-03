package com.customerApi.response;

import com.customerApi.dto.CustomerDto;

import lombok.Data;
@Data
public class AuthResponse {

	private CustomerDto customer;
	private String token;
}
