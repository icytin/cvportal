package com.cgi.cvportal.controllers._rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.cvportal.model.Language;
import com.cgi.cvportal.model.LanguageDao;

@RestController
public class LanguageRestController {

	@Autowired
	private LanguageDao languageDao;

	@RequestMapping(value = "/rest/languages", method = RequestMethod.GET)
	public Iterable<Language> list() {
		return languageDao.findAll();
	}

}