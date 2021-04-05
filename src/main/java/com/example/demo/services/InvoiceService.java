package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.InvoiceDto;

public interface InvoiceService {
	
	InvoiceDto createInvoice(InvoiceDto invoice);
    List<InvoiceDto> getAllInvoices();
    InvoiceDto getInvoiceById(int id);
    InvoiceDto modifyInvoice(int id, InvoiceDto category);
    void deleteInvoiceById(int id);
     
    // le nombre des factures dans le stock
    int getTotalNumberInvoices();
}
