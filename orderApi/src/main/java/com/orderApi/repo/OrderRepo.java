package com.orderApi.repo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderApi.entity.Order;


public interface OrderRepo extends JpaRepository<Order, Long>{

	public Order findByRazorpayOrderId(String razorpayOrderId);
	public List<Order> findByEmail(String email);
	public List<Order> findByDeliveryDate(LocalDate date);
}
