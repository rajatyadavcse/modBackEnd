package com.project.mod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mod.model.Payment;
import com.project.mod.model.Training;
import com.project.mod.service.PaymentService;
import com.project.mod.service.TrainingService;

@RestController
@CrossOrigin
@RequestMapping({"/payments"})
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private TrainingService trainingService;
	
	@PostMapping
	public Payment create(@RequestBody Payment payment) {
		if(payment.getTrainingId()!= null) {
			Training training = trainingService.findById(payment.getTrainingId());
			if(training!=null)
			{
				training.getPayment().add(payment);
				trainingService.create(training);
			}
			return payment;
		}
		else {
			return paymentService.create(payment);
		}
	}
	
	@GetMapping(path = {"/{id}"})
	public Payment findOne(@PathVariable("id") int id) {
		return paymentService.findById(id);
	}
	
	@PutMapping(path = {"/{id}"})
    public Payment update(@PathVariable("id") int id, @RequestBody Payment payment){
        payment.setId(id);
        return paymentService.update(payment);
    }

    @DeleteMapping(path ={"/{id}"})
    public Payment delete(@PathVariable("id") int id) {
        return paymentService.delete(id);
    }

    @GetMapping
    public List<Payment> findAll(){
        return paymentService.findAll();
    }
}
