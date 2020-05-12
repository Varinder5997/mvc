package com.mindtree.restoline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.restoline.entiry.Guest;

/*
 * Repositroy class for Guest it extends JpaRepository
 */
@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

	public Guest findByGuestEmail(String guestEmail);

}
