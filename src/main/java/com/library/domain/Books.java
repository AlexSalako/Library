package com.library.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;


@Entity
public class Books {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(min = 13, max = 13)
	private long id;
	@Size(min = 2, max = 50)
	private String bookTitle;
	@Size(min = 2, max = 50)
	private String genre;
	@Size(min = 4, max = 4)
	private int yearPublished;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<libraryUser> user = new HashSet<>();

	public Books(){
		
	}
	
	public Books(String bookTitle, String genre, int yearPublished) {
		
		this.bookTitle = bookTitle;
		this.genre = genre;
		this.yearPublished = yearPublished;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	
	
}
