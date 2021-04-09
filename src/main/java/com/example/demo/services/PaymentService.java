package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.PaymentDto;

public interface PaymentService {

	PaymentDto createPayment(PaymentDto payment,int id);
	List<PaymentDto> getAllPayments();
	PaymentDto getPaymentById(int id);
	PaymentDto modifyPayment(int id, PaymentDto payment);
	void deletePaymentyById(int id);
}
