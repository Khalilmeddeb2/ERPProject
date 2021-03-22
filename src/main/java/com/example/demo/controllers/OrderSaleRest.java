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

import com.example.demo.dto.OrderSaleDto;
import com.example.demo.services.OrderSaleService;

@RestController
@RequestMapping("/api/orderSale")

public class OrderSaleRest {
	
	private OrderSaleService service;
    
	@Autowired
    public OrderSaleRest(OrderSaleService service) {
        super();
        this.service = service;
    }
     @PostMapping("/{id}")
        public OrderSaleDto createProduct(  @PathVariable("id") int id,@RequestBody OrderSaleDto OrderSale) {
            
            return service.createOrderSale(OrderSale,id);
        }
     @GetMapping
        public List<OrderSaleDto> getAllOrderSale() {
            return service.getAllOrderSales();
        }
     @GetMapping("/{id}")
        public OrderSaleDto getOrderSaletById(@PathVariable("id") int id) {
            return service.getOrderSaleById(id);
        }
     @DeleteMapping("/{id}")
        public void deleteOrderSaleById(@PathVariable("id") int id)
        {
            service.deleteOrderSaleById(id);;
        }
     @PutMapping("/{id}")
        public OrderSaleDto modifyOrderSale(@PathVariable("id") int id,@RequestBody OrderSaleDto order) {
            return    service.modifyOrderSale(id, order);
            }
     
     // prix total de la commande 
     @GetMapping("/totalPriceOrderSale/{id}")
     public float calculCommande(@PathVariable("id") int id) {
    	 return service.calculCommande(id);
    	 
     }

}
