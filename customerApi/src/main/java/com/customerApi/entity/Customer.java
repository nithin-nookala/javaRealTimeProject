package com.customerApi.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String PwdUpdated;
	@Column(name = "phno")
	private String phoneNo;
	@Column(name = "addr")
	private String address;
	@CreationTimestamp
	private LocalDate dateCreated;
	@UpdateTimestamp
	private LocalDate lastUpdated;
}
