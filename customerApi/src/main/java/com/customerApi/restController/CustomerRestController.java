package com.customerApi.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerApi.dto.CustomerDto;
import com.customerApi.dto.ResetPwdDto;
import com.customerApi.response.ApiResponse;
import com.customerApi.response.AuthResponse;
import com.customerApi.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	@Autowired
	private CustomerServiceImpl custService;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<String>> register(@RequestBody CustomerDto customerDto){
		
		ApiResponse<String> response = new ApiResponse<>();
		
		Boolean emailUnique = custService.isEmailUnique(customerDto.getEmail());		
		if(!emailUnique) {
			response.setData("Duplicate Email, please use a unique email");
			response.setMessage("Failed");
			response.setStatus(400);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		Boolean register = custService.register(customerDto);
		if(register) {
			response.setData("Registration successful");
			response.setMessage("Success");
			response.setStatus(201);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}else {
			response.setData("Registration failed");
			response.setMessage("failed");
			response.setStatus(500);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody CustomerDto customerDto){
		
		ApiResponse<AuthResponse> response = new ApiResponse<>();
		
		AuthResponse authResponse = custService.login(customerDto);
		if(authResponse != null) {
			response.setData(authResponse);
			response.setMessage("login successful");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			response.setData(null);
			response.setMessage("login failed, invalid credentials");
			response.setStatus(400);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/reset-pwd")
	public ResponseEntity<ApiResponse<String>> resetPassword(@RequestBody ResetPwdDto resetPwdDto){
		ApiResponse<String> response = new ApiResponse<>();
		
		CustomerDto customer = custService.getCustomerByEmail(resetPwdDto.getEmail());
		if(!pwdEncoder.matches(resetPwdDto.getOldPwd(), customer.getPassword())){
			response.setData("current password is incorrect");
			response.setMessage("failed");
			response.setStatus(400);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		Boolean status = custService.resetPwd(resetPwdDto);
		if(status) {
			response.setData("reset password successful");
			response.setMessage("success");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			response.setData("password reset failed");
			response.setMessage("failed");
			response.setStatus(500);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/forgot-pwd/{email}")
	public ResponseEntity<ApiResponse<String>> forgotPwdRequest(@PathVariable String email){
		ApiResponse<String> response = new ApiResponse<>();
		Boolean status = custService.forgotPassword(email);
		if(status) {
			response.setData("email sent");
			response.setMessage("success");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			response.setData("no account found");
			response.setMessage("failed");
			response.setStatus(500);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}
