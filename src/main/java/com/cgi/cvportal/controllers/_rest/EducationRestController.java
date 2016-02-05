package com.cgi.cvportal.controllers._rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cvportal.model.EducationDao;

@RestController
public class EducationRestController {
	
	@Autowired
	private EducationDao educationDao;
	
	
}
