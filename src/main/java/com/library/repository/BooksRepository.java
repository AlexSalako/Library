package com.library.repository;

public interface BooksRepository {

	String getAllBooks();

	String createBook(String book);

	String deleteBooks(Long id);

	
}
