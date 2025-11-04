package com.notificationApi.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.notificationApi.dto.WatiParameters;
import com.notificationApi.dto.WatiRequest;
import com.notificationApi.dto.WatiResponse;
import com.notificationApi.entity.Customer;
import com.notificationApi.entity.Order;
import com.notificationApi.repo.OrderRepo;
@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private EmailService emailService; 
	@Value("${wati.token}")
	private String watiToken;
	@Value("${wati.template.name}")
	private String templateName;
	@Value("${wati.endpoint.url}")
	private String watiEndPointUrl;
	
	@Override
	@Scheduled(cron = "0 7 * * * *")
	public Integer sendDeliveryNotification() {
		List<Order> orders = orderRepo.findByDeliveryDate(LocalDate.now());
		for(Order order: orders) {
			Customer customer = order.getCustomer();
			sendEmailNotification(customer.getEmail(), customer.getName(), order.getOrderTrackingNumber());
			sendWatiNotification(customer.getPhoneNo(), customer.getName(), order.getOrderTrackingNumber());
		}
		return orders.size();
	}

	private WatiResponse sendWatiNotification(String phoneNo, String name, String orderTrackingNumber) {
		RestTemplate rt = new RestTemplate();
		String apiUrl = watiEndPointUrl + "?whatsappNumber=" + phoneNo;
		WatiParameters nameParameters = new WatiParameters();
		nameParameters.setName("name");
		nameParameters.setValue(name);
		
		WatiParameters trackingParameters = new WatiParameters();
		trackingParameters.setName("value");
		trackingParameters.setValue(orderTrackingNumber);
		
		WatiRequest request = new WatiRequest();
		request.setTemplate_name(templateName);
		request.setBroadcast_name(templateName + "BD");
		request.setParameters(Arrays.asList(nameParameters, trackingParameters));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorizaton", watiToken);
		HttpEntity<WatiRequest> reqEntity = new HttpEntity<WatiRequest>(request, headers);
		ResponseEntity<WatiResponse> postForEntity = rt.postForEntity(apiUrl, reqEntity, WatiResponse.class);
		return postForEntity.getBody();
	}

	private void sendEmailNotification(String email, String name, String orderTrackingNumber) {
		String subject = "order out for delivery";
		String body = "Hi " + name + " your order " + orderTrackingNumber + " is out for delivery, Thank You.";
		emailService.sendEmail(email, subject, body);
		
	}

	@Override
	public Integer sendPendingOrdersNotification() {
		// TODO Auto-generated method stub
		return null;
	}

}
