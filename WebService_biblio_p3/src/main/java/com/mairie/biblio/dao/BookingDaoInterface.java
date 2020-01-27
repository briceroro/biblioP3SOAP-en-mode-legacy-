package com.mairie.biblio.dao;

import java.util.List;

import com.mairie.biblio.model.Booking;

public interface BookingDaoInterface {

	Booking findById(int id);
	
	List<Booking> findByUser(int id);

	List<Booking> findAllbooking();

	List<Booking> findBookingByBook(int bookId);
}
