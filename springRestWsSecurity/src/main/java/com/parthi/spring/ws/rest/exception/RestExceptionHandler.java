package com.parthi.spring.ws.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Handles the exception raising in the application.
 * 
 * @author parthiban Samykutti
 * @since 25/Feb/2017
 */
@Component
public class RestExceptionHandler {
	@ResponseStatus(reason="The client's accept header value may not be matched with the server's response object",value=HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public void handleHttpMediaTypeNotAcceptableException(){
		
	}
	@ResponseStatus(reason="Unexpected server exception raised.",value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public void handleException(Exception e){
		
	}
	@ResponseStatus(reason="Requested method is not implemented.",value=HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public void handleHttpRequestMethodNotSupportedException(Exception e){
		
	}
	
}
