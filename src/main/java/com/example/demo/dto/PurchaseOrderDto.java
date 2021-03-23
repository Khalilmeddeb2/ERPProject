package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.models.InvoiceEntiy;
import com.example.demo.models.ProviderEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDto {
	
	private int number;
	//private int total;
	private LocalDate date;
	private float totalPrice;
	private ProviderDto provider ;   
	private InvoiceDto invoice;

}
