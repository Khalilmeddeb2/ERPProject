package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.LineBuyDto;

public interface LineBuyService {
	LineBuyDto createLineBuy(LineBuyDto lineBuy,int idProduct , int purchaseNumber);
	List<LineBuyDto> getAllLineBuy();
	LineBuyDto getLineById(int id);
	LineBuyDto modifyLineBuy(int id, LineBuyDto lineBuy);
	LineBuyDto deleteLineBuyById(int id);

}
