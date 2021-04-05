package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.InvoiceDto;
import com.example.demo.models.InvoiceEntiy;
import com.example.demo.models.OrderSaleEntity;
import com.example.demo.repositories.InvoiceRepository;
import com.example.demo.repositories.OrderSaleRepository;
@Service
public class InvoiceServiceImpl implements InvoiceService{

	 private InvoiceRepository reposInvoice;
	 //private OrderSaleRepository reposOrderSale;
	    private ModelMapper mapper;
	    @Autowired
	    public InvoiceServiceImpl(InvoiceRepository reposInvoice, OrderSaleRepository reposOrderSale,ModelMapper mapper) {
	        super();
	        this.reposInvoice = reposInvoice;
	        //this.reposOrderSale = reposOrderSale;
	        this.mapper = mapper;
	    }

	 

	    @Override
	    public InvoiceDto createInvoice(InvoiceDto invoice) {
	    InvoiceEntiy entity=mapper.map(invoice, InvoiceEntiy.class);
	    //OrderSaleEntity orderSaleEntity=entity.getOrderSale();
	    //OrderSaleEntity orderSaleNewEntity = reposOrderSale.save(orderSaleEntity);
	    //entity.setOrderSale(orderSaleNewEntity);
	    InvoiceEntiy newEntity =reposInvoice.save(entity);
	        return mapper.map(newEntity, InvoiceDto.class);
	    }

	 

	    @Override
	    public List<InvoiceDto> getAllInvoices() {
	        List<InvoiceDto>listInvoicesDto =new ArrayList<>();
	        List<InvoiceEntiy>listInvoiceEntity=reposInvoice.findAll();
	        for (InvoiceEntiy Entity : listInvoiceEntity) {
	            listInvoicesDto.add(mapper.map(Entity,InvoiceDto.class));
	        }
	        
	        
	        return listInvoicesDto;    }

	 

	    @Override
	    public InvoiceDto getInvoiceById(int id) {
	        InvoiceEntiy entity=reposInvoice.findById(id).get();
	        return mapper.map(entity, InvoiceDto.class);
	    }

	 

	    @Override
	    public InvoiceDto modifyInvoice(int id, InvoiceDto Invoice) {
	        InvoiceEntiy entity=reposInvoice.findById(id).get();
	        entity.setDescription(Invoice.getDescription());
	        entity.setDate(Invoice.getDate());
	        InvoiceEntiy newEntity=reposInvoice.save(entity);
	        return mapper.map(newEntity, InvoiceDto.class);
	            }

	 

	    @Override
	    public void deleteInvoiceById(int id) {
	        reposInvoice.deleteById(id);
	    }


	    // le nombre des factures dans le stock
		@Override
		public int getTotalNumberInvoices() {
			List<InvoiceEntiy> invoices = reposInvoice.findAll();
			return invoices.size();
		}

	 

	}
	

