package com.mindtree.restoline.entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Entity class for Reservation
 */
@Entity
public class Reservation {

	/*
	 * Declare all variables of Reservation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservationId")
	private int reservationId;
	@Column(name = "noOfSeats")
	private int noOfseats;

	private boolean status;
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	@JsonIgnore
	@ManyToOne
	private Guest guest;

	/*
	 * Getters and setters of variables
	 */

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getNoOfseats() {
		return noOfseats;
	}

	public void setNoOfseats(int noOfseats) {
		this.noOfseats = noOfseats;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Reservation() {
		super();
		
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/*
	 * Constructor
	 */

	public Reservation(int noOfseats, boolean status, Restaurant restaurant, Guest guest) {
		super();
		this.noOfseats = noOfseats;
		this.status = status;
		this.restaurant = restaurant;
		this.guest = guest;
	}

}
