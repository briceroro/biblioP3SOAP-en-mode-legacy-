package com.mairie.biblio.test.service;

import com.mairie.biblio.model.Book;
import com.mairie.biblio.model.Booking;
import com.mairie.biblio.model.User;
import com.mairie.biblio.service.BookService;
import com.mairie.biblio.service.BookingService;
import com.mairie.biblio.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class BookingServiceTest {

	private static BookingService bookingService = new BookingService();
	
	private static UserService userService = new UserService();
	
	private static BookService bookService = new BookService();
	
	private static User user = new User();
	private static Book book = new Book();

	@BeforeAll
    public static void init() {
		userService.createUser("brice.oc.formation@gmail.com",
				"$2a$10$mkrCmcYqvfBM/npVhMesO.oofqEmEQl3.ikvwZ7PzzM.FrBCC6yMu","user",
				"test","usertestBooking",true,"user");

	    bookService.createBook("livreTestBooking", "blabla", "authorTest", "testBook", true, 1);
	    
	    user = userService.findUserByUserName("usertestBooking");
	    book = bookService.findBookByTitle("livreTestBooking");
	    bookingService.createBooking(book.getId(), user.getId());
		
	}
	
	@Test
	public void findAllBookingTest() {
		bookingService.allBooking();
	}
	
	@Test
	public void findByUserTest() {
		user = userService.findUserByUserName("usertestBooking");
		bookingService.bookingByUser(user.getId());
		
	    List<Booking> bookingUserList = bookingService.bookingByUser(user.getId());
	    
	    Assertions.assertEquals("usertestBooking",bookingUserList.get(0).getUser().getUserName());
	}
	
	@Test
	public void findByBookTest() {
		book = bookService.findBookByTitle("livreTestBooking");
		bookingService.bookingByBook(book.getId());
		
		List<Booking> bookingUserList = bookingService.bookingByBook(book.getId());
		
		Assertions.assertEquals("livreTestBooking",bookingUserList.get(0).getBook().getTitle());	
	}
	
	@Test
	public void findbyBookingIdTest() {
		user = userService.findUserByUserName("usertestBooking");
		
		List<Booking> bookingUserList = bookingService.bookingByUser(user.getId());
		Booking booking = bookingService.bookingById(bookingUserList.get(0).getId());
		
		Assertions.assertEquals("usertestBooking",booking.getUser().getUserName());
	}
	
	@Test
	public void setDateBookingTest() {
		user = userService.findUserByUserName("usertestBooking");
	
		List<Booking> bookingUserList = bookingService.bookingByUser(user.getId());
		Booking booking = bookingUserList.get(0);
		bookingService.dateLimiteBooking(booking.getId());
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 2);
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		
		Assertions.assertEquals(formater.format(cal.getTime().getTime()), 
				formater.format(bookingService.bookingById(booking.getId()).getMaxDateBooking()));
	}
	
	@Test
	public void changeOrderListBookingTest() {
		user = userService.findUserByUserName("usertestBooking");
		List<Booking> bookingUserList = bookingService.bookingByUser(user.getId());
		
		Booking booking = bookingUserList.get(0);
		int initialOrder = booking.getPriorityOrder();
		
		bookingService.changeOrderListBooking(booking.getId());
		booking = bookingService.bookingById(bookingUserList.get(0).getId());
		
		Assertions.assertEquals(initialOrder-1, booking.getPriorityOrder());
	}
	
	@AfterAll
	public static void cleanUp(){
		user = userService.findUserByUserName("usertestBooking");
		book = bookService.findBookByTitle("livreTestBooking");
		List<Booking> bookingUserList = bookingService.bookingByUser(user.getId());
		bookingService.deleteBooking(bookingUserList.get(0).getId());
		userService.deleteUser(user.getId());
		bookService.deleteBook(book.getId());
	}
}
