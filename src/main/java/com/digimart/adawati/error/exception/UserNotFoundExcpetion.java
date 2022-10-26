package com.digimart.adawati.error.exception;

import com.digimart.adawati.error.exception.base.NotFoundException;

public class UserNotFoundExcpetion extends NotFoundException{

	private static final long serialVersionUID = 1L;
	
	private static final String errorCode = "Err_user_0001"; 
	private static final String errorMessage = "No user with the username %s was found"; 

	public UserNotFoundExcpetion(String userName) {
		super(errorCode, errorMessage,userName);
	}

}
