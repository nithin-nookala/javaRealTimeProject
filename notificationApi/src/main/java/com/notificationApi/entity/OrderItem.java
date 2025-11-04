package com.notificationApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Setter
@Getter
public class OrderItem {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private String productName;
	private String imageUrl;
	private Double unitPrice;
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
}
