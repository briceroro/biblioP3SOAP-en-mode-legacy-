package com.mairie.biblioWebApp.controller;



import java.util.List;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import generated.BorrowedBookService.BorrowedBook;
import generated.BorrowedBookService.BorrowedBookService;
import generated.BorrowedBookService.BorrowedBook_Service;
import generated.userService.User;
import generated.userService.UserService;
import generated.userService.User_Service;

/**
 * Controller servant a recuperer la page des borrowedBook de l'user identifé
 * @author briceroro
 *
 */
@Controller
public class SearchBorrowedBookController {
	
	/**
	 * declaration du Service  UserService
	 */
	User_Service us = new User_Service();
	/**
	 * récupération du port du service UserService
	 */
	UserService userService =us.getUserServicePort();
	
	/**
	 * declaration du Service  BorrowedService
	 */
	BorrowedBook_Service bs = new BorrowedBook_Service();
	/**
	 * récupération du port du service BorrowedBookService
	 */
	BorrowedBookService borrowedBookService =bs.getBorrowedBookServicePort();
	
	
	/**
	 * Methode request GET qui affiche la liste des borrowedBook de l'user identifé
	 * @param model afin d'ajouter l'user et les borrowedBook au model
	 * @return la page searchBorrowedBook
	 */
	@RequestMapping(value="/searchBorrowedBook", method = RequestMethod.GET)
	public String searchBorrowedBook(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		int userInt = user.getId();
		model.addAttribute("username", usernameString);
		
        List<BorrowedBook> userBorrowedbook = borrowedBookService.findUserBorrowedBooks(userInt);    

        model.addAttribute("userBorrowedbook", userBorrowedbook);
      
		return "/searchBorrowedBook" ;
	
	}
	
	
	@RequestMapping(value="/searchBorrowedBook", method = RequestMethod.POST)
	public String searchBorrowedBook(ModelMap model,@RequestParam(name="bookId")int bookid){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		String usernameString = user.getLastName() +" "+ user.getName();
		int userInt = user.getId();
		model.addAttribute("username", usernameString);
		
		borrowedBookService.extensionDateBorrowing(bookid);
        List<BorrowedBook> userBorrowedbook = borrowedBookService.findUserBorrowedBooks(userInt);
        userBorrowedbook.get(0).getDateBorrowing().toString();
        model.addAttribute("userBorrowedbook", userBorrowedbook);
        
		return "/searchBorrowedBook" ;
	}
}
