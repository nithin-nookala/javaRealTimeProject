package com.orderApi.dto;

import lombok.Data;

@Data
public class PaymentCallBackDto {

	private String razorpayOrderId;
	private String raorpayPaymentId;
	private String razorpaySignature;
}
