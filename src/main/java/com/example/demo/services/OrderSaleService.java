package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.OrderSaleDto;

public interface OrderSaleService {
	
	OrderSaleDto createOrderSale(OrderSaleDto OrderSale, int id );
    List<OrderSaleDto> getAllOrderSales();
    OrderSaleDto getOrderSaleById(int id);
    OrderSaleDto modifyOrderSale(int id, OrderSaleDto OrderSale);
    void deleteOrderSaleById(int id);
    // methode de calcul de commande 
    /*float calculCommande(int numero);*/

}
