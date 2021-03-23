package com.example.demo.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineBuyDto {
	private int id;
	private int Qt;
	private String description;
	private ProductDto product;
	private PurchaseOrderDto purchaseOrder;

}
