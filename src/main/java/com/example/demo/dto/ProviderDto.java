package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDto {
	private int id;
	private String FirstName;
	private String LastName;
	private String Email;
	private String adresse;
	private String ville;
	private int phoneNumber;
    private String image;
    

}
