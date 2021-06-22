package com.psap.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.psap.exceptions.NoSuchPaymentFoundException;
import com.psap.exceptions.PaymentFailureException;
import com.psap.model.Payment;
import com.psap.service.PaymentService;

@RestController
@RequestMapping("/Payment")
public class PaymentController {

	@Autowired
	PaymentService pservice;

	@PutMapping
	public ResponseEntity<?> parkingBookingPayment(@RequestBody Payment payment) throws PaymentFailureException {
		pservice.parkingBookingPayment(payment);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@GetMapping("/findbyid/{paymentId}")
	public ResponseEntity<Payment> fetchAllPaymentById(@PathVariable("paymentId") long paymentId) throws NoSuchPaymentFoundException {
		Optional<Payment> p = pservice.findPaymentById(paymentId);
		return new ResponseEntity<Payment>(p.get(),HttpStatus.OK);

	}


}
