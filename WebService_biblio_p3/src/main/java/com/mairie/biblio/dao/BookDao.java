package com.mairie.biblio.dao;

import java.util.List;

import org.hibernate.Session;
import com.mairie.biblio.db.HibernateUtil;

import com.mairie.biblio.model.Book;


/**
 * Class servant a faire la liason avec la BDD et l'application via hibernate
 * @author briceroro
 *
 */
public class BookDao implements BookDaoInterface {
	
	/**
	 * declaration de la session
	 */
	private Session session;
	
	 public BookDao() {
	    }

	
	public Session openSession() {
		session = HibernateUtil.currentSession();
		return session;
	}
	
	/**
	 * recupération de la session
	 * @return la session récupérée
	 */
	public Session getSession() {
		return session;
		
	}
	
	/**
	 * ouvre la transaction
	 */
	public void openTransation() {
		session.beginTransaction();
	}
	/**
	 * commit des modification en bdd
	 */
	public void commitTransaction() {
		session.getTransaction().commit();
	}
	 
	public void closeSession() {
		HibernateUtil.closeSession();
	}
	
	/**
	 * Methode servant a sauver la création ou la modification d'un book dans la bdd
	 * @param book a sauver ou modifier
	 */
	public void saveBook(Book book) {
		getSession().save(book);
		
	}
	
	/**
	 * Methode servant a supprimer le book selectionné
	 * @param book a supprimer
	 */
	public void deleteBook(Book book) {
		getSession().delete(book);
	}
	
	/**
	 * Methode servant a recuperer un book via son titre
	 * @param titre du livre a rechercher
	 */
	@Override
	public Book findBookBytitle(String title) {
		
		Book bookTitle = (Book) getSession().createQuery("from Book b where b.title='"+title+"'").getSingleResult();
        
		return bookTitle ;
	}

	/**
	 * Methode servant a recuperer la liste de tous les book
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAllbook() {
		List<Book> books = (List<Book>) getSession().createQuery("from Book").getResultList();
        return books;
	}
    
	/**
	 * Methode servant a recuperer une liste de Book contenant la String passer en parametre dans son titre
	 * 
	 * @param mc 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Book> findBookByKeywordsTitle(String mc) {
		List<Book> books = (List<Book>) getSession().createQuery("from Book b where b.title like '%"+mc+"%'").getResultList();
		return books;
	}

	/**
	 * Methode servant a recuperer une liste des ouvrage écrit par un autheur
	 * @param non de l'autheur dont on souhaite voir les ouvrages
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findBookByAuthor(String author) {
		List<Book> books = (List<Book>) getSession().createQuery("from Book b where b.author like '%"+author+"%'").getResultList();
		return books;
	}

	/**
	 * Methode servant a afficher une liste de book correspondat a type de catégory
	 * @param category des book dont on souhaite voir la liste
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findBookByCategory(String category) {
		List<Book> books = (List<Book>) getSession().createQuery("from Book b where b.category like '%"+category+"%'").getResultList();
		return books;
	}

	/**
	 * Methode servant a rechercher un book  par son id
	 * @ id du book a rechercher
	 */
	@Override
	public Book findBookById(int bookId) {
		Book book = (Book) getSession().createQuery("from Book b where b.id="+bookId+"").getSingleResult();
		return book;
	}

	

	

	

}
