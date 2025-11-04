package com.notificationApi.dto;




import lombok.Data;
@Data
public class ProductDto {

	private Long productId;
	private String name;
	private String desc;
	private String title;
	private Double unitPrice;
	private String imageUrl;
	private boolean active;
	private Integer unitsStock;
	
}
