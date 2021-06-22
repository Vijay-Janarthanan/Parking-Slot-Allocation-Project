package com.psap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psap.exceptions.DuplicateVehicleException;
import com.psap.exceptions.NoSuchVehicleException;
import com.psap.model.User;
import com.psap.model.Vehicle;
import com.psap.model.VehicleType;
import com.psap.repository.VehicleRepository;
import com.psap.service.VehicleService;

@SpringBootTest
public class VehicleServiceImplTest {
	@Autowired
	VehicleService service;
	
	@Autowired
	VehicleRepository  dao;
	
	private static final String VEHICLE_NUMBER = "MH01 DX 1234";
	
	@Test
	@Order(1)
	public void addUsersVehicleTest() {
		Vehicle v = new Vehicle();
		User u = new User();
		u.setUserId(1);
		v.setOwner(u);
		v.setVehicleCompany("Hyundai");
		v.setVehicleModel("Xing");
		v.setVehicleNumber(VEHICLE_NUMBER);
		v.setVehicleType(VehicleType.FourWheeler);
		try {
			service.addUsersVehicle(v);
		} catch (DuplicateVehicleException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		assertNotNull(dao.findByVehicleNumberAndOwnerUserId(VEHICLE_NUMBER, 1));
		
	}
	
	@Test
	@Order(2)
	public void findVehicleByVehicleNumberTest() {
		Vehicle v = null;
		try {
			v = service.findVehicleByVehicleNumber(VEHICLE_NUMBER, 1);
		} catch (NoSuchVehicleException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		assertNotNull(v);
		assertEquals(v.getVehicleNumber(), VEHICLE_NUMBER);
	}
	
	@Test
	@Order(4)
	public void findAllVehiclesByUserIdTest() {
		List<Vehicle> vehiclesList = service.findAllVehiclesByUserId(1);
		assertNotNull(vehiclesList);
		assertThat(vehiclesList.size() > 0);
	}
	
	@Test
	@Order(3)
	public void modifyVehicleTest() {
		Vehicle v = new Vehicle();
		User u = new User();
		u.setUserId(1);
		v.setOwner(u);
		v.setVehicleCompany("Hyundai");
		v.setVehicleModel("Santro Xing");
		v.setVehicleNumber(VEHICLE_NUMBER);
		v.setVehicleType(VehicleType.FourWheeler);
		service.modifyVehicle(v);
		Vehicle vehicleTest = null;
		try {
			vehicleTest = service.findVehicleByVehicleNumber(VEHICLE_NUMBER, 1);
		} catch (NoSuchVehicleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(vehicleTest);
		assertEquals(vehicleTest.getVehicleModel(), "Santro Xing");
		
	}
	
	@Test
	@Order(5)
	public void removeVehicleByVehicleNumberTest() {
		boolean deleted = false;
		try {
			deleted = service.removeVehicleByVehicleNumber(VEHICLE_NUMBER, 1);
			System.out.println("Vehicle Deleted");
		} catch (NoSuchVehicleException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
		}
		if(deleted) {
			Vehicle vehicleTest = null;
			try {
				vehicleTest = service.findVehicleByVehicleNumber(VEHICLE_NUMBER, 1);
			} catch (NoSuchVehicleException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			assertNull(vehicleTest);
		}
	}

}
