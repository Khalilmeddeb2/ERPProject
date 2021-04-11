package com.example.demo.services;

import java.util.List;
import com.example.demo.dto.PurchaseOrderDto;

public interface PurchaseOrderService {
	PurchaseOrderDto createPurchaseOrder(PurchaseOrderDto purchaseOrder,int id);
	List<PurchaseOrderDto> getAllPurchaseOrder();
	PurchaseOrderDto getPurchaseOrderById(int id);
	PurchaseOrderDto modifyPurchaseOrder(int id, PurchaseOrderDto purchaseOrder);
	PurchaseOrderDto deletePurchaseOrderById(int id);
	public float calculOrder(int num);

}
