package com.notificationApi.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class OrderDto {

	private Long orderId;
	private String orderTrackingNumber;
	private String razorpayOrderId;
	private String email;
	private String orderStatus;
	private Double totalPrice;
	private Integer totalQuantity;
	private String razorpayPaymentId;
	private String invoiceUrl;
	private LocalDate deliveryDate;
}
