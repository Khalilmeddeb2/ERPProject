package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

}
