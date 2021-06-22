package com.psap.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.ParkingSlots;

@Repository
public interface ParkingSlotsRepository extends JpaRepository <ParkingSlots, Long>{

	ParkingSlots findByParkingDateAndParkingTime(Date d, String t);
	
	ParkingSlots findByParkingSlotId(long parkingSlotId);
//	List<ParkingSlots> findByParkingPremises()
	
}
