package com.psap.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.psap.exceptions.NoSuchParkingSlotException;
import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.model.ParkingPremise;
import com.psap.model.ParkingSlots;

@Service
public interface ParkingService {
	public boolean checkAvailability(Date date, String time) throws ParkingSlotNotAvailableException;
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException;
	public boolean cancelParkingSlotBooking(long parkingSlotId) throws NoSuchParkingSlotException;
	
	public List<ParkingSlots> getAllParkingSlotsByPremise(ParkingPremise parkingPremise);
	public Optional<ParkingSlots> getParkingSlotsById(long parkingSlotId)throws NoSuchParkingSlotException;
	
	
}
