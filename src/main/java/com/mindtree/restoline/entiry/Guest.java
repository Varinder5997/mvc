package com.mindtree.restoline.entiry;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/*
 * Guest Entity class
 */

@Entity
public class Guest {

	/*
	 * Declare all variables for the Guest
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guestId")
	private int guestId;
	@Column(name = "guestName")
	private String guestName;
	@Column(name = "guestEmail")
	private String guestEmail;
	@Column(name = "guestPassword")
	private String guestPassword;
	@Column(name = "guestAddress")
	private String guestAddress;

	@JsonIgnore
	@OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
	List<Reservation> reservations;

	/*
	 * Getters and setters of all variavles
	 */
	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public String getGuestPassword() {
		return guestPassword;
	}

	public void setGuestPassword(String guestPassword) {
		this.guestPassword = guestPassword;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Guest(String guestName, String guestEmail, String guestPassword, String guestAddress) {
		super();
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.guestPassword = guestPassword;
		this.guestAddress = guestAddress;

	}

	/*
	 * Constructors
	 */
	public Guest() {
		super();
	
	}

	public Guest(int guestId, String guestName, String guestEmail, String guestPassword, String guestAddress) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.guestPassword = guestPassword;
		this.guestAddress = guestAddress;
	}

}
