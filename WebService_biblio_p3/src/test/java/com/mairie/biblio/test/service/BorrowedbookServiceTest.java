package com.mairie.biblio.test.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.mairie.biblio.model.Book;
import com.mairie.biblio.model.BorrowedBook;
import com.mairie.biblio.model.User;
import com.mairie.biblio.service.BookService;
import com.mairie.biblio.service.BookingService;
import com.mairie.biblio.service.BorrowedBookService;
import com.mairie.biblio.service.UserService;

public class BorrowedbookServiceTest {
	
	
    private static UserService userService = new UserService();
	private static BookService bookService = new BookService();
	@SuppressWarnings("unused")
	private static BookingService bookingService = new BookingService();
	private static BorrowedBookService borrowedbookService = new BorrowedBookService ();
	
	private static User user = new User();
	private static Book book = new Book();
	private static BorrowedBook borrowedBook = new BorrowedBook();
	
	
	@BeforeAll
    public static void init() {
		userService.createUser("brice.oc.formation@gmail.com",
				"$2a$10$mkrCmcYqvfBM/npVhMesO.oofqEmEQl3.ikvwZ7PzzM.FrBCC6yMu","user",
				"test","usertestBorrowedBook",true,"user");
		
		bookService.createBook("livreTestBorrowedBook", "blabla", "authorTest", "testBook", true, 1);
		
		user = userService.findUserByUserName("usertestBorrowedBook");
		book = bookService.findBookByTitle("livreTestBorrowedBook");
		borrowedbookService.createBorrowedBook(book.getId(), user.getId());
	}

	@Test
	public void extensionDateBorrowingTest() {
		 
		user = userService.findUserByUserName("usertestBorrowedBook");
		book = bookService.findBookByTitle("livreTestBorrowedBook");

        List<BorrowedBook> borrowedbookUserList = borrowedbookService.findUserBorrowedBooks(user.getId());
		borrowedbookService.extensionDateBorrowing(borrowedbookUserList.get(0).getId());
		
		borrowedBook = borrowedbookService.findBorrowedbookById(borrowedbookUserList.get(0).getId());
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 56);
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		    
		Assertions.assertEquals(formater.format(cal.getTime().getTime()), formater.format(borrowedBook.getDateBorrowing()));
	}
	
	@Test
	public void findBorrowedBookNotreturnedTest() {
		
		List<BorrowedBook> bs = borrowedbookService.findBorrowedBookNotReturned();
		
		

		if(bs.size() == 1) {
			BorrowedBook borrowedBook = borrowedbookService.findBorrowedbookById(bs.get(0).getId());
			Assertions.assertTrue(borrowedBook.getDateBorrowing().compareTo(new Date()) < 0);
		}else {
			// rien a tester!
		}
	}
	
	@AfterAll
	public static void cleanUp(){
		user = userService.findUserByUserName("usertestBorrowedBook");
		book = bookService.findBookByTitle("livreTestBorrowedBook");
		List<BorrowedBook> borrowedbookUserList = borrowedbookService.findUserBorrowedBooks(user.getId());
		
		borrowedbookService.deleteBorrowedBook(borrowedbookUserList.get(0).getId());
		userService.deleteUser(user.getId());
		bookService.deleteBook(book.getId());	
	}
}
