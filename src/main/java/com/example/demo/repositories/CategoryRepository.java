package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.CategoryEntity;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	

}
