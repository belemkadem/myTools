package com.digimart.adawati.error.exception.base;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus httpStatus;
	private String errorCode;
	private String errorMessage;
	
	public TechnicalException(HttpStatus httpStatus, String errorCode, String errorMessage, Object... errorMessageArgs) {
		this.httpStatus=httpStatus;
		this.errorCode=errorCode;
		this.errorMessage=String.format(errorMessage, errorMessageArgs);
	}

}
