package com.orderApi.service;

import com.razorpay.Order;

public interface RazorpayService {
	public Order createRazorpayOrder(double amount);
}
