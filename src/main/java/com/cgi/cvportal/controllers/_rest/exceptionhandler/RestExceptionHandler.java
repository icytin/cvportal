package com.cgi.cvportal.controllers._rest.exceptionhandler;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cgi.cvportal.dto.ErrorMessageCarrierDTO;
import com.cgi.cvportal.dto.ErrorMessageDTO;

@ControllerAdvice(annotations=RestController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	 @Autowired
	 private MessageSource messageSource;
	
	 @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
	        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
	        ErrorMessageCarrierDTO errorCarrier = new ErrorMessageCarrierDTO();

	        for (FieldError fieldError : fieldErrors) 
	        	errorCarrier.add(new ErrorMessageDTO(fieldError.getField(),resolveLocalizedErrorMessage(fieldError)));
	        
	        for (ObjectError objectError : globalErrors)
	        	errorCarrier.add(new ErrorMessageDTO(objectError.getObjectName(),objectError.getDefaultMessage()));

	        return new ResponseEntity<Object>(errorCarrier, headers, HttpStatus.OK);
	    }
	 
	    @Override
	    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    	ErrorMessageCarrierDTO errorCarrier = new ErrorMessageCarrierDTO();
	    	errorCarrier.add(new ErrorMessageDTO("Unsupported content type", ex.getContentType().toString()));
	    	errorCarrier.add(new ErrorMessageDTO("Supported content types", MediaType.toString(ex.getSupportedMediaTypes())));
	        return new ResponseEntity<Object>(errorCarrier, headers, status);
	    }
	 
	    @Override
	    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        Throwable mostSpecificCause = ex.getMostSpecificCause();
	        ErrorMessageCarrierDTO errorCarrier = new ErrorMessageCarrierDTO();
	        if (mostSpecificCause != null) {
	            String exceptionName = mostSpecificCause.getClass().getName();
	            String message = mostSpecificCause.getMessage();
	            errorCarrier.add(new ErrorMessageDTO(exceptionName, message));
	        } else {
	        	errorCarrier.add(new ErrorMessageDTO("unknown exception", ex.getMessage()));
	        }
	        return new ResponseEntity<Object>(errorCarrier, headers, status);
	    }

	    private String resolveLocalizedErrorMessage(FieldError fieldError) {
	        Locale currentLocale =  LocaleContextHolder.getLocale();
	        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
	 
	        //If the message was not found, return the most accurate field error code instead.
	        //You can remove this check if you prefer to get the default error message.
	        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
	            String[] fieldErrorCodes = fieldError.getCodes();
	            localizedErrorMessage = fieldErrorCodes[0];
	        }
	 
	        return localizedErrorMessage;
	    }
}
