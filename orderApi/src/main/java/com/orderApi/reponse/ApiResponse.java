package com.orderApi.reponse;

import lombok.Data;

@Data
public class ApiResponse<T> {

	private T data;
	private Integer Status;
	private String msg;
}
