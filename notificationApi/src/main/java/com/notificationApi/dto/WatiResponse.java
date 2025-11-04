package com.notificationApi.dto;

import java.util.List;

import lombok.Data;
@Data
public class WatiResponse {

	private String result;
	private String phoneNumber;
	private List<WatiParameters> parameters;
	private boolean validWhatsAppNumber;
	private String name;
	private String orderId;
	private String orderName;
}
