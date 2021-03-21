package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="LineBuy")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//ligne d'achat
public class BuyLineEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int Qt;
	private String description;
	
	@ManyToOne
	private ProductEntity product;
	
	@ManyToOne
	private PurchaseOrderEntity purchaseOrder;

}
