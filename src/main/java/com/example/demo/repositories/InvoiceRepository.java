package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.InvoiceEntiy;

public interface InvoiceRepository extends JpaRepository<InvoiceEntiy, Integer> {

}
