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

import com.example.demo.dto.InvoiceDto;
import com.example.demo.services.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceRest {
	
	private InvoiceService service;
	@Autowired

	 
	public InvoiceRest(InvoiceService service) {
	    super();
	    this.service = service;
	}

	 
	@PostMapping
	public InvoiceDto createProduct( @RequestBody InvoiceDto invoice) {
	    
	    return service.createInvoice(invoice);
	}
	
	
	@GetMapping
	public List<InvoiceDto> getAllInvoice() {
	    return service.getAllInvoices();
	} 
	
	
	@GetMapping("/{id}")
	public InvoiceDto getInvoiceById(@PathVariable("id") int id) {
	    return service.getInvoiceById(id);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteInvoiceById(@PathVariable("id") int id)
	{
	    service.deleteInvoiceById(id);
	}
	
	
	@PutMapping("/{id}")
	public InvoiceDto modifyProduct(@PathVariable("id") int id,@RequestBody InvoiceDto invoice) {
	    return    service.modifyInvoice(id, invoice);}
	
	
	@GetMapping("/TotalInvoice")
	public int getNumberInvoices() {
	  return service.getNumberInvoices();
	}


	}



