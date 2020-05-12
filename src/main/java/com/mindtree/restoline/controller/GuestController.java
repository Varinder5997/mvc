package com.mindtree.restoline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.restoline.dto.LoginDto;
import com.mindtree.restoline.dto.SeatDto;
import com.mindtree.restoline.entiry.Guest;
import com.mindtree.restoline.entiry.Reservation;
import com.mindtree.restoline.entiry.Restaurant;
import com.mindtree.restoline.service.GuestService;
import com.mindtree.restoline.service.ReservationService;
import com.mindtree.restoline.service.RestaurantService;

/*
 * 
 * Class of Guest Controller
 * 
 */
@Controller
public class GuestController {

	/*
	 * 
	 * Create Bean of Guest Service Layer
	 */
	@Autowired
	GuestService guestService;
	/*
	 * Create Bean of Restaurant Service Layer
	 */
	@Autowired
	RestaurantService restaurantService;
	/*
	 * Create Bean of Reservation Service Layer
	 */
	@Autowired
	ReservationService reservationService;

	/*
	 * Method for User Login Page
	 */

	@RequestMapping("/")
	public String user() {
		return "User"; //// Return to succesfullyAdded Page
	}

	/*
	 * Method for Guest regitration
	 */

	@RequestMapping("/register")
	public String addUser(Model model) {
		Guest guest = new Guest(); // Create an object of the guest
		model.addAttribute("guest", guest); // Add guest Object to the model
		return "NewUser"; // Return to NewUser Page
	}

	/*
	 * Method for Save Guest
	 */

	@RequestMapping("/save-user")
	public String addNewUser(@ModelAttribute Guest guest) {
		this.guestService.addGuest(guest); // Add Guest into Database
		return "SuccesfullyAdded"; // Return to succesfullyAdded Page

	}

	/*
	 * Method for guest login
	 */

	@RequestMapping("/login")
	public String loginUser(Model model) {
		LoginDto loginDto = new LoginDto(); // Create object of LoginDto class
		model.addAttribute("loginDto", loginDto); // Add object to the model
		return "LoginUser";
	}

	/*
	 * Method for goint to Guest Login page
	 */
	int loginId = 0;

	@RequestMapping("/login-user")
	public String login(@ModelAttribute LoginDto loginDto, Model model) {
		int guestId = this.guestService.loginGuest(loginDto); // Find the GuestId by the LoginDtoId
		if (guestId > 0) { // check the loginId
			loginId = guestId;
			Guest guest = this.guestService.findById(guestId);// Find the guest by the guestId
			model.addAttribute("guest", guest); // Add guest the the model
			return "LoginPage"; // Return to Login Page
		} else { // Check Another condition
			return "WrongUserName"; // Return to wrongusername Page
		}

	}

	/*
	 * 
	 * Method for find all Restaurant
	 */
	String hId = null;

	@RequestMapping("/bookSeat")
	public String BookSeat(Model model) {
		List<Restaurant> allRestaurants = this.restaurantService.allRestaurants(); // Get list of all the restaurants
																					// present in the database
		model.addAttribute("allRestaurants", allRestaurants); // Add allRestaurant Object to model
		return "BookResturant"; // Return to BookResturent Page

	}
	/*
	 * Method for select restaurant for booking seats
	 */

	@RequestMapping("/selectedRestaurant")
	public String noOfRooms(@RequestParam(name = "chooserestaurantId") String name, Model model) {
		Restaurant restaurant = this.restaurantService.findByName(name); // Find restaurants bt the restaurantId
		if (restaurant.getTotalSeats() == 0) { // Check the condition if no any seat is avalable
			return "ChooseAnotherRestaurant"; // Return to ChooseAnotherRestaurant Page
		} else {// check another condition
			hId = restaurant.getResturantName();// get the name of the restaurant
			SeatDto seatDto = new SeatDto();// Create object of SetDto class
			model.addAttribute("seatDto", seatDto);// Add SetDto object to the model
			return "EnterSeats";// Return to EnterSeats Page
		}

	}
	/*
	 * Method for going to Login page
	 */

	@RequestMapping("/aa")
	public String pub(Model model) {
		Guest guest = this.guestService.findById(loginId);// Find the Guest By guestId;
		model.addAttribute("guest", guest);// Add guest to the model
		return "LoginPage";// Return to Login Page

	}

	/*
	 * Method for Enter No of seats User want to Select
	 */
	@RequestMapping("/no-of-seats")
	public String seats(@ModelAttribute SeatDto seatDto, Model model) {
		if (seatDto.getSeats() > this.restaurantService.findByName(hId).getTotalSeats()) {// Chech condition that seats
																							// are not greater then
																							// restaurant seats
			SeatDto s = new SeatDto();// Create an object of SeatDto Class
			s.setSeats(this.restaurantService.findByName(hId).getTotalSeats());// Set the no of seats to the SeatDto
																				// object
			model.addAttribute("s", s);// Add seatDto object to model
			return "AvailableSeats";// Return to AvailableSeats Page
		} else {// Check another condition

			Restaurant r = this.restaurantService.findByName(hId);// find restaurand by restaurantId
			Guest guests = this.guestService.findById(loginId);// Find guestBy guestId
			r.setTotalSeats(r.getTotalSeats() - seatDto.getSeats());// Reduce the seats of restaurant
			Reservation reserve = new Reservation();// Create Obhect of reservation
			reserve.setNoOfseats(seatDto.getSeats());// Set no of seats to reservation
			reserve.setRestaurant(r);// Set restaurant to reservation
			reserve.setGuest(guests);// set Guest to reservation
			this.reservationService.addReservation(loginId, this.restaurantService.findByName(hId).getResturantId(),
					reserve);// Add reservation to the database

			Guest guest = this.guestService.findById(loginId);// Find Guest by guestId
			model.addAttribute("guest", guest);// Add guest object to model
			return "LoginPage";// Return to Login Page
		}
	}
	/*
	 * Method to cancle reservation
	 */

	@RequestMapping("/cancleReservation/{id}")
	public String cancleReservation(@PathVariable(name = "id") int id, Model model) {
		this.reservationService.deletereservation(id);// Find reservation by reservationId
		Guest guest = this.guestService.findById(loginId);// Find guest by guestId
		model.addAttribute("guest", guest);// Add guest object to model
		return "Reservations";// Return to reservation Page
	}
	/*
	 * Method for find reservation of Guest
	 */

	@RequestMapping("/reservations")
	public String reservations(Model model) {
		Guest guest = this.guestService.findById(loginId);// Find Guest by guestId
		model.addAttribute("guest", guest);// Add guest object to model
		return "Reservations";// Return to Reservation Page

	}

}
