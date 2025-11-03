package com.productsApi.mapper;

import org.modelmapper.ModelMapper;

import com.productsApi.dto.ProductCategoryDto;
import com.productsApi.entities.ProductCategory;

public class ProductCategoryMapper {

	public static final ModelMapper mapper = new ModelMapper();
	
	public static ProductCategory convertToEntity(ProductCategoryDto productCategoryDto) {
		return mapper.map(productCategoryDto, ProductCategory.class);
	}
	
	public static ProductCategoryDto convertToDto(ProductCategory productCategory) {
		return mapper.map(productCategory, ProductCategoryDto.class);
	}
}
