package com.example.demo.services;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.RepoCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    
    @Autowired
    RepoCustom repo;

    public List<Payment> getPayment(){
        return paymentRepository.findAll();
    }
    
    public void createNewPayment(Payment payment) {
		repo.add_editPayment(payment);
	}
}

