package com.mairie.biblio.test.service;

import com.mairie.biblio.model.Book;
import com.mairie.biblio.service.BookService;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class BookServiceTest {
	
	private static BookService bookService = new BookService();
	
	private static Book bookTest = new Book();
	
	/**
	 * sert a creer les bookTest
	 */
	@BeforeAll
    public static void init() {
		bookService.createBook("livreTest", "blabla", "authorTest", "testBook", true, 1);
		bookService.createBook("4x4x4xtest4x4x4x", "blabla", "authorTest2", "testBook2", true, 1);
	}
	
	/**
	 * sert a verifier si le service recherche bien une liste de book
	 */
	@Test
	public void findAllBookTest() {
		List<Book> bl = bookService.findAllBook();
		Assertions.assertTrue(bl.size() > 2);
	}
	
	/**
	 * sert a rechercher un livre par son titre
	 */
	@Test
	public void findByTitleTest() {
		bookTest = bookService.findBookByTitle("livreTest");
		Assertions.assertEquals("authorTest",bookTest.getAuthor());
	}
	
	/**
	 * sert a recher une liste de livre par mots clés
	 */
	@Test
	public void findbykeaywordsTest() {
		List<Book> bookList = bookService.findBookByTitleKeywords("4xtest4x");
		Assertions.assertEquals("4x4x4xtest4x4x4x", bookList.get(0).getTitle());
	}
	
	/**
	 * sert a rechercher une liste de book par autheur
	 */
	@Test
	public void findByAuthorTest() {
		List<Book> bookList = bookService.findBookByAuthor("authorTest");
		Assertions.assertEquals("livreTest", bookList.get(0).getTitle());
	}
	
	/**
	 * sert a rechercher une liste de book par categorie
	 */
	@Test
	public void findByCategoryTest() {
		List<Book> bookList = bookService.findBookByCategory("testBook");
		Assertions.assertEquals("livreTest", bookList.get(0).getTitle());
	}
	
	@AfterAll
	public static void cleanUp(){
		bookTest = bookService.findBookByTitle("livreTest");
		bookService.deleteBook(bookTest.getId());
		bookTest = bookService.findBookByTitle("4x4x4xtest4x4x4x");
		bookService.deleteBook(bookTest.getId());
	}

}
