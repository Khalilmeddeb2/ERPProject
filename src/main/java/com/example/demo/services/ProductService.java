package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.ProductDto;

public interface ProductService {

	ProductDto createProduct(ProductDto product,int id);
	List<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
	ProductDto modifyProduct(int id, ProductDto product);
	void deleteProductyById(int id);
	
	String getProductlePlusAchete();
	
	int getNumberProducts();
	
}
