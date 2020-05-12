package com.mindtree.restoline.service;

import java.util.List;

import com.mindtree.restoline.entiry.Restaurant;

/*
 * Service interface for Restaurant
 */
public interface RestaurantService {

	public Restaurant addRestaurant(Restaurant restauant);// Method for add Restaurant

	public boolean cheackSeats(int restaurantId, int seats);// Method for check Seats are avalable or not

	public List<Restaurant> allRestaurants();// Method for find all Restaurant

	public Restaurant findByName(String name);// Method for find RestaurantByname

}
