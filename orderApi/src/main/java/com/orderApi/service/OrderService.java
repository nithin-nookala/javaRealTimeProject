package com.orderApi.service;

import java.util.List;

import com.orderApi.dto.OrderDto;
import com.orderApi.dto.PaymentCallBackDto;
import com.orderApi.reponse.PurchaseOrderResponse;
import com.orderApi.request.PurchaseOrderRequest;

public interface OrderService {

	public PurchaseOrderResponse createOrder(PurchaseOrderRequest orderRequest);
	public PurchaseOrderResponse updateOrder(PaymentCallBackDto paymentCallBackDto);
	public List<OrderDto> getOrdersByEmail(String email);
}
