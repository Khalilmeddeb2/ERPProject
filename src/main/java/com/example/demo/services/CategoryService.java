package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.CategoryDto;


public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto category);
	List<CategoryDto> getAllCategorys();
	CategoryDto getCategoryById(int id);
	CategoryDto modifyCategory(int id, CategoryDto category);
	void deleteCategoryById(int id);

}
