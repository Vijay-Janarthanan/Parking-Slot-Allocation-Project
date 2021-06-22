package com.psap.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository <Payment, Long>{
	
	List<Payment> findBypaymentDateTime(Date paymentDate);
	Payment findByPaymentId(long paymentId);

}