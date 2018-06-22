package com.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class libraryUser {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private short id;
	@Size(min = 8, max = 40)
	private String userName;
	@Size(min = 2, max = 40)
	private String transactionDetails;
	
	public libraryUser() {

	}

	public libraryUser(String userName , String transactionDetails) {
		this.userName = userName;
		this.transactionDetails = transactionDetails;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	
}

