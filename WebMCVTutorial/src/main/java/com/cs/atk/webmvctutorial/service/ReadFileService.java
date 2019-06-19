package com.cs.atk.webmvctutorial.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReadFileService {
	
	private static final Logger logger = LoggerFactory.getLogger(ReadFileService.class);
	
	public void  getReadFile() {
		
		logger.info("Get read file !!");
		
	} 

}
