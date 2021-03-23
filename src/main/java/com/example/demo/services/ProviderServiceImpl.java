package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProviderDto;
import com.example.demo.models.ProviderEntity;
import com.example.demo.repositories.ProviderRepository;


@Service
public class ProviderServiceImpl implements ProviderService {
	private ProviderRepository repoProvider;
	private ModelMapper mapper ;
	
	@Autowired
	public ProviderServiceImpl(ProviderRepository repoProvider,ModelMapper mapper)
	{
		this.repoProvider=repoProvider;
		this.mapper=mapper;
	}

	@Override
	public ProviderDto createProvider(ProviderDto provider) {
		// TODO Auto-generated method stub
		//saving provider
		ProviderEntity entity=mapper.map(provider, ProviderEntity.class);
		ProviderEntity  newEntity = repoProvider.save(entity);
		
		return mapper.map(newEntity, ProviderDto.class);
	}

	@Override
	public List<ProviderDto> getAllProvider() {
		// TODO Auto-generated method stub
		List<ProviderDto> listProvider = new ArrayList<>();
		List<ProviderEntity> listProviderEntity=repoProvider.findAll();
		for(ProviderEntity provider:listProviderEntity)
		{
			listProvider.add(mapper.map(provider, ProviderDto.class));
		}
		return listProvider;
	}

	@Override
	public ProviderDto getProviderById(int id) {
		// TODO Auto-generated method stub
		ProviderEntity entity = mapper.map(ProviderDto.class,ProviderEntity.class);
		Optional<ProviderEntity> newEntity = repoProvider.findById(id);
		if(newEntity.isPresent())
		{
			entity = newEntity.get();
		}
		else 
		{
			throw new NoSuchElementException("Provider with this id is not found");
		}
		ProviderDto provider = new ProviderDto(entity.getId(), entity.getFirstName(),
				entity.getLastName(),entity.getEmail(),entity.getAdresse(), entity.getVille(),
				entity.getPhoneNumber(),entity.getImage());
		
		
		return mapper.map(provider, ProviderDto.class);
	}

	@Override
	public ProviderDto modifyProvider(int id, ProviderDto newProvider) {
		// TODO Auto-generated method stub
		ProviderEntity entity = mapper.map(newProvider,ProviderEntity.class);
		ProviderEntity oldProvider = repoProvider.findById(id).get();
		if (newProvider.getFirstName()!=null)
			oldProvider.setFirstName(newProvider.getFirstName());
		if(newProvider.getLastName()!=null)
			oldProvider.setLastName(newProvider.getLastName());
		if(newProvider.getAdresse()!=null)
			oldProvider.setAdresse(newProvider.getAdresse());
		if(newProvider.getEmail()!=null)
			oldProvider.setAdresse(newProvider.getEmail());
		if(newProvider.getPhoneNumber()!=0)
			oldProvider.setPhoneNumber(newProvider.getPhoneNumber());
		


		return mapper.map(repoProvider.save(oldProvider),ProviderDto.class);
	}

	@Override
	public ProviderDto deleteProviderById(int id) {
		// TODO Auto-generated method stub
		ProviderDto entity = this.getProviderById(id);
		repoProvider.deleteById(id);
		return entity;

	}

}
