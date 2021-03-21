package com.example.demo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="OrderSale")
// commande vente
public class OrderSaleEntity {
	
	@Id
	private int number;
	//private int total;
	private LocalDate date;
	private float totalPrice;
	
	@ManyToOne
	private CustomerEntity customer;
	
	/*@ManyToOne
	private UserEntity user;*/
	
	@OneToOne
	private InvoiceEntiy invoice;
	
	@OneToMany(mappedBy = "orderSale",cascade = CascadeType.REMOVE)
	private List<LineSaleEntity> lineSales= new ArrayList<>();

}
