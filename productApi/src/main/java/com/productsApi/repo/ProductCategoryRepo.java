package com.productsApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productsApi.entities.ProductCategory;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long >{

}
