package com.mairie.biblio.dao;

import java.util.List;

import org.hibernate.Session;

import com.mairie.biblio.db.HibernateUtil;
import com.mairie.biblio.model.Book;
import com.mairie.biblio.model.BorrowedBook;

/**
 * Class servant a faire la liason avec la BDD et l'application via hibernate
 * @author briceroro
 *
 */
public class BorrowedbookDao implements BorrowedbookdaoInterface {
	
	/**
	 * declaration de la session
	 */
	private Session session;
	
	public BorrowedbookDao() {
		
	}
	
	public Session openSession() {
		session = HibernateUtil.currentSession();
		return session;
	}
	
	/**
	 * ouvre la transaction
	 */
	public void openTransation() {
		session.beginTransaction();
	}
	
	/**
	 * recupération de la session
	 * @return la session récupérée
	 */
	public Session getSession() {
		return session;
		
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
	 * Methode servant a sauver la création ou la modification d'un borrowedBook dans la bdd
	 * @param borrowedBook a sauver ou modifier
	 */
	public void saveBorrowedBook(BorrowedBook borrowedBook) {
		getSession().save(borrowedBook);
		
	}
	
	/**
	 * Methode servant a supprimer le borrowedBook selectionné
	 * @param borrowedBook a supprimer
	 */
	public void deleteBorrowedBook(BorrowedBook borrowedBook) {
		getSession().delete(borrowedBook);
	}
	

	/**
	 * Methode servant a recuperer la liste des borrowedBook d'un user
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowedBook> findByUser_id(int id) {
		List <BorrowedBook> borrowedBooks = (List<BorrowedBook>) getSession().createQuery("from BorrowedBook b where b.user = "+id+"").getResultList();
		return borrowedBooks;
	}

	/**
	 * Methode servant a rechercher un borrowedBook par son id
	 * @ id du borrowedBook a rechercher
	 */
	@Override
	public BorrowedBook findById(int id) {
		BorrowedBook borrowedBook = (BorrowedBook) getSession().createQuery("from BorrowedBook b where b.id = "+id+"").getSingleResult();
		return borrowedBook;
	}


	/**
	 * Methode servant a recuperer la totalité des borrowedBook
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowedBook> findAll() {
		List<BorrowedBook> borrowedBook = (List<BorrowedBook>) getSession().createQuery("from BorrowedBook").getResultList();
		return borrowedBook;
	}

}
