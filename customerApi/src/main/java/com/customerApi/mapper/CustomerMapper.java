package com.customerApi.mapper;

import org.modelmapper.ModelMapper;

import com.customerApi.dto.CustomerDto;
import com.customerApi.entity.Customer;

public class CustomerMapper {

	public static final ModelMapper mapper = new ModelMapper();
	public static Customer convertToEntity(CustomerDto customerDto) {
		return mapper.map(customerDto, Customer.class);
	}
	public static CustomerDto convertToDto(Customer customer) {
		return mapper.map(customer, CustomerDto.class);
	}
}
