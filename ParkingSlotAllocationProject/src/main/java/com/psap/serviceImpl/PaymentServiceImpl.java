package com.psap.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psap.exceptions.NoSuchPaymentFoundException;
import com.psap.exceptions.PaymentFailureException;
import com.psap.model.Payment;
import com.psap.repository.PaymentRepository;
import com.psap.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository dao;
	
	//Parking Booking payment
	@Override
	public boolean parkingBookingPayment(Payment payment) throws PaymentFailureException {
		// TODO Auto-generated method stub
		Optional<Payment> p= dao.findById(payment.getPaymentId()) ;
		if(p.isPresent())
			throw new PaymentFailureException("Payment Fail");
		dao.save(payment);
		return true;
	}

	// Check for payment by id
	@Override
	public Optional<Payment> findPaymentById(long paymentId) throws NoSuchPaymentFoundException {
		Optional<Payment> p= dao.findById(paymentId);
		if(!p.isPresent())
			throw new NoSuchPaymentFoundException("No payment for this id");
		return p;
	}

}