package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ProviderEntity;

public interface ProviderRepository extends JpaRepository<ProviderEntity, Integer> {

}
