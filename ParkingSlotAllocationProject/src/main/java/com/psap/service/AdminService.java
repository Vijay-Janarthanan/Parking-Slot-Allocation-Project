package com.psap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.psap.exceptions.DuplicateParkingFloorException;
import com.psap.exceptions.DuplicateParkingPremiseException;
import com.psap.exceptions.InvalidLoginCredintialException;
import com.psap.exceptions.NoSuchParkingFloorException;
import com.psap.exceptions.NoSuchParkingPremiseException;
import com.psap.exceptions.NoSuchUserException;
import com.psap.model.Login;
import com.psap.model.ParkingFloor;
import com.psap.model.ParkingPremise;
import com.psap.model.User;

@Service
public interface AdminService {
	public boolean login(Login login) throws InvalidLoginCredintialException;
	public boolean blockUser(User user) throws NoSuchUserException;
	
	// Parking Premise
	public boolean addParkingPremise(ParkingPremise parkingPremise) throws DuplicateParkingPremiseException;
	public ParkingPremise getParkingPremiseById(long parkingPremiseId) throws NoSuchParkingPremiseException;
	public List<ParkingPremise> getParkingPremiseByName(String premiseName) throws NoSuchParkingPremiseException;
	public List<ParkingPremise> getAllParkingPremises();
	public ParkingPremise modifyParkingPremise(ParkingPremise parkingPremise);
	public boolean removeParkingPremise(int parkingPremiseId) throws NoSuchParkingPremiseException;
	
	// Parking Floor
	public boolean addParkingFloor(ParkingFloor parkingFloor) throws DuplicateParkingFloorException;
	public ParkingFloor getParkingFloorById(long parkingFloorId) throws NoSuchParkingFloorException;
	public List<ParkingFloor> getParkingFloorByNumber(long parkingPremiseId, String floorNumber) throws NoSuchParkingFloorException;
	public List<ParkingFloor> getAllParkingFloors(long parkingPremiseId);
	public ParkingFloor modifyParkingCapacity(ParkingFloor parkingFloor);
	public boolean removeParkingFloor(long parkingFloorId) throws NoSuchParkingPremiseException;
	
}
