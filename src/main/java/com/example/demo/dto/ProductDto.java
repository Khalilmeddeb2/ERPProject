package com.example.demo.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class ProductDto {
	
	private int id;
	private String Name;
	private String Description;
	private double PriceVente;
	private double priceAchat;
	private boolean statuts;
	private String image ;
	private int quantite;
	
    
	private CategoryDto category;
}
