package com.library.service;

public interface BookService {

	String getAllBooks();
	
	String addBooks(String book);

	String deleteBooks(long id);
	
}
