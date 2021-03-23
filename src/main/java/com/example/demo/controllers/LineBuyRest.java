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

import com.example.demo.dto.LineBuyDto;
import com.example.demo.services.LineBuyService;

@RestController
@RequestMapping("/api/lineBuys")
public class LineBuyRest {
	private LineBuyService service ;
	
	@Autowired
	public LineBuyRest(LineBuyService service ) {
		// TODO Auto-generated constructor stub
		super();
		this.service=service;
	}
	
	
	@PostMapping("/{idProduct}/{numberPurchase}")
	public LineBuyDto createLineBuy(@RequestBody LineBuyDto lineBuy,  @PathVariable("idProduct") int idProduct,
			@PathVariable("numberPurchase")int purchaseNumber) {
		return service.createLineBuy(lineBuy, idProduct, purchaseNumber);
	}
	
	@GetMapping
	public List<LineBuyDto> getAllLineBuy() {
		return service.getAllLineBuy();
	}
	@GetMapping("/{id}")
	public LineBuyDto getLineBusById(@PathVariable("id") int id) {
		return service.getLineById(id);
	}
	@PutMapping("/{id}")
	public LineBuyDto modifyLineBuy(@PathVariable("id")int id, @RequestBody LineBuyDto lineBuy) {	
		return service.modifyLineBuy(id, lineBuy);
	}
	@DeleteMapping("/{id}")
	public LineBuyDto deleteLineBuyById(@PathVariable("id") int id) {
		return service.deleteLineBuyById(id);
	}
	
	

}
