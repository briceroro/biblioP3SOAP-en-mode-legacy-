package com.mairie.biblio.db;

import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mairie.biblio.model.Book;
import com.mairie.biblio.model.Booking;
import com.mairie.biblio.model.BorrowedBook;
import com.mairie.biblio.model.User;


public final class HibernateUtil {
    
	private static final SessionFactory sessionFactory;
	Logger log = Logger.getLogger(HibernateUtil.class.getName());
 
	static {
		try {
			
			sessionFactory =
				new Configuration()
									.configure()
									.addAnnotatedClass(Book.class)
									.addAnnotatedClass(BorrowedBook.class)
									.addAnnotatedClass(User.class)
									.addAnnotatedClass(Booking.class)
									.buildSessionFactory();
		} catch (HibernateException ex) {
			throw new RuntimeException("Problème de configuration : "
					+ ex.getMessage(), ex);
		}
	}
	
	public static SessionFactory currentSessionFactory() {
		return sessionFactory;
	}
 
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();
 
	public static Session currentSession() throws HibernateException {
		Session s = (Session) session.get();
		
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}
 
	public static void closeSession() throws HibernateException {
		
		Session s = (Session) session.get();
		session.set(null);
		if (s != null)
			s.close();
	}
}



