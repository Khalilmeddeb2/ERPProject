package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LineSaleDto;
import com.example.demo.services.LineSaleService;

@RestController
@RequestMapping("/api/LineSale")
public class LineSaleRest {
	private LineSaleService service;
	
	 @Autowired
     public LineSaleRest(LineSaleService service) {
		super();
		this.service = service;
	}
	 @PostMapping("/{id1}/{id2}")
		public LineSaleDto createLineSale(@PathVariable("id1") int id1 ,@PathVariable("id2") int id2,@RequestBody LineSaleDto LineSale) {
			
			return service.createLineSale(LineSale, id1, id2);
		}
	 @GetMapping
		public List<LineSaleDto> getAllLineSale() {
			return service.getAllLinesale();
		}
	 @GetMapping("/{id}")
		public LineSaleDto getLineSaletById(@PathVariable("id") int id) {
	    	return service.getLinesaleById(id);
	    }
	 @DeleteMapping("/{id}")
	    public void deleteLineById(@PathVariable("id") int id)
	    {
	    	service.deleteLinesaleById(id);
	    }
	 @PutMapping("/{id}")
		public LineSaleDto modifyLine(@PathVariable("id") int id,@RequestBody LineSaleDto LineSale) {
		    return	service.modifyLinesale(id, LineSale);}

	 

	 

	 

    

}



