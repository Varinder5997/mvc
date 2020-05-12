package com.mindtree.restoline.service;

import com.mindtree.restoline.entiry.Reservation;

/*
 * Service interface for Reservation
 */
public interface ReservationService {

	public void addReservation(int guestid, int restaurentId, Reservation seats);// Method for Add reservation

	public void deletereservation(int id);// Method for delete reservation

}
