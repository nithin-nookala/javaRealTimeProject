package com.notificationApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificationApi.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long>{

}
