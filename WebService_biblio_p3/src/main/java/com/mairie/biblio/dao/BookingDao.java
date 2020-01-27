package com.mairie.biblio.dao;

import java.util.List;

import org.hibernate.Session;

import com.mairie.biblio.db.HibernateUtil;
import com.mairie.biblio.model.Book;
import com.mairie.biblio.model.Booking;
import com.mairie.biblio.model.BorrowedBook;
import com.mairie.biblio.model.User;

public class BookingDao implements BookingDaoInterface {

	private Session session;
	
	public BookingDao() {
		
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
	 * Methode servant a sauver la création ou la modification d'un booking dans la bdd
	 * @param booking a sauver ou modifier
	 */
	public void saveBooking(Booking booking) {
		getSession().save(booking);
		
	}
	
	/**
	 * Methode servant a supprimer le booking selectionné
	 * @param booking a supprimer
	 */
	public void deleteBooking(Booking booking) {
		getSession().delete(booking);
	}
	
	@Override
	public Booking findById(int id) {
		Booking booking  = (Booking) getSession().createQuery("from Booking u where u.id = "+id+"").getSingleResult();
		return booking;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findByUser(int id) {
		List<Booking> booking = (List<Booking>) getSession().createQuery("from Booking b where b.user = "+id+"").getResultList();
		return booking;
	}
	
	/**
	 * Methode servant a recuperer la liste de tous les booking
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findAllbooking() {
		List<Booking> bookings = (List<Booking>) getSession().createQuery("from Booking").getResultList();
        return bookings;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findBookingByBook(int bookId) {
		List<Booking> bookings = (List<Booking>) getSession().createQuery("from Booking b where b.book = "+bookId+"").getResultList();
        return bookings;
	}

}
