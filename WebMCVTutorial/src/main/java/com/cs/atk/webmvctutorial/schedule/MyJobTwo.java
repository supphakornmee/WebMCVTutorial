package com.cs.atk.webmvctutorial.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.atk.webmvctutorial.service.ReadFileService;

@Component
public class MyJobTwo implements Job{
	private static final Logger logger = LoggerFactory.getLogger(MyJobTwo.class);
	
	@Autowired
	ReadFileService readFileService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		readFileService.getReadFile();
		logger.info("Run job test two.");
	}

}
