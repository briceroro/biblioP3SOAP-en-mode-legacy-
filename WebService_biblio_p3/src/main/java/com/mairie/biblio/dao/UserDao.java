package com.mairie.biblio.dao;

import org.hibernate.Session;

import com.mairie.biblio.db.HibernateUtil;
import com.mairie.biblio.model.User;
import com.mairie.biblio.dao.userDaoInterface;


/**
 * Class servant a faire la liason avec la BDD et l'application via hibernate
 * @author briceroro
 *
 */
public class UserDao implements userDaoInterface {
	
	private Session session;
	
	public UserDao() {
		
	}
	
	public Session openSession() {
		session = HibernateUtil.currentSession();
		return session;
	}
	
	/**
	 * recupération de la session
	 * @return la session récupérée
	 */
	public Session getSession() {
		return session;
		
	}
	
	/**
	 * ouvre la transaction
	 */
	public void openTransation() {
		session.beginTransaction();
	}
	
	/**
	 * commit des modification en bdd
	 */
	public void commitTransaction() {
		session.getTransaction().commit();
	}
	 
	public void closeSession() {
		HibernateUtil.closeSession();
	}
	
	/**
	 * Methode servant a sauver la création ou la modification d'un User dans la bdd
	 * @param User a sauver ou modifier
	 */
	public void saveUser(User user) {
		getSession().save(user);
		
	}
	
	/**
	 * Methode servant a supprimer le User selectionné
	 * @param User a supprimer
	 */
	public void deleteUser(User user) {
		getSession().delete(user);
	}
	
	/**
	 * Methode servant a récuperer un User avec son username
	 * 
	 * @param username de l'user a rechercher
	 */
	@Override
	public User findByUsername(String username) {
		User user  = (User) getSession().createQuery("from User u where u.username='"+username+"'").getSingleResult();
		return user;
	}
	 
	/**
	 * Methode servant a recuperer un User avec son id
	 * 
	 * @param id de l'user a rechercher
	 */
	@Override
	public User findById(int id) {
		User user  = (User) getSession().createQuery("from User u where u.id = "+id+"").getSingleResult();
		return user;
	}

}
