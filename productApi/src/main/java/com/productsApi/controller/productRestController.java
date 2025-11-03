package com.productsApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productsApi.dto.ProductCategoryDto;
import com.productsApi.dto.ProductDto;
import com.productsApi.response.ApiResponse;
import com.productsApi.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class productRestController {
	@Autowired
	private ProductServiceImpl productService;
	@GetMapping(
			value = "/all",
			produces = "application/json")
	public ResponseEntity<ApiResponse<List<ProductDto>>> allProducts(){
		ApiResponse<List<ProductDto>> response = new ApiResponse();
		List<ProductDto> products = productService.getProducts();
		if(products != null) {
			response.setData(products);
			response.setMessage("Fetched all Products");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			response.setData(null);
			response.setMessage("Fetching unsuccessfull");
			response.setStatus(500);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(
			value = "/categories",
			produces = "application/json")
	public ResponseEntity<ApiResponse<List<ProductCategoryDto>>> allCategories(){
		ApiResponse<List<ProductCategoryDto>> response = new ApiResponse();
		List<ProductCategoryDto> categories = productService.getCategories();
		if(categories != null) {
			response.setData(categories);
			response.setMessage("Fetched all Products");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			response.setData(null);
			response.setMessage("Fetching unsuccessfull");
			response.setStatus(500);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(
			value = "/byId/{productId}",
			produces = "application/json")
	public ResponseEntity<ApiResponse<ProductDto>> allProductById(@PathVariable Long productId){
		ApiResponse<ProductDto> response = new ApiResponse();
		ProductDto product = productService.getByProductId(productId);
		if(product != null) {
			response.setData(product);
			response.setMessage("Fetched all Products");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			response.setData(null);
			response.setMessage("Fetching unsuccessfull");
			response.setStatus(500);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(
			value = "/all/{name}",
			produces = "application/json")
	public ResponseEntity<ApiResponse<List<ProductDto>>> allProductsByName(@PathVariable String name){
		ApiResponse<List<ProductDto>> response = new ApiResponse();
		List<ProductDto> products = productService.getByName(name);
		if(products != null) {
			response.setData(products);
			response.setMessage("Fetched all Products");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			response.setData(null);
			response.setMessage("Fetching unsuccessfull");
			response.setStatus(500);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(
			value = "/all/category/{categoryId}",
			produces = "application/json")
	public ResponseEntity<ApiResponse<List<ProductDto>>> allProductsByCategoryId(@PathVariable Long categoryId){
		ApiResponse<List<ProductDto>> response = new ApiResponse();
		List<ProductDto> products = productService.getProductsByCategoryId(categoryId);
		if(products != null) {
			response.setData(products);
			response.setMessage("Fetched all Products");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			response.setData(null);
			response.setMessage("Fetching unsuccessfull");
			response.setStatus(500);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
