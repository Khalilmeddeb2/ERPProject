package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.LineSaleDto;

public interface LineSaleService {

	LineSaleDto createLineSale(LineSaleDto linesale,int idProduct , int numberOrderSale);
	List<LineSaleDto> getAllLinesale();
	LineSaleDto getLinesaleById(int id);
	LineSaleDto modifyLinesale(int id, LineSaleDto category);
	void deleteLinesaleById(int id);
}
