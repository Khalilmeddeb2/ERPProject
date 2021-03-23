
package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductRest {
 
	private ProductService service;
	
	
    @Autowired
	public ProductRest(ProductService service) {
		super();
		this.service = service;
	}
    
    @PostMapping("/{id}")
	public ProductDto createProduct( @PathVariable("id") int id,@RequestBody ProductDto product) {
		
		return service.createProduct(product, id);
	}
    
    @GetMapping
	public List<ProductDto> getAllProducts() {
		return service.getAllProducts();
	}
    
    @GetMapping("/{id}")
	public ProductDto getProductById(@PathVariable("id") int id) {
    	return service.getProductById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProductyById(@PathVariable("id") int id)
    {
    	service.deleteProductyById(id);
    }
    
    @PutMapping("/{id}")
	public ProductDto modifyProduct(@PathVariable("id") int id,@RequestBody ProductDto product) {
	    return	service.modifyProduct(id, product);}
    
    @GetMapping("/LeplusAchete")
    public String getProductlePlusAchete() {
    	return service.getProductlePlusAchete();
    }
    
    @GetMapping("/NumberProducts")
    public int getNumberProducts() {
    	return service.getNumberProducts();
    }
	
}
