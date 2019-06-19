package com.cs.atk.webmvctutorial.config;

import static org.quartz.CronScheduleBuilder.cronSchedule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import com.cs.atk.webmvctutorial.model.ScheduleModel;
import com.cs.atk.webmvctutorial.service.ScheduleService;

@Configuration
public class SchedulerConfig {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private ScheduleService scheduleService;

	@Bean
	public List<ScheduleModel> getScheduler() {
		return scheduleService.getScheduleList();
	}

	@Bean
	public List<JobDetail> jobDetail(List<ScheduleModel> scheduleList) throws ClassNotFoundException {

		List<JobDetail> jobDetailList = new ArrayList<JobDetail>();
		for (ScheduleModel model : scheduleList) {
			Class c = Class.forName(model.getJobClassName());
			JobDetail job = JobBuilder.newJob().ofType(c).storeDurably()
					.withIdentity(model.getJobName(), model.getJobGroup()).build();
			jobDetailList.add(job);
		}
		return jobDetailList;
	}

	@Bean
	public List<Trigger> trigger(List<JobDetail> jobList, List<ScheduleModel> scheduleList) {
		List<Trigger> triggerList = new ArrayList<Trigger>();
		int index = 0;

		for (ScheduleModel model : scheduleList) {
			Trigger trigger = TriggerBuilder.newTrigger().forJob(jobList.get(index++))
					.withIdentity(model.getTriggerName(), model.getTriggerGroup())
					.withSchedule(cronSchedule(model.getCronExpression())).build();
			triggerList.add(trigger);
		}
		return triggerList;
	}

	@Bean
	public SpringBeanJobFactory springBeanJobFactory() {
		AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	@Bean
	public Scheduler scheduler(List<Trigger> triggerList, List<JobDetail> jobList, List<ScheduleModel> scheduleList)
			throws SchedulerException, IOException {
		StdSchedulerFactory factory = new StdSchedulerFactory();
		factory.initialize(new ClassPathResource("quartz.properties").getInputStream());
		Scheduler scheduler = factory.getScheduler();
		for (int i = 0; i < scheduleList.size(); i++) {
			scheduler.setJobFactory(springBeanJobFactory());
			scheduler.scheduleJob(jobList.get(i), triggerList.get(i));
		}
		scheduler.start();
		return scheduler;
	}

}
