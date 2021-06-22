package com.psap.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import com.psap.exceptions.NoSuchPaymentFoundException;
import com.psap.exceptions.PaymentFailureException;
import com.psap.model.Payment;

@Service
public interface PaymentService {
	public boolean parkingBookingPayment(Payment payment) throws PaymentFailureException;
	public Optional<Payment> findPaymentById(long paymentId) throws NoSuchPaymentFoundException;

}