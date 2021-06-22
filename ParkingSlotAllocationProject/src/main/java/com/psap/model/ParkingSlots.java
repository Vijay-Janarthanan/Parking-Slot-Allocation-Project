package com.psap.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ParkingSlots")
public class ParkingSlots {
	@Id
	private long parkingSlotId;
	@ManyToOne()
	private ParkingFloor parkingFloor;
	@OneToOne
	private Vehicle vehicle;
	private Date parkingDate;
	private String parkingTime;
	private Date bookingDate;
	private int parkingDuration;
	@ManyToOne()
	private Payment payment;
	
	// Constructors, Getter & Setter method
	public ParkingSlots() {
		super();
	}
	
	public ParkingSlots(long parkingSlotId, ParkingFloor parkingFloor, Vehicle vehicle, Date parkingDate,
			String parkingTime, Date bookingDate, int parkingDuration, Payment payment) {
		super();
		this.parkingSlotId = parkingSlotId;
		this.parkingFloor = parkingFloor;
		this.vehicle = vehicle;
		this.parkingDate = parkingDate;
		this.parkingTime = parkingTime;
		this.bookingDate = bookingDate;
		this.parkingDuration = parkingDuration;
		this.payment = payment;
	}

	public long getParkingSlotId() {
		return parkingSlotId;
	}

	public void setParkingSlotId(long parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}

	public ParkingFloor getParkingFloor() {
		return parkingFloor;
	}

	public void setParkingFloor(ParkingFloor parkingFloor) {
		this.parkingFloor = parkingFloor;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Date getParkingDate() {
		return parkingDate;
	}

	public void setParkingDate(Date parkingDate) {
		this.parkingDate = parkingDate;
	}

	public String getParkingTime() {
		return parkingTime;
	}

	public void setParkingTime(String parkingTime) {
		this.parkingTime = parkingTime;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getParkingDuration() {
		return parkingDuration;
	}

	public void setParkingDuration(int parkingDuration) {
		this.parkingDuration = parkingDuration;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "ParkingSlots [parkingSlotId=" + parkingSlotId + ", parkingFloor=" + parkingFloor + ", vehicle="
				+ vehicle + ", parkingDate=" + parkingDate + ", parkingTime=" + parkingTime + ", bookingDate="
				+ bookingDate + ", parkingDuration=" + parkingDuration + ", payment=" + payment + "]";
	}
	
	
	
}
