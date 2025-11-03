package com.productsApi.service;

import java.util.List;

import com.productsApi.dto.ProductCategoryDto;
import com.productsApi.dto.ProductDto;

public interface ProductService {

	public List<ProductDto> getProducts();
	public List<ProductCategoryDto> getCategories();
	public List<ProductDto> getByName(String name);
	public ProductDto getByProductId(long productId);
	public List<ProductDto> getProductsByCategoryId(Long categoryId);
}
