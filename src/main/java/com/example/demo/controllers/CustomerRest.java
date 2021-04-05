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

import com.example.demo.dto.CustomerDto;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRest {
	private CustomerService service;

	@Autowired
	public CustomerRest(CustomerService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public CustomerDto createCustomer(@RequestBody CustomerDto customer) {
		return service.createCustomer(customer);
	}
	
	@GetMapping
	public List<CustomerDto> getAllCustomers() {
		return service.getAllCustomers();
	}

	@GetMapping("/{id}")
	public CustomerDto getCustomertById(@PathVariable("id") int id) {
		return service.getCustomerById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomerById(@PathVariable("id") int id) {
		service.deleteCustomerById(id);
	}
	
	@PutMapping("/{id}")
	public CustomerDto modifyCustomer(@PathVariable("id")int id, @RequestBody CustomerDto customer) {	
		return service.modifyCustomer(id, customer);
	}
	
	
	// le client le plus fidele
	@GetMapping("/plusFidele")
	public String getClientFidele() {
		return service.getClientFidele();
	}
	
	
	// le nombre des client dans le stock 
	@GetMapping("/NumberCustomers")
	public int getNumberclients()
	{
		return service.getTotalNumberclients();
	}
	
}
