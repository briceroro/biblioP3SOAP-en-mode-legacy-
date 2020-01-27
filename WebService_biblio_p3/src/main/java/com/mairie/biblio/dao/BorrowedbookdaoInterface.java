package com.mairie.biblio.dao;

import java.util.List;

import com.mairie.biblio.model.BorrowedBook;

public interface BorrowedbookdaoInterface {
	
	public List<BorrowedBook> findByUser_id(int id);
	
	public BorrowedBook findById(int id);
	
	public List<BorrowedBook> findAll();
	

}
