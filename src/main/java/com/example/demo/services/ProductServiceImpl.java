package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
import com.example.demo.models.CategoryEntity;
import com.example.demo.models.LineSaleEntity;
import com.example.demo.models.ProductEntity;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository reposProduct;
	private CategoryRepository reposCategory;
	private ModelMapper mapper;
	
	
    @Autowired
	public ProductServiceImpl(ProductRepository reposProduct, CategoryRepository reposCategory,ModelMapper mapper) {
		super();
		this.reposProduct = reposProduct;
		this.reposCategory = reposCategory;
		this.mapper = mapper;
	}

	@Override
	public ProductDto createProduct(ProductDto product ,int id) {
		
		ProductEntity entity=mapper.map(product, ProductEntity.class);
		CategoryEntity catEntity=reposCategory.findById(id).get();
		entity.setCategory(catEntity);
		ProductEntity newEntity=reposProduct.save(entity);
		return mapper.map(newEntity, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto>listProductDto =new ArrayList<>();
		List<ProductEntity>listProductEntity=reposProduct.findAll();
		for (ProductEntity productEntity : listProductEntity) {
			listProductDto.add(mapper.map(productEntity, ProductDto.class));
		}
		
		
		return listProductDto;
	}
		

	@Override
	public ProductDto getProductById(int id) {
		
		ProductEntity entity;
		Optional<ProductEntity> opt = reposProduct.findById(id);
		if(opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("product with this id is not found");
		
		return mapper.map(entity, ProductDto.class);
	}

		
	

	@Override
	public ProductDto modifyProduct(int id, ProductDto product) {
		ProductEntity entity=reposProduct.findById(id).get();
		entity.setName(product.getName());
		entity.setDescription(product.getDescription());
		entity.setImage(product.getImage());
		entity.setPriceAchat(product.getPriceAchat());
		entity.setPriceVente(product.getPriceVente());
		//entity.setStatuts(product.get);
		ProductEntity newEntity=reposProduct.save(entity);
		return mapper.map(newEntity, ProductDto.class);
	
	}

	@Override
	public void deleteProductyById(int id) {
		reposProduct.deleteById(id);

	}

	@Override
	public String getProductlePlusAchete() {
		int max =0;
		LineSaleEntity lineSaleMaxQt =null;
		ProductEntity productPlusAchete =null;
	  List<ProductEntity> products=reposProduct.findAll();
	  for (ProductEntity product : products) {
          for(LineSaleEntity line : product.getLineSales())
          {
        	 if(line.getQt()>max) {
        		 max=line.getQt();
        		 lineSaleMaxQt=line;
        		 productPlusAchete =product;
        	 }
          }
          
	}
		return productPlusAchete.getName();
	}

	@Override
	public int getNumberProducts() {
		 List<ProductEntity> products=reposProduct.findAll();
	     return products.size();
	}

}
