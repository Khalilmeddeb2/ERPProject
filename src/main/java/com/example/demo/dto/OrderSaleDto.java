package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSaleDto {

	private int number;
    private LocalDate date;
    //private float totalPrice;
    
    private CustomerDto customer;
    
    private InvoiceDto invoice;
}
