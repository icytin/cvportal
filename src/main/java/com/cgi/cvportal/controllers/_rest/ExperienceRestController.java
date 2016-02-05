package com.cgi.cvportal.controllers._rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cvportal.controllers._rest.exceptionhandler.CustomMethodArgumentNotValidException;
import com.cgi.cvportal.model.Cv;
import com.cgi.cvportal.model.Experience;
import com.cgi.cvportal.model.ExperienceDao;
import com.cgi.cvportal.model.User;

@RestController
public class ExperienceRestController {
	
	@Autowired
	private ExperienceDao experienceDao;
	
	@RequestMapping(value="/rest/experience/{id}", method = RequestMethod.GET)
	public Experience getExperience(@PathVariable long id) {
		try {
			return experienceDao.findOne(id);
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value = "/rest/experience", method = RequestMethod.POST)
	public ResponseEntity<Experience> create(@Valid @RequestBody Experience experience) {
		experienceDao.save(experience);
		return new ResponseEntity<Experience>(experience, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/rest/experience/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) throws MethodArgumentNotValidException{
		if (!experienceDao.exists(id))
			throw new CustomMethodArgumentNotValidException(id, "id", "experience med id ("+ id +") saknas i databasen");
		
		experienceDao.delete(id);
	}
}
