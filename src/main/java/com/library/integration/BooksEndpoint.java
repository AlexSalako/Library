package com.library.integration;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.library.service.BookService;

@Path("/account")
public class BooksEndpoint {

	private static final Logger LOGGER = Logger.getLogger(BooksEndpoint.class);
	
	@Inject
	private BookService service;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllBooks() {
		LOGGER.info("BooksEndpoint + getAllBooks");
		return service.getAllBooks();
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String addBooks(String book) {
		LOGGER.info("BooksEndpoint + addBooks");
		return service.addBooks(book);
	}
	
	@Path("/json{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteBooks(@PathParam("id") long id) {
		LOGGER.info("BooksEndpoint + deleteBooks");
		return service.deleteBooks(id);
	}
	
	public void setService(BookService service) {
		LOGGER.info("BooksEndpoint + setService");
		this.service = service;
	}
}
