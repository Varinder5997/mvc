package com.mindtree.restoline.repository;

import org.hibernate.event.internal.ReattachVisitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.restoline.entiry.Restaurant;

/*
 * Repositroy class for Restaurant it extends JpaRepository
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	public Restaurant findByResturantName(String name);

}
