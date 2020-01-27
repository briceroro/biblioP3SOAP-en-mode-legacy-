package com.mairie.biblioWebApp.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import generated.BookService.Book;
import generated.BookService.BookService;
import generated.BookService.Book_Service;
import generated.BookingService.Booking;
import generated.BookingService.BookingService;
import generated.BookingService.Booking_Service;
import generated.userService.User;
import generated.userService.UserService;
import generated.userService.User_Service;

/**
 * Controller servant a recuperer la page SearchBook
 * @author briceroro
 *
 */
@Controller
public class SearchBookController {

	/**
	 * declaration du Service  UserService
	 */
	User_Service us = new User_Service();
	UserService userService =us.getUserServicePort();
	
	/**
	 * récupération du port du service UserService
	 */
	Book_Service bs = new Book_Service();
	BookService bookService = bs.getBookServicePort();
	
	/**
	 * declaration du service bookingService
	 */
	Booking_Service bookings = new Booking_Service();
	BookingService bookingService = bookings.getBookingServicePort();
	
	
	/**
	 * Methode request GET servant a recuperer la page SearchBook avec l'user identifé
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/searchBook", method = RequestMethod.GET)
	public String home(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		model.addAttribute("username", usernameString);
		
		return "searchBook";
	}
	
	/**
	 * Methode request POST servant a recuperer la page SearchBook avec l'user identifé et une liste de Book suivant le param rensigné
	 * @param model afin d'ajouter l'user et les books au model
	 * @param name correspondant au titre du book rechercher par l'user
	 * @return
	 */
	@RequestMapping(value="/searchBook", method = RequestMethod.POST)
	public String home(ModelMap model,@RequestParam(name="nameBook")String name){
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		model.addAttribute("username", usernameString);
		
		List<Book> bookByKeywords = bookService.findBookByTitleKeywords(name);
		model.addAttribute("booksKey", bookByKeywords);
		
		Date date = new Date();
		model.addAttribute("today", date);
	
        Boolean checkBooking = false;
		
		List<Booking> userBookingList = bookingService.bookingByUser(user.getId());
		for (int i =0; i < userBookingList.size(); i++) {
			for(int y = 0; y < bookByKeywords.size(); y++) {
				if(userBookingList.get(i).getBook().getId() == bookByKeywords.get(y).getId()) {
					checkBooking = true;
				}
			}	
		}
		model.addAttribute("checkBooking", checkBooking);
		return "searchBook";
	}
	
	@RequestMapping(value="/searchBookAfterBooking", method = RequestMethod.POST)
	public String searchBookAfterBooking(ModelMap model,@RequestParam(name="bookId")int bookId){
			
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		model.addAttribute("username", usernameString);
		
		int createBooking = bookingService.createBooking(bookId, user.getId());
		//model.addAttribute("createBooking", createBooking);
		
		String ErrorCreateBooking = "impossible de réserver l'ouvrage, vous l'avez déjà réservé!";
		if(createBooking == 0){
			model.addAttribute("ErrorCreateBooking", ErrorCreateBooking);
		}
		
		return "searchBook";
	}

}
