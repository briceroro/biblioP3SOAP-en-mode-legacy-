package com.mairie.biblioWebApp.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;

import generated.userService.User;
import generated.userService.UserService;
import generated.userService.User_Service;

/**
 * Controller servant a recupérer la page home de l'application
 * @author briceroro
 *
 */
@Controller
public class HomeController {
	
	User_Service us = new User_Service();
	UserService userService =us.getUserServicePort();

	/**
	 * Methode de request Get de la page home qui récupere l'user identifié
	 * @param model afin d'ajouter l'user au model
	 * @return la page d'acceuil du site
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		String usernameString = user.getUsername();
		model.addAttribute("username", usernameString);

		return "home";
	}
	

}
