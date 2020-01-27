
package com.mairie.biblioWebApp.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import generated.BookingService.Booking;
import generated.BookingService.BookingService;
import generated.BookingService.Booking_Service;
import generated.userService.User;
import generated.userService.UserService;
import generated.userService.User_Service;

@Controller
public class SearchBookingController {

	/**
	 * declaration du Service  UserService
	 */
	User_Service us = new User_Service();
	/**
	 * récupération du port du service UserService
	 */
	UserService userService =us.getUserServicePort();
	
	/**
	 * declaration du service bookingService
	 */
	Booking_Service bs = new Booking_Service();
	/**
	 * recuperation du port du service bookingservice
	 */
	BookingService bookingService = bs.getBookingServicePort();
	
	/**
	 * methode Get servant a afficher les booking en fonction de luser identifié
	 * 
	 * @param model
	 * @return searchBooking
	 */
	@RequestMapping(value="/searchBooking", method = RequestMethod.GET)
	public String searchBooking(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		int userInt = user.getId();
		model.addAttribute("username", usernameString);
		
		List<Booking> listUserBooking = bookingService.bookingByUser(userInt);

		model.addAttribute("listUserBooking", listUserBooking);
		
		return "/searchBooking";
	}
	
	/**
	 * methode Post servant a supprimer un booking
	 * 
	 * @param model
	 * @param bookingid
	 * @return la page des booking apres la supression du booking sélectionné
	 */
	@RequestMapping(value="/searchBooking", method = RequestMethod.POST)
	public String searchBooking(ModelMap model,@RequestParam(name="bookingId")int bookingId){
		Booking booking = bookingService.bookingById(bookingId);
		String deleteBooking = "La réservation : "+booking.getBook().getTitle()+" est bien annulée";
		model.addAttribute("deleteBooking", deleteBooking);
		
		bookingService.deleteBooking(bookingId);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		int userInt = user.getId();
		model.addAttribute("username", usernameString);
		
		List<Booking> listUserBooking = bookingService.bookingByUser(userInt);

		model.addAttribute("listUserBooking", listUserBooking);
		

		return "/searchBooking";
	}
}
