package com.cgi.cvportal.controllers._rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cvportal.dto.ValidationMessageDTO;
import com.cgi.cvportal.model.Certification;
import com.cgi.cvportal.model.Competence;
import com.cgi.cvportal.model.Course;
import com.cgi.cvportal.model.Cv;
import com.cgi.cvportal.model.CvDao;
import com.cgi.cvportal.model.Education;
import com.cgi.cvportal.model.Experience;
import com.cgi.cvportal.model.OtherExperience;
import com.cgi.cvportal.validator.CvValidator;
import com.cgi.cvportal.validator.Validator;

@RestController
public class CvRestController {

	@Autowired
	private CvDao cvDao;
	
	@RequestMapping(value="/rest/cvs", method = RequestMethod.GET)
	public Iterable<Cv> getCvs() {
		try {
			Iterable<Cv> cvs = cvDao.findAll();
			return cvs;
		}
	    catch (Exception ex) {
	    	return null;
	    }
	}
	
	@RequestMapping(value="/rest/cv/{id}", method = RequestMethod.GET)
	public Cv getCv(@PathVariable long id) {
		try {
			return cvDao.findOne(id);
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	
	@RequestMapping(value = "/rest/cv", method = RequestMethod.POST)
	public ResponseEntity<Cv> updateUser(@Valid @RequestBody Cv cv) {
			cvDao.save(cv);
		return new ResponseEntity<Cv>(cv, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/rest/cv/{id}/experiences", method = RequestMethod.GET)
	public Iterable<Experience> getExperienceByCV(@PathVariable long id) {
		
		Cv cv = null;
		
		try {
			
			cv = cvDao.findOne(id);
			if(cv != null) {
				return cv.getExperiences();
			}
			
			return null;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value="/rest/cv/{id}/educations", method = RequestMethod.GET)
	public Iterable<Education> getEducationsByCV(@PathVariable long id) {
		
		Cv cv = null;
		
		try {
			
			cv = cvDao.findOne(id);
			if(cv != null) {
				return cv.getEducations();
			}
			
			return null;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value="/rest/cv/{id}/otherExperiences", method = RequestMethod.GET)
	public Iterable<OtherExperience> getOtherExperiencesByCV(@PathVariable long id) {
		
		Cv cv = null;
		
		try {
			
			cv = cvDao.findOne(id);
			if(cv != null) {
				return cv.getOtherExperiences();
			}
			
			return null;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value="/rest/cv/{id}/courses", method = RequestMethod.GET)
	public Iterable<Course> getCoursesByCV(@PathVariable long id) {
		
		Cv cv = null;
		
		try {
			
			cv = cvDao.findOne(id);
			if(cv != null) {
				return cv.getCourses();
			}
			
			return null;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value="/rest/cv/{id}/competences", method = RequestMethod.GET)
	public Iterable<Competence> getCompetencesByCV(@PathVariable long id) {
		
		Cv cv = null;
		
		try {
			
			cv = cvDao.findOne(id);
			if(cv != null) {
				return cv.getCompetences();
			}
			
			return null;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	@RequestMapping(value="/rest/cv/{id}/certifications", method = RequestMethod.GET)
	public Iterable<Certification> getCertificationsByCV(@PathVariable long id) {
		
		Cv cv = null;
		
		try {
			
			cv = cvDao.findOne(id);
			if(cv != null) {
				return cv.getCertifications();
			}
			
			return null;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
}
