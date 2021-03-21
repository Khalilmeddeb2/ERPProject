package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.OrderSaleEntity;

public interface OrderSaleRepository extends JpaRepository<OrderSaleEntity, Integer>{

}
