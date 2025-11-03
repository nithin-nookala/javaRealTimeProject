package com.customerApi.response;

import lombok.Data;

@Data
public class ApiResponse<T>{

	private T data;
	private Integer status;
	private String message;
}
