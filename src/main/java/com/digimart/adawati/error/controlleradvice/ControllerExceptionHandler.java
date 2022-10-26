package com.digimart.adawati.error.controlleradvice;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.digimart.adawati.error.dto.BusinessErrorRepresentation;
import com.digimart.adawati.error.exception.base.BusinessException;
import com.digimart.adawati.error.exception.base.TechnicalException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
	
	private static final String UNHANDLED_ERROR_CODE="ERR_TECH_ERROR";
	private static final String UNHANDLED_ERROR_MESSAGE="Technical Error, please contact administrator and provide error id %s";
	
  @ExceptionHandler(value = {BusinessException.class})
  public ResponseEntity<BusinessErrorRepresentation> handleBusinessException(BusinessException ex, WebRequest request) {
    return new ResponseEntity<BusinessErrorRepresentation>(
    		BusinessErrorRepresentation.builder()
	    		.errorCode(ex.getErrorCode())
	    		.errorMessage(ex.getErrorMessage())
	    		.errorTime(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()))
	    		.build()
    		, ex.getHttpStatus());
  }
  
  @ExceptionHandler(value = {TechnicalException.class})
  public ResponseEntity<BusinessErrorRepresentation> handleTechnicalException(TechnicalException ex, WebRequest request) {
    return new ResponseEntity<BusinessErrorRepresentation>(
    		BusinessErrorRepresentation.builder()
	    		.errorCode(ex.getErrorCode())
	    		.errorMessage(ex.getErrorMessage())
	    		.errorTime(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()))
	    		.build()
    		, ex.getHttpStatus());
  }
  
  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<BusinessErrorRepresentation> handleException(Exception ex, WebRequest request) {
	  StringBuilder errorIdStringBuilder = new StringBuilder("Err_").append(ZonedDateTime.now().toInstant().toEpochMilli());
	  String errorMessage = String.format(UNHANDLED_ERROR_MESSAGE, errorIdStringBuilder.toString());
	  log.error(errorMessage,ex);
    return new ResponseEntity<BusinessErrorRepresentation>(
    		BusinessErrorRepresentation.builder()
	    		.errorCode(UNHANDLED_ERROR_CODE)
	    		.errorMessage(errorMessage)
	    		.errorTime(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()))
	    		.build()
    		, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}