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
import com.example.demo.dto.ProviderDto;
import com.example.demo.services.ProviderService;

@RestController
@RequestMapping("/api/providers")
public class ProviderRest {
	private ProviderService service;
	
	
	
	@Autowired
	public ProviderRest(ProviderService service) {
		super();
		// TODO Auto-generated constructor stub
		this.service=service;
	}
	@PostMapping
	public ProviderDto createProvider(@RequestBody ProviderDto provider)
	{
		return service.createProvider(provider);
	}
	
	@GetMapping
	public List<ProviderDto> getAllProviders()
	{
		return service.getAllProvider();		
	}
	@GetMapping("/{id}")
	public ProviderDto getProviderById(@PathVariable("id") int id) {
		return service.getProviderById(id);
	}
	@PutMapping("/{id}")
	public ProviderDto modifyProvider(@PathVariable("id")int id, @RequestBody ProviderDto provider) {	
		return service.modifyProvider(id, provider);
	}
	@DeleteMapping("/{id}")
	public ProviderDto deleteProviderById(@PathVariable("id") int id) {
		return service.deleteProviderById(id);
	}

}
