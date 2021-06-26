package com.project.mod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mod.model.Payment;
import com.project.mod.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repository;
	
	@Override
	public Payment create(Payment payment) {
		return repository.save(payment);
	}

	@Override
	public Payment delete(int id) {
		Payment payment = findById(id);
		if(payment!=null) {
			repository.delete(payment);
		}
		return payment;
	}

	@Override
	public List<Payment> findAll() {
		return repository.findAll();
	}

	@Override
	public Payment findById(int id) {
		return repository.findOne(id);
	}

	@Override
	public Payment update(Payment payment) {
		return repository.save(payment);
	}

}
