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

/**
 * Class servant a définir les services de la class borrowedBook
 * @author briceroro
 *
 */
@WebService(serviceName = "BorrowedBook")
public class BorrowedBookService {
	
	/**
	 * instantiation de BorrowedBookDao
	 */
	private BorrowedbookDao borrowedBookDao;
	/**
	 * instantiation de BookDao
	 */
    private BookDao bookDao;
    /**
     * instantiation de UserDao
     */
    private UserDao userDao;
    /**
     * initialisation des log de la class
     */
    
    /**
     * initialisation de booking
     */
    private BookingDao bookingDao;
    
    /**
	 * instanciation des logs de la class
	 */
	private final static Logger logger = Logger.getLogger(BorrowedBookService.class);
    
    
	public BorrowedBookService() {	
		borrowedBookDao = new BorrowedbookDao();
		bookingDao = new BookingDao();
		bookDao = new BookDao();
		userDao = new UserDao();
		
	}
	@WebMethod
	public BorrowedBook findBorrowedbookById(int id) {
		BorrowedBook borrowedBook = new BorrowedBook();
		try {
			borrowedBookDao.openSession();
			borrowedBook = borrowedBookDao.findById(id);
		}finally {
			borrowedBookDao.closeSession();
		}
		return borrowedBook;
	}

	/**
	 * Methode servant a recuperer une liste de borrowedBook avec l'id d'un User
	 * @param id de l'user
	 * @return la liste des borrowedBook de l'User
	 */
	@WebMethod
	public List<BorrowedBook> findUserBorrowedBooks(int id) {
		
		List<BorrowedBook> userBorrowedBooks = new ArrayList<BorrowedBook>();
		try {
			borrowedBookDao.openSession();
			userBorrowedBooks = borrowedBookDao.findByUser_id(id);
		}finally {
			borrowedBookDao.closeSession();
		}
		
		
		return userBorrowedBooks;
	}
	
	/**
	 * Methode servant a recuperer une liste des borrowedBook non retourner 
	 * 
	 * @return la liste des BorrowedBook recuperés
	 */
	@SuppressWarnings("null")
	@WebMethod
	public List<BorrowedBook> findBorrowedBookNotReturned(){
		
		List<BorrowedBook> AllBorrowedBooks = new ArrayList<BorrowedBook>();
		List<BorrowedBook> BookNotReturned = new ArrayList<BorrowedBook>();
		
		try {
			 borrowedBookDao.openSession();
			 borrowedBookDao.openTransation();
			 AllBorrowedBooks = borrowedBookDao.findAll();
			 BookNotReturned = new ArrayList<BorrowedBook>();
			 int i = 0;
				Date date = new Date();
				while (i < AllBorrowedBooks.size()) {
					
					if(AllBorrowedBooks.get(i).getDateBorrowing().compareTo(date) < 0)
							{
						this.setFalseAvailableExtension(AllBorrowedBooks.get(i).getId());
						BookNotReturned.add(AllBorrowedBooks.get(i));
							}
					i++;
				}
		}finally {
			borrowedBookDao.closeSession();
		}
		
		return BookNotReturned;	
	}
	
	/**
	 * sert a rendre impossible l'extention d'un borrowedBook
	 * 
	 * @param borrowedBookId
	 */
	@SuppressWarnings("unused")
	private void setFalseAvailableExtension( int borrowedBookId) {
		
		    BorrowedBook borrowedBook = new BorrowedBook();
		
			borrowedBook = borrowedBookDao.findById(borrowedBookId);
			borrowedBook.setAvailableExtension(false);
			borrowedBookDao.commitTransaction();
			logger.debug("set false availaible extension borrowedBook : "+borrowedBook.getId()+"");
	}
	
	/**
	 * Methode servant a creer un BorrowedBook
	 * 
	 * @param bookId
	 * @param userId
	 * 
	 * @return le borrowedBook creer en BDD
	 */
	@WebMethod
	public int createBorrowedBook( int bookId, int userId) {
		
		BorrowedBook borrowedBook ;
		try {
  			borrowedBookDao.openSession();
  			bookDao.openSession();
  			userDao.openSession();
  			bookingDao.openSession();
  			borrowedBookDao.openTransation();
  			
  			Date newdate = new Date();
  			Calendar cal = Calendar.getInstance();
  			cal.setTime(newdate);
  			cal.add(Calendar.DATE, 28);
  			
  			Book book = bookDao.findBookById(bookId);
  			
  			book.setDispo(false);
  			
  			book.setDateAvalaible(cal.getTime());
  			
  			User user = userDao.findById(userId);
  			
  			this.checkBooking(userId, bookId);
  			
  			borrowedBook = new BorrowedBook(true,cal.getTime(),book,user);
  			borrowedBookDao.saveBorrowedBook(borrowedBook);
  			borrowedBookDao.commitTransaction();
  			logger.debug("création du borrowedBook: "+borrowedBook.getId()+"");
  		}finally {

  			borrowedBookDao.closeSession();
  			bookDao.closeSession();
  			userDao.closeSession();
  			
  		}

		logger.debug("BorrowedBookService createBorrowedBook");
		logger.debug("BorrowedBook: bookId="+bookId+", UserId="+userId);
		return borrowedBook.getId();
	}
	
	/**
	 * methode servant a vérifier si un user n'a pas de booking en meme tmeps qu'un borrowedBook
	 * 
	 * @param userId
	 * @param bookId
	 */
	public void checkBooking(int userId,int bookId) {
		List<Booking> userBooking = bookingDao.findByUser(userId);
			for ( int i =0; i < userBooking.size(); i++) {
				if ( userBooking.get(i).getBook().getId() == bookId) {
					bookingDao.deleteBooking(userBooking.get(i));
				}
			}
	}
	
	/**
	 * Methode servant a supprimer un borrowedBook de la BDD
	 * 
	 * @param id
	 * 
	 */
	@WebMethod
	public void deleteBorrowedBook(int id) {
		
		BorrowedBook borrowedBook =new BorrowedBook();
		
		try {
			borrowedBookDao.openSession();
			bookDao.openSession();
			borrowedBookDao.openTransation();
			
			borrowedBook = borrowedBookDao.findById(id);
			Book book = bookDao.findBookById(borrowedBook.getBook().getId());

			if (!book.isReserve()) {
				book.setDispo(true);
			}

			book.setDateAvalaible(null);
			
			borrowedBookDao.deleteBorrowedBook(borrowedBook);
			borrowedBookDao.commitTransaction();
			logger.debug("suppression BorrowedBook id:"+id);
		}finally {
			borrowedBookDao.closeSession();
			bookDao.closeSession();
		}
	}
	
	/**
	 * Methode servant a prolonger la date de retour d'un borrowedBook
	 * 
	 * @param id
	 * 
	 * @return la nouvelle date de retour du borrowedBook
	 */
	@WebMethod
	public Date extensionDateBorrowing(int id) {
		
		BorrowedBook borrowedBook = new BorrowedBook();
		try {
			borrowedBookDao.openSession();
			bookDao.openSession();
			borrowedBookDao.openTransation();
			
			borrowedBook = borrowedBookDao.findById(id);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(borrowedBook.getDateBorrowing());
			cal.add(Calendar.DATE, 28);
			
			borrowedBook.setDateBorrowing(cal.getTime());
			borrowedBook.setAvailableExtension(false);
			
			Book book = bookDao.findBookById(borrowedBook.getBook().getId());
			book.setDateAvalaible(cal.getTime());
			
			borrowedBookDao.commitTransaction();
		}finally {
			
			borrowedBookDao.closeSession();
			bookDao.closeSession();
		}
		logger.debug("extention de la date de restitution du BorrowedBook id:"+id+
				"demandé par l'user: "+borrowedBook.getUser().getId());
		return borrowedBook.getDateBorrowing();
	}

}
