package com.howtodoinjava.exceptionhandler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) {

		return "nullpointer";
	}

	@ExceptionHandler(value = IOException.class)
	public String handleIoException(Exception e) {

		return "ioexception";
	}
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {

		return "exception";
	}
}
