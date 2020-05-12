package com.mindtree.restoline.entiry;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Entity class for Restaurant
 */

@Entity
public class Restaurant {
	
	/*
	 * Declare all variables of restaurants
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resturantId")
	private int resturantId;
	@Column(name = "resturantName")
	private String resturantName;
	@Column(name = "resturantAddress")
	private String resturantAddress;
	@Column(name = "totalSeats")
	private int totalSeats;
	
	@Column(name = "seatPrice")
	private double seatPrice;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
	List<Reservation> reservations;
	
	/*
	 * Genrate getters and setters of variabels
	 */
	
	public double getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public int getResturantId() {
		return resturantId;
	}
	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}
	public String getResturantName() {
		return resturantName;
	}
	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}
	public String getResturantAddress() {
		return resturantAddress;
	}
	public void setResturantAddress(String resturantAddress) {
		this.resturantAddress = resturantAddress;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	/*
	 * Generate Constructore
	 */
	public Restaurant() {
		super();
		
	}
	public Restaurant(String resturantName, String resturantAddress, int totalSeats, double seatPrice) {
		super();
		this.resturantName = resturantName;
		this.resturantAddress = resturantAddress;
		this.totalSeats = totalSeats;
		this.seatPrice = seatPrice;
	}
	
	

}
