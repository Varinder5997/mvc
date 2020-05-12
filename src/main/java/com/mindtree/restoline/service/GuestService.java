package com.mindtree.restoline.service;

import com.mindtree.restoline.dto.LoginDto;
import com.mindtree.restoline.entiry.Guest;

/*
 * Service interface for Guest
 */
public interface GuestService {

	public Guest addGuest(Guest guest);// Method for add guest

	public int loginGuest(LoginDto loginDto);// Method for login guest

	public Guest findById(int id);// Method for find GuestbuId

}
