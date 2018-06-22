package com.library.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.library.domain.Books;
import com.library.util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class BooksDBRepository implements BooksRepository{

	private static final Logger LOGGER = Logger.getLogger(BooksDBRepository.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllBooks() {
		LOGGER.info("BooksDBRepository getAllAccounts");
		Query query = manager.createQuery("Select a FROM books a");
		Collection<Books> book = (Collection<Books>) query.getResultList();
		return util.getJSONForObject(book);
	}

	@Override
	@Transactional(REQUIRED)
	public String createBook(String book) {
		LOGGER.info("BooksDBRepository createAccount");
		Books aBook = util.getObjectForJson(book, Books.class);
		manager.persist(aBook);
		return "{\"message\": \"book has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteBooks(Long id) {
		LOGGER.info("BooksDBRepository deleteBooks");
		Books booksInDB = findBooks(id);
		if (booksInDB != null) {
			manager.remove(booksInDB);
			return "{\"message\": \"book sucessfully deleted\"}";
		}
		return "{\"message\": \"book not found\"}";

	}

	private Books findBooks(Long id) {
		return manager.find(Books.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
