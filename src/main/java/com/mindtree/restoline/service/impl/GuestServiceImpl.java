package com.mindtree.restoline.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restoline.dto.LoginDto;
import com.mindtree.restoline.entiry.Guest;
import com.mindtree.restoline.repository.GuestRepository;
import com.mindtree.restoline.service.GuestService;

/*
 * Service class for Guest Service implementaion
 */
@Service
public class GuestServiceImpl implements GuestService {

	/*
	 * Create bean of guest repository
	 */
	@Autowired
	GuestRepository guestRepository;

	/*
	 * Method for add Guest
	 */
	@Override
	public Guest addGuest(Guest guest) {

		return this.guestRepository.save(guest);// Save guest to database and return it

	}
	/*
	 * Method for login Guest
	 */

	@Override
	public int loginGuest(LoginDto loginDto) {
		Guest guest = this.guestRepository.findByGuestEmail(loginDto.getGuestEmail());// Find guest by guestEmailId
		if (guest != null) {// Check condition if guest is not null
			if (guest.getGuestPassword().compareTo(loginDto.getGuestPassword()) == 0) {// Check if guest password is not
																						// correct
				return guest.getGuestId();// return Id of the guest

			}
		}
		return 0;// return 0
	}

	/*
	 * Method for find Guest by id
	 */
	@Override
	public Guest findById(int id) {
		return this.guestRepository.findById(id).get();// Find the guest by id and return it

	}

}
