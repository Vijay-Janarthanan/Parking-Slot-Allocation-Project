package com.psap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
	// should be auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;

	@Enumerated(EnumType.ORDINAL)
	private VehicleType vehicleType;
	@Column(length = 12)
	@Size(min = 10, max = 12)
	private String vehicleNumber;
	private String vehicleCompany;
	private String vehicleModel;

	@OneToOne
	private User owner;

	// Constructors, Getter & Setter method
	public Vehicle() {
		super();
	}

	public Vehicle(int vehicleId, VehicleType vehicleType, String vehicleNumber, String vehicleCompany,
			String vehicleModel, User owner) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.vehicleCompany = vehicleCompany;
		this.vehicleModel = vehicleModel;
		this.owner = owner;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleCompany() {
		return vehicleCompany;
	}

	public void setVehicleCompany(String vehicleCompany) {
		this.vehicleCompany = vehicleCompany;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber
				+ ", vehicleCompany=" + vehicleCompany + ", vehicleModel=" + vehicleModel + ", owner=" + owner + "]";
	}

}
