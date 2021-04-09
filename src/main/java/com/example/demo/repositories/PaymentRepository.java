package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

}
