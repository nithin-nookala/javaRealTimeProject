package com.productsApi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productsApi.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

	public List<Product> findByNameContaining(String name);
	public List<Product> findByCategoryCategoryId(Long categoryId);
}
