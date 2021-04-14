package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PaymentDto;
import com.example.demo.models.InvoiceEntiy;
import com.example.demo.models.PaymentEntity;
import com.example.demo.repositories.InvoiceRepository;
import com.example.demo.repositories.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	private PaymentRepository reposPayement;
	private InvoiceRepository reposInvoice;
	private ModelMapper mapper;
	
	
    @Autowired
	public PaymentServiceImpl(PaymentRepository reposPayement, InvoiceRepository reposInvoice, ModelMapper mapper) {
		super();
		this.reposPayement = reposPayement;
		this.reposInvoice = reposInvoice;
		this.mapper = mapper;
	}

	@Override
	public PaymentDto createPayment(PaymentDto payment, int id) {
		
		PaymentEntity entity=mapper.map(payment, PaymentEntity.class);
		InvoiceEntiy invoiceEntity=reposInvoice.findById(id).get();
		if(invoiceEntity.getTotPayments() >= entity.getMontant()) {
			invoiceEntity.setTotPayments(invoiceEntity.getTotPayments()-entity.getMontant());
			entity.setInvoice(invoiceEntity);
		reposPayement.save(entity);
		}
		else
		{
			throw new NoSuchElementException("payment with this montant it is impossible");
		}
		
		return mapper.map(entity, PaymentDto.class);
		
	}

	@Override
	public List<PaymentDto> getAllPayments() {
		List<PaymentDto>listPaymentDto =new ArrayList<>();
		List<PaymentEntity>listPaymentEntity=reposPayement.findAll();
		for (PaymentEntity paymentEntity : listPaymentEntity) {
			listPaymentDto.add(mapper.map(paymentEntity, PaymentDto.class));
		}
		
		
		return listPaymentDto;
	}

	

	@Override
	public PaymentDto getPaymentById(int id) {

		PaymentEntity entity;
		Optional<PaymentEntity> opt = reposPayement.findById(id);
		if(opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("payment with this id is not found");
		
		return mapper.map(entity, PaymentDto.class);
	}

	@Override
	public PaymentDto modifyPayment(int id, PaymentDto payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePaymentyById(int id) {
		reposPayement.deleteById(id);

	}

}
