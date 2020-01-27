package com.mairie.bash.service;

import java.util.List;

import generated.borrowedBook.BorrowedBook;
import generated.borrowedBook.BorrowedBookService;
import generated.borrowedBook.BorrowedBook_Service;

/**
 * Class servant a récuperer une List de BorrowedBook non restitué
 * @author briceroro
 *
 */
public class GetBorrowedBookNotReturned {

	/**
	 * declaration du Service BorrowedBookService
	 */
	 private static BorrowedBook_Service bs = new BorrowedBook_Service();
	 /**
	  * récupération du port du service BorrowedBookService
	  */
	 private static BorrowedBookService bookService = bs.getBorrowedBookServicePort();
	
	 /**
	  * Sert a recuperer la liste des oeuvre non restitué
	  * 
	  * @return La liste des oeuvres non restituée
	  *  
	  */
	public List<BorrowedBook> findBookNotRetruned(){
		
		List<BorrowedBook> borrowedBookNotReturned = bookService.findBorrowedBookNotReturned();
		return borrowedBookNotReturned;
	}
}
