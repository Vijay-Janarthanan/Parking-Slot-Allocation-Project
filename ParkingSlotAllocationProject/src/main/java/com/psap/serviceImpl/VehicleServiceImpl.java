package com.psap.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psap.exceptions.DuplicateVehicleException;
import com.psap.exceptions.NoSuchVehicleException;
import com.psap.model.User;
import com.psap.model.Vehicle;
import com.psap.repository.VehicleRepository;
import com.psap.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleRepository dao;
		
	@Override
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException {
		System.out.println(vehicle.getOwner());
		Optional<Vehicle> v = dao.findById((int) vehicle.getVehicleId());
		if(v.isPresent())
			throw new DuplicateVehicleException("Vehicle of number " +vehicle.getVehicleId() + "already exist");
		dao.save(vehicle);
		return true;
	}

	@Override
	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException {
		Vehicle userVehicle = dao.findByVehicleNumberAndOwnerUserId(vehicleNumber, userId);
		if(userVehicle == null)
			throw new NoSuchVehicleException("No Vehicle found for Vehicle Number " + vehicleNumber);
		return userVehicle;
	}

	@Override
	public List<Vehicle> findAllVehiclesByUserId(int ownerId) {
		User u=new User();
		u.setUserId(ownerId);
		List<Vehicle> vehiclesList = dao.findByOwner(u);

		return vehiclesList;
	}

	@Override
	public boolean removeVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException {
		Vehicle userVehicle = dao.findByVehicleNumberAndOwnerUserId(vehicleNumber, userId);
		if(userVehicle == null)
			throw new NoSuchVehicleException("No Vehicle found of this Vehicle Number");
		dao.delete(userVehicle);
		return true;
	}

	@Override
	public Vehicle modifyVehicle(Vehicle vehicle) {
		dao.save(vehicle);
		return vehicle;
	}

}
