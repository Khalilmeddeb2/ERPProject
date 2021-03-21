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

import com.example.demo.dto.CategoryDto;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/api/categorys")
public class CategoryRest {
	
	private CategoryService service;

	@Autowired
	public CategoryRest(CategoryService service) {
		super();
		this.service = service;
	}
	
	 @PostMapping
		public CategoryDto createProduct( @RequestBody CategoryDto category) {
			
			return service.createCategory(category);
		}
	 
	 @GetMapping
     public List<CategoryDto> getAllCategoy() {
         return service.getAllCategorys();
     }
	 
     @GetMapping("/{id}")
     public CategoryDto getCategorytById(@PathVariable("id") int id) {
         return service.getCategoryById(id);
     }
     
     @DeleteMapping("/{id}")
     public void deleteCategoryById(@PathVariable("id") int id)
     {
         service.deleteCategoryById(id);;
     }
     
    @PutMapping("/{id}")
     public CategoryDto modifyProduct(@PathVariable("id") int id,@RequestBody CategoryDto category) {
         return    service.modifyCategory(id, category);}

}
