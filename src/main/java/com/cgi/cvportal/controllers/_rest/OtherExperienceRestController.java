package com.cgi.cvportal.controllers._rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cvportal.model.OtherExperience;
import com.cgi.cvportal.model.OtherExperienceDao;

@RestController
public class OtherExperienceRestController {
	
	@Autowired
	private OtherExperienceDao OtherExperienceDao;
	
	@RequestMapping(value="/rest/otherExperience/{id}", method = RequestMethod.GET)
	public OtherExperience getOtherExperiencesByCV(@PathVariable long id) {
		
		try {	
			return OtherExperienceDao.findOne(id);
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	
}
