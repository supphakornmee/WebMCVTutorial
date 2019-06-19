package com.cs.atk.webmvctutorial.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs.atk.webmvctutorial.model.ScheduleModel;

@Repository
public class ScheduleRepository {
	
	@Autowired
	//@Qualifier("jdbcUserService")
	JdbcTemplate jdbcTemplate;

	public List<ScheduleModel> getSchedulerList(){
		List<ScheduleModel> scheduleList = null;
		System.out.println("Get Schedul start!");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * ");
	//	sql.append("FROM quartz_scheduler.qrtz_triggers ");
		sql.append("FROM jack_rutorial.user ");
		
		try {
			scheduleList = (List<ScheduleModel>)jdbcTemplate.query(sql.toString(), new RowMapper<ScheduleModel>() {
				
				@Override
				public ScheduleModel mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					ScheduleModel model = new ScheduleModel();
//					model.setJobName(rs.getString("JOB_NAME"));
//					model.setJobGroup(rs.getString("JOB_GROUP"));
//					model.setTriggerName(rs.getString("TRIGGER_NAME"));
//					model.setTriggerGroup(rs.getString("TRIGGER_GROUP"));
//					model.setCronExpression(rs.getString("DESCRIPTION"));
					model.setJobName(rs.getString("user_id"));
					model.setJobGroup(rs.getString("user_name"));
					model.setTriggerName(rs.getString("email"));
					model.setTriggerGroup(rs.getString("user_name"));
					model.setCronExpression("0 0/2 * * * ?");
					model.setJobClassName("com.cs.atk.webmvc.tutorial.schedule.MyJobOne");
					return model;
				}
			});
			
			System.out.print("Get Schedul success!");
		}catch(Exception e) {
			throw e;
		}
		
		return scheduleList;
		
		
	}
	
}
