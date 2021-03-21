package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ProductEntity;


public interface ProductRepository  extends JpaRepository<ProductEntity, Integer>{

}
