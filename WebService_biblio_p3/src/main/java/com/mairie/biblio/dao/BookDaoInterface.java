package com.mairie.biblio.dao;

import java.util.List;

import org.hibernate.Session;

import com.mairie.biblio.model.Book;

public interface BookDaoInterface {
	
	public Book findBookBytitle(String title);
	
	public Book findBookById(int id);
	
	public List<Book> findBookByKeywordsTitle(String mc);
	
	public List<Book> findBookByAuthor(String author);
	
	public List<Book> findBookByCategory(String category);
	
	public List<Book> findAllbook();
	
	
	
	
	
}