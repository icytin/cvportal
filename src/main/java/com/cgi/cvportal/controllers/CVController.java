package com.cgi.cvportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class CVController {

	@RequestMapping(value="/")
	public String cvIndex(Model model){
		return "cv/index";
	}
	
	@RequestMapping(value="/cv/edit/{id}")
	public String cvEdit(Model model){
		return "cv/edit";
	}
	
	@RequestMapping(value="/cv/handle/{id}")
	public String cvHandle(Model model){
		return "cv/handle";
	}
	
	@RequestMapping(value="/cv/create")
	public String cvCreate(){
		return "cv/create";
	}
}
