package com.psap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.psap.exceptions.DuplicateVehicleException;
import com.psap.exceptions.NoSuchVehicleException;
import com.psap.model.Vehicle;

@Service
public interface VehicleService {
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException;
	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException;
	public List<Vehicle> findAllVehiclesByUserId(int ownerId);
	public boolean removeVehicleByVehicleNumber(String vehicleNumber, int userId) throws NoSuchVehicleException;
	public Vehicle modifyVehicle(Vehicle vehicle);
}
