package com.notificationApi.dto;

import lombok.Data;

@Data
public class OrderItemDto {

	private Long id;
	private String productName;
	private String imageUrl;
	private Double unitPrice;
	private Integer quantity;
}
