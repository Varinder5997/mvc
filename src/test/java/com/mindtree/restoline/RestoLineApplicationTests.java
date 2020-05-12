package com.mindtree.restoline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.mindtree.restoline.controller.GuestController;
import com.mindtree.restoline.entiry.Guest;
import com.mindtree.restoline.entiry.Restaurant;
import com.mindtree.restoline.repository.GuestRepository;
import com.mindtree.restoline.repository.ReservationRepository;
import com.mindtree.restoline.repository.RestaurantRepository;
import com.mindtree.restoline.service.GuestService;
import com.mindtree.restoline.service.ReservationService;
import com.mindtree.restoline.service.RestaurantService;

@SpringBootTest
class RestoLineApplicationTests {
	
	
	
	@Autowired
	GuestController guestController;
	
	@Autowired
	GuestService guestService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	ReservationService reservationService;
	
	@MockBean
	GuestRepository guestRepository;
	
	@MockBean
	RestaurantRepository restaurantRepository;
	
	@MockBean
	ReservationRepository reservationRepository;
	private static Guest guest;
	private static Restaurant restaurant;
	
	@BeforeTestClass
	public void init() {
		guest=new Guest("Sharan", "sharan@gmail.com", "111", "punjab");
		restaurant=new Restaurant("Any", "Punjab", 5, 500);
	}

	@Test
	public void registerGuest() {
		
		when(guestRepository.save(guest)).thenReturn(guest);
		assertEquals(guest, guestService.addGuest(guest));
	}

	@Test
	public void allRestaurants() {
		when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurant));
		assertEquals(1, restaurantService.allRestaurants().size());
	}
	

	@Test
	public void addRestaurant() {
		
		when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
		assertEquals(restaurant, restaurantService.addRestaurant(restaurant));
	}
	
	
//	@Test 
//	public void findById() {
//		guestRepository.save(guest);
//		when(guestRepository.findById(1).get()).thenReturn(guest);
//		assertEquals(guest,guestService.findById(1));
//		
//	}
//	
	
	
	
}
