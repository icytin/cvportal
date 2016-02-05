package com.cgi.cvportal.controllers._rest.exceptionhandler;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class CustomMethodArgumentNotValidException extends MethodArgumentNotValidException {

	private static final long serialVersionUID = 1L;

	public CustomMethodArgumentNotValidException(Object target, String field, String message) {
		super(null, new BindException(target, null));
		this.getBindingResult().addError(new ObjectError(field, message));
	}
}
