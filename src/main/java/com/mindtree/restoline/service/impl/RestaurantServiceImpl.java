package com.mindtree.restoline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restoline.entiry.Restaurant;
import com.mindtree.restoline.repository.RestaurantRepository;
import com.mindtree.restoline.service.RestaurantService;

/*
 * Service class for Restaurant Service implementaion
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
	/*
	 * Create bean of restaurantRepository
	 */
	@Autowired
	RestaurantRepository restaurantRepo;

	/*
	 * Method for add restaurant
	 */
	@Override
	public Restaurant addRestaurant(Restaurant restauant) {

		return this.restaurantRepo.save(restauant);// Save restaurant to database and return it
	}

	/*
	 * Method for check seats in restaurant
	 */
	@Override
	public boolean cheackSeats(int restaurantId, int seats) {
		Restaurant restaurant = this.restaurantRepo.findById(restaurantId).get();// Find the restaurant by restaurantId
		if (restaurant.getTotalSeats() > seats) {// Check the condition if seats avalble
			return true;// return true to controller
		}
		return false;// return false to controller
	}

	/*
	 * Method for get all the restaurants
	 */
	@Override
	public List<Restaurant> allRestaurants() {

		return this.restaurantRepo.findAll();// find all the restaurants from the databae
	}

	/*
	 * Method for find restaurant by name
	 */
	@Override
	public Restaurant findByName(String name) {

		return this.restaurantRepo.findByResturantName(name);// Find restaurant by restaurantname
	}

}
