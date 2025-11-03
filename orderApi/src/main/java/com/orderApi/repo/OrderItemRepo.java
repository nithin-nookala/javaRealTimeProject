package com.orderApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderApi.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long>{

}
