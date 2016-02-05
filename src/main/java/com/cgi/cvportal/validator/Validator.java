package com.cgi.cvportal.validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cgi.cvportal.dto.ValidationMessageDTO;

public class Validator implements Serializable {
	
	private static final long serialVersionUID = 1054469536490284007L;
	private List<ValidationMessageDTO> validationMessagesDtos = new ArrayList<ValidationMessageDTO>();
	
	public List<ValidationMessageDTO> getValidationMessagesDtos() {
		return validationMessagesDtos;
	}

	public void setValidationMessagesDtos(List<ValidationMessageDTO> validationMessagesDtos) {
		this.validationMessagesDtos = validationMessagesDtos;
	}
	
	public List<ValidationMessageDTO> getValidationMessages() {
		return this.validationMessagesDtos;
	}
	
	public boolean isSuccess() {
		return this.validationMessagesDtos.isEmpty();
	}
	
	public void addValidationMessage(String field, String message) {
		this.validationMessagesDtos.add(new ValidationMessageDTO(field, message));
	}

}
