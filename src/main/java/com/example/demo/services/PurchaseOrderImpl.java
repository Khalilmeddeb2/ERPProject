package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProviderDto;
import com.example.demo.dto.PurchaseOrderDto;
import com.example.demo.models.InvoiceEntiy;
import com.example.demo.models.ProviderEntity;
import com.example.demo.models.PurchaseOrderEntity;
import com.example.demo.repositories.InvoiceRepository;
import com.example.demo.repositories.ProviderRepository;
import com.example.demo.repositories.PurchaseOrderRepository;
@Service
public class PurchaseOrderImpl implements PurchaseOrderService {
	private PurchaseOrderRepository repoPurchaseOrder;
	private ProviderRepository repoProvider;
	private InvoiceRepository repoInvoice;
	
	private ModelMapper mapper;
	
	
	@Autowired
	public PurchaseOrderImpl (PurchaseOrderRepository repoPurchaseOrder,ProviderRepository repoProvider,
			InvoiceRepository repoInvoice,ModelMapper mapper)
	{
		this.repoPurchaseOrder=repoPurchaseOrder;
		this.repoProvider=repoProvider;
		this.repoInvoice=repoInvoice;
		this.mapper=mapper;
	}
	@Override
	public PurchaseOrderDto createPurchaseOrder(PurchaseOrderDto purchaseOrder,int id) {
		// TODO Auto-generated method stub
		PurchaseOrderEntity entity=mapper.map(purchaseOrder, PurchaseOrderEntity.class);
		ProviderEntity provider = repoProvider.findById(id).get();
		ProviderEntity providerEntityinBd = repoProvider.save(provider);
		entity.setProvider(providerEntityinBd);
		InvoiceEntiy invoice=entity.getInvoice();
		entity.setInvoice(invoice);
		PurchaseOrderEntity  newEntity = repoPurchaseOrder.save(entity);

		
		
		return mapper.map(newEntity, PurchaseOrderDto.class);
	}

	@Override
	public List<PurchaseOrderDto> getAllPurchaseOrder() {
		// TODO Auto-generated method stub
		List<PurchaseOrderDto> purchaseOrderDto = new ArrayList<>();
		List<PurchaseOrderEntity> purchaseOrder=repoPurchaseOrder.findAll();
		for(PurchaseOrderEntity purchaseOrderEntity:purchaseOrder)
		{
			purchaseOrderDto.add(mapper.map(purchaseOrderEntity, PurchaseOrderDto.class));
			
		}
		return purchaseOrderDto;
	}

	@Override
	public PurchaseOrderDto getPurchaseOrderById(int id) {
		PurchaseOrderEntity entity = mapper.map(PurchaseOrderDto.class,PurchaseOrderEntity.class);
		Optional<PurchaseOrderEntity> newEntity = repoPurchaseOrder.findById(id);
		if(newEntity.isPresent())
		{
			entity = newEntity.get();
		}
		else 
			throw new NoSuchElementException("This purchase order is not fount");
		/*PurchaseOrderDto purchaseOrdr = new PurchaseOrderDto(entity.getNumber(),
				entity.getDate(),entity.getTotalPrice(),entity.getProvider(),entity.getInvoice());*/

		

		return mapper.map(entity, PurchaseOrderDto.class);
	}

	@Override
	public PurchaseOrderDto modifyPurchaseOrder(int id, PurchaseOrderDto newPurchaseOrder) {
		// TODO Auto-generated method stub
		PurchaseOrderEntity entity = mapper.map(newPurchaseOrder,PurchaseOrderEntity.class);
		PurchaseOrderEntity oldPurchaseOrder = repoPurchaseOrder.findById(id).get();
		if(newPurchaseOrder.getDate()!=null)
			oldPurchaseOrder.setDate(newPurchaseOrder.getDate());
		if(newPurchaseOrder.getTotalPrice()!=0)
			oldPurchaseOrder.setTotalPrice(newPurchaseOrder.getTotalPrice());
		
		
		return mapper.map(repoPurchaseOrder.save(oldPurchaseOrder),PurchaseOrderDto.class);
	}

	@Override
	public PurchaseOrderDto deletePurchaseOrderById(int id) {
		// TODO Auto-generated method stub
		PurchaseOrderDto entity = this.getPurchaseOrderById(id);
		repoPurchaseOrder.deleteById(id);
		return entity;

	}

}
