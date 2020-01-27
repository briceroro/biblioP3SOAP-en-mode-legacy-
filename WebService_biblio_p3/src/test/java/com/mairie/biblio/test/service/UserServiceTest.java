package com.mairie.biblio.test.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.mairie.biblio.model.User;
import com.mairie.biblio.service.UserService;


public class UserServiceTest {

	private static UserService userService = new UserService();
	
	private static User user = new User();
	
	
	@BeforeAll
    public static void init() {
		userService.createUser("brice.oc.formation@gmail.com",
				"$2a$10$mkrCmcYqvfBM/npVhMesO.oofqEmEQl3.ikvwZ7PzzM.FrBCC6yMu","user",
				"test","usertest",true,"user");
	}
	
	
	/**
	 * vérifie que l'on arrive a recuperer un user par son username
	 */
	@Test
	public void findUserByUsernameTest() {
	    user = userService.findUserByUserName("usertest");
		Assertions.assertEquals("usertest", user.getUserName());
	}
		
	/**
	 * verifie que l'on arrive a recuperer un user par son id
	 */
	@Test
	public void findUserByIdTest() {

		int userId = userService.findUserByUserName("usertest").getId();
		user = userService.findbyId(userId);
		Assertions.assertEquals("usertest", user.getUserName());
	}
	
	
	@AfterAll
	public static void cleanUp(){
		user = userService.findUserByUserName("usertest");
		userService.deleteUser(user.getId());
	}
	
	
}
