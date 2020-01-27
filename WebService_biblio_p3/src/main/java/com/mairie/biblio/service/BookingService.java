package com.mairie.biblio.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.mairie.biblio.dao.BookDao;
import com.mairie.biblio.dao.BookingDao;
import com.mairie.biblio.dao.BorrowedbookDao;
import com.mairie.biblio.dao.UserDao;
import com.mairie.biblio.model.Book;
import com.mairie.biblio.model.Booking;
import com.mairie.biblio.model.BorrowedBook;
import com.mairie.biblio.model.User;

@WebService(serviceName = "Booking")
public class BookingService {
	
	private static BookingDao bookingDao;
	
    private BookDao bookDao;
   
    private UserDao userDao;
    
    private BorrowedbookDao borrowedbookDao;
	
	/**
	 * instanciation des logs de la class
	 */
	private final static Logger logger = Logger.getLogger(BookingService.class);

	/**
	 * constructeur de bookngService
	 */
	public BookingService () {
		bookingDao = new BookingDao();
		bookDao = new BookDao();
		userDao = new UserDao();
		borrowedbookDao = new BorrowedbookDao();
		
	}
	/**
	 * sert a rechercher un booking par un bookId
	 * 
	 * @param bookId
	 * @return une List de booking par bookId
	 */
	@WebMethod
	public List<Booking> bookingByBook (int bookId){
		List<Booking> bookingList = new ArrayList<Booking>();
		try {
			bookingDao.openSession();
			
			bookingList = bookingDao.findBookingByBook(bookId);
		}finally {
			bookingDao.closeSession();
		}
		return bookingList;

	}
	
	/**
	 * sert a rechercher un booking par son Id
	 * 
	 * @param bookingId
	 * @return un booking 
	 */
	@WebMethod
	public Booking bookingById(int bookingId) {
		Booking booking = new Booking();
		try {
			bookingDao.openSession();
			booking = bookingDao.findById(bookingId);
		}finally {
			bookingDao.closeSession();
		}
		return booking;
	}
	
	/**
	 * sert a rechercher un booking par un userId
	 * 
	 * @param id
	 * @return une List de booking selon userId
	 */
	@WebMethod
	public List<Booking> bookingByUser (int id){
		List<Booking> bookingList = new ArrayList<Booking>();
		try {
			bookingDao.openSession();
			
			bookingList = bookingDao.findByUser(id);
		}finally {
			bookingDao.closeSession();
		}
		return bookingList;

	}
	
	/**
	 * sert a rechercher tous les booking
	 * 
	 * @return List de l'ensemble des booking
	 */
	public List<Booking> allBooking (){
		List<Booking> allBooking = new ArrayList<Booking>();
		try {
			bookingDao.openSession();
			
			allBooking = bookingDao.findAllbooking();
		}finally {
			bookingDao.closeSession();
		}
		return allBooking;
	}
	
	/**
	 * sert a creer un booking
	 * 
	 * @param bookId
	 * @param userId
	 * 
	 * @return id du booking crée
	 */
	@WebMethod
	public int createBooking( int bookId, int userId) {
		Booking booking = new Booking();
		Boolean verifBooking = true;
		int id = 0;
		try {
			bookingDao.openSession();
			bookDao.openSession();
  			userDao.openSession();
  			borrowedbookDao.openSession();
			bookingDao.openTransation();
			
			Book book = bookDao.findBookById(bookId);
			
			List<BorrowedBook> bs = borrowedbookDao.findByUser_id(userId);

			
			
			for (int i = 0; i < bs.size(); i++) {
			    if (bs.get(i).getBook().getId() == book.getId()) {
			    verifBooking = 	false;
			    logger.debug("l'user "+userId+" a deja empruté cette ouvrage");
			    }
			}
			
			List<Booking> bookingList =  bookingDao.findByUser(userId);
			
			for (int i= 0; i < bookingList.size(); i++) {
				if(bookingList.get(i).getBook().getId() == book.getId()) {
					verifBooking = 	false;
					logger.debug("l'user "+userId+" a deja reserver cette ouvrage");
				}
			}
			
			 if ( verifBooking == true) {
				 book.setNbrBooking(book.getNbrBooking()+1);
				 book.setReserve(true);
					
				 User user = userDao.findById(userId);
					
				 booking = new Booking(book.getNbrBooking(),user,book);
				 logger.debug("creation du booking : "+booking.getId()+"");
				 
				 bookingDao.saveBooking(booking);
				 bookingDao.commitTransaction();
			 }
			
		}finally {
			bookingDao.closeSession();
			bookDao.closeSession();
  			userDao.closeSession();
		}
		id = booking.getId();
		return id;
			
	}
	
	@WebMethod
	public int dateLimiteBooking( int bookingId) {
		Booking booking = new Booking();
		try {
			bookingDao.openSession();
			bookingDao.openTransation();
			
			Date newdate = new Date();
  			Calendar cal = Calendar.getInstance();
  			cal.setTime(newdate);
  			cal.add(Calendar.DATE, 2);
  			
			booking = bookingDao.findById(bookingId);
  			booking.setMaxDateBooking(cal.getTime());
  			logger.debug("génération de la date limite de la résa : "+booking.getId()+"");
  			
  			bookingDao.saveBooking(booking);
			bookingDao.commitTransaction();
			logger.debug("initDateLimiteBooking : "+booking.getId()+"");
		}finally {
			bookingDao.closeSession();
		}
		return booking.getId();
	}
	
	
	public void changeOrderListBooking(int bookingId) {
		Booking booking = new Booking();
		
		try {
			bookingDao.openSession();
			bookingDao.openTransation();
			
			booking = bookingDao.findById(bookingId);
			booking.setPriorityOrder(booking.getPriorityOrder()-1);
			bookingDao.commitTransaction();
			logger.debug("changeOrderListBooking : "+booking.getId()+"");

			}	
		finally {
			bookingDao.closeSession();
		}
     }
	
	@WebMethod
	public void deleteBooking(int bookingId) {
		
		Booking booking = new Booking();
		
		try {
			bookingDao.openSession();
			bookDao.openSession();
			bookingDao.openTransation();
			
			booking = bookingDao.findById(bookingId);
			Book book = bookDao.findBookById(booking.getBook().getId());
			
			bookingDao.deleteBooking(booking);
			logger.debug("deleteBooking : "+booking.getId()+"");
			
			book.setNbrBooking(book.getNbrBooking()-1);
			if (book.getNbrBooking() == 0) {
				book.setReserve(false);
				this.deleteBookingByBookId(booking.getBook().getId());	
			}

			bookingDao.commitTransaction();
			
		}finally {
			bookingDao.closeSession();
			bookDao.closeSession();			
		}
	}
	
	
	@SuppressWarnings("unused")
	private void deleteBookingByBookId(int bookId) {
		List<Booking> bookingList = new ArrayList<Booking>();
		Booking booking = new Booking();
		try {
			bookingList = bookingDao.findBookingByBook(bookId);
			
			for (int i= 0; i < bookingList.size(); i++) {
				booking = bookingDao.findById(bookingList.get(i).getId());
				bookingDao.deleteBooking(booking);	
				logger.debug("deleteBooking : "+booking.getId()+"");
			}	
		}finally {
		}
	}
}
