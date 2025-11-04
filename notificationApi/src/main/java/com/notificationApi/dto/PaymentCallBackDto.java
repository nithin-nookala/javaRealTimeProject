package com.notificationApi.dto;

import lombok.Data;

@Data
public class PaymentCallBackDto {

	private String razorpayOrderId;
	private String raorpayPaymentId;
	private String razorpaySignature;
}
