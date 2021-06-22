package com.psap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psap.model.Payment;
import com.psap.repository.PaymentRepository;

@SpringBootTest
public class PaymentServiceImplTest {

	@Autowired
	PaymentRepository repo;
	
	@Test
	public void parkingBookingPaymentTest() {
		Payment p = new Payment();
		p.setPaymentId(130);
		p.setAmountPaid(200);
		p.setPaymentDateTime(new Date());
		repo.save(p);
		assertNotNull(repo.findById((long) 130));
	}
	
	@Test
	public void findPaymentByIdTest() {
		Payment p = repo.findByPaymentId(130);
		assertEquals(p.getPaymentId(),130);
		
	}
}
