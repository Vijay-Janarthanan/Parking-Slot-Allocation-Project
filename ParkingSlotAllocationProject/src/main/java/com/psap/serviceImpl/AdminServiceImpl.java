package com.psap.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.psap.repository.LoginRepository;
import com.psap.repository.ParkingFloorRepository;
import com.psap.repository.ParkingPremiseRepository;
import com.psap.repository.UserRepository;
import com.psap.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	LoginRepository lr;
	@Autowired
	UserRepository ur;
	@Autowired
	ParkingPremiseRepository pp;
	@Autowired
	ParkingFloorRepository pf;
	
//checking login credentials
	@Override
	public boolean login(Login login) throws InvalidLoginCredintialException {
		Optional<Login> l = lr.findById(login.getLoginId());
		if(!login.getPassword().equals(l.get().getPassword()))
			throw new InvalidLoginCredintialException("User Id and Password not Matching");
		return true;
	}
//block user
	@Override
	public boolean blockUser(User user) throws NoSuchUserException {
		Optional<User> u = ur.findById(user.getUserId());
		if(!u.isPresent())
			throw new NoSuchUserException("User is not available to block");
		ur.delete(user);
		return true;
	}
//adding parking premises 
	@Override
	public boolean addParkingPremise(ParkingPremise parkingPremise) throws DuplicateParkingPremiseException {
		Optional<ParkingPremise> p = pp.findById(parkingPremise.getParkingPremiseId());
		if(p.isPresent())
			throw new DuplicateParkingPremiseException("Parking Premise is already present");
		pp.save(parkingPremise);
		return true;
	}
//display parking premise by ID
	@Override
	public ParkingPremise getParkingPremiseById(long parkingPremiseId) throws NoSuchParkingPremiseException {
		Optional<ParkingPremise> p = pp.findById((int) parkingPremiseId);
		if(!p.isPresent())
			throw new NoSuchParkingPremiseException("No Parking Premise found for this ID");
		return p.get();
	}
//Display parking premise by premise name
	@Override
	public List<ParkingPremise> getParkingPremiseByName(String premiseName) throws NoSuchParkingPremiseException {
		List<ParkingPremise> p = (List<ParkingPremise>) pp.findByParkingPremiseName(premiseName);
		return p;
	}
//display all parking premise
	@Override
	public List<ParkingPremise> getAllParkingPremises() {
		return pp.findAll();
	}
//modify parking premise
	@Override
	public ParkingPremise modifyParkingPremise(ParkingPremise parkingPremise) {
		ParkingPremise pre = (ParkingPremise) pp.findByParkingPremiseId(parkingPremise.getParkingPremiseId());
		if(parkingPremise.getParkingPremiseName() == null) {
			System.out.println("Parking Premise Not Available");
		}
		pre.setParkingPremiseName(parkingPremise.getParkingPremiseName());
		pre.setNumberOfParkingFloors(parkingPremise.getNumberOfParkingFloors());
		pre.setParkingPremiseId(parkingPremise.getParkingPremiseId());
		pre.setPremiseAddress(parkingPremise.getPremiseAddress());
		pp.save(pre);
		return pre;
	}
//removing parking premise
	@Override
	public boolean removeParkingPremise(int parkingPremiseId) throws NoSuchParkingPremiseException {
		Optional<ParkingPremise> p = pp.findById((int) parkingPremiseId);
		if(!p.isPresent())
			throw new NoSuchParkingPremiseException("No Parking Premise found for this ID");
		pp.deleteById(parkingPremiseId);
		return true;
	}
//adding parking floor
	@Override
	public boolean addParkingFloor(ParkingFloor parkingFloor) throws DuplicateParkingFloorException {
		Optional<ParkingFloor> p = pf.findById(parkingFloor.getParkingFloorId());
		if(p.isPresent())
			throw new DuplicateParkingFloorException("Parking Floor is already present");
		pf.save(parkingFloor);
		return true;
	}
//display parking floor by ID
	@Override
	public ParkingFloor getParkingFloorById(long parkingFloorId) throws NoSuchParkingFloorException {
		Optional<ParkingFloor> p = pf.findById((int) parkingFloorId);
		if(!p.isPresent())
			throw new NoSuchParkingFloorException("No Parking Floor found for this ID");
		return p.get();
	}
//display parking floor by number
	@Override
	public List<ParkingFloor> getParkingFloorByNumber(long parkingPremiseId, String floorNumber)
			throws NoSuchParkingFloorException {
		List<ParkingFloor> li = (List<ParkingFloor>) pf.findByFloorNumber(floorNumber);
		return li;
	}
//display all parking floor
	@Override
	public List<ParkingFloor> getAllParkingFloors(long parkingPremiseId) {
		return pf.findAll();
	}
//modify parking capacity
	@Override
	public ParkingFloor modifyParkingCapacity(ParkingFloor parkingFloor) {
		if(parkingFloor.getParkingFloorId() == 0) {
			System.out.println("Parking Floor Id is not valid");
		}
		parkingFloor.setNumberOfParkingSlots(parkingFloor.getNumberOfParkingSlots());
		pf.save(parkingFloor);
		return parkingFloor;
	}
//remove parking floor
	@Override
	public boolean removeParkingFloor(long parkingFloorId) throws NoSuchParkingPremiseException {
		Optional<ParkingFloor> p = pf.findById((int) parkingFloorId);
		if(!p.isPresent())
			throw new NoSuchParkingPremiseException("No Parking Floor found for this ID");
		pp.deleteById((int) parkingFloorId);
		return true;
	}

}
