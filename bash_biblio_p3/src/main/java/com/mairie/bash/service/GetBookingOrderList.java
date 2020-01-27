package com.mairie.bash.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import generated.BookingService.Booking;
import generated.BookingService.BookingService;
import generated.BookingService.Booking_Service;

public class GetBookingOrderList {

	/**
	 * declaration du service bookingService
	 */
	Booking_Service bs = new Booking_Service();
	/**
	 * recuperation du port du service bookingservice
	 */
	BookingService bookingService = bs.getBookingServicePort();
	
	public List<Booking> findAllBooking(){
		List<Booking> allBooking = bookingService.allBooking();
		return allBooking;	
	}
	
	public List<Booking> findBookingByBook(int bookId){
		List<Booking> bookingByBookId = bookingService.bookingByBook(bookId);
		return bookingByBookId;
	}
	
	public void CheckExpiredBooking(){
		List<Booking> bookingList = this.findAllBooking();
		
		 for(int i = 0; i < bookingList.size(); i++) {
			 
			   if(bookingList.get(i).getMaxDateBooking() == null) {
				   // it's good!
			   }else if(bookingList.get(i).getMaxDateBooking().toGregorianCalendar().getTime().getDay() != new Date().getDay()) {
				    // it's goog!	
				}else if(bookingList.get(i).getMaxDateBooking().toGregorianCalendar().getTime().getDay() == new Date().getDay()) {
				    bookingService.deleteBooking(bookingList.get(i).getId());	
				    this.changeOrderListBooking(bookingList.get(i).getBook().getId());
				    
				}
			}	
	}
	
	public void changeOrderListBooking(int bookId){
		List<Booking> bookingList = this.findBookingByBook(bookId);
		try {
		for(int i = 0; i < bookingList.size(); i++) {
			if(bookingList.get(i).getPriorityOrder() > 1) {
				bookingService.changeOrderListBooking(bookingList.get(i).getId());
			}
		}
		}finally {
			
		}
	}
	
	public List<Booking> initDateLimiteBooking() {
		List<Booking> bookingList = this.findAllBooking();
		List<Booking> firtBookingList = new ArrayList<Booking>();
		
		for(int i = 0; i < bookingList.size(); i++) { 
			if(bookingList.get(i).getPriorityOrder() == 1) {
				firtBookingList.add(bookingList.get(i));
				bookingService.dateLimiteBooking(bookingList.get(i).getId());
			}
		}
		return firtBookingList;	
	}
}
