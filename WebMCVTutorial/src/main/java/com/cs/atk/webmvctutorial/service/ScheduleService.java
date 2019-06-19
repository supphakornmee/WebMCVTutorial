package com.cs.atk.webmvctutorial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.atk.webmvctutorial.model.ScheduleModel;
import com.cs.atk.webmvctutorial.repository.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepo;
	
	public List<ScheduleModel> getScheduleList(){
		
		List<ScheduleModel> schedulLists = new ArrayList<ScheduleModel>();
		schedulLists = scheduleRepo.getSchedulerList();
		return  schedulLists;
	}
	

}
