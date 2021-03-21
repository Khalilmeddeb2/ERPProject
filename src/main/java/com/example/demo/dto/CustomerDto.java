package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	
	
	private int id;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Username;
	private int phoneNumber;
	private String address;
	private String type;

}
