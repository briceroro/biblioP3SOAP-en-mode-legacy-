package com.mairie.biblio.service;



import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.mairie.biblio.dao.UserDao;
import com.mairie.biblio.model.User;


/**
 * Class servant a définir les services de la class User
 * @author briceroro
 *
 */
@WebService(serviceName = "User")
public class UserService {

	 /**
     * instantiation de UserDao
     */
	private UserDao userDao;
	
	/**
     * initialisation des log de la class
     */
	Logger log = Logger.getLogger(UserService.class.getName());
	
	public UserService() {
		userDao = new UserDao();
	}
	
	/**
	 *methode servant a recuperer un user avec son username 
	 *
	 * @param name
	 * 
	 * @return l'user recuperer
	 */
	@WebMethod
	public User findUserByUserName(String name) {
		
		User user = new User();
		
		try {
			userDao.openSession();
			user = userDao.findByUsername(name);
		}finally {
			userDao.closeSession();
		}

		return user;
	}
	
	/**
	 * Methode servant a recuperer un User avec son id
	 * 
	 * @param id
	 * 
	 * @return l'user recuperer
	 */
	@WebMethod
	public User findbyId(int id) {
		
		User user = new User();
		
		try {
			userDao.openSession();
			user = userDao.findById(id);
		}finally {
			userDao.closeSession();
		}
		
		return user;
	}
	
	/**
	 * Methode servant a creer un user et l'enregistrer en BDD
	 * 
	 * @param email
	 * @param password
	 * @param name
	 * @param lastName
	 * @param username
	 * @param active
	 * @param role
	 * 
	 * @return l'user creer en BDD
	 */
	@WebMethod
	public int createUser(String email,String password,String name,String lastName,
			String username,Boolean active,String role) {
		
		User user = new User();
		
		try {
			userDao.openSession();
			userDao.openTransation();
			user = new User(email,password,name,lastName,username,active,role);
			userDao.saveUser(user);
			userDao.commitTransaction();
		}finally {
			userDao.closeSession();
		}
		
		log.info("UserService createUser");
		log.info("User: email="+email+", password="+password+", name="+name+", lastName="+lastName+
				", username="+username+", active="+active+", role="+role);
		return user.getId();
	}
	
	/**
	 * Methode servant a supprimer un user de la BDD
	 * 
	 * @param id
	 */
	@WebMethod
	public void deleteUser(int id) {

		User user = new User();
		
		try {
			userDao.openSession();
			userDao.openTransation();
			user = userDao.findById(id);
			userDao.deleteUser(user);
			userDao.commitTransaction();
		}finally {
			userDao.closeSession();
		}
        
		log.info("UserService deleteUser");
		log.info("suppression User id="+id);
		
	}

	
}
