package com.example.demo.models;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



	@Entity
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Table(name="Users")
	public class UserEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private int id;
		private String FirstName;
		private String LastName;
		private String Email;
		private String Username;
		private String password;
		private String Role;
		
		/*@OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
		private List<OrderSaleEntity> salesOrders= new ArrayList<>();
		
		@OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
		private List<PurchaseOrderEntity> purchaseOrders= new ArrayList<>();*/
}
