package com.cs.atk.webmvctutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);
	
	@RequestMapping(value = "/test" )
	public String test() {
			
		logger.info("AppController --> Welcome()");
		System.out.println("AppController --> Welcome()");
		return "Test";
	}
	
	@RequestMapping(value ="/list_contact")
	public String listContact(Model model) {

//		ContactBusiness business = new ContactBusiness();
//		List<Contact> contactList = business.getContactList();
//		model.addAttribute("contacts", contactList);		
		return "contact";
	}
	
	
	
	
}
