package com.cgi.cvportal.dto;

import java.io.Serializable;

public class ErrorMessageDTO implements Serializable {
	
	private static final long serialVersionUID = -2078375216812948278L;
	private String field;
	private String message;

	public ErrorMessageDTO(String field, String message)
	{
		this.setField(field);
		this.setMessage(message);
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
