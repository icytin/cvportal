package com.cgi.cvportal.validator;

import com.cgi.cvportal.model.Cv;

public class CvValidator extends Validator {

	private static final long serialVersionUID = 5307865319122249445L;

	public void validate(Cv cv){
		
		if(cv.getBackground() == null || cv.getBackground().length() < 20) {
			addValidationMessage("background", "Bakgrund måste anges. Minst 20 tecken.");
		}
		
		if (cv.getId() == null || cv.getId() < 1) {
			addValidationMessage("id", "id saknas");
		}
		
	}
	
}
