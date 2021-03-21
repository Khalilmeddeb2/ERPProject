package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Products")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	private String Description;
	private double PriceVente;
	private double priceAchat;
	private boolean statuts;
	private String image ;
	private int quantite;
	
	@ManyToOne
    //""@Column(insertable=true, updatable=true)
	private CategoryEntity category;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	private List<LineSaleEntity> lineSales= new ArrayList<>();
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	private List<BuyLineEntity> lineBuys= new ArrayList<>();
	
	

}
