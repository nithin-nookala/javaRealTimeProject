package com.productsApi.response;

import lombok.Data;

@Data
public class ApiResponse<T>{

	private String message;
	private Integer status;
	private T data;
}
