package com.digimart.adawati.error.exception.base;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NotFoundException extends BusinessException{

	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String errorCode, String errorMessage) {
		super(HttpStatus.NOT_FOUND, errorCode, errorMessage);
	}
	
	public NotFoundException(String errorCode, String errorMessage,Object...errorMessageArgs) {
		super(HttpStatus.NOT_FOUND, errorCode, errorMessage,errorMessageArgs);
	}
}
