package com.mairie.bash.application;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mairie.bash.javamail.SendMail;
import com.mairie.bash.javamail.SendMailBooking;
import com.mairie.bash.service.GetBookingOrderList;
import com.mairie.bash.service.GetBorrowedBookNotReturned;

import generated.BookingService.Booking;
import generated.borrowedBook.BorrowedBook;

@Component
public class Main {
	
	private SendMail sendMail = new SendMail();
	private GetBorrowedBookNotReturned getBook = new GetBorrowedBookNotReturned();
	
	private SendMailBooking sendMailBooking = new SendMailBooking();
	private GetBookingOrderList getBooking = new GetBookingOrderList();
	

	/**
	 * utlise l'annotation scheduled de spring pour gerer le cycle de répétion de la méthode
	 * 
	 * Sert e déclarer la récupération et l'envoi des mails aux users concernés,
	 *   a verfiier les booking expriré 
	 *  et envoyé un email user 1a sur la liste des booking
	 *  
	 * 
	 */
	@Scheduled(cron="${cronExpression}") 
    public void mainBash() {

    	List<BorrowedBook> borrowedBookNotReturned = getBook.findBookNotRetruned();
    	
    	for(int i = 0; i < borrowedBookNotReturned.size(); i++)
    	{
    	  sendMail.sendMailToUser(borrowedBookNotReturned, i);
    	}
    	
    	getBooking.CheckExpiredBooking();
    	
    	List<Booking> allBooking = getBooking.initDateLimiteBooking();
    	for( int i = 0; i < allBooking.size(); i++) {
    		sendMailBooking.SendMailBookingToUser(allBooking, i);
    	}
    	
    }
}
