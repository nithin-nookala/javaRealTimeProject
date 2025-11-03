package com.orderApi.request;

import java.util.List;

import com.orderApi.dto.AddressDto;
import com.orderApi.dto.CustomerDto;
import com.orderApi.dto.OrderDto;
import com.orderApi.dto.OrderItemDto;

import lombok.Data;

@Data
public class PurchaseOrderRequest {

	private CustomerDto customer;
	private AddressDto address;
	private OrderDto order;
	private List<OrderItemDto> orderItems;
}
