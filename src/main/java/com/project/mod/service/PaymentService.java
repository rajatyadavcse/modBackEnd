package com.project.mod.service;

import java.util.List;

import com.project.mod.model.Payment;

public interface PaymentService {
	
	Payment create(Payment payment);
	
	Payment delete(int id);
	
	List<Payment> findAll();
	
	Payment findById(int id);
	
	Payment update(Payment payment);
}
