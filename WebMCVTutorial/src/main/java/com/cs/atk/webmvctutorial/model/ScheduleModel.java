package com.cs.atk.webmvctutorial.model;

import java.io.Serializable;

public class ScheduleModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String jobName;
	private String jobGroup;
	private String triggerName;
	private String triggerGroup;
	private String cronExpression;
	private String jobClassName;
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getTriggerName() {
		return triggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public String getTriggerGroup() {
		return triggerGroup;
	}
	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public String getJobClassName() {
		return jobClassName;
	}
	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}

}
