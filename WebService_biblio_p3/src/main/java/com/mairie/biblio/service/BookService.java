package com.mairie.biblio.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.mairie.biblio.dao.BookDao;
import com.mairie.biblio.model.Book;





/**
 * Class servant a définir les services de la class book
 * @author briceroro
 *
 */
@WebService(serviceName = "Book")
public class BookService {
	
	/**
	 * instanciation de  la class bookDao
	 */
	private static BookDao bookDao;

	/**
	 * instanciation des logs de la class
	 */
	private final static Logger logger = Logger.getLogger(BookService.class);
	
	public BookService() {
		bookDao = new BookDao();
		
		
	}
	
	/**
	 * Methode servant retourner la liste complete des Book
	 * 
	 * @return la liste de book récuperer
	 */
	@WebMethod
	public List<Book> findAllBook() {
		
		List<Book> books = new ArrayList<Book>();
		
		try {
			bookDao.openSession();
			books = bookDao.findAllbook();
		}finally {
			bookDao.closeSession();
		}
		
		
		return books;
	}
	
	/**
	 * Methode servant a retourner un book par son titre
	 * @param title
	 * @return le book correspondant au titre rechercher
	 */
	@WebMethod
	public Book findBookByTitle(String title) {
		
		Book book = new Book();
		bookDao.openSession();
		
		try {
			book = bookDao.findBookBytitle(title);
		}finally {
			bookDao.closeSession();
			
		}
		
		return book;
	}
	
	/**
	 * Methode servant a afficher une liste de book par une rechercher par mot clé
	 * @param mc 
	 * @return la liste des book correspondant  la recherche par mot clé
	 */
	@WebMethod
	public List<Book> findBookByTitleKeywords(String mc) {
		
		List<Book> books = new ArrayList<Book>();
		try {
			bookDao.openSession();
			books = bookDao.findBookByKeywordsTitle(mc);	
		}finally {
			bookDao.closeSession();
		}
		
		return books;
		
	}
	
	/**
	 * Methode servant a retourner un liste de book écrité par autheur 
	 * @param author 
	 * @return la liste de book de l'auteur
	 */
	@WebMethod
	public List<Book> findBookByAuthor(String author) {
		
		List<Book> books = new ArrayList<Book>();
		
		try {
			bookDao.openSession();
			books = bookDao.findBookByAuthor(author);
		}finally {
			bookDao.closeSession();
		}
		
	    return books ;
	}
	
	/**
	 * Methode servant a recuperer une liste de book par category
	 * @param category
	 * @return la liste des book de la category
	 */
	@WebMethod
	public List<Book> findBookByCategory (String category){
		
		List<Book> books = new ArrayList<Book>();
		try {
			bookDao.openSession();
			books = bookDao.findBookByCategory(category);
		}finally {
			bookDao.closeSession();
		}
		return books;
	}
	
	/**
	 * Methode servant  creer un book
	 * 
	 * @param title
	 * @param description
	 * @param author
	 * @param category
	 * @param dispo
	 * 
	 * @return le book creer via le constructeur et enregistrer dans la BDD
	 */
	@WebMethod
	public int createBook(String title,String description,String author,String category,Boolean dispo,int nbrOfBook) {
		
		Book book = new Book();
		
		try {
			bookDao.openSession();
			bookDao.openTransation();
			book = new Book(title,description,author,category,dispo,nbrOfBook);
			book.setNbrDispo(nbrOfBook);
			book.setDateAvalaible(new Date());
			bookDao.saveBook(book);
			bookDao.commitTransaction();
		}finally {
			bookDao.closeSession();
		}
        
		logger.debug("Book: title="+title+", description="+description+", author="+author+
				", category="+category+", dispo="+", nbrOfBook"+nbrOfBook);
		return book.getId();
	}
	
	/**
	 * Methode servant a supprimer un book de la BDD
	 * @param id
	 */
	@WebMethod
	public void deleteBook (int id) {
		
		Book book = new Book();
		
		try {
			bookDao.openSession();
			bookDao.openTransation();
			book = bookDao.findBookById(id);
			bookDao.deleteBook(book);
			bookDao.commitTransaction();
		}finally {
			bookDao.closeSession();
		}
		
		logger.debug("suppression Book: bookId="+id);
		
	}
	

}
