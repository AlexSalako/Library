package com.library.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.library.repository.BooksRepository;


public class BookServiceImpl {

	private static final Logger LOGGER = Logger.getLogger(BookService.class);
	
	@Inject
	private BooksRepository repo;
	
	public String getAllBooks() {
		LOGGER.info("In BookServiceImpl getAllBooks");
		return repo.getAllBooks();
	}
	
	public String addBooks(String book) {
		LOGGER.info("In BookServiceImpl addBooks");
		return repo.createBook(book);
	}
	
	public String deleteBooks(Long id) {
		LOGGER.info("In BookServiceImpl deleteBooks");
		return repo.deleteBooks(id);
	}
	
	public void setRepo(BooksRepository repo) {
		this.repo = repo;
	}
}
