package com.productsApi.mapper;

import org.modelmapper.ModelMapper;

import com.productsApi.dto.ProductDto;
import com.productsApi.entities.Product;

public class ProductMapper{
	public static final ModelMapper mapper = new ModelMapper();
	
	public static Product convertToEntity(ProductDto productDto) {
		return mapper.map(productDto, Product.class);
	}
	
	public static ProductDto convertToDto(Product product) {
		return mapper.map(product, ProductDto.class);
	}

}
