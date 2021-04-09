package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LineSaleDto;
import com.example.demo.models.LineSaleEntity;
import com.example.demo.models.OrderSaleEntity;
import com.example.demo.models.ProductEntity;
import com.example.demo.repositories.LineSaleRepository;
import com.example.demo.repositories.OrderSaleRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class LineSaleServiceImpl implements LineSaleService {

	   private LineSaleRepository reposLineSale;
	   private ProductRepository reposProduct;
	   private OrderSaleRepository reposOrderSale;
	   private OrderSaleService orderService;
	   private ModelMapper mapper;

	  

		public LineSaleServiceImpl(LineSaleRepository reposLineSale, ProductRepository reposProduct,
			OrderSaleRepository reposOrderSale, OrderSaleService orderService, ModelMapper mapper) {
		super();
		this.reposLineSale = reposLineSale;
		this.reposProduct = reposProduct;
		this.reposOrderSale = reposOrderSale;
		this.orderService = orderService;
		this.mapper = mapper;
	}

		@Override
		public LineSaleDto createLineSale(LineSaleDto linesale,int idProduct , int numberOrderSale) {
			LineSaleEntity entityLineSale =mapper.map(linesale, LineSaleEntity.class);
			ProductEntity entityProduct =reposProduct.findById(idProduct).get();
			OrderSaleEntity entityOrdersale = reposOrderSale.findById(numberOrderSale).get();
			entityLineSale.setProduct(entityProduct);
			entityLineSale.setOrderSale(entityOrdersale);
			entityOrdersale.getLineSales().add(entityLineSale);
			LineSaleEntity newEntityLineSale = reposLineSale.save(entityLineSale);
			entityLineSale.getOrderSale().setTotalPrice(orderService.calculCommande(numberOrderSale));
			reposOrderSale.save(entityOrdersale);
			return mapper.map(newEntityLineSale, LineSaleDto.class);
		}

		@Override
		public List<LineSaleDto> getAllLinesale() {
			List<LineSaleDto>ListLineSaleDto =new ArrayList<>();
			List<LineSaleEntity>ListLineSaleEntity=reposLineSale.findAll();
			for (LineSaleEntity entity : ListLineSaleEntity) {
				ListLineSaleDto.add(mapper.map(entity, LineSaleDto.class));
			}
			
			
			return ListLineSaleDto;
				
				}

		@Override
		public LineSaleDto getLinesaleById(int id) {
			LineSaleEntity entity = reposLineSale.findById(id).get();
			return mapper.map(entity, LineSaleDto.class);
		}

		@Override
		public LineSaleDto modifyLinesale(int id, LineSaleDto LineSale) {
			LineSaleEntity entity=reposLineSale.findById(id).get();
			entity.setQt(LineSale.getQt());
			entity.setDescription(LineSale.getDescription());
			//entity.setType(category.getType());
			LineSaleEntity newEntity=reposLineSale.save(entity);
			return mapper.map(newEntity, LineSaleDto.class);
				}

		@Override
		public void deleteLinesaleById(int id) {
			reposLineSale.deleteById(id);
		}

}
