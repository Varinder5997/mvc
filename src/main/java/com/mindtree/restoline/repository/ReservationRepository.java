package com.mindtree.restoline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.restoline.entiry.Reservation;

/*
 * Repositroy class for Reservation it extends JpaRepository
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
