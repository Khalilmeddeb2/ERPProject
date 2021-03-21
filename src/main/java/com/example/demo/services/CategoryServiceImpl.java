package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.models.CategoryEntity;
import com.example.demo.repositories.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository reposCategoty;
	
	private ModelMapper mapper;
	
	
	
    @Autowired
	public CategoryServiceImpl(CategoryRepository reposCategoty, ModelMapper mapper) {
		super();
		this.reposCategoty = reposCategoty;
		this.mapper = mapper;
	}

	@Override
	public CategoryDto createCategory(CategoryDto category) {
		CategoryEntity entity=mapper.map(category, CategoryEntity.class);
		CategoryEntity newEntity=reposCategoty.save(entity);
		/*if(entity.getProducts()!=null) {
			for(ProductEntity product :entity.getProducts()) {
				product.setCategory(entity);
		        reposProduct.save(product);		
		       
			}
		}*/
		
		
		return mapper.map(newEntity, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategorys() {
		List<CategoryDto>listCategorysDto =new ArrayList<>();
		List<CategoryEntity>listCategoryEntity=reposCategoty.findAll();
		for (CategoryEntity categoryEntity : listCategoryEntity) {
			listCategorysDto.add(mapper.map(categoryEntity, CategoryDto.class));
		}
		
		
		return listCategorysDto;
	}

	@Override
	public CategoryDto getCategoryById(int id) {
		CategoryEntity entity=reposCategoty.findById(id).get();
		return mapper.map(entity, CategoryDto.class);
	}

	@Override
	public CategoryDto modifyCategory(int id, CategoryDto category) {
		
		CategoryEntity entity=reposCategoty.findById(id).get();
		entity.setType(category.getType());
		CategoryEntity newEntity=reposCategoty.save(entity);
		
		return mapper.map(newEntity, CategoryDto.class);
		
	}

	@Override
	public void deleteCategoryById(int id) {
		reposCategoty.deleteById(id);

	}

}
