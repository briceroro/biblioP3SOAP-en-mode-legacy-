package com.mairie.biblioWebApp.configuration;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import generated.userService.User;
import generated.userService.UserService;
import generated.userService.User_Service;

/**
 * Class servant a modifié UserDetailsService
 * 
 * @author briceroro
 *
 */
public class UserDetailsServiceImp implements UserDetailsService {
	
	/**
	 * declaration du Service  UserService
	 */
	User_Service us = new User_Service();
	
	/**
	 * récupération du port du service UserService
	 */
	UserService userService =us.getUserServicePort();
	
	
	  /**
	   * Methode servant a a indiquer les parametres custom de User
	   */
	  @Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    /*Here we are using dummy data, you need to load user data from
	     database or other third party application*/
	    User user = userService.findUserByUserName(username);

	    UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.password(user.getPassword());
	      builder.roles(user.getRole());
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
	  }

	  
	}