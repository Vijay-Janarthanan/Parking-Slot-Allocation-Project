package com.psap.service;

import org.springframework.stereotype.Service;

import com.psap.exceptions.NotificationException;
import com.psap.model.ParkingSlots;
import com.psap.model.User;

@Service
public interface NotificationService {
	public String sendRegistrationByEmail(User user) throws NotificationException;
	public String sendParkingConfirmationByEmail(User user, ParkingSlots slot) throws NotificationException;
	public String sendParkingCancellationByEmail(User user, ParkingSlots slot) throws NotificationException;
	public String  sendForgotPasswordByEmail(User user) throws NotificationException;
	public String  sendLoginIdByEmail(User user) throws NotificationException;
}
