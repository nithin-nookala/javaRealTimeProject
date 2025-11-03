package com.productsApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productsApi.dto.ProductCategoryDto;
import com.productsApi.dto.ProductDto;
import com.productsApi.mapper.ProductCategoryMapper;
import com.productsApi.mapper.ProductMapper;
import com.productsApi.repo.ProductCategoryRepo;
import com.productsApi.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ProductCategoryRepo categoryRepo;
	@Override
	public List<ProductDto> getProducts() {
		
		return productRepo.findAll()
						  .stream()
						  .map(ProductMapper::convertToDto)
						  .collect(Collectors.toList());
	}

	@Override
	public List<ProductCategoryDto> getCategories() {
		
		return categoryRepo.findAll()
						   .stream()
						   .map(ProductCategoryMapper::convertToDto)
						   .collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getByName(String name) {
		
		return productRepo.findByNameContaining(name)
						  .stream()
						  .map(ProductMapper::convertToDto)
						  .collect(Collectors.toList());
	}

	@Override
	public ProductDto getByProductId(long productId) {
		
		return productRepo.findById(productId)
						  .map(ProductMapper::convertToDto)
						  .orElse(null);
	}

	@Override
	public List<ProductDto> getProductsByCategoryId(Long categoryId) {
		
		return productRepo.findByCategoryCategoryId(categoryId)
						  .stream()
						  .map(ProductMapper::convertToDto)
						  .collect(Collectors.toList());
	}

}
