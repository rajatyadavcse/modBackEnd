package com.project.mod.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.project.mod.model.Payment;

public interface PaymentRepository extends Repository<Payment, Integer> {
	
	Payment delete(Payment payment);
	
	List<Payment> findAll();
	
	Payment findOne(int id);
	
	Payment save(Payment payment);
}
