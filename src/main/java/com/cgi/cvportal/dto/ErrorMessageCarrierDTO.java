package com.cgi.cvportal.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessageCarrierDTO {
 
    private List<ErrorMessageDTO> errors = new ArrayList<ErrorMessageDTO>();
 
    public void add(ErrorMessageDTO error){
    	errors.add(error);
    }
 
    public List<ErrorMessageDTO> getErrors() {
        return errors;
    }
}