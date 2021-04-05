package com.example.demo.services;

import java.util.List;
import com.example.demo.dto.CustomerDto;

public interface CustomerService {

	CustomerDto createCustomer(CustomerDto customer);
	List<CustomerDto> getAllCustomers();
	CustomerDto getCustomerById(int id);
	CustomerDto modifyCustomer(int id, CustomerDto customer);
	void deleteCustomerById(int id);
	
	// le client le plus fidele
	String getClientFidele();
	
	
	// le nombre des client dans le stock 
	int getTotalNumberclients();
}
