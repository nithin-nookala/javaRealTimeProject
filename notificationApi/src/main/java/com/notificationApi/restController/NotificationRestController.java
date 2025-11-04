package com.notificationApi.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notificationApi.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationRestController {

	@Autowired
	private NotificationService notification;
	
	@GetMapping("/delivery")
	public String delivery() {
		notification.sendDeliveryNotification();
		return "success";
	}
}
