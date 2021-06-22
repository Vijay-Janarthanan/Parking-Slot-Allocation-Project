package com.psap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.ParkingPremise;

@Repository
public interface ParkingPremiseRepository extends JpaRepository <ParkingPremise, Integer> {
	ParkingPremise findByParkingPremiseName(String parkingPremiseName);
	ParkingPremise findByParkingPremiseId(int parkingPremiseId);
}
