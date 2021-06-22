package com.psap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.User;
import com.psap.model.Vehicle;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	Vehicle findByVehicleNumberAndOwnerUserId(String vehicleNumber, long userId);
	Vehicle findByVehicleNumber(String vehicleNumber);
	List<Vehicle> findByOwner(User u);
}
