package com.notificationApi.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificationApi.entity.Order;


public interface OrderRepo extends JpaRepository<Order, Long>{

	public Order findByRazorpayOrderId(String razorpayOrderId);
	public List<Order> findByEmail(String email);
	public List<Order> findByDeliveryDate(LocalDate now);
}
