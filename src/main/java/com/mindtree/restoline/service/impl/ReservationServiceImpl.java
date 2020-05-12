package com.mindtree.restoline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restoline.entiry.Guest;
import com.mindtree.restoline.entiry.Reservation;
import com.mindtree.restoline.repository.GuestRepository;
import com.mindtree.restoline.repository.ReservationRepository;
import com.mindtree.restoline.repository.RestaurantRepository;

/*
 * Service class for Reservation Service implementaion
 */
@Service
public class ReservationServiceImpl implements com.mindtree.restoline.service.ReservationService {

	/*
	 * Create bean of guestRepository
	 */
	@Autowired
	GuestRepository guestRepo;
	/*
	 * Create bean of restaurantRepository
	 */
	@Autowired
	RestaurantRepository restaurantRepo;
	/*
	 * Create bean of reservationRepository
	 */
	@Autowired
	ReservationRepository reservationRepo;
	
	/*
	 * Method for add Reservation
	 */
	@Override
	public void addReservation(int guestid, int restaurentId, Reservation seats) {
		Guest guest=this.guestRepo.findById(guestid).get();//FInd guest by guestId
		seats.setStatus(true);//set status of reservation
		Reservation r=this.reservationRepo.save(seats);//Save the reservation to the database
		
		List<Reservation>all=guest.getReservations();//GEt all the reservation from the data base
		all.add(r);
		guest.setReservations(all);//Set all the reservation to the guest 
		this.guestRepo.save(guest);//Save guest to the database
		
	}

	/*
	 * Method for delete the reservation
	 */

	@Override
	public void deletereservation(int id) {
		Reservation r=this.reservationRepo.findById(id).get();//Find the reservation by the reservation Id
		r.setStatus(false);//set the reservation statue false
		this.reservationRepo.save(r);//save the reservation

	}

}
